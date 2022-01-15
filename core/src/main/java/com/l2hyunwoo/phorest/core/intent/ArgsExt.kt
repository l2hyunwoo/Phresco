package com.l2hyunwoo.phorest.core.intent

import android.os.Parcelable
import androidx.fragment.app.Fragment
import kotlin.properties.ReadOnlyProperty

/*
* Created By Nunu Lee
* at 2022.01.15
* */
fun intArgs() = ReadOnlyProperty<Fragment, Int> { thisRef, property ->
    thisRef.requireArguments().getInt(property.name)
}

fun longArgs() = ReadOnlyProperty<Fragment, Long> { thisRef, property ->
    thisRef.requireArguments().getLong(property.name)
}

fun boolArgs() = ReadOnlyProperty<Fragment, Boolean> { thisRef, property ->
    thisRef.requireArguments().getBoolean(property.name)
}

fun stringExtra() = ReadOnlyProperty<Fragment, String> { thisRef, property ->
    thisRef.requireArguments().getString(property.name, "")
}

fun <P : Parcelable> parcelableExtra() = ReadOnlyProperty<Fragment, P?> { thisRef, property ->
    thisRef.requireArguments().getParcelable(property.name)
}
