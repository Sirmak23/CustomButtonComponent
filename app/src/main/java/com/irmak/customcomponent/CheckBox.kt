package com.irmak.customcomponent

import android.annotation.SuppressLint
import android.content.Context
import android.content.res.TypedArray
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.RectF
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatCheckBox


class CheckBox : AppCompatCheckBox {
    private val strokePaint = Paint(Paint.ANTI_ALIAS_FLAG)
    private val boxRect = RectF()

    private var checkboxStrokeColor: Int = 0
    private var checkboxStrokeWidth: Float = 0f
    private var checkboxCornerRadius: Float = 0f

    constructor(context: Context) : super(context) {
        init(null)
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        init(attrs)
    }

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        init(attrs)
    }

    @SuppressLint("CustomViewStyleable")
    private fun init(attrs: AttributeSet?) {
        val typedArray: TypedArray = context.obtainStyledAttributes(attrs, R.styleable.CustomCheckBox)

        checkboxStrokeColor = typedArray.getColor(R.styleable.CustomCheckBox_checkboxStrokeColor, 0)
        checkboxStrokeWidth = typedArray.getDimension(R.styleable.CustomCheckBox_checkboxStrokeWidth, 0f)
        checkboxCornerRadius = typedArray.getDimension(R.styleable.CustomCheckBox_checkboxCornerRadius, 0f)

        typedArray.recycle()

        strokePaint.style = Paint.Style.STROKE
        strokePaint.color = checkboxStrokeColor
        strokePaint.strokeWidth = checkboxStrokeWidth
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        boxRect.set(checkboxStrokeWidth / 2, checkboxStrokeWidth / 2, width - checkboxStrokeWidth / 2, height - checkboxStrokeWidth / 2)
        canvas.drawRoundRect(boxRect, checkboxCornerRadius, checkboxCornerRadius, strokePaint)
    }
}

