package com.saucefan.stuff.additionalandroidm01

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.AttributeSet
import com.saucefan.stuff.additionalandroidm01.work.cb
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main2.*

class Main2Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        val cb= cb(this,)
        rl.addView(cb)
        cb.invalidate()



    }
}
