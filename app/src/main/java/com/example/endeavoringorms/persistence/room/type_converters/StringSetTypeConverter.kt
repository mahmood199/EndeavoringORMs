package com.example.endeavoringorms.persistence.room.type_converters

import android.util.JsonReader
import android.util.JsonWriter
import androidx.room.TypeConverter
import java.io.StringReader
import java.io.StringWriter

class StringSetTypeConverter {

    @TypeConverter
    fun stringSetToString(list: Set<String>?) = list?.let {
        val sw = StringWriter()
        val json = JsonWriter(sw)
        json.beginArray()
        list.forEach { json.value(it) }
        json.endArray()
        json.close()
        sw.buffer.toString()
    }

    @TypeConverter
    fun stringToStringSet(stringified: String?) = stringified?.let {
        val json = JsonReader(StringReader(it))
        val result = mutableSetOf<String>()
        json.beginArray()
        while (json.hasNext()) {
            result += json.nextString()
        }
        json.endArray()
        result.toSet()
    }


}