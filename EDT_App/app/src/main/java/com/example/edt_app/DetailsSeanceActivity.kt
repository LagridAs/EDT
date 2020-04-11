package com.example.edt_app

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.recyclerview.widget.GridLayoutManager
import kotlinx.android.synthetic.main.activity_details_seance.*
import java.time.LocalTime

class DetailsSeanceActivity : AppCompatActivity(),CommSeance {
    private var jour:Jour?=null
    private lateinit var dimList:MutableList<Seance>
    private lateinit var lunList:MutableList<Seance>
    private lateinit var marList:MutableList<Seance>
    private lateinit var merList:MutableList<Seance>
    private lateinit var jeuList:MutableList<Seance>
    private lateinit var ensList:MutableList<Enseignant>
    private lateinit var moduleList:MutableList<Module>
    private lateinit var seanceAdapter: SeanceAdapter
    private lateinit var layoutManager: GridLayoutManager

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details_seance)
        //jour=intent.getStringExtra("jour") as Jour
        jour=intent.getSerializableExtra("jour") as Jour


        ensList= mutableListOf(
            Enseignant(getString(R.string.ensname1),getString(R.string.mail1),getString(R.string.diplome1)),
            Enseignant(getString(R.string.ensname2),getString(R.string.mail2),getString(R.string.diplome2)),
            Enseignant(getString(R.string.ensname3),getString(R.string.mail3),getString(R.string.diplome3)),
            Enseignant(getString(R.string.ensname4),getString(R.string.mail4),getString(R.string.diplome4)),
            Enseignant(getString(R.string.ensname5),getString(R.string.mail5),getString(R.string.diplome5))

            )

        moduleList= mutableListOf(
            Module(getString(R.string.module1),2,ensList[0]),
            Module(getString(R.string.module2),2,ensList[1]),
            Module(getString(R.string.module3),2,ensList[2]),
            Module(getString(R.string.module4),2,ensList[3]),
            Module(getString(R.string.module5),2,ensList[4])
            )

            dimList= mutableListOf(
                Seance(getString(R.string.senace1), null,LocalTime.of(8, 30, 0),LocalTime.of(10, 30, 0),moduleList[0],getString(R.string.salle1)),
                Seance(getString(R.string.senace2), null,LocalTime.of(10, 40, 0),LocalTime.of(12, 10, 0),moduleList[1],getString(R.string.salle2)),
                Seance(getString(R.string.senace3),null, LocalTime.of(13, 0,0),LocalTime.of(15, 0, 0),moduleList[2],getString(R.string.salle3)),
                Seance(getString(R.string.senace1),null, LocalTime.of(15, 10, 0),LocalTime.of(17, 10, 0),moduleList[3],getString(R.string.salle4))
            )
            lunList= mutableListOf(
                Seance(getString(R.string.senace1), null,LocalTime.of(8, 30, 0),LocalTime.of(10, 0, 0),moduleList[5],getString(R.string.salle5)),
                Seance(getString(R.string.senace2),null, LocalTime.of(10, 10, 0),LocalTime.of(12, 10, 0),moduleList[2],getString(R.string.salle2)),
                Seance(getString(R.string.senace3),null, LocalTime.of(13, 0,0),LocalTime.of(15, 0, 0),moduleList[4],getString(R.string.salle4))
            )
            marList= mutableListOf(
                Seance(getString(R.string.senace1),null, LocalTime.of(8, 30, 0),LocalTime.of(10, 30, 0),moduleList[5],getString(R.string.salle1)),
                Seance(getString(R.string.senace1), null,LocalTime.of(10, 40, 0),LocalTime.of(12, 40, 0),moduleList[6],getString(R.string.salle3))
            )
            merList= mutableListOf(
                Seance(getString(R.string.senace1),null, LocalTime.of(8, 30, 0),LocalTime.of(10, 30, 0),moduleList[4],getString(R.string.salle4)),
                Seance(getString(R.string.senace2), null,LocalTime.of(10, 40, 0),LocalTime.of(12, 10, 0),moduleList[3],getString(R.string.salle3)),
                Seance(getString(R.string.senace3), null,LocalTime.of(13, 0,0),LocalTime.of(15, 0, 0),moduleList[1],getString(R.string.salle1))
            )
            jeuList= mutableListOf(
                Seance(getString(R.string.senace4),null, LocalTime.of(8, 30, 0),LocalTime.of(12, 0, 0),moduleList[3],getString(R.string.salle3)),
                Seance(getString(R.string.senace3),null, LocalTime.of(13, 0, 0),LocalTime.of(15, 0, 0),moduleList[1],getString(R.string.salle1))
            )

        when(jour!!.name) {
            JourEnum.DIMANCHE -> seanceAdapter= SeanceAdapter(dimList)
            JourEnum.LUNDI -> seanceAdapter= SeanceAdapter(lunList)
            JourEnum.MARDI -> seanceAdapter= SeanceAdapter(marList)
            JourEnum.MERCREDI -> seanceAdapter= SeanceAdapter(merList)
            JourEnum.JEUDI -> seanceAdapter= SeanceAdapter(jeuList)
        }

        layoutManager= GridLayoutManager(this,2)
        recyclerSeance.apply {
            adapter=seanceAdapter
            layoutManager=layoutManager
        }
        val fragment= DetailsModFragment()
        val reference= R.id.moduleplace
        seanceAdapter.onItemClick = { seance ->
            passSeance(seance,fragment,reference)
            Log.d("SeanceAct", seance.nom)
        }




    }

    override fun passSeance(seance: Seance,fragment: Fragment,reference:Int) {
        Log.d("DetailsSc",seance.nom)
        val bundle1 = Bundle()
        bundle1.putSerializable("seance",seance)
        val transaction = this.supportFragmentManager.beginTransaction()
        fragment.arguments = bundle1
        transaction.replace(reference, fragment)
        transaction.addToBackStack(null)
        transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
        transaction.commit()
    }
}
