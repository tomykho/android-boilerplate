package com.boilerplate.ui

import android.content.Context
import android.graphics.Typeface
import android.support.v7.widget.Toolbar
import android.util.TypedValue
import android.view.View
import android.view.ViewManager
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.boilerplate.R
import com.boilerplate.widget.SquareImageView
import com.boilerplate.widget.StateView
import org.jetbrains.anko.AnkoViewDslMarker
import org.jetbrains.anko.custom.ankoView
import org.jetbrains.anko.internals.AnkoInternals
import org.jetbrains.anko.button as _button
import org.jetbrains.anko.editText as _editText
import org.jetbrains.anko.textView as _textView

/**
 * Created by tomykho on 5/19/17.
 */

val View.selectableItemBackgroundResource: Int get() {
    val typedValue = TypedValue()
    context.theme.resolveAttribute(R.attr.selectableItemBackground, typedValue, true)
    return typedValue.resourceId
}

val font: String get() = "SanFranciscoDisplay"

val TextView.regular: Typeface get() = Typeface.createFromAsset(context.assets, "fonts/$font-Regular.otf")

val TextView.semibold: Typeface get() = Typeface.createFromAsset(context.assets, "fonts/$font-Semibold.otf")

val TextView.bold: Typeface get() = Typeface.createFromAsset(context.assets, "fonts/$font-Bold.otf")

var ImageView.url: String
    @Deprecated(AnkoInternals.NO_GETTER, level = DeprecationLevel.ERROR) get() = AnkoInternals.noGetter()
    set(v) {
        Glide.with(context).load(v).into(this)
    }

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

fun ViewManager.toolbar(): Toolbar = toolbar {}
fun ViewManager.toolbar(init: (@AnkoViewDslMarker Toolbar).() -> Unit): Toolbar = ankoView({ ctx: Context -> Toolbar(ctx) }, theme = R.style.ThemeOverlay_AppCompat_Dark_ActionBar) {
    init()
}

fun ViewManager.squareImageView(init: (@AnkoViewDslMarker SquareImageView).() -> Unit): SquareImageView {
    return ankoView({ ctx: Context -> SquareImageView(ctx) }, theme = 0) {
        init()
    }
}

fun ViewManager.stateView(init: (@AnkoViewDslMarker StateView).() -> Unit): StateView {
    return ankoView({ ctx: Context -> StateView(ctx) }, theme = 0) {
        init()
    }
}