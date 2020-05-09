package com.subratgyawali.boilerplatemvp.base

import android.view.View
import androidx.recyclerview.widget.RecyclerView

/**
 * @author Subrat Gyawali
 */
abstract class BaseViewHolder<in T>(itemView: View) : RecyclerView.ViewHolder(itemView) {
    abstract fun bindView(obj: T)
}