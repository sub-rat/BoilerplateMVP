package com.subratgyawali.boilerplatemvp

import android.app.Application
import android.content.Context
import androidx.multidex.MultiDex
import com.jakewharton.threetenabp.AndroidThreeTen
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import com.subratgyawali.boilerplatemvp.di.component.DaggerApplicationComponent
import javax.inject.Inject

class MainApplication : Application(), HasAndroidInjector{

    override fun androidInjector(): AndroidInjector<Any> {
        return  activityDispatchingAndroidInjector
    }

    @Inject
    lateinit var activityDispatchingAndroidInjector: DispatchingAndroidInjector<Any>

    override fun onCreate() {
        super.onCreate()
        initializeDaggerComponent()
        initConfig()
    }


    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        MultiDex.install(this)
    }

    fun initConfig(){
        AndroidThreeTen.init(this)
    }

    private fun initializeDaggerComponent() {
        DaggerApplicationComponent.builder()
            .application(this)
            .build()
            .inject(this)
    }
}