package com.example.edt_app

import android.content.ContentValues
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentTransaction
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_details_seance.*
import kotlinx.android.synthetic.main.fragment_seance_list.*

class SeanceListFragment : Fragment(){
    private lateinit var jour:Jour
    private lateinit var dimList:MutableList<Seance>
    private lateinit var lunList:MutableList<Seance>
    private lateinit var marList:MutableList<Seance>
    private lateinit var merList:MutableList<Seance>
    private lateinit var jeuList:MutableList<Seance>
    private lateinit var ensList:MutableList<Enseignant>
    private lateinit var moduleList:MutableList<Module>
    private lateinit var seanceAdapter: SeanceAdapter
    private lateinit var layoutManagerSeance: LinearLayoutManager
    private lateinit var comm:CommSeance
    private var v:View?=null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        v=inflater.inflate(R.layout.fragment_seance_list, container, false)
        return v
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        comm = activity as CommSeance

        jour = arguments?.getSerializable("jour") as Jour
        Log.d(ContentValues.TAG, "dakhal details seancelist fragment")
        Log.d(ContentValues.TAG, jour.name.toString())
        ensList = mutableListOf(
            Enseignant(
                v?.resources?.getString(R.string.ensname1),
                v?.resources?.getString(R.string.mail1),
                v?.resources?.getString(R.string.diplome1)
            ),
            Enseignant(
                v?.resources?.getString(R.string.ensname2),
                v?.resources?.getString(R.string.mail2),
                v?.resources?.getString(R.string.diplome2)
            ),
            Enseignant(
                v?.resources?.getString(R.string.ensname3),
                v?.resources?.getString(R.string.mail3),
                v?.resources?.getString(R.string.diplome3)
            ),
            Enseignant(
                v?.resources?.getString(R.string.ensname4),
                v?.resources?.getString(R.string.mail4),
                v?.resources?.getString(R.string.diplome4)
            ),
            Enseignant(
                v?.resources?.getString(R.string.ensname5),
                v?.resources?.getString(R.string.mail5),
                v?.resources?.getString(R.string.diplome5)
            )

        )

        moduleList = mutableListOf(
            Module(v?.resources?.getString(R.string.module1), 2, ensList[0]),
            Module(v?.resources?.getString(R.string.module2), 2, ensList[1]),
            Module(v?.resources?.getString(R.string.module3), 2, ensList[2]),
            Module(v?.resources?.getString(R.string.module4), 2, ensList[3]),
            Module(v?.resources?.getString(R.string.module5), 2, ensList[4])
        )

        Log.d(ContentValues.TAG, "tahtiii kayen hadikk ta3 localTimeeeeeee")


        dimList = mutableListOf(
            Seance(
                v?.resources?.getString(R.string.senace1),
                v?.resources?.getString(R.string.time08),
                v?.resources?.getString(R.string.time103),
                moduleList[0],
                v?.resources?.getString(R.string.salle1)
            ),
            Seance(
                v?.resources?.getString(R.string.senace2),
                v?.resources?.getString(R.string.time104),
                v?.resources?.getString(R.string.time121),
                moduleList[1],
                v?.resources?.getString(R.string.salle2)
            ),
            Seance(
                v?.resources?.getString(R.string.senace3),
                v?.resources?.getString(R.string.time13),
                v?.resources?.getString(R.string.time15),
                moduleList[2],
                v?.resources?.getString(R.string.salle3)
            ),
            Seance(
                v?.resources?.getString(R.string.senace1),
                v?.resources?.getString(R.string.time151),
                v?.resources?.getString(R.string.time171),
                moduleList[3],
                v?.resources?.getString(R.string.salle4)
            )
        )
        lunList = mutableListOf(
            Seance(
                v?.resources?.getString(R.string.senace1),
                v?.resources?.getString(R.string.time08),
                v?.resources?.getString(R.string.time100),
                moduleList[0],
                v?.resources?.getString(R.string.salle5)
            ),
            Seance(
                v?.resources?.getString(R.string.senace2),
                v?.resources?.getString(R.string.time101),
                v?.resources?.getString(R.string.time121),
                moduleList[2],
                v?.resources?.getString(R.string.salle2)
            ),
            Seance(
                v?.resources?.getString(R.string.senace3),
                v?.resources?.getString(R.string.time13),
                v?.resources?.getString(R.string.time15),
                moduleList[4],
                v?.resources?.getString(R.string.salle4)
            )
        )
        marList = mutableListOf(
            Seance(
                v?.resources?.getString(R.string.senace1),
                v?.resources?.getString(R.string.time08),
                v?.resources?.getString(R.string.time103),
                moduleList[3],
                v?.resources?.getString(R.string.salle1)
            ),
            Seance(
                v?.resources?.getString(R.string.senace1),
                v?.resources?.getString(R.string.time104),
                v?.resources?.getString(R.string.time124),
                moduleList[2],
                v?.resources?.getString(R.string.salle3)
            )
        )
        merList = mutableListOf(
            Seance(
                v?.resources?.getString(R.string.senace1),
                v?.resources?.getString(R.string.time08),
                v?.resources?.getString(R.string.time103),
                moduleList[4],
                v?.resources?.getString(R.string.salle4)
            ),
            Seance(
                v?.resources?.getString(R.string.senace2),
                v?.resources?.getString(R.string.time104),
                v?.resources?.getString(R.string.time121),
                moduleList[3],
                v?.resources?.getString(R.string.salle3)
            ),
            Seance(
                v?.resources?.getString(R.string.senace3),
                v?.resources?.getString(R.string.time13),
                v?.resources?.getString(R.string.time15),
                moduleList[1],
                v?.resources?.getString(R.string.salle1)
            )
        )
        jeuList = mutableListOf(
            Seance(
                v?.resources?.getString(R.string.senace4),
                v?.resources?.getString(R.string.time08),
                v?.resources?.getString(R.string.time121),
                moduleList[3],
                v?.resources?.getString(R.string.salle3)
            ),
            Seance(
                v?.resources?.getString(R.string.senace3),
                v?.resources?.getString(R.string.time13),
                v?.resources?.getString(R.string.time15),
                moduleList[1],
                v?.resources?.getString(R.string.salle1)
            )
        )

        when (jour.name) {
            JourEnum.DIMANCHE -> seanceAdapter = SeanceAdapter(dimList)
            JourEnum.LUNDI -> seanceAdapter = SeanceAdapter(lunList)
            JourEnum.MARDI -> seanceAdapter = SeanceAdapter(marList)
            JourEnum.MERCREDI -> seanceAdapter = SeanceAdapter(merList)
            JourEnum.JEUDI -> seanceAdapter = SeanceAdapter(jeuList)
        }
        layoutManagerSeance = LinearLayoutManager(context)
        seanceGrand.apply {
            adapter = seanceAdapter
            layoutManager = layoutManagerSeance
            Log.d(ContentValues.TAG, "initialisina seanceGrand")
        }

        val fragment = DetailsModFragment()
        val reference = R.id.moduleP
        seanceAdapter.onItemClick = { seance ->
            comm.passSeance(seance, fragment, reference)
            Log.d(ContentValues.TAG, "passina seance")
        }

        }

    companion object {
        fun newInstance():SeanceListFragment{
            return SeanceListFragment()
        }
    }

}

