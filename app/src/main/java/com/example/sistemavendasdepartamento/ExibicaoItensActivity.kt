package com.example.sistemavendasdepartamento

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.ComponentActivity
import androidx.recyclerview.widget.LinearLayoutManager
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.sistemavendasdepartamento.adapter.ItemAdapter
import com.example.sistemavendasdepartamento.model.Item
import com.example.sistemavendasdepartamento.repository.ItemRepository

class ExibicaoItensActivity : ComponentActivity() {

    private lateinit var adapterItens: ItemAdapter
    private val listaExibida = mutableListOf<Item>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_exibicao_itens)

        val rvItens = findViewById<RecyclerView>(R.id.rvItens)
        val etBuscarCodigo = findViewById<EditText>(R.id.edDigitarCodigoItem)
        val btnBuscar = findViewById<Button>(R.id.btPesquisarItem)

        listaExibida.addAll(ItemRepository.listaItem)
        adapterItens = ItemAdapter(listaExibida)

        rvItens.layoutManager = LinearLayoutManager(this)
        rvItens.adapter = adapterItens

        btnBuscar.setOnClickListener {
            val codigo = etBuscarCodigo.text.toString().trim()

            listaExibida.clear()

            if (codigo.isEmpty()) {
                listaExibida.addAll(ItemRepository.listaItem)
            } else {
                val item = ItemRepository.buscarPorCodigo(codigo)
                if (item != null) {
                    listaExibida.add(item)
                } else {
                    Toast.makeText(this, "Código não encontrado!", Toast.LENGTH_SHORT).show()
                }
            }
            adapterItens.notifyDataSetChanged()
        }
    }

    override fun onResume() {
        super.onResume()
        listaExibida.clear()
        listaExibida.addAll(ItemRepository.listaItem)
        adapterItens.notifyDataSetChanged()
    }
}