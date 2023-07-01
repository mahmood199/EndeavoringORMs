package com.example.endeavoringorms.persistence.room.migrations

import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase

internal val MIGRATION_2_to_3 = object : Migration(2, 3) {

    override fun migrate(database: SupportSQLiteDatabase) {
        database.execSQL("ALTER TABLE transmogrified ADD COLUMN area_name TEXT NOT NULL")
    }

}