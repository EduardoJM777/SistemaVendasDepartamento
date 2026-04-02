package com.example.sistemavendasdepartamento.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.sistemavendasdepartamento.R
import com.example.sistemavendasdepartamento.model.Cliente

class PedidoAdapter (private val listaClientes: List<Cliente>,
                     private val onClick: (Cliente) -> Unit): RecyclerView.Adapter<PedidoAdapter.PedidoViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): PedidoViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.cliente_item_list, parent, false)

        return PedidoViewHolder(view)
    }

    override fun onBindViewHolder(
        holder: PedidoViewHolder,
        position: Int
    ) {
        val clientes = listaClientes[position]
        holder.tvNome.text = clientes.nome
        holder.tvCpf.text = clientes.cpf

        holder.itemView.setOnClickListener {
            onClick(clientes)
        }
    }

    override fun getItemCount(): Int {
        return listaClientes.size
    }

    class PedidoViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val tvNome = itemView.findViewById<TextView>(R.id.tvNome)
        val tvCpf = itemView.findViewById<TextView>(R.id.tvCpf)
    }


}