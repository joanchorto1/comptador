package me.joanchortodev.android.comptador

import android.content.IntentSender.OnFinished
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.compose.material3.TimeInput


class MainActivity : ComponentActivity() {

    internal lateinit var tapmebutton: Button
    internal lateinit var Timetextview: TextView
    internal lateinit var comptadortextview: TextView
    internal var counter = 0
    internal var time = 60
    internal var appStarted = false
    internal lateinit var countDownTimer: CountDownTimer
    internal var initialCountDownTimer: Long = 60000
    internal var intervalCountDownTimer: Long = 1000
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_main)

        initCountDown()

        tapmebutton = findViewById(R.id.tapmebutton)
        Timetextview = findViewById(R.id.Timetextview)
        comptadortextview = findViewById(R.id.comptadortextview)

        //Actualitzar o definir el valor inicial de ComptadorTextView

        //TODO EXECUTAR LES FUNCIONS

        tapmebutton.setOnClickListener {
            if (!appStarted) {
                startGame()

            }
            incrementCounter()
        }

        Timetextview.text = getString(R.string.timeText, time)

    }

    private fun startGame() {
        countDownTimer.start()
        appStarted = true
    }

    private fun incrementCounter() {
        counter += 1;
        comptadortextview.text = counter.toString();

    }

    private fun resetGame() {


    }

    private fun endGame() {
        Toast.makeText(this, getString(R.string.endGame), Toast.LENGTH_LONG).show()
    }

    private fun initCountDown() {
        countDownTimer = object : CountDownTimer(initialCountDownTimer, intervalCountDownTimer) {
            override fun onTick(millisUntilFinished: Long) {
                val timeLeft = millisUntilFinished / 1000
                Timetextview.text = timeLeft.toString()
            }

            override fun onFinish() {
                endGame()
            }

        }
    }
}

