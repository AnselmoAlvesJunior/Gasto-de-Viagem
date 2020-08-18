package com.example.gastodeviagem

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.NumberFormatException

class MainActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnCalcula.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        val id= p0?.id

        if (id==R.id.btnCalcula){
            calcula()
        }

    }
    private fun calcula(){
        try{
            val distancia = distanciaId.text.toString().toFloat()
            val preco = precoId.text.toString().toFloat()
            val autonomia = autonomiaId.text.toString().toFloat()

            val totalValor = (distancia * preco) / autonomia
            valorFinal.text = "R$ ${"%.2f".format(totalValor)}"
        }catch (e:NumberFormatException ){
            e.toString()
            Toast.makeText(this,"Valores invalidos!",Toast.LENGTH_SHORT).show()
        }

    }

}


