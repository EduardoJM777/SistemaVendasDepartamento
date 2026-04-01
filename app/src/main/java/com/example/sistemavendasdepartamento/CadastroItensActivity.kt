package com.example.sistemavendasdepartamento

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.ComponentActivity
import com.example.sistemavendasdepartamento.model.Cliente
import com.example.sistemavendasdepartamento.repository.ClienteRepository

class CadastroItensActivity: ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro_item)

        val edCodItem = findViewById<EditText>(R.id.edCodItem)
        val edDescItem = findViewById<EditText>(R.id.edDescItem)
        val edValUnit = findViewById<EditText>(R.id.edValUnit)
        val btCadastrarItem = findViewById<Button>(R.id.btCadastrarItem)

        btCadastrarCliente.setOnClickListener {

            val nome = edNomeCliente.text.toString()
            val cpf = edCpfCliente.text.toString()
            val cliente = Cliente(nome, cpf)

            ClienteRepository.listaCliente.add(cliente)

            finish()
        }

    }

}