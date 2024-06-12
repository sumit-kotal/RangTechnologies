package com.example.rangtech.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface InspectionDao {
    @Query("SELECT * FROM inspections WHERE id = :id")
    suspend fun getInspectionById(id: Int): InspectionEntity?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertInspection(inspection: InspectionEntity)
}