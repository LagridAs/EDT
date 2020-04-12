package com.example.edt_app

import java.io.Serializable
import java.time.Duration

data class Module (val intitule:String?,
                   val nomdetails:String?,
                   val duree:Int?,
                   val ens:Enseignant
):Serializable