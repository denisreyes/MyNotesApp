package mx.udg.cuvalles.mynotesapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.launch
import mx.udg.cuvalles.mynotesapp.adapter.NotasAdapter

class AddNotaActivity : AppCompatActivity() {

    var etTitulo: EditText?=null
    var etContenido: EditText?=null
    var btnAdd: Button?=null
    var btnvolver: Button?=null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_nota)
        val app = applicationContext as NotaApp

        etTitulo = findViewById(R.id.etTitulo)
        etContenido = findViewById(R.id.etContenido)
        btnAdd = findViewById(R.id.btnAdd)
        btnvolver = findViewById(R.id.btnVolver)

        btnvolver!!.setOnClickListener {
            val i = Intent(this,MainActivity::class.java)
            startActivity(i)
        }


        btnAdd!!.setOnClickListener{
            val titule = etTitulo!!.text.toString()
            val content = etContenido!!.text.toString()

            val nota = Nota(0, titule, content)
            val notas = listOf<Nota>(nota)

           lifecycleScope.launch {
                app!!.baseDeDatos.notaDao().insert(notas)
            }


            etTitulo!!.setText("")
            etContenido!!.setText("")
        }

    }
}