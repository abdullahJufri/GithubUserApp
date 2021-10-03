package com.dicoding.githubuserapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class ListUserAdapter(private val listUser: ArrayList<User>) : RecyclerView.Adapter<ListUserAdapter.ListViewHolder>() {
    private lateinit var onItemClickCallback: OnItemClickCallback


    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ListViewHolder {
        val view: View = LayoutInflater.from(viewGroup.context).inflate(R.layout.item_row_user, viewGroup, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (name, username, location, avatar) = listUser[position]
        if (avatar != null) {
            holder.imgAvatar.setImageResource(avatar)
        }
        holder.tvName.text = name
        holder.tvLocation.text = location
        holder.tvUsername.text = username
        holder.itemView.setOnClickListener { onItemClickCallback.onItemClicked(listUser[holder.adapterPosition]) }
    }


    override fun getItemCount(): Int = listUser.size

    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var imgAvatar: ImageView = itemView.findViewById(R.id.img_item_avatar)
        var tvName: TextView = itemView.findViewById(R.id.tv_item_name)
        var tvLocation: TextView = itemView.findViewById(R.id.tv_item_location)
        var tvUsername: TextView = itemView.findViewById(R.id.tv_item_username)


    }
    interface OnItemClickCallback {
        fun onItemClicked(data: User)
    }
}