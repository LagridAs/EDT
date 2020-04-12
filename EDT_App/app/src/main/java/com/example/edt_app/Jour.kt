package com.example.edt_app

import java.io.Serializable

data class Jour(var name:JourEnum,
                var nbrSeance:Int?
                //val seances:MutableList<Seance>
):Serializable