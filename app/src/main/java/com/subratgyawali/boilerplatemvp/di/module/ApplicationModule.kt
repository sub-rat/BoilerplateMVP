package fi.resimator.di.module

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides
import com.subratgyawali.boilerplatemvp.data.pref.SharedPreferenceManager
import com.subratgyawali.boilerplatemvp.di.scope.PerApplication
import com.subratgyawali.boilerplatemvp.utils.SchedulersFactory
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

@Module
open class ApplicationModule {
    @Provides
    @PerApplication
    fun provideContext(application: Application): Context = application

    @Provides
    @PerApplication
    fun provideScheduler() = object : SchedulersFactory {
        override fun ui(): Scheduler = AndroidSchedulers.mainThread()
        override fun io(): Scheduler = Schedulers.io()
    }

    @Provides
    @PerApplication
    fun provideSharedPreference(context: Context): SharedPreferenceManager {
        return SharedPreferenceManager(context)
    }
}