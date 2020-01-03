package com.chozhanaadu.animatedtypewritetextview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.chozhanaadu.typewritingtextview.TypeWriteTextView

class MainActivity : AppCompatActivity() {

    private lateinit var textView1 : TypeWriteTextView;
    private lateinit var textView2 : TypeWriteTextView;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
    }

    fun initView()
    {
        textView1 = findViewById(R.id.tv_text1);
        textView2 = findViewById(R.id.tv_text2);

        textView2.setCharDelay(500)
        textView1.animateText(getString(R.string.text1))

        textView2.animateText(getString(R.string.text1))
    }
}
