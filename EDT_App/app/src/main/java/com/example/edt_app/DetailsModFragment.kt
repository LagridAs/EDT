package com.example.edt_app

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView

class DetailsModFragment : Fragment() {
    private var v:View?=null
    lateinit var comm: CommSeance
    private lateinit var seance:Seance
    private var intituleView:TextView?=null
    private var dureeView:TextView?=null
    private var ensView:TextView?=null
    private var detailsnomView:TextView?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        v=inflater.inflate(R.layout.fragment_details_mod, container, false)
        return v
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        comm = activity as CommSeance

        intituleView= v?.findViewById(R.id.intituleModView)
        dureeView= v?.findViewById(R.id.dureeModView)
        ensView=v?.findViewById(R.id.ensModView)
        detailsnomView=v?.findViewById(R.id.nomDetailModView)

        seance= arguments?.getSerializable("seance") as Seance
        intituleView?.text=seance.module?.intitule
        dureeView?.text="a".plus(" ").plus(seance.module?.duree.toString()).plus(" ").plus("heures par Semaine")
        ensView?.text="Ens".plus(" ").plus(seance.module?.ens?.nom)
        detailsnomView?.text="Module".plus(" ").plus(seance.module?.nomdetails)


        val fragment=DetailsEnsFragment()
        val reference= R.id.ensP
        ensView?.setOnClickListener {
            comm.passSeance(seance,fragment,reference)
        }
    }

    companion object {
        fun newInstance():DetailsModFragment{
            return DetailsModFragment()
        }
    }
}
