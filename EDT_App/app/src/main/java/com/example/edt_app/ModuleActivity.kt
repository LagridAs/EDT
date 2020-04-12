package com.example.edt_app

import android.content.ContentValues
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import kotlinx.android.synthetic.main.activity_module.*
import kotlin.properties.Delegates

class ModuleActivity : AppCompatActivity() ,CommSeance{
    private lateinit var seance:Seance

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_module)
            seance=intent.getSerializableExtra("seance") as Seance
            intituleModView2.text= seance.module?.intitule
            dureeModView2.text= seance.module?.duree.toString()
            ensModView2.text=seance.module?.ens?.nom


        ensModView2.setOnClickListener{
            val fragment= DetailsEnsFragment()
            val  reference= R.id.ensPLC
            passSeance(seance,fragment,reference)
            Log.d(ContentValues.TAG,"passina seance")
            }
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
