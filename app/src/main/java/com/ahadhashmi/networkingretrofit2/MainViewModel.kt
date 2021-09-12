package com.ahadhashmi.networkingretrofit2

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ahadhashmi.networkingretrofit2.models.Comment
import com.ahadhashmi.networkingretrofit2.models.Post
import com.ahadhashmi.networkingretrofit2.network.RetrofitInstance
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainViewModel : ViewModel() {
    private var posts: MutableLiveData<List<Post>> = MutableLiveData()
    private var comments: MutableLiveData<List<Comment>> = MutableLiveData()
    init {

    }
    fun getAllPosts() : LiveData<List<Post>>{
        viewModelScope.launch(Dispatchers.IO) {
            val post = RetrofitInstance.retrofit.getAllPosts()
            withContext(Dispatchers.Main){
                posts.value = post
            }
        }
        return posts
    }
    fun getAllComments(position: Int) : LiveData<List<Comment>>{
        viewModelScope.launch(Dispatchers.IO) {
            val comment = RetrofitInstance.retrofit.getComments(position)
            withContext(Dispatchers.Main){
                comments.value = comment
            }
        }
        return comments
    }
}