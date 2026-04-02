package com.example.sistemavendasdepartamento

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.ComponentActivity
import com.example.sistemavendasdepartamento.model.Item
import com.example.sistemavendasdepartamento.repository.ItemRepository

class CadastroItensActivity: ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro_item)

        val edCodItem = findViewById<EditText>(R.id.edCodItem)
        val edDescItem = findViewById<EditText>(R.id.edDescItem)
        val edValUnit = findViewById<EditText>(R.id.edValUnit)
        val btCadastrarItem = findViewById<Button>(R.id.btCadastrarItem)

        btCadastrarItem.setOnClickListener {

            val codigo = edCodItem.text.toString()
            val desc = edDescItem.text.toString()
            val valUnit = edValUnit.text.toString().toDouble()
            val item = Item(codigo, desc, valUnit)

            ItemRepository.listaItem.add(item)

            finish()
        }

    }

}