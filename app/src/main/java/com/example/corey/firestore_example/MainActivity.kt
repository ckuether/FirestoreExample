package com.example.corey.firestore_example

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import com.google.firebase.firestore.FieldValue
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.WriteBatch
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*

class MainActivity : AppCompatActivity() {

    val writeBatch: WriteBatch = FirebaseFirestore.getInstance().batch()
    val db: FirebaseFirestore = FirebaseFirestore.getInstance()

    val usersDoc = db.collection("users").document()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        setDoc.setOnClickListener {
            Toast.makeText(this, "Set Document", Toast.LENGTH_LONG).show()
            setFirestoreDoc()
        }

        updateDoc.setOnClickListener {
            Toast.makeText(this, "Update Document", Toast.LENGTH_LONG).show()
            updateFirestoreDoc()
        }

        deleteDoc.setOnClickListener {
            Toast.makeText(this, "Delete Document", Toast.LENGTH_LONG).show()
            deleteFirestoreDoc()
        }

        commitDoc.setOnClickListener {
            Toast.makeText(this, "Commit Batch", Toast.LENGTH_LONG).show()
            commitFirestoreBatch()
        }
    }

    fun setFirestoreDoc() {
        val user = HashMap<String, Any>()
        user["first"] = "Ada"
        user["last"] = "Lovelace"
        user["born"] = 1815

        // Add a new document with a generated ID
        writeBatch.set(usersDoc, user)
    }

    fun updateFirestoreDoc(){
        val timestamp = HashMap<String, Any>()
        timestamp["timestamp"] = FieldValue.serverTimestamp()

        writeBatch.update(usersDoc, timestamp)
    }

    fun deleteFirestoreDoc(){
        writeBatch.delete(usersDoc)
    }

    fun commitFirestoreBatch(){
        writeBatch.commit()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}
