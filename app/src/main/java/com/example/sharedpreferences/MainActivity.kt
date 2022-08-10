package com.example.sharedpreferences

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val db = DatabaseManager(this, "saudacoes")

        btnSave.setOnClickListener(View.OnClickListener {
            // remove itens do banco
            db.removeSalutation()
            // insere item no banco
            db.insertSalutation(1, etName.text.toString(), sListTreatment.selectedItem.toString())
            // mostra mensagem de sucesso
            Toast.makeText(this, "Salvo com Sucesso", Toast.LENGTH_SHORT).show()
        })

        btnShow.setOnClickListener(View.OnClickListener {
            // chama outra activity
            val intent = Intent(this, SaudacaoActivity::class.java)
            startActivity(intent)
        })
    }
}