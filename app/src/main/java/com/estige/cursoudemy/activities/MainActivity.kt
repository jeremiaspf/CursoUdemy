package com.estige.cursoudemy.activities

import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.Toolbar
import android.widget.Toast
import com.estige.cursoudemy.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : ControlDeToolbar() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Toolbar manual
        toolbarToLoad(botontoolbar as Toolbar)
        //enableHomeDisplay(true)



        //setSupportActionBar(botontoolbar as Toolbar?)
        //botontoolbar.setOnClickListener{Toast.makeText(this, "Click toolbar: Este mensaje es en el menú principal", Toast.LENGTH_LONG).show()}

        botonListView.setOnClickListener {
            var vistaDestino = Intent(
                    this,
                    VerListaActivity::class.java
            )
            vistaDestino.putExtra("titulo",botonListView.text.toString())
            startActivity(vistaDestino) //vistaDestino será intent en destino
            Toast.makeText(this, "Aquí mostraremos la ventana con la lista cargada", Toast.LENGTH_LONG).show()
        }

        botonCamera.setOnClickListener {
            var vistaDestino = Intent(
                    this,
                    PermissionActivity::class.java
            )
            startActivity(vistaDestino) //vistaDestino será intent en destino
        }




        botonSalir.setOnClickListener{finishAndRemoveTask()}
    }
}
