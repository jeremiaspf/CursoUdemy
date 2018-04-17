package com.estige.cursoudemy.view_holders

import android.view.View
import android.widget.TextView
import kotlinx.android.synthetic.main.linea_persona.view.*

//Implementa el patron de diseño ViewHolder
//Representa el layout_LineaPersona que luego queremos insertar en el contenedorListView
//
class PersonaViewHolder(vista: View){
    val nombre: TextView = vista.nombre
    val edad: TextView = vista.edad
}