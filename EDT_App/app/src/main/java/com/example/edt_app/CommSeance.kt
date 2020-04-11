package com.example.edt_app

import androidx.fragment.app.Fragment

interface CommSeance {
    fun passSeance(seance: Seance, fragment: Fragment, reference:Int)
}