package com.example.edt_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(),CommJour {
    private lateinit var jourAdapter:JourAdapter
    private lateinit var jourList:MutableList<Jour>
    private lateinit var linearLayoutManager:LinearLayoutManager


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        jourList= mutableListOf(
            Jour(JourEnum.DIMANCHE,4),
            Jour(JourEnum.LUNDI,3),
            Jour(JourEnum.MARDI,2),
            Jour(JourEnum.MERCREDI,4),
            Jour(JourEnum.JEUDI,3)
        )

        jourAdapter=JourAdapter(jourList)
        linearLayoutManager = LinearLayoutManager(this)
        recyclerJour.apply {
            adapter= jourAdapter
            layoutManager= linearLayoutManager
        }

        jourAdapter.onItemClick = { jour ->
            jrComm(jour)
            Log.d("FRAGMANRT", jour.name.toString())
        }



    }

    override fun jrComm(jour: Jour) {
        Log.d("MAINACT",jour.name.toString())
        val intent = Intent(this@MainActivity,DetailsSeanceActivity::class.java)
        intent.putExtra("jour",jour)
        startActivity(intent)    }
}
