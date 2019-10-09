package com.saucefan.stuff.menupolish

import android.graphics.Color
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.app_bar_main2.*
import kotlinx.android.synthetic.main.content_main2.*


class Menu : AppCompatActivity() {

    private lateinit var drawerLayout: DrawerLayout


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        drawerLayout = findViewById(R.id.drawer_layout)

        val toggle = ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.drawer_open,R.string.drawer_close)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()



        val navigationView = findViewById<NavigationView>(R.id.nav_view)
        navigationView.setNavigationItemSelectedListener {menuItem->
            menuItem.isChecked = true
            Toast.makeText(baseContext,"${menuItem.title}", Toast.LENGTH_SHORT).show()
            when (menuItem.itemId) {
                R.id.nav_menu -> {
                    tv.text="main menu"
                    tv.setBackgroundColor(Color.WHITE)
                }
                R.id.nav_difficulty -> {
                    tv.text="difficulty selector"
                    tv.setBackgroundColor(Color.RED)
                }
                R.id.nav_gfx_swap -> {
                    tv.text="gfxswap"
                    tv.setBackgroundColor(Color.BLUE)
                }

            }
            drawerLayout.closeDrawers()
            drawerLayout.invalidate()
            true
        }

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.sort_menu, menu)

        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {

        when (item?.itemId) {
            R.id.menu_nightmode -> {
                Toast.makeText(this, "we'd swap over to spooky nightmode (GHOST AND GHOULS ONLY)", Toast.LENGTH_SHORT).show()
            }
            R.id.menu_score_display -> {
                Toast.makeText(this, "we'd turn on scores here", Toast.LENGTH_SHORT).show()
            }
        }
        return super.onOptionsItemSelected(item as MenuItem)
    }

}




