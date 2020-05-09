package com.subratgyawali.boilerplatemvp.utils
import io.reactivex.Scheduler

/**
 * Provide scheduling to observer/subscribe for streams
 *
 * @see [ApplicationModule.provideScheduler]
 */

interface SchedulersFactory {

    /**
     * Scheduler generally used for observing streams.
     * @return scheduler representing the ui
     */
    fun ui(): Scheduler

    /**
     * Scheduler generally used for subscribing to streams.
     * @return scheduler representing I/O operations
     */
    fun io(): Scheduler
}