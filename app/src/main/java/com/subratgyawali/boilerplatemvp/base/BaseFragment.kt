package com.subratgyawali.boilerplatemvp.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ProgressBar
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.subratgyawali.boilerplatemvp.R
import dagger.android.support.DaggerFragment

/**
 * @author Subrat Gyawali
 */

abstract class BaseFragment<T: ViewDataBinding> : DaggerFragment() {

    abstract fun layout(): Int

    lateinit var binding: T

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, layout(), container, false)
        return binding.root
    }

    fun <T : ViewDataBinding> showLoading(binding: T?) {
        binding?.root?.findViewById<Button>(R.id.btnAction)?.visibility = View.GONE
        binding?.root?.findViewById<RelativeLayout>(R.id.loadingLayout)?.findViewById<RelativeLayout>(
            R.id.loadingContainer)?.alpha= 0.2F
        binding?.root?.findViewById<RelativeLayout>(R.id.loadingLayout)?.visibility = View.VISIBLE
        binding?.root?.findViewById<RelativeLayout>(R.id.loadingLayout)?.findViewById<TextView>(R.id.txtLoading)?.text = getString(
            R.string.loading)
        binding?.root?.findViewById<RelativeLayout>(R.id.loadingLayout)?.findViewById<ProgressBar>(R.id.progressBar)?.visibility = View.VISIBLE
    }

    fun <T : ViewDataBinding> showData(binding: T?) {
        binding?.root?.findViewById<RelativeLayout>(R.id.loadingLayout)?.visibility = View.GONE
    }

    fun <T : ViewDataBinding> showError(binding: T?, errorMessage: String) {
        binding?.root?.findViewById<Button>(R.id.btnAction)?.visibility = View.GONE
        binding?.root?.findViewById<RelativeLayout>(R.id.loadingLayout)?.visibility = View.VISIBLE
        binding?.root?.findViewById<RelativeLayout>(R.id.loadingLayout)?.findViewById<TextView>(R.id.txtLoading)?.text = errorMessage
        binding?.root?.findViewById<RelativeLayout>(R.id.loadingLayout)?.findViewById<ProgressBar>(R.id.progressBar)?.visibility = View.GONE
    }

    fun <T : ViewDataBinding> showActionableError(binding: T?, errorMessage: String, actionLabel: String, actionListener: () -> Unit) {
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
}

