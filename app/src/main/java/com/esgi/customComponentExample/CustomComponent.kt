package com.esgi.customComponentExample

import android.content.Context
import android.graphics.Color
import android.util.AttributeSet
import android.view.View
import android.widget.EditText
import android.widget.ImageView
import androidx.constraintlayout.widget.ConstraintLayout

class CustomComponent (context: Context, attrs: AttributeSet? = null) : ConstraintLayout(context, attrs) {

    private var imageView: ImageView
    private var editText: EditText

    init {
        View.inflate(context, R.layout.custom_component, this)

        imageView = findViewById(R.id.my_image_view)
        editText = findViewById(R.id.my_edit)

        attrs?.let {
            val styledAttributeList = context.obtainStyledAttributes(it, R.styleable.CustomComponent, 0, 0)

            imageView.setImageResource(styledAttributeList.getResourceId(
                R.styleable.CustomComponent_src,
                R.drawable.windows_phone
            ))
            editText.setTextColor(styledAttributeList.getColor(R.styleable.CustomComponent_textColor, Color.BLACK))
            editText.setText(styledAttributeList.getString(R.styleable.CustomComponent_text))

            styledAttributeList.recycle()
        }
    }
}