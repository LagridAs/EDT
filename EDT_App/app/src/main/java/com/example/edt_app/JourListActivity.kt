package com.example.edt_app

import android.content.ContentValues
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class JourListActivity : AppCompatActivity() {

    private lateinit var jourAdapter:JourAdapter
    private lateinit var jourList:MutableList<Jour>
    private lateinit var linearLayoutManager: LinearLayoutManager


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
            Log.d(ContentValues.TAG,"initialisinaaa recyclerview")
            adapter= jourAdapter
            layoutManager= linearLayoutManager
            Log.d(ContentValues.TAG,"khrejna recyclerview")

        }

        jourAdapter.onItemClick = { jour ->
            jrComm(jour)
            Log.d(ContentValues.TAG,"passina jour")
        }
    }
    override fun jrComm(jour: Jour) {
        Log.d(ContentValues.TAG,"dakhal jrComm")
        val intent = Intent(this@JourListActivity,DetailsSeanceActivity::class.java)
        intent.putExtra("jour",jour)
        startActivity(intent) }
}
