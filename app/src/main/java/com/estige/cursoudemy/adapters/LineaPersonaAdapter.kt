package com.estige.cursoudemy.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.estige.cursoudemy.models.PersonaDataClass
import com.estige.cursoudemy.view_holders.PersonaViewHolder

class LineaPersonaAdapter (val contexto: Context, val patronLayout: Int, val listaPersonas:List<PersonaDataClass>) : BaseAdapter() {

    override fun getItem(position: Int): Any {
        return listaPersonas[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return listaPersonas.size
    }

    private val lineaInflada: LayoutInflater = LayoutInflater.from(contexto)
    //Cada vez que se llena una línea del contenedorListView con un elemento de la lista se llama a este método
    override fun getView(position: Int, lineaPersona: View?, listaLineaPersona: ViewGroup?): View {
        val vista: View
        val patronVista: PersonaViewHolder
        if (lineaPersona == null) { //Esta es la primera vez que entra, viene vacio
            vista = lineaInflada.inflate(patronLayout, listaLineaPersona, false)
            patronVista = PersonaViewHolder(vista)
            vista.tag = patronVista
        } else {
            vista = lineaPersona
            patronVista = vista.tag as PersonaViewHolder
        }

        val nombreCompleto = "${listaPersonas[position].nombre}, ${listaPersonas[position].apellidos}"
        patronVista.nombre.text = nombreCompleto
        patronVista.edad.text = "${listaPersonas[position].edad}"

        return vista

    }

}