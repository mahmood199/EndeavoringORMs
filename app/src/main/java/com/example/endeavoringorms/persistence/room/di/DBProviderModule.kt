package com.example.endeavoringorms.persistence.room.di

import android.app.Application
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.endeavoringorms.persistence.room.db.RoomApplicationDatabase
import com.example.endeavoringorms.persistence.room.migrations.MIGRATION_2_to_3
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
@RequiresApi(Build.VERSION_CODES.O)
object DBProviderModule {

    fun provideDatabase(@ApplicationContext application: Application): RoomApplicationDatabase {
        return Room.databaseBuilder(
            application,
            RoomApplicationDatabase::class.java,
            "db_using_room"
        ).addMigrations(MIGRATION_2_to_3).build()
    }



}