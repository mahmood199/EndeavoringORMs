package com.example.endeavoringorms.persistence.room.sql_views

import androidx.room.DatabaseView


@DatabaseView(
    viewName = "ownerView",
    value = "SELECT name, age FROM owner"
)
data class OwnerView(
    val name: Long,
    val age: Int,
)