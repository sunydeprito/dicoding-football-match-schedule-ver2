package com.example.achmad.footballmatchschedulever3.utils


import io.reactivex.schedulers.Schedulers
import io.reactivex.android.schedulers.AndroidSchedulers



class AppSchedulerProvider : SchedulerProviderView {
    override fun ui() = AndroidSchedulers.mainThread()
    override fun io() = Schedulers.io()
}

class TrampolineSchedulerProvider : SchedulerProviderView {
    override fun ui() = Schedulers.trampoline()
    override fun io() = Schedulers.trampoline()
}