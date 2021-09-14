package com.sahel.toss

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private lateinit var img:ImageView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        img = findViewById(R.id.coin)

        onCoinTap()
    }

    private fun onCoinTap()
    {
        img.setOnClickListener {
            val randomNumber = (1..2).random()
            if (randomNumber == 1)
            {
                flipTheCoin(R.drawable.tail, "Tails")
            }else{
                flipTheCoin(R.drawable.haid, "Heads")
            }
        }
    }
    private fun flipTheCoin(imgId:Int, coinSide:String)
    {
         val coinSound:MediaPlayer = MediaPlayer.create(this,R.raw.coinflip)
        img.animate().apply {
            coinSound.start()
            duration = 1000
            rotationBy(1800f)
            img.isClickable = false
        }.withEndAction {
            img.setImageResource(imgId)
            Toast.makeText(this, coinSide, Toast.LENGTH_LONG).show()
            img.isClickable = true
        }
    }
}