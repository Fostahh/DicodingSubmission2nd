package com.mohammadazri.MyBestRecyclerViewSoFar.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.mohammadazri.MyBestRecyclerViewSoFar.R
import com.mohammadazri.MyBestRecyclerViewSoFar.model.Repository
import com.mohammadazri.MyBestRecyclerViewSoFar.model.User

class UserDetailRecyclerViewAdapter(val user: User) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private val HEADER_TYPE: Int = 0
    private val ITEM_TYPE: Int = 1

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            HEADER_TYPE -> {
                val layout: View =
                    LayoutInflater.from(parent.context)
                        .inflate(R.layout.item_user_header, parent, false)
                UserHeaderViewHolder(layout)
            }
            else -> {
                val layout: View =
                    LayoutInflater.from(parent.context)
                        .inflate(R.layout.item_repository, parent, false)
                RepositoryViewHolder(layout)
            }
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is UserHeaderViewHolder) {
            user.avatar?.let { holder.imageViewUser.setImageResource(it) }
            holder.textViewUserName.text = user.name
            holder.textViewUserUsername.text = user.username
            holder.textViewUserCompanyDetail.text = user.company
            holder.textViewUserLocationDetail.text = user.location
            holder.textViewFollowerDetail.text =
                "${user.follower ?: 0} followers, ${user.following ?: 0} following"
            holder.textViewUserDescription.text = user.description
        } else if (holder is RepositoryViewHolder) {
            val repository: Repository? = user.repositories?.get(position - 1)
            repository?.let {
                holder.repositoryName.text = it.name
                holder.repositoryDescription.text = it.description
                holder.numberOfStar.text = "${it.numberOfStars ?: 0}"
                holder.languageTextView.text = it.language
            }
        }
    }

    override fun getItemCount(): Int {
        user.repositories?.let {
            return 1 + it.size
        }.run {
            return 1
        }
    }

    override fun getItemViewType(position: Int): Int {
        return when (position) {
            0 -> HEADER_TYPE
            else -> ITEM_TYPE
        }
    }

    class UserHeaderViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageViewUser: ImageView = itemView.findViewById(R.id.imageViewUserDetail)
        val textViewUserName: TextView = itemView.findViewById(R.id.textViewUserNameDetail)
        val textViewUserUsername: TextView = itemView.findViewById(R.id.textViewUserUsernameDetail)
        val textViewUserDescription: TextView =
            itemView.findViewById(R.id.textViewUserDescriptionDetail)
        val textViewUserCompanyDetail: TextView =
            itemView.findViewById(R.id.textViewUserCompanyDetail)
        val textViewUserLocationDetail: TextView =
            itemView.findViewById(R.id.textViewUserLocationDetail)
        val textViewFollowerDetail: TextView = itemView.findViewById(R.id.textViewUserFollowers)
    }

    class RepositoryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val repositoryName: TextView = itemView.findViewById(R.id.repositoryNameTextView)
        val repositoryDescription: TextView =
            itemView.findViewById(R.id.repositoryDescriptionTextView)
        val numberOfStar: TextView = itemView.findViewById(R.id.numberOfStarsRepositoryTextView)
        val languageTextView: TextView = itemView.findViewById(R.id.textView7)

    }
}