package com.example.sistemavendasdepartamento

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.ComponentActivity
import android.app.AlertDialog
import android.widget.Toast
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
        val valorTotal = PedidoRepository.totalGeral()
        val formato = NumberFormat.getCurrencyInstance(Locale("pt", "BR"))
        tvValPedido.text = " ${formato.format(valorTotal)}"

        val tvQtdItens = findViewById<TextView>(R.id.tvQtdItens)
        tvQtdItens.text = " ${PedidoRepository.somaItens()}"

        val btAvista = findViewById<Button>(R.id.btAvista)
        val btAprazo = findViewById<Button>(R.id.btAprazo)
        val tvValPag = findViewById<TextView>(R.id.tvValPag)
        val tvValLiq = findViewById<TextView>(R.id.tvValLiq)
        val btConcluir = findViewById<Button>(R.id.btConcluir)

        val valorAvista = valorTotal - (valorTotal * 0.05)
        val valorAprazo = valorTotal + (valorTotal * 0.05)

        val opcoes = arrayOf("2", "3", "4", "5", "6")

        var finalizado = false

        btAprazo.setOnClickListener {

            AlertDialog.Builder(this)
                .setTitle("Selecione a quantidade de parcelas:")
                .setItems(opcoes) { _, position ->
                    val parcelas = opcoes[position].toInt()
                    val valorParcela = valorAprazo / parcelas

                    tvValLiq.text = " ${parcelas}x de ${formato.format(valorParcela)}"

                }
                .show()

            finalizado = true

        }

        btAvista.setOnClickListener {

            tvValPag.text = " Valor a pagar:"

            tvValLiq.text = " ${formato.format(valorAvista)}"

            finalizado = true

        }

        btConcluir.setOnClickListener {
            if (finalizado) {
                val numeroPedido = PedidoRepository.gerarNumeroPedido()

                // Limpa a lista de pedidos
                PedidoRepository.listaPedidos.clear()

                // Exibe o Toast com o número do pedido
                Toast.makeText(
                    this,
                    "Pedido Nº $numeroPedido concluído com sucesso!",
                    Toast.LENGTH_LONG
                ).show()

                // Limpa os campos da tela
                tvValPedido.text = " ${formato.format(0.0)}"
                tvQtdItens.text = " 0"
                tvValPag.text = ""
                tvValLiq.text = ""

                // Atualiza o RecyclerView
                adapterPedidos.notifyDataSetChanged()

                // Reseta o estado de pagamento
                finalizado = false

            } else {
                Toast.makeText(this, "Selecione um método de pagamento.", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onResume() {
        super.onResume()
        adapterPedidos.notifyDataSetChanged()
    }

}