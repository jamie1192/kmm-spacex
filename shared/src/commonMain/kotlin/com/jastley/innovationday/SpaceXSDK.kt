package com.jastley.innovationday

import com.jastley.innovationday.cache.Database
import com.jastley.innovationday.cache.DatabaseDriverFactory
import com.jastley.innovationday.entity.RocketLaunch
import com.jastley.innovationday.network.SpaceXAPI

class SpaceXSDK(databaseDriverFactory: DatabaseDriverFactory) {
    private val database = Database(databaseDriverFactory)
    private val api = SpaceXAPI()

    //    To handle exceptions produced by the Ktor client, in Swift,
    //    we need to mark our function with @Throws annotation. All Kotlin exceptions
    //    are unchecked, while Swift has only checked errors.
    //
    //    Thus, to make Swift code aware of expected exceptions, Kotlin functions should
    //    be marked with an @Throws annotation specifying a list of potential exception classes.
    @Throws(Exception::class) suspend fun getLaunches(forceReload: Boolean): List<RocketLaunch> {
        val cachedLaunches = database.getAllLaunches()
        return if (cachedLaunches.isNotEmpty() && !forceReload) {
            cachedLaunches
        } else {
            api.getAllLaunches().also {
                database.clearDatabase()
                database.createLaunches(it)
            }
        }
    }
}