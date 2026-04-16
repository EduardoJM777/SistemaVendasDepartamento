package com.example.sistemavendasdepartamento

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
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
            val nome = edNomeCliente.text.toString().trim()
            val cpf = edCpfCliente.text.toString().trim()


               if( nome.isEmpty()){
                    edNomeCliente.error = "Nome é obrigatório"
                    edNomeCliente.requestFocus()}

               else if(cpf.isEmpty()){
                    edCpfCliente.error = "CPF é obrigatório"
                    edCpfCliente.requestFocus()
                }else {
                    val cliente = Cliente(nome, cpf)
                    ClienteRepository.listaCliente.add(cliente)
                    Toast.makeText(this, "Cliente cadastrado com sucesso!", Toast.LENGTH_SHORT)
                        .show()
                    finish()
                }
            }
        }
    }