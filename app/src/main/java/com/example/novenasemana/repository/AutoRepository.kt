package com.example.novenasemana.repository

import androidx.lifecycle.LiveData
import com.example.novenasemana.db.dao.AutoDao
import com.example.novenasemana.db.entity.AutoEntity

class AutoRepository (private val autoDao:AutoDao){

    val autos:LiveData<List<AutoEntity>> = autoDao.getAutos()

    suspend fun insertAuto(auto:AutoEntity){
        autoDao.insertAuto(auto)
    }
}