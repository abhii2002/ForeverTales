package com.blissvine.forevertales

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_story_content.*
import kotlinx.android.synthetic.main.content_main.*

class StoryContent : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_story_content)

        val sTitle = intent.getStringExtra("storyTitle")
        val sContent = intent.getStringExtra("storyContent")
        val sImage = intent.getStringExtra("storyImages")

        setSupportActionBar(storyContentToolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = sTitle

        storyContentToolbar.setNavigationOnClickListener{
            onBackPressed()
        }

        Picasso.get().load(sImage).into(storyImage)
        storyDetails.text = sContent
    }
}