package com.example.orderingfoodapp.data.entity

import com.google.firebase.firestore.ServerTimestamp
import java.util.Date

class ProductEnity (
    override var id: String? = null,
    @ServerTimestamp
    override var createdAt: Date? = null,
    @ServerTimestamp
    override var deletedAt: Date? = null,
    override var collection: String = "order",


    var restaurantId: String? = null,
    var name: String? = null,
    var basePrice: Float? = null,
    var description: String? = null,
    var tags: Array<String>? = null,
    var rating: Float? = null,

): BaseEntity(id, createdAt, deletedAt, collection) {
    constructor(data: HashMap<String, Any?>) : this() {
        data.toEntity<OrderEntity>()
    }
}