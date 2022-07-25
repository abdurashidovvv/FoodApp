package com.abdurashidov.foodapp

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.abdurashidov.foodapp.models.Food
import com.abdurashidov.foodapp.models.FoodsList
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        sharedPreferences=getSharedPreferences("foodCache", Context.MODE_PRIVATE)
        val editor=sharedPreferences.edit()
        val type=object : TypeToken<ArrayList<Food>>(){}.type
        FoodsList.list = Gson().fromJson(sharedPreferences.getString("listKey", "[]"), type)

        foods.setOnClickListener {
            val intent=Intent(this,Foods::class.java)
            startActivity(intent)
        }

        add_food.setOnClickListener {
            val intent=Intent(this, AddFood::class.java)
            startActivity(intent)
        }

    }
}