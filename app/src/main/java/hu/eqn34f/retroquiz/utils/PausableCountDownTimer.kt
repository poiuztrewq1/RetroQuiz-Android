package hu.eqn34f.retroquiz.utils

import android.os.CountDownTimer

abstract class PausableCountDownTimer(
    val timeInMinutes: Int, val countDownInterval: Long = 1000,
) {


    private var remaining = (timeInMinutes * 60000).toLong()
    private var isPaused = false


    private var timer: CountDownTimer

    init {
        timer = createTimer(remaining).start()
    }


    private fun createTimer(start: Long): CountDownTimer {
        return object : CountDownTimer(start, countDownInterval) {
            override fun onTick(p0: Long) {
                remaining = p0
                this@PausableCountDownTimer.onTick(p0)
            }

            override fun onFinish() {
                this@PausableCountDownTimer.onFinish()
            }
        }
    }

    abstract fun onTick(p0: Long)
    abstract fun onFinish()


    public fun pause() {
        if (!isPaused && remaining > 0) {
            timer.cancel()
            isPaused = true
        }
    }

    fun resume() {
        if (isPaused && remaining > 0) {
            timer = createTimer(remaining).start()
            isPaused = false
        }
    }

}