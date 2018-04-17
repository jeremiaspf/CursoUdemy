package com.estige.cursoudemy.activities

import android.os.Bundle
import android.support.v7.widget.Toolbar
import com.estige.cursoudemy.R
import com.estige.cursoudemy.R.layout.linea_persona
import com.estige.cursoudemy.adapters.LineaPersonaAdapter
import com.estige.cursoudemy.models.PersonaDataClass
import kotlinx.android.synthetic.main.activity_ver_lista.*

class VerListaActivity : ControlDeToolbar() {

    //DOS FORMAS DE HACER LO MISMO, PARA QUE DISPONGAN DE VALOR [null o lateinit]
    private var adaptador: LineaPersonaAdapter? = null
    private lateinit var listaPersonas: List<PersonaDataClass>
    private var titulo: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ver_lista)
        titulo = intent.getStringExtra("titulo")

        //Toolbar manual, el destino (actividad padre) se indica en el manifest
        toolbarToLoad(botontoolbar as Toolbar)
        enableHomeDisplay(true)




        //setSupportActionBar(botontoolbar as Toolbar?) //Activar
        //supportActionBar?.setDisplayHomeAsUpEnabled(true) //activa el atras
        //botontoolbar.setOnClickListener{ Toast.makeText(this, "Click TOOLBAR: Este mensaje es en la vista de personas", Toast.LENGTH_LONG).show()}

        listaPersonas = obtenerPersonas()
        adaptador = LineaPersonaAdapter(this, linea_persona  , listaPersonas)
        contenedorListView.adapter = adaptador

    }

    private fun obtenerPersonas(): List<PersonaDataClass> {
        val listaDePersonas = listOf<PersonaDataClass>(
                PersonaDataClass("Alejandro", "Lora", 27),
                PersonaDataClass("Juan", "Fernández", 28),
                PersonaDataClass("Jeremias", "Perez", 29),
                PersonaDataClass("Gabriel", "Alonso", 30),
                PersonaDataClass("Cristina", "Juncadella", 31),
                PersonaDataClass("Marcos", "Lucas", 32),
                PersonaDataClass("Alexia", "Sintetico", 33),
                PersonaDataClass("Mercedes", "Ramos", 34),
                PersonaDataClass("Matea", "Cosmos", 35)
        )
        return listaDePersonas
    }
}
