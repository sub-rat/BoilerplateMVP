package com.subratgyawali.boilerplatemvp.base

import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.ProgressBar
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.subratgyawali.boilerplatemvp.R
import dagger.android.support.DaggerAppCompatActivity


/**
 * @author Subrat Gyawali
 */
abstract class BaseActivity<T : ViewDataBinding> : DaggerAppCompatActivity(){

    abstract fun layout(): Int

    lateinit var binding: T

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_left);
        binding = DataBindingUtil.setContentView(this, layout())


    }

    override fun finish() {
        super.finish()
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right)
    }

    fun <T : ViewDataBinding> showLoading(binding: T?, message: String = getString(R.string.loading)) {
        getWindow().setFlags(
            WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE,
            WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
        binding?.root?.findViewById<Button>(R.id.btnAction)?.visibility = View.GONE
        binding?.root?.findViewById<RelativeLayout>(R.id.loadingLayout)?.findViewById<RelativeLayout>(R.id.loadingContainer)?.alpha= 0.2F
        binding?.root?.findViewById<RelativeLayout>(R.id.loadingLayout)?.visibility = View.VISIBLE
        binding?.root?.findViewById<RelativeLayout>(R.id.loadingLayout)?.findViewById<TextView>(R.id.txtLoading)?.text = message
        binding?.root?.findViewById<RelativeLayout>(R.id.loadingLayout)?.findViewById<ProgressBar>(R.id.progressBar)?.visibility = View.VISIBLE
    }

    fun <T : ViewDataBinding> showData(binding: T?) {
        getWindow().clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
        binding?.root?.findViewById<RelativeLayout>(R.id.loadingLayout)?.visibility = View.GONE
    }

    fun <T : ViewDataBinding> showError(binding: T?, errorMessage: String) {
        getWindow().clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
        binding?.root?.findViewById<Button>(R.id.btnAction)?.visibility = View.GONE
        binding?.root?.findViewById<RelativeLayout>(R.id.loadingLayout)?.visibility = View.VISIBLE
        binding?.root?.findViewById<RelativeLayout>(R.id.loadingLayout)?.findViewById<TextView>(R.id.txtLoading)?.text = errorMessage
        binding?.root?.findViewById<RelativeLayout>(R.id.loadingLayout)?.findViewById<ProgressBar>(R.id.progressBar)?.visibility = View.GONE
    }

    fun <T : ViewDataBinding> showActionableError(binding: T?, errorMessage: String, actionLabel: String, actionListener: () -> Unit) {
        getWindow().clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
        binding?.root?.findViewById<Button>(R.id.btnAction)?.visibility = View.GONE
        binding?.root?.findViewById<RelativeLayout>(R.id.loadingLayout)?.visibility = View.VISIBLE
        binding?.root?.findViewById<RelativeLayout>(R.id.loadingLayout)?.findViewById<TextView>(R.id.txtLoading)?.text = errorMessage
        binding?.root?.findViewById<RelativeLayout>(R.id.loadingLayout)?.findViewById<Button>(R.id.btnAction)?.apply {
            text = actionLabel
            visibility = View.VISIBLE
            setOnClickListener {
                actionListener()
            }
        }
        binding?.root?.findViewById<RelativeLayout>(R.id.loadingLayout)?.findViewById<ProgressBar>(R.id.progressBar)?.visibility = View.GONE
    }

    fun hideKeyboard(view: View) {
        val imm: InputMethodManager? = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm?.hideSoftInputFromWindow(view.windowToken, 0)
    }
}