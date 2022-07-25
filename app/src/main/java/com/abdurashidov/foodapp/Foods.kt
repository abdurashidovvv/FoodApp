package com.abdurashidov.foodapp

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import com.abdurashidov.foodapp.models.Food
import com.abdurashidov.foodapp.models.FoodsList.list
import com.abdurashidov.foodapp.models.MyAdapter
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_foods.*

class Foods : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_foods)


        val foodName=ArrayList<String>()
        for (i in 0 until list.size){
            foodName.add(list[i].name)
        }
        val adapter=MyAdapter(list, this)
        list_view.adapter=adapter


        val intent=Intent(this, infoActivity::class.java)

        list_view.setOnItemClickListener { parent, view, position, id ->
            intent.putExtra("itemName", list[position].name)
            intent.putExtra("itemProduct", list[position].product)
            intent.putExtra("itemInstruction", list[position].instruction)
            startActivity(intent)
        }
    }
}