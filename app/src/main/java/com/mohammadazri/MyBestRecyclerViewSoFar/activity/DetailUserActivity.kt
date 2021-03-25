package com.mohammadazri.MyBestRecyclerViewSoFar.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mohammadazri.MyBestRecyclerViewSoFar.R
import com.mohammadazri.MyBestRecyclerViewSoFar.adapter.UserDetailRecyclerViewAdapter
import com.mohammadazri.MyBestRecyclerViewSoFar.model.User

class DetailUserActivity : AppCompatActivity() {

    private lateinit var detailUserRecyclerView: RecyclerView


    companion object {
        const val EXTRA_USER = "extra_user"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_user)
        supportActionBar?.title = "Detail User"
        detailUserRecyclerView = findViewById(R.id.rvRepository)
        var user = intent.getParcelableExtra(EXTRA_USER) as? User

        showRecycler(user)
    }

    private fun showRecycler(user: User?) {
        user?.let {
            detailUserRecyclerView.layoutManager = LinearLayoutManager(this)
            val listUsersAdapter = UserDetailRecyclerViewAdapter(it)
            detailUserRecyclerView.adapter = listUsersAdapter
        }
    }
}