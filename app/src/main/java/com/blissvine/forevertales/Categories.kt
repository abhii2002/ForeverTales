package com.blissvine.forevertales

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.animation.AnimationUtils
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_categories.*
import kotlinx.android.synthetic.main.activity_contact_us.*



class Categories : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_categories)


          iv_horror.setOnClickListener(this)
          iv_fantasy.setOnClickListener(this)
          iv_mystery.setOnClickListener(this)
         iv_romance.setOnClickListener(this)

    }
    override fun onClick(view: View?) {
        when(view!!.id){
             R.id.iv_horror ->{
                 iv_horror.startAnimation(AnimationUtils.loadAnimation(this, R.anim.image_anim))
             }
            R.id.iv_fantasy -> {
                iv_fantasy.startAnimation(AnimationUtils.loadAnimation(this, R.anim.image_anim))
            }
            R.id.iv_romance ->{
                iv_romance.startAnimation(AnimationUtils.loadAnimation(this, R.anim.image_anim))
            }
            R.id.iv_mystery ->{
                iv_mystery.startAnimation(AnimationUtils.loadAnimation(this, R.anim.image_anim))
            }
        }
    }



}