package com.frost.practiceextentionanddialog

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(R.layout.activity_main), AlertDialogFragment.PositiveNegativeCallback {

    private val message = "Que Toast desea invocar?"
    private lateinit var alertDialogFragment: AlertDialogFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setButton()
    }

    private fun setButton() {
        button.setOnClickListener {
            alertDialogFragment = AlertDialogFragment.newInstace(message, "Short", "Long")
            alertDialogFragment.show(supportFragmentManager, "tag")
        }
    }

    override fun negativePressedOnAlertDialog() { toastLong("Funcionando Ok Long")}

    override fun positivePressedOnAlertDialog() { toastShort("Funcionando Ok Short")}
}
