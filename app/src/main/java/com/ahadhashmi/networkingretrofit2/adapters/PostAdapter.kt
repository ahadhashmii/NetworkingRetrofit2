package com.ahadhashmi.networkingretrofit2.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ahadhashmi.networkingretrofit2.databinding.ItemPostBinding
import com.ahadhashmi.networkingretrofit2.models.Post

class PostAdapter(val posts: List<Post>) : RecyclerView.Adapter<PostAdapter.PostViewHolder>() {
    private var mListener: ItemClickListener? = null
    fun setOnItemClickListener(itemClickListener: ItemClickListener){
        mListener = itemClickListener
    }
    interface ItemClickListener{
        fun commentsClickListener(position: Int)
    }
    class PostViewHolder(val binding: ItemPostBinding) : RecyclerView.ViewHolder(binding.root) {
        @SuppressLint("SetTextI18n")
        fun bind(post: Post){
            binding.id.text = "id: ${post.id}"
            binding.userId.text = "userId: ${post.userId}"
            binding.title.text = "title: ${post.title}"
            binding.body.text = "body: ${post.body}"
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        return PostViewHolder(ItemPostBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        val post = posts[position]
        holder.bind(post)
        holder.binding.comments.setOnClickListener(View.OnClickListener {
            mListener?.commentsClickListener(post.id)
        })

    }
    override fun getItemCount() = posts.size
}