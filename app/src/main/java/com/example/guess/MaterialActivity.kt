package com.example.guess

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity

import kotlinx.android.synthetic.main.activity_material.*
import kotlinx.android.synthetic.main.content_material.*

class MaterialActivity : AppCompatActivity() {

    val secretNumber = SecretNumber()
    val TAG = MaterialActivity::class.java.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_material)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            AlertDialog.Builder(this)
                .setTitle("Replay game")
                .setMessage("are you sure?")
                .setPositiveButton(getString(R.string.ok),{dialog, which ->
                    secretNumber.reset()
                    counter.setText(secretNumber.count.toString())
                    number.setText("")
                })
                .setNegativeButton("Cancel",null)
                .show()
        }
        counter.setText(secretNumber.count.toString())
    }
    fun check(view: View) {

        val n = number.text.toString().toInt()
        println("number: $n ")
        Log.d(TAG, "number:" + n)
        val diff = secretNumber.validate(n)
        var message =getString(R.string.yes_you_got_it)
        if (diff < 0) {
            message = getString(R.string.Bigger)
        } else if (diff > 0) {
            message =getString(R.string.Samller)
        }

        counter.setText(secretNumber.count.toString())
        AlertDialog.Builder(this)
            .setTitle(getString(R.string.dialog_title))
            .setMessage(message)
            .setPositiveButton(getString(R.string.ok),null)
            .show()
    }

}
