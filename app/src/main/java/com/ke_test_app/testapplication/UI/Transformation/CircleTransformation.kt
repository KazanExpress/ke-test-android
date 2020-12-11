package com.ke_test_app.testapplication.UI.Transformation

import android.graphics.*
import com.squareup.picasso.Transformation

class CircleTransformation : Transformation {

    val KEY : String = javaClass.name

    override fun transform(source: Bitmap): Bitmap {

        val mRadius : Int = source.width/2

        val output = Bitmap.createBitmap(
            source.width, source.height,
            Bitmap.Config.ARGB_8888
        )
        val canvas = Canvas(output)

        val paint = Paint()
        val rect = Rect(0, 0, source.width, source.height)

        paint.isAntiAlias = true
        paint.isFilterBitmap = true
        paint.isDither = true

        canvas.drawCircle(
            (source.width / 2).toFloat(), (source.height / 2).toFloat(),
            mRadius.toFloat(), paint
        )

        paint.xfermode = PorterDuffXfermode(PorterDuff.Mode.SRC_IN)

        canvas.drawBitmap(source, rect, rect, paint)

        if (source !== output) {
            source.recycle()
        }

        return output
    }

    override fun key(): String = KEY
}