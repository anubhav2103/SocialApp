package com.abhishek.socialapp

import android.content.Context
import android.text.format.DateUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.abhishek.socialapp.models.Post
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_post.view.*
import java.math.BigInteger
import java.security.MessageDigest

class PostsAdapter(val context: Context,val posts : List<Post>):RecyclerView.Adapter<PostsAdapter.ViewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_post,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount() = posts.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
    holder.bind(posts[position])
    }

    inner class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        fun bind(post : Post){

            itemView.tvUsername.text = post.user?.username
            itemView.tvDescription.text = post.description
            Glide.with(context).load(post.imageUrl).into(itemView.ivPost)

            itemView.tvTimeStamp.text = DateUtils.getRelativeTimeSpanString(post.creationTimeMs)
        }


    }
}