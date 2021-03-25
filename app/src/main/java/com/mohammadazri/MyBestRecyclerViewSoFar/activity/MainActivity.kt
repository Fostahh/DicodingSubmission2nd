package com.mohammadazri.MyBestRecyclerViewSoFar.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mohammadazri.MyBestRecyclerViewSoFar.R
import com.mohammadazri.MyBestRecyclerViewSoFar.adapter.UserRecyclerViewAdapter
import com.mohammadazri.MyBestRecyclerViewSoFar.model.User
import com.mohammadazri.MyBestRecyclerViewSoFar.model.UserRepository

class MainActivity : AppCompatActivity(), UserRecyclerViewAdapter.UserRecyclerViewAdapterInterface {
    private lateinit var userRecyclerView: RecyclerView
    private var users: ArrayList<User> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.title = "Github User's"

        userRecyclerView = findViewById(R.id.rv_users)
        users.addAll(UserRepository.users)

        showRecycler()
    }

    private fun showRecycler() {
        userRecyclerView.layoutManager = LinearLayoutManager(this)
        val listUsersAdapter = UserRecyclerViewAdapter(users, this)
        userRecyclerView.adapter = listUsersAdapter
    }

    override fun onItemClicked(user: User) {
        val intent = Intent(this, DetailUserActivity::class.java)
        intent.putExtra(DetailUserActivity.EXTRA_USER, user)
        startActivity(intent)
    }
}