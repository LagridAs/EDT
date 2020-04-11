package com.example.edt_app

import android.content.ContentValues
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
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
        private var picLivre: ImageView?=null
        private var titrLivre: TextView?=null
        private var autrLivre: TextView?=null
        private var voirLivreBtn: Button?=null

        init {
            picLivre=itemView.findViewById(R.id.livrepic)
            titrLivre=itemView.findViewById(R.id.titreLiv)
            autrLivre=itemView.findViewById(R.id.auteur)
            voirLivreBtn=itemView.findViewById(R.id.voirBtn)
        }

        fun bind(seance: Seance){
            livre.imageLivre?.let { picLivre?.setImageResource(it) }
            titrLivre?.text=livre.titre
            Log.d(ContentValues.TAG,titrLivre?.text as String)
            autrLivre?.text="de".plus(" ").plus(livre.auteur?.Nom)
            voirLivreBtn?.setOnClickListener{
                onItemClick?.invoke(seance)
            }
        }

    }

}