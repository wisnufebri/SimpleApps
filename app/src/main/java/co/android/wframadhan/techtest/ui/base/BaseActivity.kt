package co.android.wframadhan.techtest.ui.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding

abstract class BaseActivity : AppCompatActivity() {

    abstract val binding: ViewBinding

    abstract fun init()

    open fun observer() {}


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        init()
        observer()
    }

    override fun onDestroy() {
        super.onDestroy()
    }
}