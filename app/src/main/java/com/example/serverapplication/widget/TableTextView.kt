package com.example.serverapplication.widget

import android.content.Context
import android.util.AttributeSet
import android.widget.TextView
import androidx.appcompat.widget.LinearLayoutCompat
import com.example.serverapplication.R
import com.example.serverapplication.widget.common.TableTextViewInfo

class TableTextView(context: Context, attrs: AttributeSet, defStyleAttr: Int) :
    LinearLayoutCompat(context, attrs, defStyleAttr) {

    private val firstTitle: TextView
    private val secondTitle: TextView
    private val thirdTitle: TextView

    constructor(context: Context, attrs: AttributeSet) : this(context, attrs, 0)

    fun setFirstTitleText(text: String) {
        firstTitle.text = text
    }

    fun setSecondTitleText(text: String) {
        secondTitle.text = text
    }

    fun setThirdTitleText(text: String) {
        thirdTitle.text = text
    }

    fun invalidateView(info: TableTextViewInfo) {
        firstTitle.apply {
            text = info.firstTitle
            info.firstStyleId?.let {
                setTextAppearance(it)
            }
        }

        secondTitle.apply {
            text = info.secondTitle
            info.secondStyleId?.let {
                setTextAppearance(it)
            }
        }

        thirdTitle.apply {
            text = info.thirdTitle
            info.thirdStyleId?.let {
                setTextAppearance(it)
            }
        }
    }

    init {
        inflate(context, R.layout.table_text_view, this)

        firstTitle = findViewById(R.id.first_title)
        secondTitle = findViewById(R.id.second_title)
        thirdTitle = findViewById(R.id.third_title)

        context.theme.obtainStyledAttributes(attrs, R.styleable.TableTextView, 0, 0).apply {
            try {
                firstTitle.apply {
                    text = getString(R.styleable.TableTextView_first_title_text)
                    val textAppearance =
                        getResourceId(R.styleable.TableTextView_first_title_text_style, -1)
                    if (textAppearance != -1) {
                        setTextAppearance(textAppearance)
                    }
                }

                secondTitle.apply {
                    text = getString(R.styleable.TableTextView_second_title_text)
                    val textAppearance =
                        getResourceId(R.styleable.TableTextView_second_title_text_style, -1)
                    if (textAppearance != -1) {
                        setTextAppearance(textAppearance)
                    }
                }

                thirdTitle.apply {
                    text = getString(R.styleable.TableTextView_third_title_text)
                    val textAppearance =
                        getResourceId(R.styleable.TableTextView_third_title_text_style, -1)
                    if (textAppearance != -1) {
                        setTextAppearance(textAppearance)
                    }
                }
            } finally {
                recycle()
            }
        }
    }
}