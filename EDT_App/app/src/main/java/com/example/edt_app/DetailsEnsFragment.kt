package com.example.edt_app

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.TextureView
import android.view.View
import android.view.ViewGroup
import android.widget.TextView


class DetailsEnsFragment : Fragment() {
    private var v:View?=null
    private var nomView:TextView?=null
    private var mailView:TextView?=null
    private var diplomeView:TextView?=null
    private lateinit var seance:Seance

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        v=inflater.inflate(R.layout.fragment_details_ens, container, false)
        return v
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        seance = arguments?.getSerializable("seance") as Seance
        nomView=v?.findViewById(R.id.nomEnsView)
        mailView=v?.findViewById(R.id.mailEnsView)
        diplomeView=v?.findViewById(R.id.diplomeEnsView)

        nomView?.text=seance.module?.ens?.nom
        mailView?.text=seance.module?.ens?.mail
        diplomeView?.text=seance.module?.ens?.Diplome


    }

    companion object {
        fun newInstance():DetailsEnsFragment {
            return DetailsEnsFragment()
        }
    }
}
