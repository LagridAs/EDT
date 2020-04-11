package com.example.edt_app

import java.io.Serializable
import java.sql.Time
import java.time.LocalDate
import java.time.LocalTime

data class Seance(val nom:String?,
                  val date: LocalDate?,
                  val tempsDeb:LocalTime?,
                  val tempsFin:LocalTime?,
                  val module:Module?,
                  val salle:String?
):Serializable