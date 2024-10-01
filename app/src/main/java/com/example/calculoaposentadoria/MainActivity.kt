package com.example.calculoaposentadoria

import android.app.Activity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView

class MainActivity: Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val spn_sexo = findViewById<Spinner>(R.id.spn_sexo)
        val txt_idade = findViewById<EditText>(R.id.txt_idade)
        val btn_calcular = findViewById<Button>(R.id.btn_calcular)
        val txt_resultado = findViewById<TextView>(R.id.txt_resultado)

        spn_sexo.adapter = ArrayAdapter<String>(this,
            android.R.layout.simple_spinner_dropdown_item,
            listOf("masculino", "feminino"))



        btn_calcular.setOnClickListener{
            val sexo = spn_sexo.selectedItem as String
            val idade = txt_idade.text.toString().toInt()
            var idadeParaAposentar = 0

            if(sexo == "masculino"){
                if (idade in 1..64) idadeParaAposentar = 65-idade
            }else{
                if (idade in 1..59) idadeParaAposentar = 60-idade
            }

            txt_resultado.text = "Faltam $idadeParaAposentar anos para você se aposentar."
        }
    }
}