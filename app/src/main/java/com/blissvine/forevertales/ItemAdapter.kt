package com.blissvine.forevertales

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.custom_recyclerview_item.view.*

class ItemAdapter(val storyTitle: Array<String>,
                  val storyContents: Array<String>,
                  val storyImages: Array<String>):
    RecyclerView.Adapter<ItemAdapter.ViewHolder>() {
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val cardTitle : TextView = itemView.tv_title
        val cardContent: TextView = itemView.tv_description
        val cardImage: ImageView = itemView.imageView
        val view = itemView

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.custom_recyclerview_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
         holder.cardTitle.text = storyTitle[position]
         holder.cardContent.text = storyContents[position]
         Picasso.get().load(storyImages[position]).into(holder.cardImage)

        holder.view.setOnClickListener{
            val intent = Intent(it.context, StoryContent::class.java)
             intent.putExtra("storyTitle", storyTitle[position])
             intent.putExtra("storyContent", storyContents[position])
            intent.putExtra("storyImages", storyImages[position])

            holder.view.context.startActivity(intent)

        // Toast.makeText(holder.view.context, "Item Number ->$position", Toast.LENGTH_SHORT).show()
        }
    }

    override fun getItemCount(): Int {
        return storyTitle.size
    }
}