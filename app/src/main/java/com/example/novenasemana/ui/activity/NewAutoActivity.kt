package com.example.novenasemana.ui.activity

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.novenasemana.R
import kotlinx.android.synthetic.main.activity_new_auto.*

class NewAutoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_auto)

        btSave.setOnClickListener {
            val replyIntent = Intent()

            val brand = etBrand.text.toString()
            val model = etModel.text.toString()
            val year = etYear.text.toString()

            replyIntent.putExtra("brand",brand)
            replyIntent.putExtra("model",model)
            replyIntent.putExtra("year",year)

            setResult(Activity.RESULT_OK,replyIntent)

            finish()
        }
    }
}
