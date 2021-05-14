package com.jastley.innovationday

class Greeting {
    fun greeting(): String {
        return "Hello, ${Platform().platform}!"
    }
}