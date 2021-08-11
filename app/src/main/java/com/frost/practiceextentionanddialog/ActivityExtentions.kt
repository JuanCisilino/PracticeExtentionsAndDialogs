package com.frost.practiceextentionanddialog

import android.app.Activity
import android.widget.Toast

fun Activity.toastShort(message: String){
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show() }


fun Activity.toastLong(message: String){
    Toast.makeText(this, message, Toast.LENGTH_LONG).show() }