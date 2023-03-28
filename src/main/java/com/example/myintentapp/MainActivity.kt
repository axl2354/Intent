package com.example.myintentapp

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts
import com.example.myintentapp.MoveForResultActivity.Companion.RESULT_CODE

class MainActivity : AppCompatActivity(),View.OnClickListener {
    private lateinit var tvResult: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnMoveActivity: Button =
            findViewById(R.id.btn_move_activity)
        btnMoveActivity.setOnClickListener(this)

        val btnMoveWithDataActivity: Button =
            findViewById(R.id.btn_move_activity_data)
        btnMoveWithDataActivity.setOnClickListener(this)

        val btnDialPhone: Button =
            findViewById(R.id.btn_dial_number)
        btnDialPhone.setOnClickListener(this)

        val btnMoveWithObject: Button =
            findViewById(R.id.btn_move_activity_object)
        btnMoveWithObject.setOnClickListener(this)

        val btnMoveWithResult: Button =
            findViewById(R.id.btn_move_activity_result)
        btnMoveWithResult.setOnClickListener(this)

    }
    override fun onClick(v: View) {
        when (v.id) {
            R.id.btn_move_activity -> {
                val moveIntent = Intent(
                    this@MainActivity,
                    MoveActivity::class.java
                )
                startActivity(moveIntent)
            }
            R.id.btn_move_activity_data -> {
                val moveWithDataIntent =
                    Intent(this@MainActivity, MoveWithDataActivity::class.java)
                moveWithDataIntent.putExtra(MoveWithDataActivity.EXTRA_NAME, "Dicoding Academy Boy")
                moveWithDataIntent.putExtra(MoveWithDataActivity.EXTRA_AGE, 5)
                startActivity(moveWithDataIntent)
            }
            R.id.btn_dial_number -> {
                val phoneNumber = "082333874780"
                val dialPhoneIntent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:$phoneNumber"))
                startActivity(dialPhoneIntent)

            }
            R.id.btn_move_activity_object -> {
                val person =
                    Person("Axl", "axl_fanany_30rpl@student.smktelkom-mlg.sch.id", "malang")
                val moveWithObjectActivity =
                    Intent(this@MainActivity, MoveWithObjectActivity::class.java)
                moveWithObjectActivity.putExtra(MoveWithObjectActivity.Extra_Person, person)
                startActivity(moveWithObjectActivity)
            }
            R.id.btn_move_activity_result -> {
                val moveForResultIntent =
                    Intent(this@MainActivity,
                    MoveForResultActivity::class.java)
                getResult.launch(moveForResultIntent)
            }
        }
    }
    private val getResult =
        registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()){
            if(it.resultCode == RESULT_CODE){
                val value = it.data?.getIntExtra(
                    MoveForResultActivity.EXTRA_SELECTED_VALUE,0)
                tvResult.setText("Hasil $value")
            }
        }

}