package com.estige.cursoudemy.activities

import com.estige.cursoudemy.models.ToolbarInterface
import android.support.v7.widget.Toolbar

open class ControlDeToolbar : ControDeFlujo(), ToolbarInterface {

    protected var _toolbar: Toolbar? = null

    override fun toolbarToLoad(toolbar: Toolbar) {
        _toolbar = toolbar
        _toolbar?.let{setSupportActionBar(_toolbar)}
    }

    override fun enableHomeDisplay(value: Boolean) {
        supportActionBar?.setDisplayHomeAsUpEnabled(value)
    }
}
