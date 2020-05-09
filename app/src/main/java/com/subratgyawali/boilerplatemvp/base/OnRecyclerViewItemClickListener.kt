package com.subratgyawali.boilerplatemvp.base

/**
 * @author Subrat Gyawali
 */

interface OnRecyclerViewItemClickListener<in T> {
    fun onRecyclerViewItemClick(selectedItem: T, position : Int)
}