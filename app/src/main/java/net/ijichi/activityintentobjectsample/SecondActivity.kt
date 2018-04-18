package net.ijichi.activityintentobjectsample

import android.os.Bundle
import android.service.autofill.Dataset
import android.support.v7.app.AppCompatActivity
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken


class SecondActivity : AppCompatActivity() {

    companion object {
        val KEY_STATE = "key_state"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val statesStr = intent.getStringExtra(KEY_STATE)
        // Gsonで String → List<Object>
        val states = Gson().fromJson<List<DataState>>(statesStr, object : TypeToken<List<DataState>>() {}.type)

        states.forEach {
            println(it.id)
            println(it.name)
        }
    }
}