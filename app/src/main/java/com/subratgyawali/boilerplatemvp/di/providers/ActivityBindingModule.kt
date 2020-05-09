package com.subratgyawali.boilerplatemvp.di.providers

import dagger.Module
import dagger.android.ContributesAndroidInjector
import com.subratgyawali.boilerplatemvp.di.scope.PerActivity

@Module
abstract class ActivityBindingModule {

//    @PerActivity
//    @ContributesAndroidInjector(modules = [(LoginActivityModule::class)])
//    abstract fun bindLoginActivity(): LoginActivity

}