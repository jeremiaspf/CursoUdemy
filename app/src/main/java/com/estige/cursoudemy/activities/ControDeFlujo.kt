package com.estige.cursoudemy.activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

open class ControDeFlujo : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        println("-->inicio evento [ONCREATE] ${this.localClassName}")
        super.onCreate(savedInstanceState)
        println("-->fin evento [ONCREATE] ${this.localClassName}")
    }

    override fun onBackPressed() {
        println("-->inicio evento [ONBACKPRESSED] ${this.localClassName}")
        super.onBackPressed()
        println("-->fin evento [ONBACKPRESSED] ${this.localClassName}")
    }

    override fun onStart() {
        println("-->inicio evento [ONSTART] ${this.localClassName}")
        super.onStart()
        println("-->fin evento [ONSTART] ${this.localClassName}")
    }

    override fun onResume() {
        println("-->inicio evento [ONRESUME] ${this.localClassName}")
        super.onResume()
        println("-->fin evento [ONRESUME] ${this.localClassName}")
    }

    override fun onPause() {
        println("-->inicio evento [ONPAUSE] ${this.localClassName}")
        super.onPause()
        println("-->evento [ONPAUSE] ${this.localClassName}")
    }

    override fun onStop() {
        println("-->inicio evento [ONSTOP] ${this.localClassName}")
        super.onStop()
        println("-->fin evento [ONSTOP] ${this.localClassName}")
    }

    override fun onDestroy() {
        println("-->inicio evento [ONDESTROY] ${this.localClassName}")
        super.onDestroy()
        println("-->fin evento [ONDESTROY] ${this.localClassName}")
    }

}
