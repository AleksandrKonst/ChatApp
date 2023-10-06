package com.example.chatapp.Service

import android.util.Patterns

fun CharSequence?.isValidEmail() = !isNullOrEmpty() && Patterns.EMAIL_ADDRESS.matcher(this).matches() && this.length <= 30

fun CharSequence?.isValidPassword() = !isNullOrEmpty() && this.length <= 20

fun CharSequence?.isValidName() = !isNullOrEmpty() && this.length <= 30