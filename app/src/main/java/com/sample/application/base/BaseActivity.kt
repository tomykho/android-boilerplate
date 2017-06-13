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
import com.sample.application.ui.toolbar
import org.jetbrains.anko.AnkoContext
import org.jetbrains.anko._LinearLayout
import org.jetbrains.anko.verticalLayout

/**
 * Created by tomykho on 5/18/17.
 */

abstract class BaseActivity : AppCompatActivity() {

    abstract val layout: BaseLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        verticalLayout {
            val toolbar = onCreateToolbar(this)
            if (toolbar != null) {
                setSupportActionBar(toolbar)
                val f = toolbar::class.java.getDeclaredField("mTitleTextView")
                f.isAccessible = true
                val titleTextView = f.get(toolbar) as TextView
                titleTextView.typeface = titleTextView.semibold
            }
            val view = layout.createView(AnkoContext.Companion.create(this@BaseActivity, this@BaseActivity))
            addView(view)
        }
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    open fun onCreateToolbar(layout: _LinearLayout): Toolbar? = with(layout) {
        toolbar()
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
