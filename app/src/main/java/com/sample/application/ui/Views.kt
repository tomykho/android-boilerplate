package com.sample.application.ui

import android.content.Context
import android.graphics.Typeface
import android.support.v4.content.ContextCompat
import android.support.v7.widget.Toolbar
import android.view.ViewManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import org.jetbrains.anko.AnkoViewDslMarker
import org.jetbrains.anko.custom.ankoView
import org.jetbrains.anko.button as _button
import org.jetbrains.anko.editText as _editText
import org.jetbrains.anko.textView as _textView

/**
 * Created by tomykho on 5/19/17.
 */
val font: String get() = "SanFranciscoDisplay"
val TextView.regular: Typeface get() = Typeface.createFromAsset(context.assets, "fonts/$font-Regular.otf")
val TextView.semibold: Typeface get() = Typeface.createFromAsset(context.assets, "fonts/$font-Semibold.otf")
val TextView.bold: Typeface get() = Typeface.createFromAsset(context.assets, "fonts/$font-Bold.otf")

fun ViewManager.textView(): TextView = textView {}
fun ViewManager.textView(init: (@AnkoViewDslMarker TextView).() -> Unit): TextView {
    val view = _textView(init)
    view.typeface = view.regular
    return view
}

fun ViewManager.editText(): EditText = editText {}
fun ViewManager.editText(init: (@AnkoViewDslMarker EditText).() -> Unit): EditText {
    val view = _editText(init)
    view.typeface = view.regular
    return view
}

fun ViewManager.button(): Button = button {}
fun ViewManager.button(init: (@AnkoViewDslMarker Button).() -> Unit): Button = button(0, init)
fun ViewManager.button(text: Int): Button = button(text) {}
fun ViewManager.button(text: Int, init: (@AnkoViewDslMarker Button).() -> Unit): Button {
    val view = _button(text, init)
    view.typeface = view.semibold
    return view
}

fun ViewManager.toolbar(): Toolbar = ankoView({ ctx: Context -> Toolbar(ctx) }, theme = 0) {
    setTitleTextColor(ContextCompat.getColor(context, android.R.color.white))
}