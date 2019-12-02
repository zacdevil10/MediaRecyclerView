package uk.co.zac_h.mediarecyclerview

import android.content.Context
import android.util.AttributeSet
import android.widget.ImageView

class ZoomableImageView : ImageView {

    /*companion object {
        private const val NONE = 0
        private const val DRAG = 1
        private const val ZOOM = 2
        private const val CLICK = 3
    }

    private val scaleMatrix = Matrix()
    private val last = PointF()
    private val start = PointF()

    private var minScale = 1f
    private var maxScale = 4f
    private var saveScale = 1f

    private var m = FloatArray(9)

    private var redundantXSpace = 0f
    private var redundantYSpace = 0f

    private var width = 0f
    private var height = 0f

    private var right = 0f
    private var bottom = 0f
    private var originalWidth = 0f
    private var originalHeight = 0f
    private var bmWidth = 0f
    private var bmHeight = 0f

    private var mode = NONE*/

    constructor(context: Context) : super(context, null)

    constructor(context: Context, attributeSet: AttributeSet) : super(context, attributeSet)

    /*init {
        scaleMatrix.setTranslate(1f, 1f)
        imageMatrix = scaleMatrix
        scaleType = ScaleType.MATRIX
        setOnTouchListener(this)
    }

    override fun onTouch(view: View?, event: MotionEvent): Boolean {
        scaleMatrix.getValues(m)
        val x = m[Matrix.MTRANS_X]
        val y = m[Matrix.MTRANS_Y]
        val curr = PointF(event.x, event.y)

        when (event.action) {
            MotionEvent.ACTION_DOWN -> {
                last.set(event.x, event.y)
                start.set(last)
                mode = DRAG
            }
            MotionEvent.ACTION_POINTER_DOWN -> {
                last.set(event.x, event.y)
                start.set(last)
                mode = ZOOM
            }
            MotionEvent.ACTION_MOVE -> {
                if (mode == ZOOM || (mode == DRAG && saveScale > minScale)) {
                    var deltaX = curr.x - last.x
                    var deltaY = curr.y - last.y

                    val scaleWidth = round(originalWidth * saveScale)
                    val scaleHeight = round(originalHeight * saveScale)

                    if (scaleWidth < width) {
                        deltaX = 0f
                        if (y + deltaY > 0) deltaY = -y
                        else if (y + deltaY < -bottom) deltaY = -(y + bottom)
                    } else if (scaleHeight < height) {
                        if (x + deltaX > 0) deltaX = -x
                        else if (x + deltaX < -right) deltaX = -(x + right)

                        if (y + deltaY > 0) deltaY = -y
                        else if (y + deltaY < -bottom) deltaY = -(y + bottom)
                    }
                    scaleMatrix.postTranslate(deltaX, deltaY)

                    last.set(curr.x, curr.y)
                }
            }
            MotionEvent.ACTION_POINTER_UP -> mode = NONE
        }
        imageMatrix = scaleMatrix
        invalidate()
        return true
    }

    inner class ScaleListener : ScaleGestureDetector.SimpleOnScaleGestureListener() {

        override fun onScaleBegin(detector: ScaleGestureDetector): Boolean {
            mode = ZOOM
            return true
        }

        override fun onScale(detector: ScaleGestureDetector): Boolean {
            var scaleFactor = detector.scaleFactor
            val originalScale = saveScale

            saveScale *= scaleFactor

            if (saveScale > maxScale) {
                saveScale = maxScale
                scaleFactor = maxScale / originalScale
            } else if (saveScale < maxScale) {
                saveScale = minScale
                scaleFactor = minScale / originalScale
            }

            right = width * saveScale - width - (2 * redundantXSpace * saveScale)
            bottom = height * saveScale - height - (2 * redundantYSpace * saveScale)



            return super.onScale(detector)
        }
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)

        width = MeasureSpec.getSize(widthMeasureSpec).toFloat()
        height = MeasureSpec.getSize(heightMeasureSpec).toFloat()

        val scaleX = width / bmWidth
        val scaleY = height / bmHeight

        val scale = min(scaleX, scaleY)
        scaleMatrix.setScale(scale, scale)
        imageMatrix = scaleMatrix
        saveScale = 1f

        redundantYSpace = height - (scale * bmHeight)
        redundantXSpace = width - (scale * bmWidth)
        redundantYSpace /= 2
        redundantXSpace /= 2

        scaleMatrix.postTranslate(redundantXSpace, redundantYSpace)

        originalWidth = width - 2 * redundantXSpace
        originalHeight = height - 2 * redundantYSpace

        right = width * saveScale - width - (2 * redundantXSpace * saveScale)
        bottom = height * saveScale - height - (2 * redundantYSpace * saveScale)

        imageMatrix = scaleMatrix
    }*/

}