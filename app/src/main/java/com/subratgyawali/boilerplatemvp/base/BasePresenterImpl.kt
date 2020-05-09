package com.subratgyawali.boilerplatemvp.base

import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

/**
 * @author Subrat Gyawali
 */

abstract class BasePresenterImpl {
    var compositeDisposable: CompositeDisposable = CompositeDisposable()
    var disposable: Disposable? = null
}