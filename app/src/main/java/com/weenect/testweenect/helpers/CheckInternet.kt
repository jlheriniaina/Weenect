package com.weenect.testweenect.helpers

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.io.IOException
import java.net.InetSocketAddress
import java.net.Socket
import javax.inject.Inject

class CheckInternet @Inject constructor() {
    companion object {
        private const val HOST_NAME = "8.8.8.8"
        private const val PORT = 53
        private const val TIMEOUT = 1_500
    }

    fun isCheck(listener: (connected: Boolean) -> Unit) {
        CoroutineScope(Dispatchers.IO).launch(Dispatchers.IO) {
            try {
                Socket().use { it.connect(InetSocketAddress(HOST_NAME, PORT), TIMEOUT) }
                withContext(Dispatchers.IO) {
                    listener(true)
                }
            } catch (e: IOException) {
                withContext(Dispatchers.IO) {
                    listener(false)
                }
            }
        }
    }

    suspend fun isCheck(): Boolean {
        return withContext(Dispatchers.IO) {
            try {
                Socket().use { it.connect(InetSocketAddress(HOST_NAME, PORT), TIMEOUT) }
                return@withContext true
            } catch (e: IOException) {
                return@withContext false
            }
        }
    }
}