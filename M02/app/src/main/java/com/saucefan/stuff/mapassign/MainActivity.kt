package com.saucefan.stuff.mapassign

import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.google.android.material.shape.ShapeAppearanceModel
import com.mikepenz.materialdrawer.Drawer
import com.mikepenz.materialdrawer.DrawerBuilder
import com.mikepenz.materialdrawer.model.DividerDrawerItem
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem
import com.mikepenz.materialdrawer.model.SecondaryDrawerItem
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem
import java.util.jar.Manifest
import kotlin.random.Random

class MainActivity : AppCompatActivity(), OnMapReadyCallback {
val contxt = this
    //from the materialdrawer readme
    //if you want to update the items at a later time it is recommended to keep it in a variable
    private lateinit var mMap: GoogleMap


    var FINE_LOCATION_REQUEST_CODE =5


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val item1 = PrimaryDrawerItem().withIdentifier(1).withName(R.string.bullheck)
        val item2 = SecondaryDrawerItem().withIdentifier(2).withName(R.string.bullhockey)

        ShapeAppearanceModel()
//create the drawer and remember the Drawer result object
        DrawerBuilder()
            .withActivity(this)
            // .withToolbar(toolbar)
            .withActionBarDrawerToggle(false)
            .withTranslucentStatusBar(false)
            .addDrawerItems(
                item1,
                item2
                    .withOnDrawerItemClickListener(object : Drawer.OnDrawerItemClickListener {
                        override fun onItemClick(
                            view: View?,
                            position: Int,
                            drawerItem: IDrawerItem<*>
                        ): Boolean {
                            // do something with the clicked item :D
                            Toast.makeText(this@MainActivity, "yus", Toast.LENGTH_SHORT).show()
                            return true
                        }
                    })
            )
            .build()

        //check permission
        if (ContextCompat.checkSelfPermission
                (
                this,
                android.Manifest.permission.ACCESS_FINE_LOCATION
            )  //or whatever permission is in question
            != PackageManager.PERMISSION_GRANTED
        ) {
            ActivityCompat.requestPermissions(
                this,
                arrayOf(android.Manifest.permission.ACCESS_FINE_LOCATION),
                FINE_LOCATION_REQUEST_CODE

            )
        } else {
            Toast.makeText(this, "Permission asked and denied", Toast.LENGTH_SHORT).show()
            //do stuff without fine location
        }


        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
          mapFragment.getMapAsync(this)
    }


/**
 * Manipulates the map once available.
 * This callback is triggered when the map is ready to be used.
 * This is where we can add markers or lines, add listeners or move the camera. In this case,
 * we just add a marker near Sydney, Australia.
 * If Google Play services is not installed on the device, the user will be prompted to install
 * it inside the SupportMapFragment. This method will only be triggered once the user has
 * installed Google Play services and returned to the app.
 */
override fun onMapReady(googleMap: GoogleMap) {
    mMap = googleMap

    val r = Random
    // Add a marker in Sydney and move the camera
   // val sydney = LatLng(-34.0, 151.0)
    val mapDraw=MapDraw(mMap)
    mapDraw.example()

}





fun makeArbMarker(x:Double,y:Double) {
    val chords = LatLng(x,y)
    mMap.addMarker(MarkerOptions().position(chords).title("Marker in Sydney"))

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

