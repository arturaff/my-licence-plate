package ru.arturprgr.mylicenceplate.data

import com.google.firebase.Firebase
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.database

class FirebaseHelper(val path: String) {
    private val reference = Firebase.database.getReference(path)

    fun setValue(value: Any) = Thread { reference.setValue(value) }.start()

    fun getValue(onGet: (value: String) -> Unit) {
        reference.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                onGet("${snapshot.value}")
            }

            override fun onCancelled(error: DatabaseError) {}
        })
    }
}