package com.saucefan.stuff.mapassign

import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import java.util.jar.Manifest

class MainActivity : AppCompatActivity() {
val contxt = this


    var FINE_LOCATION_REQUEST_CODE =5


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //check permission
        if(ContextCompat.checkSelfPermission
                (this, android.Manifest.permission.ACCESS_FINE_LOCATION)  //or whatever permission is in question
                        != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(
                this,
                arrayOf(android.Manifest.permission.ACCESS_FINE_LOCATION),
            FINE_LOCATION_REQUEST_CODE

            )}
            else {
                Toast.makeText(this,"Permission asked and denied",Toast.LENGTH_SHORT).show()
            //do stuff without fine location
            }


        }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode==FINE_LOCATION_REQUEST_CODE) {
            if (permissions[0] == android.Manifest.permission.ACCESS_FINE_LOCATION
                    && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                // if we get here we are absolutely sure we have permissions
                getLocation()
            }else {permissiionDeniend()} // and we land here if not permissions

        }
    }




    private fun getLocation() {
        if (ActivityCompat.checkSelfPermission(contxt,
                android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED
        ){

            Toast.makeText(this,"it didn't work",Toast.LENGTH_SHORT).show()
            return
        }
        Toast.makeText(this,"it works!",Toast.LENGTH_SHORT).show()
    }
    fun permissiionDeniend() {
        //todo 1
    }
}

