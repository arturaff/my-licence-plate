package ru.arturprgr.mylicenceplate.data

import android.annotation.SuppressLint
import android.os.Bundle
import android.os.Handler
import android.os.Message
import com.google.firebase.Firebase
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.database

class Database(val path: String) {
    private val reference = Firebase.database.getReference(path)

    fun setValue(value: Any) = Thread { reference.setValue(value) }.start()

    @Suppress("DEPRECATION")
    fun getValue(onGet: (value: String) -> Unit) {
        val handler = @SuppressLint("HandlerLeak") object : Handler() {
            override fun handleMessage(msg: Message) {
                super.handleMessage(msg)
                onGet(msg.data.getString("value").toString())
            }
        }
        Thread {
            reference.addValueEventListener(object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    val bundle = Bundle()
                    val message = handler.obtainMessage()
                    bundle.putString("value", "${snapshot.value}")
                    message.data = bundle
                    handler.sendMessage(message)
                }
                override fun onCancelled(error: DatabaseError) {}
            })
        }.start()
    }
}