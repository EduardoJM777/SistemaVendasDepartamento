package com.example.sistemavendasdepartamento

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.ComponentActivity
import com.example.sistemavendasdepartamento.model.Item
import com.example.sistemavendasdepartamento.repository.ItemRepository

class CadastroItensActivity: ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro_item)

        val edCodItem = findViewById<EditText>(R.id.edCodItem)
        val edDescItem = findViewById<EditText>(R.id.edDescItem)
        val edValUnit = findViewById<EditText>(R.id.edValUnit)
        val btCadastrarItem = findViewById<Button>(R.id.btCadastrarItem)

        btCadastrarItem.setOnClickListener {

            val codigo = edCodItem.text.toString().trim()
            val desc = edDescItem.text.toString().trim()
            val valUnit = edValUnit.text.toString().trim()

            if(codigo.isEmpty() || desc.isEmpty() || valUnit.isEmpty()){
                edCodItem.error = "Preencher todos os campos"
                edCodItem.requestFocus()
            } else if ((valUnit.toDoubleOrNull()?:0.0) <= 0.0){
                edValUnit.error = "Valor deve ser maior 0"
            }
            else{
                val unit = valUnit.toDoubleOrNull()?:0.0
                val item = Item(codigo, desc, unit)
                ItemRepository.listaItem.add(item)
                finish()
            }
        }

    }

}