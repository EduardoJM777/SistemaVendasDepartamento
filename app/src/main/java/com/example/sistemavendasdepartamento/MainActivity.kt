package com.example.sistemavendasdepartamento

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.ComponentActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.sistemavendasdepartamento.adapter.ClienteAdapter
import com.example.sistemavendasdepartamento.repository.ClienteRepository

class MainActivity : ComponentActivity() {

    private lateinit var adapterClientes: ClienteAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)

        val rvClientes = findViewById<RecyclerView>(R.id.rvClientes)

        adapterClientes = ClienteAdapter(ClienteRepository.listaCliente)

        rvClientes.layoutManager = LinearLayoutManager(this)
        rvClientes.adapter = adapterClientes

        val btTelaCadCliente = findViewById<Button>(R.id.btTelaCadCliente)

        btTelaCadCliente.setOnClickListener {
            val intent = Intent(this, CadastroClienteActivity::class.java)
            startActivity(intent)
        }

    }


    override fun onResume(){
        super.onResume()
        adapterClientes.notifyDataSetChanged()
    }

}