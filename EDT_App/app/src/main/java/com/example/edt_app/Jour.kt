package com.example.edt_app

import java.io.Serializable

data class Jour(val name:JourEnum,
                val nbrSeance:Int?
                //val seances:MutableList<Seance>
):Serializable