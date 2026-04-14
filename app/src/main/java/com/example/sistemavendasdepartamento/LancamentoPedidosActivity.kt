package com.example.sistemavendasdepartamento

import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.sistemavendasdepartamento.adapter.ClienteAdapter
import com.example.sistemavendasdepartamento.adapter.ItemAdapter
import com.example.sistemavendasdepartamento.model.Cliente
import com.example.sistemavendasdepartamento.model.Item
import com.example.sistemavendasdepartamento.repository.ClienteRepository
import com.example.sistemavendasdepartamento.repository.ItemRepository
import java.text.NumberFormat
import java.util.Locale

class LancamentoPedidosActivity : ComponentActivity() {

    private var clienteSelecionado: Cliente? = null
    private var itemSelecionado: Item? = null

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lancamento_pedido)

        val rvClientes = findViewById<RecyclerView>(R.id.rvClientes)
        val rvItens = findViewById<RecyclerView>(R.id.rvItens)

        rvClientes.layoutManager = LinearLayoutManager(this)
        rvItens.layoutManager = LinearLayoutManager(this)

        rvClientes.adapter = ClienteAdapter(ClienteRepository.listaCliente) {
            cliente -> clienteSelecionado = cliente
        }

        val tvValUnit = findViewById<TextView>(R.id.tvValUnit)

        rvItens.adapter = ItemAdapter(ItemRepository.listaItem) {
                item -> itemSelecionado = item
                val formato = NumberFormat.getCurrencyInstance(Locale("pt", "BR"))
                tvValUnit.setText(formato.format(item.valorUnitario))
        }

        val edQtd = findViewById<EditText>(R.id.edQtd)


    }




}