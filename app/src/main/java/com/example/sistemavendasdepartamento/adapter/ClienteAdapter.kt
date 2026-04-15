package com.example.sistemavendasdepartamento.adapter

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.sistemavendasdepartamento.R
import com.example.sistemavendasdepartamento.model.Cliente

class ClienteAdapter (private val listaClientes: List<Cliente>,
                      private val onClick: ((Cliente) -> Unit)? = null): RecyclerView.Adapter<ClienteAdapter.ClienteViewHolder>() {

    private var posicaoSelecionada = -1

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ClienteViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.cliente_item_list, parent, false)

        return ClienteViewHolder(view)
    }

    override fun onBindViewHolder(
        holder: ClienteViewHolder,
        position: Int
    ) {
        val clientes = listaClientes[position]
        holder.tvNome.text = clientes.nome
        holder.tvCpf.text = clientes.cpf

        if (position == posicaoSelecionada) {
            holder.itemView.setBackgroundColor(Color.LTGRAY)
        } else {
            holder.itemView.setBackgroundColor(Color.TRANSPARENT)
        }

        holder.itemView.setOnClickListener {
            posicaoSelecionada = position
            notifyDataSetChanged()

            onClick?.invoke(clientes)
        }

    }

    override fun getItemCount(): Int {
        return listaClientes.size
    }

    class ClienteViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val tvNome = itemView.findViewById<TextView>(R.id.tvNome)
        val tvCpf = itemView.findViewById<TextView>(R.id.tvCpf)
    }


}