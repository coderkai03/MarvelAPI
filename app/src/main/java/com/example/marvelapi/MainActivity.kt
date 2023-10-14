package com.example.marvelapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.codepath.asynchttpclient.AsyncHttpClient
import com.codepath.asynchttpclient.callback.JsonHttpResponseHandler
import okhttp3.Headers

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Example API request with authentication
        val timestamp = System.currentTimeMillis()
        val privateKey = "1234567890987654321"
        val publicKey = "1234567890"
        val hash = stringToMd5("$timestamp$privateKey$publicKey")
        var client = AsyncHttpClient()

        val url =
            "https://gateway.marvel.com/v1/public/characters?ts=$timestamp&apikey=$publicKey&hash=$hash"
        client[url, object : JsonHttpResponseHandler() {
            // Request results
        }]
    }
}