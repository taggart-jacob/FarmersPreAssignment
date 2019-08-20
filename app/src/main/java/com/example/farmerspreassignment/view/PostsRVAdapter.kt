package com.example.farmerspreassignment.view

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.NonNull
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.farmerspreassignment.R
import com.example.farmerspreassignment.databinding.PostItemBinding
import com.example.farmerspreassignment.model.pojo.Post

class PostsRVAdapter(private val posts: MutableList<Post>, private val clickListener: MyClickListener) :
    RecyclerView.Adapter<PostsRVAdapter.ViewHolder>() {

    override fun getItemCount(): Int {
        return posts.size
    }

    @NonNull
    override fun onCreateViewHolder(@NonNull viewGroup: ViewGroup, i: Int): ViewHolder {
        val binding = DataBindingUtil.inflate(
            LayoutInflater.from(viewGroup.context),
            R.layout.post_item, viewGroup, false
        ) as PostItemBinding
        return ViewHolder(binding)
    }

    @SuppressLint("CheckResult")
    override fun onBindViewHolder(@NonNull holder: PostsRVAdapter.ViewHolder, i: Int) {
        val temp = posts[i]
        holder.itemView.setOnClickListener{ view -> clickListener.itemClicked(posts[i]) }
    }

    inner class ViewHolder(@param:NonNull internal var binding: PostItemBinding) :
        RecyclerView.ViewHolder(binding.root)

    interface MyClickListener {
        fun itemClicked(post: Post)
    }
}