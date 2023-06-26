package com.example.endeavoringorms.persistence.room.type_converters

import android.location.Location
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.room.TypeConverter
import java.time.Instant

@RequiresApi(Build.VERSION_CODES.O)
class TypeTransmogrifier {
    @TypeConverter
    fun instantToLong(timestamp: Instant?) = timestamp?.toEpochMilli()

    @TypeConverter
    fun longToInstant(timestamp: Long?) =
        timestamp?.let { Instant.ofEpochMilli(it) }


    @TypeConverter
    fun locationToString(location: Location?) =
        location?.let { "${it.latitude};${it.longitude}" }

    @TypeConverter
    fun stringToLocation(location: String?) = location?.let {
        val pieces = location.split(';')
        if (pieces.size == 2) {
            try {
                Location(null as String?).apply {
                    latitude = pieces[0].toDouble()
                    longitude = pieces[1].toDouble()
                }
            } catch (e: Exception) {
                null
            }
        } else {
            null
        }
    }


}