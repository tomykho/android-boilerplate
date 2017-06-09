package com.sample.application.base

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.util.Log
import android.view.MenuItem
import android.widget.TextView
import com.sample.application.R
import com.sample.application.api.ApiException
import com.sample.application.ui.semibold
import org.jetbrains.anko.internals.AnkoInternals
import org.jetbrains.anko.setContentView

/**
 * Created by tomykho on 5/18/17.
 */

abstract class BaseActivity : AppCompatActivity() {

    var toolbar: Toolbar
        @Deprecated(AnkoInternals.NO_GETTER, level = DeprecationLevel.ERROR) get() = AnkoInternals.noGetter()
        set(v) {
            setSupportActionBar(v)
            val f = v::class.java.getDeclaredField("mTitleTextView")
            f.isAccessible = true
            val titleTextView = f.get(v) as TextView
            titleTextView.typeface = titleTextView.semibold
        }

    abstract val layout: BaseLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        layout.setContentView(this)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId) {
            android.R.id.home -> finish()
        }
        return super.onOptionsItemSelected(item)
    }

    override fun startActivity(intent: Intent) {
        super.startActivity(intent)
        overridePendingTransition(R.anim.slide_in_right, R.anim.fade_out)
    }

    override fun finish() {
        super.finish()
        overridePendingTransition(R.anim.fade_in, R.anim.slide_out_right)
    }

    fun onError(e: Throwable) {
        if (e is ApiException) {
            when (e.kind) {
                ApiException.Kind.HTTP -> {
                    val error = e.error
                    if (error != null) {
                        Log.e("error", error.message)
                    }
                }
                else -> {
                    Log.e("error", e.message)
                }
            }
        }
    }

}
