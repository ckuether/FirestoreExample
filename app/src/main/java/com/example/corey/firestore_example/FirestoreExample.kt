package com.example.corey.firestore_example

import android.app.Application
import com.google.firebase.FirebaseApp
import com.google.firebase.FirebaseOptions

class FirestoreExample: Application() {

    override fun onCreate() {
        super.onCreate()
        FirebaseApp.initializeApp(this, FirebaseOptions.fromResource(this))
    }
}