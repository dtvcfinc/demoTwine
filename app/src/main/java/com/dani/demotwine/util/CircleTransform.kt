package com.dani.demotwine.util

import android.graphics.*
import android.graphics.Paint.ANTI_ALIAS_FLAG
import com.squareup.picasso.Transformation

/**
 * Created by codezjx on 2016/5/4.
 */
class CircleTransform : Transformation {

    override fun transform(source: Bitmap): Bitmap {

        val minEdge = Math.min(source.width, source.height)
        val dx = (source.width - minEdge) / 2
        val dy = (source.height - minEdge) / 2

        // Init shader
        val shader = BitmapShader(source, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP)
        val matrix = Matrix()
        matrix.setTranslate((-dx).toFloat(), (-dy).toFloat())   // Move the target area to center of the source bitmap
        shader.setLocalMatrix(matrix)

        // Init paint
        val paint = Paint(ANTI_ALIAS_FLAG)
        paint.shader = shader

        // Create and draw circle bitmap
        val output = Bitmap.createBitmap(minEdge, minEdge, source.config)
        val canvas = Canvas(output)
        canvas.drawOval(RectF(0f, 0f, minEdge.toFloat(), minEdge.toFloat()), paint)

        // Recycle the source bitmap, because we already generate a new one
        source.recycle()

        return output
    }

    override fun key(): String {
        return KEY
    }

    companion object {

        /**
         * A unique key for the transformation, used for caching purposes.
         */
        private val KEY = "circleImageTransformation"
    }
}
