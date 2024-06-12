package com.example.rangtech.db

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [InspectionEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun inspectionDao(): InspectionDao
}