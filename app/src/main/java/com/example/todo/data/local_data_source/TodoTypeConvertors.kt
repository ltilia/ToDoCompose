package com.example.todo.data.local_data_source

import androidx.room.TypeConverter
import java.util.UUID

class TodoTypeConvertors {

    @TypeConverter
    fun toString(uuid: UUID): String = uuid.toString()

    @TypeConverter
    fun toUUID(string: String): UUID = UUID.fromString(string)
}
