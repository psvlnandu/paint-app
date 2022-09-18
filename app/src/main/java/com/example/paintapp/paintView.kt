package com.example.paintapp

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import com.example.paintapp.MainActivity.Companion.paintBrush
import com.example.paintapp.MainActivity.Companion.path

class paintView :View{
    var params:ViewGroup.LayoutParams?=null
    companion object{
        var path_list=ArrayList<Path>()//shows all paths that we drew on screen
        var color_list=ArrayList<Color>()//since we have mulitpple colors
        var currentbrush=Color.BLACK
    }

    constructor(context: Context) : this(context, null)
    {
        init()
    }
    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0)
    {
        init()
    }
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)
    {
        init()
    }
    //methoed to intialize brush

    private fun init(){
        paintBrush.isAntiAlias=true//strokes to smooth
        paintBrush.color= currentbrush
        paintBrush.style=Paint.Style.STROKE
        paintBrush.strokeJoin=Paint.Join.ROUND//end of any path bearly notiv=cble
        paintBrush.strokeWidth=8f
        params=ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
        ViewGroup.LayoutParams.MATCH_PARENT)
    }
    //register fngers on screen
    override fun onTouchEvent(event: MotionEvent): Boolean
    {
        var x=event.x
        var y=event.y

        when(event.action){
            MotionEvent.ACTION_DOWN->{
                path.moveTo(x,y)
                return true
            }
            MotionEvent.ACTION_MOVE->{
                path.lineTo(x,y)
                path_list.add(path)
                //color_list.add(currentbrush)
            }
            else->return false
        }
        postInvalidate()
        return false
    }

    override fun onDraw(canvas: Canvas) {
        for(i in path_list.indices){
           // paintBrush.setColor(color_list.get(i))
            canvas.drawPath(path_list[i], paintBrush)
            invalidate()
        }
    }

}