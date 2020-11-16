package com.example.novenasemana.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.novenasemana.db.AppRoomDatabase
import com.example.novenasemana.db.entity.AutoEntity
import com.example.novenasemana.repository.AutoRepository
import kotlinx.coroutines.launch

class AutoViewModel(application: Application):AndroidViewModel(application){

    val autos:LiveData<List<AutoEntity>>
    private val autoRepo:AutoRepository

    init {
        val autoDao = AppRoomDatabase.getDatabase(application).autoDao()
        autoRepo = AutoRepository(autoDao)
        autos = autoRepo.autos
    }

    fun insertAuto(auto:AutoEntity) = viewModelScope.launch {
        autoRepo.insertAuto(auto)
    }

}