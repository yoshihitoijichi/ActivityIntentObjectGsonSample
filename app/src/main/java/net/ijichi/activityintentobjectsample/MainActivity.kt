package net.ijichi.activityintentobjectsample

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.google.gson.Gson

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val states = arrayListOf<DataState>()
        for(i in 0..2){
            val state = DataState(i, "name$i")
            states.add(state)
        }

        val intent = Intent(this, SecondActivity::class.java)
        // Gsonで List<Object> → String
        intent.putExtra(SecondActivity.KEY_STATE, Gson().toJson(states))
        startActivity(intent)
    }
}

