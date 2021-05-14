package com.jastley.innovationday.network

import com.jastley.innovationday.entity.RocketLaunch
import io.ktor.client.*
import io.ktor.client.features.json.JsonFeature
import io.ktor.client.features.json.serializer.KotlinxSerializer
import io.ktor.client.request.*

class SpaceXAPI {
    private val httpClient = HttpClient {
        install(JsonFeature) {
            val json = kotlinx.serialization.json.Json { ignoreUnknownKeys = true }
            serializer = KotlinxSerializer(json)
        }
    }

    companion object {
        private const val LAUNCHES_ENDPOINT = "https://api.spacexdata.com/v3/launches"
    }

    suspend fun getAllLaunches(): List<RocketLaunch> {
        return httpClient.get(LAUNCHES_ENDPOINT)
    }
}