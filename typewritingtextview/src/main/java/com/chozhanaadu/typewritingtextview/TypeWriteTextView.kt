package com.chozhanaadu.typewritingtextview

import android.content.Context
import android.os.Handler
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatTextView

class TypeWriteTextView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : AppCompatTextView(context, attrs, defStyleAttr) {

    private lateinit var mText: CharSequence
    private var mIndex = 0
    private var mDelay: Long = 100

    private val mHandler = Handler()
    private val characterAdder: Runnable = object : Runnable {
        override fun run() {
            text = mText!!.subSequence(0, mIndex++)
            if (mIndex <= mText.length) {
                mHandler.postDelayed(this, mDelay)
            }
        }
    }

    // Passing animated text from parent class
    fun animateText(text: CharSequence) {
        mText = text
        mIndex = 0
        setText("")
        mHandler.removeCallbacks(characterAdder)
        mHandler.postDelayed(characterAdder, mDelay)
    }

    // Set character delay time for typewriting animation
    fun setCharDelay(millis: Long) =  {
        mDelay = millis
    }


}