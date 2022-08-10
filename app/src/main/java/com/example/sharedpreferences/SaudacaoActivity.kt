package com.example.sharedpreferences

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_saudacao.*

class SaudacaoActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n", "Range")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_saudacao)

        val db = DatabaseManager(this, "saudacoes")
        // recupera lista do banco
        val cursor = db.listSalutation()
        var name = ""
        var treatment = ""
        // verifica se existe algo na lista
        if(cursor.count > 0){
            cursor.moveToFirst()
            name = cursor.getString(cursor.getColumnIndex("NOME"))
            treatment = cursor.getString(cursor.getColumnIndex("TRATAMENTO"))
        }
        // exibe nome com e sem tratamento
        if (treatment == "Sem tratamento") {
            tvSalutation.text = name
        } else {
            tvSalutation.text = "$treatment $name"
        }
    }
}