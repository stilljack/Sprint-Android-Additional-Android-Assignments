package com.saucefan.stuff.mapassign

import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import kotlin.random.Random






class MapDraw(var mMap: GoogleMap) {
    val r = Random
    // Add a marker in Sydney and move the camera
    val sydney = LatLng(-34.0, 151.0)


//Bresenham’s Algorithm

    fun bresenhamAlgo(x1:Double,y1: Double, x2: Double, y2:Double) {

        //iterators
        var x:Double
        var y:Double
        var dx:Double
        var dy:Double
        var dx1:Double
        var dy1:Double
        var px:Double
        var py:Double
        var  xe:Double
        var ye:Double
        var i:Double

        //deltas, difference of end points on both axises
        dx=x2-x1
        dy=y2-y1

        //"positive copy" of deltas for iterating, i.e. if negative get absolute value from zero
        //on number line
        dx1=Math.abs(dx)
        dy1=Math.abs(dy)

        //'Calculate error intervals for both axis'
        //"An error interval is the range of values that a number could have taken before being
        // rounded or truncated. Error intervals are usually written as a range using inequalities,
        // with a lower bound and an upper bound."
        //this means very little to me -Jack
        px = 2 *dy1-dx1
        py = 2 *dx1 -dy1

        //if the line is x-axis dominant, i.e.
            //ie if it goes further in the x axis then in the why
        if (dy1<=dx1) {

            //if line the draws left ot right
            if(dx>=0) {
                x=x1
                y=y1
                xe=x2
            } else{
                //line is right to left
                x=x2
                y=y2
                xe=x1
            }
          //here we call our pixel
            xAxisDomLine(x,xe,)

        }



    }



    fun xAxisDomLine(
        x:Double,
        y:Double,
                     xe:Double,
                     px:Double,
        dx1:Double,
                     dy1:Double,
        dx:Double,
        dy:Double) {
        makeArbMarker(x, y) // Draw first pixel
        var i = 0.0
        var x = x
        var y=y
        var px=px
        while (x < xe) {
            x++

            // Deal with octants...

            if (px < 0) {
                px = px + 2 * dy1
            } else {
                if (dx < 0 && dy < 0 || dx > 0 && dy > 0) {
                    y = y + 1
                } else {
                    y = y - 1
                }
                px = px + 2 * (dy1 - dx1)
            }

            // Draw pixel from line span at
            // currently rasterized position
            makeArbMarker(x, y)
            i++
        }



    }
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