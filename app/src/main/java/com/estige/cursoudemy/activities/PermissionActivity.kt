package com.estige.cursoudemy.activities

import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.support.v4.app.ActivityCompat
import android.support.v4.content.ContextCompat
import android.support.v7.widget.Toolbar
import android.widget.Toast
import com.estige.cursoudemy.R
import kotlinx.android.synthetic.main.activity_permission.*
import java.util.jar.Manifest

class PermissionActivity : ControlDeToolbar() {

    private val codigoPermisoCamara = 100
    private val codigoFotoObtenida = 500

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_permission)

        //Toolbar manual
        toolbarToLoad(botontoolbar as Toolbar)
        enableHomeDisplay(true)

        buttonPicture.setOnClickListener{getPictureAndAskPermission()}
    }

    private fun getPictureAndAskPermission() {
        //Añadir permiso al manifest
        //Se comprueba el permiso a la camara
        if (ContextCompat.checkSelfPermission(this, android.Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
            //Si no ha sido aceptado (cuidado con las versiones, solo a partir de la 6.0/23)
            ActivityCompat.requestPermissions(this,arrayOf(android.Manifest.permission.CAMERA), codigoPermisoCamara) //codigoPermisoCamara es un testigo

        } else {
            //Si ha sido aceptado previamente o versión inferior a la 6.0/23
            val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivityForResult(intent,codigoFotoObtenida)
        }
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        when (requestCode) {
            codigoPermisoCamara -> {
                if (grantResults.size == 1 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                    //Permiso aceptado
                    val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
                    startActivityForResult(intent,codigoFotoObtenida)
                } else {
                    //Denegado el acceso a la camara
                    Toast.makeText(this, "Permiso denegado, no se puede realizar la foto",Toast.LENGTH_LONG).show()
                }
            }
        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        when (requestCode) {
            codigoFotoObtenida -> {
                //Comprobar si la foto es buena
                if (resultCode == Activity.RESULT_OK){
                    //Foto OK, data no puede ser nulo, por eso !!
                    val extras = data!!.extras
                    //Formamos el bitmap
                    val imagenBitMap = extras.get("data") as Bitmap
                    //Cargamos la imagen en el componente
                    imageViewPicture.setImageBitmap(imagenBitMap)

                } else {
                    //Denegado el acceso a la camara
                    Toast.makeText(this, "La carga de la foto ha fallado",Toast.LENGTH_LONG).show()
                }
            }
        }
    }

}
