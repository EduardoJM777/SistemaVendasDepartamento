package com.example.sistemavendasdepartamento

import android.os.Bundle
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.sistemavendasdepartamento.adapter.PedidoAdapter
import com.example.sistemavendasdepartamento.repository.PedidoRepository
import java.text.NumberFormat
import java.util.Locale

class PedidosActivity: ComponentActivity() {

    private lateinit var adapterPedidos: PedidoAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pedidos)

        val rvPedidos = findViewById<RecyclerView>(R.id.rvPedidos)

        adapterPedidos = PedidoAdapter(PedidoRepository.listaPedidos)

        rvPedidos.layoutManager = LinearLayoutManager(this)
        rvPedidos.adapter = adapterPedidos

        val tvValPedido = findViewById<TextView>(R.id.tvValPedido)

        val formato = NumberFormat.getCurrencyInstance(Locale("pt", "BR"))
        tvValPedido.text = " ${formato.format(PedidoRepository.totalGeral())}"

    }

    override fun onResume() {
        super.onResume()
        adapterPedidos.notifyDataSetChanged()
    }

}