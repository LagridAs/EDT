package com.example.edt_app

import android.content.ContentValues
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

/***********Adapter**********************/
class SeanceAdapter(private val seanceList:MutableList<Seance>): RecyclerView.Adapter<SeanceAdapter.SeanceHolder>() {
    var onItemClick: ((Seance) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SeanceHolder {
        return SeanceHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_seance_view, parent, false))
    }

    override fun getItemCount(): Int {
        return seanceList.size
    }

    override fun onBindViewHolder(holder: SeanceHolder, position: Int) {
        val data= seanceList[position]
        return holder.bind(data)
    }

    /***********ViewHolder******************/
    inner class SeanceHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        private var nomSeance:TextView?=null
        private var dateSeance:TextView?=null
        private var salleSeance:TextView?=null
        private var debfinSeance:TextView?=null

        init {
            nomSeance=itemView.findViewById(R.id.nomSeanceView)
            salleSeance=itemView.findViewById(R.id.salleSeanceView)
            debfinSeance=itemView.findViewById(R.id.debfinSeanceView)
        }

        fun bind(seance: Seance){
            nomSeance?.text=(seance.nom).plus(" ").plus(seance.module?.intitule)
            salleSeance?.text="Dans la salle".plus(seance.salle)
            debfinSeance?.text="De".plus(" ").plus(seance.tempsDeb)?.plus(" ").plus("a").plus(" ").plus(seance.tempsFin)
            itemView?.setOnClickListener{
                onItemClick?.invoke(seance)
            }
        }

    }

}