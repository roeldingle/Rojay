package com.example.rojay

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_alphabet_details.*
import kotlinx.android.synthetic.main.item.view.*

class AlphabetDetailsActivity : AppCompatActivity() {
    lateinit var mediaPlayer: MediaPlayer
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_alphabet_details)

        var bundle : Bundle? = intent.extras
        imagedetailView.setImageResource(bundle!!.getInt("image"))
        textdetailView.text = bundle!!.getString("desc")

        imageView3.setOnClickListener {
            mediaPlayer = MediaPlayer.create(this, bundle!!.getInt("media"))
            playSound()
        }
    }


    private fun playSound(){
        try{
            mediaPlayer.start()
        }
        catch(e: Exception){
            println(e)
        }
    }
}