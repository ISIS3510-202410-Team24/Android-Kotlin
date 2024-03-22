package com.example.orderingfoodapp.utils

import android.content.ContentValues.TAG
import android.util.Log
import com.google.android.gms.tasks.Task
import com.google.firebase.Firebase
import com.google.firebase.firestore.DocumentReference
import com.google.firebase.firestore.FieldValue
import com.google.firebase.firestore.firestore

class FirestoreInstance {
    private val db = Firebase.firestore

    private fun addTimestamps(entity: HashMap<Any, Any?>): HashMap<Any, Any?> {

        entity["createdAt"] = FieldValue.serverTimestamp()
        entity["deletedAt"] = null

        return entity
    }

    fun write(collection: String, entity: HashMap<Any, Any?>): Task<DocumentReference> {
        val ref = db.collection(collection)
            .add(addTimestamps(entity))
            .addOnSuccessListener { documentReference ->
                Log.d(TAG, "DocumentSnapshot added with ID: ${documentReference.id}")
            }
            .addOnFailureListener { e ->
                Log.w(TAG, "Error adding document", e)
            }
        return ref
    }

    fun readDocWithName(collection: String, docId: String): MutableMap<String, Any>? {
        val docRef = db.collection(collection).document(docId)
        var data: MutableMap<String, Any>? = null
        docRef.get()
            .addOnSuccessListener { document ->
                if (document != null) {
                    Log.d(TAG, "DocumentSnapshot data: ${document.data}")
                    data = document.data
                } else {
                    Log.d(TAG, "No such document")
                }
            }
            .addOnFailureListener { exception ->
                Log.d(TAG, "get failed with ", exception)
            }
        return data
    }

}