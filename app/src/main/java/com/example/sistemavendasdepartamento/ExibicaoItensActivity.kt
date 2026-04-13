package com.example.sistemavendasdepartamento

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.sistemavendasdepartamento.adapter.ItemAdapter
import com.example.sistemavendasdepartamento.repository.ItemRepository

class ExibicaoItensActivity: ComponentActivity() {

    private lateinit var adapterItens: ItemAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_exibicao_itens)

        val rvItens = findViewById<RecyclerView>(R.id.rvItens)

        adapterItens = ItemAdapter(ItemRepository.listaItem)

        rvItens.layoutManager = LinearLayoutManager(this)
        rvItens.adapter = adapterItens

//        val btTelaListaClientes = findViewById<Button>(R.id.btTelaListaClientes)
//
//        btTelaListaClientes.setOnClickListener {
//            val intent = Intent(this, MainActivity::class.java)
//            startActivity(intent)
//        }

    }


    override fun onResume(){
        super.onResume()
        adapterItens.notifyDataSetChanged()
    }

}