package com.abdurashidov.foodapp

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.abdurashidov.foodapp.models.Food
import com.abdurashidov.foodapp.models.FoodsList
import com.abdurashidov.foodapp.models.FoodsList.list
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.android.synthetic.main.activity_add_food.*

class AddFood : AppCompatActivity() {

    lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_food)


        sharedPreferences=getSharedPreferences("foodCache", Context.MODE_PRIVATE)
        val editor=sharedPreferences.edit()
        val type=object : TypeToken<ArrayList<Food>>(){}.type
        list = Gson().fromJson(sharedPreferences.getString("listKey", "[]"), type)

        val edt1=edt_1.text
        val edt2=edt_2.text
        val edt3=edt_3.text

        btn_saqlash.setOnClickListener {
            if (edt_1.text.isEmpty() || edt_2.text.isEmpty() || edt_3.text.isEmpty()) {
                Toast.makeText(this, "Iltimos hamma maydonlarni to'ldiring.", Toast.LENGTH_SHORT).show()
            } else {
                val food=Food("$edt1","$edt2","$edt3")
                list.add(food)
                val str=Gson().toJson(list)
                editor.putString("listKey", str)
                editor.apply()
                finish()
            }
        }
    }

}