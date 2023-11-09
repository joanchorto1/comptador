package me.joanchortodev.android.comptador

import android.annotation.SuppressLint
import androidx.appcompat.app.AlertDialog
import android.content.IntentSender.OnFinished
import android.os.Build
import android.os.Build.VERSION
import android.os.Bundle
import android.os.CountDownTimer
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.PopupMenu
import android.widget.TextView
import android.widget.Toast
import android.widget.Toolbar
import androidx.activity.ComponentActivity
import androidx.activity.viewModels
import com.google.android.material.snackbar.Snackbar

import kotlin.math.log


class MainActivity : ComponentActivity() {

    internal lateinit var tapmebutton: Button
    internal lateinit var menuButton: Button
    internal lateinit var Timetextview: TextView
    internal lateinit var comptadortextview: TextView
    internal var counter = 0
    internal var time = 10
    internal var appStarted = false
    internal lateinit var countDownTimer: CountDownTimer
    internal var initialCountDownTimer: Long = time.toLong() * 1000
    internal var intervalCountDownTimer: Long = 1000
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_main)

        initCountDown()

        tapmebutton = findViewById(R.id.tapmebutton)
        Timetextview = findViewById(R.id.Timetextview)
        comptadortextview = findViewById(R.id.comptadortextview)
        menuButton = findViewById(R.id.menuButton)

        //Actualitzar o definir el valor inicial de ComptadorTextView

        //TODO EXECUTAR LES FUNCIONS

        tapmebutton.setOnClickListener {view ->
            if (!appStarted) {
                startGame()

            }
            val bounceAnimation =AnimationUtils.loadAnimation(this,R.anim.bounce)
            view.startAnimation(bounceAnimation)
            incrementCounter()
        }


        Timetextview.text = getString(R.string.timeText, time)

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        super.onCreateOptionsMenu(menu)
        menuInflater.inflate(R.menu.menu,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.aboutAction -> {
                showInfo()
                return true
            }
            // Otros casos según sea necesario
            else -> return super.onOptionsItemSelected(item)
        }
    }

    private fun showInfo() {
        Snackbar.make( findViewById(android.R.id.content),"Mensaje de texto", Snackbar.LENGTH_SHORT).show()

    }





//    private fun showInfo() {
//
//        val dialogTitle = getString(R.string.aboutTitle)
//        val aboutMessage = getString(R.string.aboutMessage)
//        val builder = AlertDialog.Builder(this)
//
//        builder.setTitle(dialogTitle).setMessage(aboutMessage).create().show()
//    }

    private fun startGame() {
        countDownTimer.start()
        appStarted = true
    }

    private fun incrementCounter() {
        counter += 1;
        comptadortextview.text = "Points: "+counter.toString();

    }

    private fun resetGame() {
        counter=0;
        comptadortextview.text =counter.toString();

        println(time)
        Timetextview.text= getString(R.string.timeText, time)

        initCountDown()

        appStarted = false
    }

    private fun endGame() {
        Toast.makeText(this, getString(R.string.endGame), Toast.LENGTH_LONG).show()
        Toast.makeText(this, getString(R.string.seePoints,counter), Toast.LENGTH_LONG).show()
        resetGame()
    }

    private fun initCountDown() {
        countDownTimer = object : CountDownTimer(initialCountDownTimer, intervalCountDownTimer) {
            @SuppressLint("StringFormatMatches")
            override fun onTick(millisUntilFinished: Long) {
                val timeLeft = millisUntilFinished / 1000
//                Timetextview.text = getString(R.string.timeText,timeLeft.toString())
                Timetextview.text = "Time: " + timeLeft.toString()
            }

            override fun onFinish() {
                endGame()
            }

        }
    }
}

