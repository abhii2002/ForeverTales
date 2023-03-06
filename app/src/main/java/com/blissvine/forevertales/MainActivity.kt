package com.blissvine.forevertales

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.telecom.Call.Details
import android.view.MenuItem
import android.widget.Adapter
import android.widget.Toast
import androidx.core.view.GravityCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*
import kotlin.random.Random

// TO USE navigation view we need to implement the OnNavigationItemSelectedListener interface
class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    // If user presses back button twice the application should close completely
    private var doubleBackToExitPressedOnce = false

    private var storyTitles = arrayOf<String>()
    private var storyContents = arrayOf<String>()
    private var storyImages = arrayOf<String>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

      navigation_view.setNavigationItemSelectedListener(this)

        setSupportActionBar(toolbar)
        toolbar.setNavigationIcon(R.drawable.ic_action_navigation_menu)
        toolbar.setNavigationOnClickListener{
            toggleDrawer()
        }

         storyTitles = resources.getStringArray(R.array.storyTitles)
         storyContents = resources.getStringArray(R.array.storyContent)
         storyImages = resources.getStringArray(R.array.storyImages)

        val adapter = ItemAdapter(storyTitles, storyContents, storyImages)
        rv_storyList.layoutManager = LinearLayoutManager(this)
        rv_storyList.adapter = adapter




    }

    override fun onBackPressed() {
        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START)
        }else{
            doubleBackToExit()
        }
    }

    private fun doubleBackToExit(){
        if(doubleBackToExitPressedOnce){
            super.onBackPressed()
            return
        }
        this.doubleBackToExitPressedOnce = true
        Toast.makeText(
            this,
            "Please click back again to exit",
            Toast.LENGTH_SHORT
        ).show()

        Handler(Looper.getMainLooper()).postDelayed({
            doubleBackToExitPressedOnce = false
        },2000)

    }



    private fun toggleDrawer(){
         if(drawerLayout.isDrawerOpen(GravityCompat.START)){
             drawerLayout.closeDrawer(GravityCompat.START)
         }else{
             drawerLayout.openDrawer(GravityCompat.START)
         }
    }

    // dealing with the navigation  drawer and its items
    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
             R.id.random ->{
                  val randomPosition = Random.nextInt(0, storyTitles.size)
                  val intent = Intent(applicationContext, StoryContent::class.java)
                 intent.putExtra("storyTitle", storyTitles[randomPosition])
                 intent.putExtra("storyContent", storyContents[randomPosition])
                 intent.putExtra("storyImages", storyImages[randomPosition])
                 startActivity(intent)

             }
            R.id.categories ->{
                val intent = Intent(applicationContext, Categories::class.java)
                startActivity(intent)
               //  Toast.makeText(this, "Categories", Toast.LENGTH_SHORT).show()
            }

            R.id.home -> {

                if(applicationContext != MainActivity::class.java){
                    startActivity(Intent(applicationContext, MainActivity::class.java))
                    finish()
                }
            }

            R.id.contact ->{
                startActivity(Intent(applicationContext, Contact::class.java))
            }


        }
        drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }


}

