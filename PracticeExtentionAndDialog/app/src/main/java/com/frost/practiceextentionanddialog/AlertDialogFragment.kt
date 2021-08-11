package com.frost.practiceextentionanddialog

import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.os.Bundle
import androidx.fragment.app.DialogFragment

class AlertDialogFragment: DialogFragment() {

    private var onPositiveCallback: (() -> Unit)? = null
    private var onNegativeCallback: (() -> Unit)? = null

    companion object{
        const val messageKey = "message"
        const val positiveKey = "positive"
        const val negativeKey = "negative"

        fun newInstace(message: String, positive: String ?= "Yes", negative: String ?= "No"): AlertDialogFragment{
            val alertDialogFragment = AlertDialogFragment()
            val bundle = Bundle()
            bundle.putString(messageKey, message)
            bundle.putString(positiveKey, positive)
            bundle.putString(negativeKey, negative)
            alertDialogFragment.arguments = bundle
            return alertDialogFragment
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        (context as? PositiveCallback)?.let { onPositiveCallback = {it.positivePressedOnAlertDialog()}}
        (context as? PositiveNegativeCallback)?.let { onNegativeCallback = {it.negativePressedOnAlertDialog()} }
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val message: String = arguments?.getString(messageKey)!!
        val positive: String = arguments?.getString(positiveKey)!!
        val negative: String = arguments?.getString(negativeKey)!!
        val alertDialogBuilder = AlertDialog.Builder(context)
        isCancelable = false
        alertDialogBuilder.setMessage(message)
        alertDialogBuilder.setPositiveButton(positive) { _, _ -> onPositiveCallback?.invoke()}
        alertDialogBuilder.setNegativeButton(negative) { _, _ -> onNegativeCallback?.invoke()}
        return alertDialogBuilder.create()
    }

    interface PositiveCallback {
        fun positivePressedOnAlertDialog()
    }

    interface PositiveNegativeCallback: PositiveCallback {
        fun negativePressedOnAlertDialog()
    }
}