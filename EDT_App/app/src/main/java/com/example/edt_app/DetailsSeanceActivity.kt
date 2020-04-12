package com.example.edt_app

import android.content.ContentValues
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.recyclerview.widget.GridLayoutManager
import kotlinx.android.synthetic.main.activity_details_seance.*
import java.util.*

class DetailsSeanceActivity : AppCompatActivity(),CommJour,CommSeance {
    private lateinit var jour:Jour
    private lateinit var dimList:MutableList<Seance>
    private lateinit var lunList:MutableList<Seance>
    private lateinit var marList:MutableList<Seance>
    private lateinit var merList:MutableList<Seance>
    private lateinit var jeuList:MutableList<Seance>
    private lateinit var ensList:MutableList<Enseignant>
    private lateinit var moduleList:MutableList<Module>
    private lateinit var seanceAdapter: SeanceAdapter
    private lateinit var layoutManagerSeance: GridLayoutManager

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details_seance)
        //jour=intent.getStringExtra("jour") as Jour
        val tablet= resources.getBoolean(R.bool.isTablet)
        val land =resources.getBoolean(R.bool.isLand)
        if(tablet || land){
            calendarView.setOnDateChangeListener { view, year, month, dayOfMonth ->
                Toast.makeText(getApplicationContext(), dayOfMonth.toString().plus("/").plus(month.toString()).plus("/").plus(year.toString()), Toast.LENGTH_LONG).show()
                val calendar: Calendar = Calendar.getInstance()
                calendar.set(year, month, dayOfMonth)
                val dayOfWeek: Int = calendar.get(Calendar.DAY_OF_WEEK)
                when (dayOfWeek) {
                    1 -> jour=Jour(JourEnum.DIMANCHE,4)
                    2 -> jour=Jour(JourEnum.LUNDI,3)
                    3 -> jour=Jour(JourEnum.MARDI,2)
                    4 -> jour=Jour(JourEnum.MERCREDI,3)
                    5 -> jour=Jour(JourEnum.JEUDI,2)
                    else->{
                        Toast.makeText(applicationContext, "C'est un weekend", Toast.LENGTH_LONG).show()
                    }
                }

                jrComm(jour)
            }
        }
        else {
            jour = intent.getSerializableExtra("jour") as Jour
            Log.d(ContentValues.TAG, "dakhal details seance activity")
            Log.d(ContentValues.TAG, jour.name.toString())
            ensList = mutableListOf(
                Enseignant(
                    getString(R.string.ensname1),
                    getString(R.string.mail1),
                    getString(R.string.diplome1)
                ),
                Enseignant(
                    getString(R.string.ensname2),
                    getString(R.string.mail2),
                    getString(R.string.diplome2)
                ),
                Enseignant(
                    getString(R.string.ensname3),
                    getString(R.string.mail3),
                    getString(R.string.diplome3)
                ),
                Enseignant(
                    getString(R.string.ensname4),
                    getString(R.string.mail4),
                    getString(R.string.diplome4)
                ),
                Enseignant(
                    getString(R.string.ensname5),
                    getString(R.string.mail5),
                    getString(R.string.diplome5)
                )

            )

            moduleList = mutableListOf(
                Module(getString(R.string.module1),getString(R.string.DetailsNom1), 2, ensList[0]),
                Module(getString(R.string.module2),getString(R.string.DetailsNom2), 2, ensList[1]),
                Module(getString(R.string.module3),getString(R.string.DetailsNom3), 2, ensList[2]),
                Module(getString(R.string.module4),getString(R.string.DetailsNom4), 2, ensList[3]),
                Module(getString(R.string.module5),getString(R.string.DetailsNom5), 2, ensList[4])
            )

            Log.d(ContentValues.TAG, "tahtiii kayen hadikk ta3 localTimeeeeeee")


            dimList = mutableListOf(
                Seance(
                    getString(R.string.senace1),
                    getString(R.string.time08),
                    getString(R.string.time103),
                    moduleList[0],
                    getString(R.string.salle1)
                ),
                Seance(
                    getString(R.string.senace2),
                    getString(R.string.time104),
                    getString(R.string.time121),
                    moduleList[1],
                    getString(R.string.salle2)
                ),
                Seance(
                    getString(R.string.senace3),
                    getString(R.string.time13),
                    getString(R.string.time15),
                    moduleList[2],
                    getString(R.string.salle3)
                ),
                Seance(
                    getString(R.string.senace1),
                    getString(R.string.time151),
                    getString(R.string.time171),
                    moduleList[3],
                    getString(R.string.salle4)
                )
            )
            lunList = mutableListOf(
                Seance(
                    getString(R.string.senace1),
                    getString(R.string.time08),
                    getString(R.string.time100),
                    moduleList[0],
                    getString(R.string.salle5)
                ),
                Seance(
                    getString(R.string.senace2),
                    getString(R.string.time101),
                    getString(R.string.time121),
                    moduleList[2],
                    getString(R.string.salle2)
                ),
                Seance(
                    getString(R.string.senace3),
                    getString(R.string.time13),
                    getString(R.string.time15),
                    moduleList[4],
                    getString(R.string.salle4)
                )
            )
            marList = mutableListOf(
                Seance(
                    getString(R.string.senace1),
                    getString(R.string.time08),
                    getString(R.string.time103),
                    moduleList[3],
                    getString(R.string.salle1)
                ),
                Seance(
                    getString(R.string.senace1),
                    getString(R.string.time104),
                    getString(R.string.time124),
                    moduleList[2],
                    getString(R.string.salle3)
                )
            )
            merList = mutableListOf(
                Seance(
                    getString(R.string.senace1),
                    getString(R.string.time08),
                    getString(R.string.time103),
                    moduleList[4],
                    getString(R.string.salle4)
                ),
                Seance(
                    getString(R.string.senace2),
                    getString(R.string.time104),
                    getString(R.string.time121),
                    moduleList[3],
                    getString(R.string.salle3)
                ),
                Seance(
                    getString(R.string.senace3),
                    getString(R.string.time13),
                    getString(R.string.time15),
                    moduleList[1],
                    getString(R.string.salle1)
                )
            )
            jeuList = mutableListOf(
                Seance(
                    getString(R.string.senace4),
                    getString(R.string.time08),
                    getString(R.string.time121),
                    moduleList[3],
                    getString(R.string.salle3)
                ),
                Seance(
                    getString(R.string.senace3),
                    getString(R.string.time13),
                    getString(R.string.time15),
                    moduleList[1],
                    getString(R.string.salle1)
                )
            )

            when (jour.name) {
                JourEnum.DIMANCHE -> seanceAdapter = SeanceAdapter(dimList)
                JourEnum.LUNDI -> seanceAdapter = SeanceAdapter(lunList)
                JourEnum.MARDI -> seanceAdapter = SeanceAdapter(marList)
                JourEnum.MERCREDI -> seanceAdapter = SeanceAdapter(merList)
                JourEnum.JEUDI -> seanceAdapter = SeanceAdapter(jeuList)
            }
            layoutManagerSeance = GridLayoutManager(this, 2)
            recyclerSeance.apply {
                adapter = seanceAdapter
                layoutManager = layoutManagerSeance
                Log.d(ContentValues.TAG, "initialisina recyclerSeance")
            }

                seanceAdapter.onItemClick = { seance ->
                    Log.d(ContentValues.TAG, "dakhal portrait detailsseance")
                    val intent = Intent(this@DetailsSeanceActivity, ModuleActivity::class.java)
                    intent.putExtra("seance", seance)
                    startActivity(intent)
                }
            }
        }
    override fun jrComm(jour: Jour) {
        Log.d(ContentValues.TAG,"dakhal jrComm")
        val bundle1 = Bundle()
        bundle1.putSerializable("jour",jour)
        val fr=SeanceListFragment()
        val transaction = this.supportFragmentManager.beginTransaction()
        fr.arguments = bundle1
        transaction.replace(R.id.listSeance, fr)
        transaction.addToBackStack(null)
        transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
        transaction.commit()
    }

    override fun passSeance(seance: Seance, fragment: Fragment, reference: Int) {
        Log.d(ContentValues.TAG,"dakhal passSeance")
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
