package com.example.myintentapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MoveWithObjectActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_move_with_object)

        if(intent != null){
            val tvObject : TextView = findViewById(R.id.tv_object)
            val manusia : Person? = intent.getParcelableExtra(Extra_Person)
            val name :String? = manusia?.name
            val email : String? = manusia?.email
            val city :String? = manusia?.city
            val text = "nama : $name, Email : $email, City : $city"
            tvObject.setText(text)
        }
    }
    companion object{
        const val Extra_Person = "extra_person"
    }
}