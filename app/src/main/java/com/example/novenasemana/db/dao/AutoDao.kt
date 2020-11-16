package com.example.novenasemana.db.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.novenasemana.db.entity.AutoEntity

@Dao
interface AutoDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertAuto(auto: AutoEntity)

    @Query("SELECT * FROM auto")
    fun getAutos():LiveData<List<AutoEntity>>

    @Query("DELETE FROM auto")
    fun deleteAutos()
}

