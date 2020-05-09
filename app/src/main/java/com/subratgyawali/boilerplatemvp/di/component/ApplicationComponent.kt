package com.subratgyawali.boilerplatemvp.di.component

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule
import com.subratgyawali.boilerplatemvp.MainApplication
import com.subratgyawali.boilerplatemvp.di.module.ApiModule
import fi.resimator.di.module.ApplicationModule
import com.subratgyawali.boilerplatemvp.di.providers.ActivityBindingModule
import com.subratgyawali.boilerplatemvp.di.scope.PerApplication

@PerApplication
@Component(modules = [
    (ActivityBindingModule::class),
    (ApiModule::class),
    (ApplicationModule::class),
    (AndroidSupportInjectionModule::class)
])
interface ApplicationComponent {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): ApplicationComponent
    }

    fun inject(app: MainApplication)
}