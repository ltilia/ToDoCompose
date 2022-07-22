package com.example.todo.data.local_data_source

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.todo.domain.Todo

@Database(version = 1, entities = [Todo::class])
@TypeConverters(TodoTypeConvertors::class)
abstract class TodoDatabase : RoomDatabase() {
    abstract val dao: TodoDao
}
