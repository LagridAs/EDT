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

class JourAdapter(private val jourList: MutableList<Jour>): RecyclerView.Adapter<JourAdapter.JourHolder>(){
    var onItemClick: ((Jour) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): JourHolder {
        val inflater = LayoutInflater.from(parent.context)
        Log.d(ContentValues.TAG,"dakhal oncreteViewHolder")

        return JourHolder(inflater, parent)
    }

    override fun getItemCount(): Int {
        return jourList.size
    }

    override fun onBindViewHolder(holder: JourHolder, position: Int) {
        val data = jourList[position]
        holder.bind(data)
        Log.d(ContentValues.TAG,"dakhal oncreteBindViewHolder")

    }


/***********viewHolder**************/
    inner class JourHolder(inflater: LayoutInflater, parent: ViewGroup) : RecyclerView.ViewHolder(inflater.inflate(R.layout.item_jour_view, parent, false)){
        private var jourView: TextView?=null
        private var nbrSView: TextView?=null

        init {
            jourView=itemView.findViewById(R.id.journame)
            nbrSView=itemView.findViewById(R.id.nbrseance)
            Log.d(ContentValues.TAG,"dakhal init")

        }

        fun bind(jr: Jour){
            jourView?.text= jr.name.toString()
            nbrSView?.text= jr.nbrSeance.toString().plus(" ").plus("Seances")
            Log.d(ContentValues.TAG,"dakhal bind")



            itemView?.setOnClickListener{
                onItemClick?.invoke(jr)
            }
        }


    }
}