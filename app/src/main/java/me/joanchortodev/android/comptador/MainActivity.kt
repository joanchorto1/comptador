package me.joanchortodev.android.comptador

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.ComponentActivity


class MainActivity : ComponentActivity() {

    internal lateinit var tapmebutton : Button
    internal lateinit var Timetextview : TextView
    internal lateinit var comptadortextview : TextView
    internal var counter = 0
    internal var time = 60
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_main)


        tapmebutton = findViewById(R.id.tapmebutton)
        Timetextview = findViewById(R.id.Timetextview)
        comptadortextview = findViewById(R.id.comptadortextview)

        //Actualitzar o definir el valor inicial de ComptadorTextView

        //TODO EXECUTAR LES FUNCIONS

        tapmebutton.setOnClickListener{
            incrementCounter()
        }

        Timetextview.text= getString(R.string.timeText, time)

    }

    private fun incrementCounter(){
        counter += 1;
        comptadortextview.text= counter.toString();

    }
    private fun decrementarTime(){

    }
}

