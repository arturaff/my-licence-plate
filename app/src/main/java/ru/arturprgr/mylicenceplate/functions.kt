package ru.arturprgr.mylicenceplate

import android.widget.Toast

fun viewToast(context: android.content.Context, text: String) = Toast.makeText(context, text, Toast.LENGTH_LONG).show()