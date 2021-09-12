package com.ahadhashmi.networkingretrofit2

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.ahadhashmi.networkingretrofit2.adapters.CommentAdapter
import com.ahadhashmi.networkingretrofit2.adapters.PostAdapter
import com.ahadhashmi.networkingretrofit2.databinding.ActivityMainBinding
import com.ahadhashmi.networkingretrofit2.databinding.DialogCommentsBinding
import com.google.android.material.bottomsheet.BottomSheetDialog

class MainActivity : AppCompatActivity(), PostAdapter.ItemClickListener {
    private lateinit var model: MainViewModel
    private lateinit var adapter: PostAdapter
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.progressBar.visibility = View.VISIBLE

        model = ViewModelProvider(this).get(MainViewModel::class.java)
        getAllPosts()
    }

    private fun getAllPosts() {
        model.getAllPosts().observe(this, Observer { posts->
            adapter = PostAdapter(posts)
            adapter.setOnItemClickListener(this@MainActivity)
            binding.PostRecyclerView.adapter = adapter
            binding.progressBar.visibility = View.GONE
        })
    }

    @SuppressLint("SetTextI18n")
    override fun commentsClickListener(position: Int) {
        val dialog = BottomSheetDialog(this)
        val bottomSheet = DialogCommentsBinding.inflate(layoutInflater)
        model.getAllComments(position).observe(this, Observer { comments->
            bottomSheet.commentsRecyclerView.adapter = CommentAdapter(comments)
            bottomSheet.comm.text = "${comments.size} Comments"
            if (comments.isEmpty()) bottomSheet.empty.visibility = View.VISIBLE else bottomSheet.empty.visibility = View.GONE
        })
        dialog.setContentView(bottomSheet.root)
        dialog.show()
    }
}