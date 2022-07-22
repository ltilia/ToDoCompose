package com.example.todo.domain

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity
data class Todo(
    @PrimaryKey
    val id: UUID = UUID.randomUUID(),
    val title: String,
    val content: String,
    val color: Int
)
