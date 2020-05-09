package com.subratgyawali.boilerplatemvp.base

import android.content.Context
import androidx.recyclerview.widget.RecyclerView

/**
 * @author Subrat Gyawali
 */
abstract class BaseRecyclerViewAdapter<T : RecyclerView.ViewHolder> : RecyclerView.Adapter<T>() {
    abstract val context: Context
}