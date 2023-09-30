package com.irmak.customcomponent

import android.content.Context
import android.content.res.ColorStateList
import android.graphics.Color
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import com.irmak.customcomponent.databinding.ProgressButtonBinding


class ProgressButton @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet,
    defStyleAttr: Int = 0,
) : ConstraintLayout(context, attrs, defStyleAttr) {
    private var title: String? = null
    private var loadingTitle: String? = null
    private var customBackgroundColor: Int = Color.TRANSPARENT
    private val binding = ProgressButtonBinding
        .inflate(LayoutInflater.from(context), this, true)
    private var state: ProgressButtonState = ProgressButtonState.Normal
        set(value) {
            field = value
            refreshState()
        }


    init {
        val typedArray = context.obtainStyledAttributes(attrs, R.styleable.ProgressButton)
        customBackgroundColor = typedArray.getColor(
            R.styleable.ProgressButton_customBackgroundColor,
            Color.TRANSPARENT
        )
        val buttonSizeOrdinal = typedArray.getInt(R.styleable.ProgressButton_buttonSize, 1)
        val buttonSize = ButtonSize.values()[buttonSizeOrdinal]
        setButtonSize(buttonSize)
        setLayout(attrs)
        refreshState()
    }


    private fun setButtonSize(buttonSize: ButtonSize) {
        val layoutParams = binding.root.layoutParams
        layoutParams.height = when (buttonSize) {
            ButtonSize.SMALL -> resources.getDimensionPixelSize(R.dimen.small_button_height)
            ButtonSize.MEDIUM -> resources.getDimensionPixelSize(R.dimen.medium_button_height)
            ButtonSize.LARGE -> resources.getDimensionPixelSize(R.dimen.large_button_height)
        }
        binding.root.layoutParams = layoutParams
    }

    enum class ButtonSize {
        SMALL,
        MEDIUM,
        LARGE
    }
    private fun setLayout(attrs: AttributeSet?) {
        attrs.let { attributeSet ->
            val attributes = context.obtainStyledAttributes(
                attributeSet,
                R.styleable.ProgressButton
            )
            setBackgroundResource(R.drawable.progress_button_background)
            val titleResId =
                attributes.getResourceId(R.styleable.ProgressButton_progress_button_title, 0)
            if (titleResId != 0) {
                title = context.getString(titleResId)
            }
            val loadingTitleResId =
                attributes.getResourceId(R.styleable.ProgressButton_progress_loading_title, 0)
            if (loadingTitleResId != 0) {
                loadingTitle = context.getString(loadingTitleResId)
            }

            attributes.recycle()
        }
    }

    private fun refreshState() {
        isEnabled = state.isEnabled
        isClickable = state.isEnabled
        refreshDrawableState()

        binding.textTitle.run {
            isEnabled = state.isEnabled
            isClickable = state.isEnabled
        }
        binding.progressButton.visibility = state.progressVisibility
//        setBackgroundColor(customBackgroundColor)
        backgroundTintList = ColorStateList.valueOf(customBackgroundColor)

        when (state) {
            ProgressButtonState.Normal -> binding.textTitle.text = title
            ProgressButtonState.Loading -> binding.textTitle.text = loadingTitle
        }
    }

    fun setLoading() {
        state = ProgressButtonState.Loading

    }

    fun setNormal() {
        state = ProgressButtonState.Normal
    }

    sealed class ProgressButtonState(val isEnabled: Boolean, val progressVisibility: Int) {
        object Normal : ProgressButtonState(isEnabled = true, View.GONE)
        object Loading : ProgressButtonState(isEnabled = false, View.VISIBLE)
    }
}
