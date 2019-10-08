package com.saucefan.stuff.additionalandroidm01.work

import android.content.Context
import android.graphics.*
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.ShapeDrawable
import android.graphics.drawable.shapes.OvalShape
import android.graphics.drawable.shapes.RectShape
import android.util.AttributeSet
import android.widget.ImageView
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import android.view.View
import com.saucefan.stuff.additionalandroidm01.R
import java.util.concurrent.atomic.AtomicReference



class KotlinView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr)
{
    val paint=Paint()
  
}



class cb :View  {
    constructor(context: Context) : this(context, null)
    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0){
        val typedArray = context.theme.obtainStyledAttributes(attrs, R.styleable.CustomView, 0, 0)
        typedArray.recycle()
    }
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        val typedArray = context.theme.obtainStyledAttributes(attrs, R.styleable.CustomView, 0, 0)
        typedArray.recycle()
    }






    val bitmap: Bitmap = Bitmap.createBitmap(400, 300, Bitmap.Config.ARGB_8888)


    var shapeDrawable: ShapeDrawable = ShapeDrawable()
    var oLeft = 100
    var oTop = 100
    var oRight = 100
    var oBottom = 100
    override fun onDrawForeground(canvas: Canvas?) {
        super.onDrawForeground(canvas)
bitmap.prepareToDraw()




    }

    init {

        val canvas = Canvas()
        shapeDrawable = ShapeDrawable(RectShape())
        shapeDrawable.setBounds( left, top, right, bottom)
        shapeDrawable.paint.color = Color.parseColor("#009944")
        paint.color = Color.parseColor("#009944")
        canvas.drawCircle(12F,111F,201F,paint)
        shapeDrawable.draw(canvas as Canvas)
        requestLayout()
        invalidate()


        // rectangle positions


    /*    // oval positions
        oLeft = 100
        oTop = 100
        oRight = 100
        oBottom = 100

        // draw oval shape to canvas
        shapeDrawable = ShapeDrawable(OvalShape())
        shapeDrawable.setBounds( left, top, right, bottom)
        shapeDrawable.getPaint().setColor(Color.parseColor("#009191"))
        shapeDrawable.draw(canvas)
*/
        // now bitmap holds the updated pixels

        // set bitmap as background to ImageView
       // this.background = BitmapDrawable(resources, bitmap)

    }


}