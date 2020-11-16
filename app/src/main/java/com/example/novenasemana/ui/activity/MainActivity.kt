package com.example.novenasemana.ui.activity

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.novenasemana.R
import com.example.novenasemana.db.entity.AutoEntity
import com.example.novenasemana.ui.adapters.AutoAdapter
import com.example.novenasemana.viewmodel.AutoViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var autoViewModel: AutoViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recycler = recyclerAutos as RecyclerView
        val adapter = AutoAdapter(this)
        recycler.adapter = adapter
        recycler.layoutManager = LinearLayoutManager(this)

        autoViewModel = ViewModelProvider(this).get(AutoViewModel::class.java)
        autoViewModel.autos.observe(this, Observer { autos ->
            autos?.let { adapter.setAutos(autos) }
        })

        btAdd.setOnClickListener {
            val intent = Intent(this,NewAutoActivity::class.java)
            startActivityForResult(intent,100)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        lateinit var brand:String
        lateinit var model:String
        lateinit var year:String

        if(requestCode==100 && resultCode == Activity.RESULT_OK){
            data?.getStringExtra("brand")?.let { brand = it}
            data?.getStringExtra("model")?.let { model = it}
            data?.getStringExtra("year")?.let { year = it}

            autoViewModel.insertAuto(AutoEntity(brand = brand,model = model,year = year.toInt()))
        }
    }
}
