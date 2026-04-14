//package com.example.sistemavendasdepartamento.adapter
//
//import android.graphics.Color
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import android.widget.TextView
//import androidx.recyclerview.widget.RecyclerView
//import com.example.sistemavendasdepartamento.R
//import com.example.sistemavendasdepartamento.model.Cliente
//import com.example.sistemavendasdepartamento.model.Item
//
//class PedidoAdapter (private val listaItens: List<Item>,
//                     private val onItemClick: (Item) -> Unit): RecyclerView.Adapter<PedidoAdapter.PedidoViewHolder>() {
//
//    inner class PedidoViewHolder(view: View) : RecyclerView.ViewHolder(view) {
//        val tvValUnit: TextView = view.findViewById(R.id.tvValUnit)
//    }
//
//    private var posicaoSelecionada = -1
//
//    override fun onCreateViewHolder(
//        parent: ViewGroup,
//        viewType: Int
//    ): PedidoViewHolder {
//        val view = LayoutInflater.from(parent.context).inflate(R.layout.)
//
//        return PedidoViewHolder(binding)
//    }
//
//    override fun onBindViewHolder(
//        holder: PedidoViewHolder,
//        position: Int
//    ) {
//        val itens = listaItens[position]
//        holder.binding.tvItem.text = item
//
//        if (position == posicaoSelecionada) {
//            holder.itemView.setBackgroundColor(Color.LTGRAY)
//        } else {
//            holder.itemView.setBackgroundColor(Color.TRANSPARENT)
//        }
//
//        holder.itemView.setOnClickListener {
//            posicaoSelecionada = position
//            notifyDataSetChanged()
//            onItemClick(itens)
//        }
//    }
//
//    override fun getItemCount(): Int {
//        return listaItens.size
//    }
//
//
//}