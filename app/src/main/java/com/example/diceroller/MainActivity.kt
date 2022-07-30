package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var diceImage1 : ImageView
    private lateinit var diceImage2 : ImageView

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.buttonRoll)
        rollButton.setOnClickListener { rollDice() }
        diceImage1 = findViewById(R.id.dice1)
        diceImage2 = findViewById(R.id.dice2)
        val buttonClear: Button = findViewById(R.id.buttonClear)
        buttonClear.setOnClickListener(this)
    }
    /**
     * Roll the dice and update the screen with the result.
     */
    private fun rollDice() {
        diceImage1.setImageResource(getRandomDiceImage())
        diceImage2.setImageResource(getRandomDiceImage())

        // Update the content description
        diceImage1.contentDescription = diceImage1.toString()
        diceImage2.contentDescription = diceImage2.toString()
    }

    private fun getRandomDiceImage(): Int {
        return when((1..6).random()) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
    }

}
    override fun onClick(v: View?) {
        diceImage1.setImageResource(R.drawable.empty_dice)
        diceImage2.setImageResource(R.drawable.empty_dice)
    }

}