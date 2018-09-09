package com.example.achmad.footballmatchschedulever3.utils

import io.reactivex.Scheduler


interface SchedulerProviderView {
    fun ui(): Scheduler
    fun io(): Scheduler

}