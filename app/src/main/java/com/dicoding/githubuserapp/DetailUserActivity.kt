package com.dicoding.githubuserapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class DetailUserActivity : AppCompatActivity() {

    companion object{
        const val EXTRA_USER = "extra_user"

    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_user)

        val tvdetailname:TextView = findViewById(R.id.tv_detail_name)
        val tvdetailusername:TextView = findViewById(R.id.tv_detail_username)
        val imgdetailavatar:ImageView = findViewById(R.id.img_detail_avatar)

        val user = intent.getParcelableExtra(EXTRA_USER) as User?
        tvdetailname.text = user!!.name
        tvdetailusername.text = user.username
        imgdetailavatar.setImageResource(user.avatar!!)


    }
}