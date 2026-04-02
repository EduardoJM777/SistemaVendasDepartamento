package com.example.sistemavendasdepartamento.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.sistemavendasdepartamento.R
import com.example.sistemavendasdepartamento.model.Item
import java.text.NumberFormat
import java.util.Locale

class ItemAdapter (private val listaItens: List<Item>): RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ItemViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_item_list, parent, false)

        return ItemViewHolder(view)
    }

    override fun onBindViewHolder(
        holder: ItemViewHolder,
        position: Int
    ) {
        val itens = listaItens[position]
        holder.tvCodigo.text = itens.codigo
        holder.tvDesc.text = itens.descricao

        val formato = NumberFormat.getCurrencyInstance(Locale("pt", "BR"))
        holder.tvValUnit.text = formato.format(itens.valorUnitario)
    }

    override fun getItemCount(): Int {
        return listaItens.size
    }

    class ItemViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val tvCodigo = itemView.findViewById<TextView>(R.id.tvCodigo)
        val tvDesc = itemView.findViewById<TextView>(R.id.tvDesc)
        val tvValUnit = itemView.findViewById<TextView>(R.id.tvValUnit)
    }


}