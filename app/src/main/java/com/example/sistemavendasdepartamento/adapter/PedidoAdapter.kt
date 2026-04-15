package com.example.sistemavendasdepartamento.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.sistemavendasdepartamento.R
import com.example.sistemavendasdepartamento.model.Pedido
import java.text.NumberFormat
import java.util.Locale

class PedidoAdapter (private val listaPedidos: List<Pedido>): RecyclerView.Adapter<PedidoAdapter.PedidoViewHolder>() {

    class PedidoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvCliente = itemView.findViewById<TextView>(R.id.tvCliente)
        val tvItem = itemView.findViewById<TextView>(R.id.tvItem)
        val tvQtd = itemView.findViewById<TextView>(R.id.tvQtd)
        val tvValTot = itemView.findViewById<TextView>(R.id.tvValTot)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): PedidoViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.pedido_item_list, parent, false)

        return PedidoViewHolder(view)
    }

    override fun onBindViewHolder(
        holder: PedidoViewHolder,
        position: Int
    ) {
        val pedido = listaPedidos[position]
        holder.tvCliente.text = pedido.cliente.nome
        holder.tvItem.text = pedido.item.descricao
        holder.tvQtd.text = "Qtd: ${pedido.qtd}"

        val formato = NumberFormat.getCurrencyInstance(Locale("pt", "BR"))
        holder.tvValTot.text = formato.format(pedido.valTot)

    }

    override fun getItemCount(): Int {
        return listaPedidos.size
    }


}