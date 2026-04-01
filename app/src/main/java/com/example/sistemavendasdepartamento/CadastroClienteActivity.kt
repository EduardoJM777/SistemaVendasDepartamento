package com.example.sistemavendasdepartamento

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.ComponentActivity
import com.example.sistemavendasdepartamento.model.Cliente
import com.example.sistemavendasdepartamento.repository.ClienteRepository

class CadastroClienteActivity: ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro_cliente)

        val edNomeCliente = findViewById<EditText>(R.id.edNomeCliente)
        val edCpfCliente = findViewById<EditText>(R.id.edCpfCliente)
        val btCadastrarCliente = findViewById<Button>(R.id.btCadastrarCliente)

        btCadastrarCliente.setOnClickListener {

            val nome = edNomeCliente.text.toString()
            val cpf = edCpfCliente.text.toString()
            val cliente = Cliente(nome, cpf)

            ClienteRepository.listaCliente.add(cliente)

            finish()
        }

    }

}