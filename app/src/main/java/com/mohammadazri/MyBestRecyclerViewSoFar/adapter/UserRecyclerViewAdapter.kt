package com.mohammadazri.MyBestRecyclerViewSoFar.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.mohammadazri.MyBestRecyclerViewSoFar.R
import com.mohammadazri.MyBestRecyclerViewSoFar.model.User

class UserRecyclerViewAdapter(
    val users: ArrayList<User>,
    val onItemClickCallback: UserRecyclerViewAdapterInterface
) : RecyclerView.Adapter<UserRecyclerViewAdapter.viewHolder>() {

    class viewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imgAvata: ImageView = itemView.findViewById(R.id.imageViewUserAvatar)
        val tvName: TextView = itemView.findViewById(R.id.textViewUserName)
        val tvUsername: TextView = itemView.findViewById(R.id.textViewUserUsername)
        val tvDescription: TextView = itemView.findViewById(R.id.textViewUserDescription)
    }

    interface UserRecyclerViewAdapterInterface {
        fun onItemClicked(user: User)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHolder {
        val layout: View =
            LayoutInflater.from(parent.context).inflate(R.layout.item_user, parent, false)
        return viewHolder(layout)
    }

    override fun onBindViewHolder(holder: viewHolder, position: Int) {
        val user = users[position]
        user.avatar?.let {
            holder.imgAvata.setImageResource(it)
        }
        holder.tvName.text = user.name
        holder.tvUsername.text = user.username
        holder.tvDescription.text = user.description

        holder.itemView.setOnClickListener {
            onItemClickCallback.onItemClicked(user)
        }
    }

    override fun getItemCount(): Int {
        return users.size
    }
}