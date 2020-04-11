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
    private var ensBtn:Button?=null
    lateinit var comm: CommSeance
    private lateinit var seance:Seance
    private var intituleView:TextView?=null
    private var dureeView:TextView?=null

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

        intituleView= v?.findViewById(R.id.intitText)
        dureeView= v?.findViewById(R.id.dureText)
        ensBtn=v?.findViewById(R.id.ensButton)

        seance= arguments?.getSerializable("seance") as Seance
        intituleView?.text=seance.module?.intitule
        dureeView?.text=seance.module?.duree.toString()


        val fragment=DetailsEnsFragment()
        val reference= R.id.ensPlace
        ensBtn?.setOnClickListener {
            comm.passSeance(seance,fragment,reference)
        }
    }

    companion object {
        fun newInstance():DetailsModFragment{
            return DetailsModFragment()
        }
    }
}
