package com.dicoding.githubuserapp

import android.content.Intent
import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.dicoding.githubuserapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var rvUsers: RecyclerView
    private val list = ArrayList<User>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.title = "Github User's"

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        rvUsers= binding.rvUsers
        rvUsers.setHasFixedSize(true)

        list.addAll(listUsers)
        showRecyclerList()
    }

    private val listUsers: ArrayList<User>
        get() {
            val dataName = resources.getStringArray(R.array.name)
            val dataUsername = resources.getStringArray(R.array.username)
            val dataLocation = resources.getStringArray(R.array.location)
            val dataAvatar = resources.obtainTypedArray(R.array.avatar)
            val dataRepository = resources.getStringArray(R.array.repository)
            val dataCompany = resources.getStringArray(R.array.company)
            val dataFollower = resources.getStringArray(R.array.followers)
            val dataFollowing = resources.getStringArray(R.array.following)

            val listUser = ArrayList<User>()
            for (i in dataName.indices) {
                val user = User(dataName[i],dataUsername[i], dataLocation[i],  dataAvatar.getResourceId(i, -1), dataRepository[i], dataCompany[i], dataFollower[i], dataFollowing[i])
                listUser.add(user)
            }
            return listUser
        }

    private fun showRecyclerList() {
        if (applicationContext.resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            rvUsers.layoutManager = GridLayoutManager(this, 2)
        } else {
            rvUsers.layoutManager = LinearLayoutManager(this)
        }
        val listHeroAdapter = ListUserAdapter(list)
        rvUsers.adapter = listHeroAdapter

        listHeroAdapter.setOnItemClickCallback(object : ListUserAdapter.OnItemClickCallback {
            override fun onItemClicked(data: User) {
                showSelectedUser(data)
            }
        })
    }

    private fun showSelectedUser(user: User) {
        Toast.makeText(this, user.name, Toast.LENGTH_SHORT).show()
        val moveWithDataIntent = Intent(this@MainActivity, DetailUserActivity::class.java)
        moveWithDataIntent.putExtra(DetailUserActivity.EXTRA_USER,user)
        startActivity(moveWithDataIntent)
    }


}