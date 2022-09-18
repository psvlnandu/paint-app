package com.example.paintapp

import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.Toast
import com.example.paintapp.paintView.Companion.color_list
import com.example.paintapp.paintView.Companion.currentbrush
import com.example.paintapp.paintView.Companion.path_list

class MainActivity : AppCompatActivity() {
    //companion o bject to access all over app
    companion object {
        var path = Path()
        var paintBrush = Paint()
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()
        val redbtn=findViewById<ImageButton>(R.id.redColor)
        val bluebtn=findViewById<ImageButton>(R.id.blueColor)
        val blackbtn=findViewById<ImageButton>(R.id.blackColor)
        val whitebtn=findViewById<ImageButton>(R.id.whiteColor)

        redbtn.setOnClickListener(){
            Toast.makeText(this,"clicked",Toast.LENGTH_SHORT).show()
            paintBrush.color=Color.RED
            currentColor((paintBrush.color))
        }
        bluebtn.setOnClickListener(){
            Toast.makeText(this,"clicked",Toast.LENGTH_SHORT).show()
            paintBrush.color=Color.BLUE
            currentColor((paintBrush.color))
        }
        blackbtn.setOnClickListener(){
            Toast.makeText(this,"clicked",Toast.LENGTH_SHORT).show()
            paintBrush.color=Color.BLACK
            currentColor((paintBrush.color))
        }
        whitebtn.setOnClickListener(){
            Toast.makeText(this,"clicked",Toast.LENGTH_SHORT).show()
            path_list.clear()
            color_list.clear()
            path.reset()
        }

    }
    private fun currentColor(color: Int){
        currentbrush=color
        path=Path()
    }
}