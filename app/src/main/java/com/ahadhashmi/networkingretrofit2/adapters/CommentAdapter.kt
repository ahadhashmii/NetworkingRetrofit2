package com.ahadhashmi.networkingretrofit2.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ahadhashmi.networkingretrofit2.databinding.ItemCommentBinding
import com.ahadhashmi.networkingretrofit2.databinding.ItemPostBinding
import com.ahadhashmi.networkingretrofit2.models.Comment

class CommentAdapter(val comments: List<Comment>) : RecyclerView.Adapter<CommentAdapter.PostViewHolder>() {
    class PostViewHolder(private val binding: ItemCommentBinding) : RecyclerView.ViewHolder(binding.root) {
        @SuppressLint("SetTextI18n")
        fun bind(comment: Comment){
            binding.id.text = "id: ${comment.id}"
            binding.postId.text = "postId: ${comment.postId}"
            binding.name.text = "name: ${comment.name}"
            binding.email.text = "email: ${comment.email}"
            binding.body.text = "body: ${comment.body}"
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        return PostViewHolder(ItemCommentBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        holder.bind(comments[position])
    }
    override fun getItemCount() = comments.size
}