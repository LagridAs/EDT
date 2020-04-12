package com.example.edt_app

import android.content.ContentValues
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tablet = resources.getBoolean(R.bool.isTablet)
        val land = resources.getBoolean(R.bool.isLand)

        startBtn.setOnClickListener{
            if(tablet ||land){
                Log.d(ContentValues.TAG,"dakhal tablet ou land")
                val intent1 = Intent(this@MainActivity,DetailsSeanceActivity::class.java)
                startActivity(intent1)
            }
            else{
                Log.d(ContentValues.TAG,"dakhal portrait")
                val intent1 = Intent(this@MainActivity,JourListActivity::class.java)
                startActivity(intent1)

            }

        }

    }
}
