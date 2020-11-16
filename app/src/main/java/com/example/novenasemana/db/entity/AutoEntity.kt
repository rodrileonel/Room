package com.example.novenasemana.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "auto")
data class AutoEntity(
    @PrimaryKey(autoGenerate = true) val idAuto:Int = 0,
    @ColumnInfo(name = "brand") val brand:String,
    @ColumnInfo(name = "model") val model:String,
    @ColumnInfo(name = "year") val year:Int
)