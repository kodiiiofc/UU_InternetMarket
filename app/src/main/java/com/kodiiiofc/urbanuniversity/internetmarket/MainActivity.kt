package com.kodiiiofc.urbanuniversity.internetmarket

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        val startBtn = findViewById<Button>(R.id.btn_start)
        val headerTV = findViewById<TextView>(R.id.tv_header)
        val logoIV = findViewById<ImageView>(R.id.iv_logo)

        headerTV.translationY = -400f

        headerTV.animate().apply {
            duration = 1000
            translationY(0f)
        }

        logoIV.rotationY = -360f
        logoIV.animate().apply {
            startDelay = 1000
            duration = 2000
            rotationY(0f)
        }

        startBtn.alpha = 0f
        startBtn.animate().apply {
            startDelay = 3000
            duration = 1000
            alphaBy(1f)
        }

        startBtn.setOnClickListener {
            supportFragmentManager.beginTransaction()
                .replace(R.id.cl_main, MarketFragment())
                .commit()
            startBtn.visibility = View.GONE
            headerTV.visibility = View.GONE
            logoIV.visibility = View.GONE
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menu?.add(1,1,1,"Выход")?.setIcon(R.drawable.ic_exit)?.setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            1 -> finish()
        }
        return super.onOptionsItemSelected(item)
    }
}