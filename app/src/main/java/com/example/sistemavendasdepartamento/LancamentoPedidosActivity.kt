package com.example.sistemavendasdepartamento

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.sistemavendasdepartamento.adapter.ClienteAdapter
import com.example.sistemavendasdepartamento.adapter.PedidoAdapter
import com.example.sistemavendasdepartamento.repository.ClienteRepository

class LancamentoPedidosActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lancamento_pedido)

        val rvClientes = findViewById<RecyclerView>(R.id.rvClientes)

        rvClientes.adapter = PedidoAdapter(ClienteRepository.listaCliente) {
            clienteSelecionado ->

            Toast.makeText(this, "Selecionado: ${clienteSelecionado.nome}", Toast.LENGTH_SHORT).show()

        }

    }




}