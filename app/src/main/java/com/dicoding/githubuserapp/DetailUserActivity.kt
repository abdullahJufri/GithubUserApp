package com.dicoding.githubuserapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.dicoding.githubuserapp.databinding.ActivityDetailUserBinding


class DetailUserActivity : AppCompatActivity() {

    companion object{
        const val EXTRA_USER = "extra_user"

    }

    private lateinit var binding: ActivityDetailUserBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_user)

        binding = ActivityDetailUserBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val user = intent.getParcelableExtra(EXTRA_USER) as User?
        binding.tvDetailName.text = user!!.name
        binding.tvDetailUsername.text = user.username
        binding.imgDetailAvatar.setImageResource(user.avatar!!)
        binding.tvDetailCompany.text = user.company
        binding.tvDetailLocation.text = user.location
        binding.tvDetailFollower.text = user.followers
        binding.tvDetailFollowing.text = user.following
        binding.tvDetailRepository.text = getString(R.string.repository, user.repository)
    }
}