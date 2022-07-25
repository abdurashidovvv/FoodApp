package com.abdurashidov.foodapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_info.*

class infoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_info)

        val item_name=intent.getStringExtra("itemName")
        val item_product=intent.getStringExtra("itemProduct")
        val item_instruction=intent.getStringExtra("itemInstruction")

        foodName.text=item_name
        product.text=item_product
        instruction.text=item_instruction
    }
}