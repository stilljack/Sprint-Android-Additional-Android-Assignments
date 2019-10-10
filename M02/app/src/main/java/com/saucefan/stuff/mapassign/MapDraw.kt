package com.saucefan.stuff.mapassign

import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import kotlin.random.Random


class MapDraw(var mMap: GoogleMap) {
    val r = Random
    // Add a marker in Sydney and move the camera
    val sydney = LatLng(-34.0, 151.0)





    //draws a cross
    fun example() {
        for (i in -25 until 50){
            val lat = 34.0 - (i.toDouble() + r.nextDouble(0.0, 1.9) - r.nextDouble(0.0, 1.9))
            val lng = 151.00

            makeArbMarker(lat,lng)

        }
        for (i in -35 until 35){
            val lat = 50.0
            val lng = 151.00- (i.toDouble() + r.nextDouble(0.0, 1.9) - r.nextDouble(0.0, 1.9))
            makeArbMarker(lat,lng)

        }
    }

    fun makeOblong() {



    }

    fun makeArbMarker(x:Double,y:Double) {
        val chords = LatLng(x,y)
        mMap.addMarker(MarkerOptions().position(chords).title("${x}, ${y}"))

    }
}