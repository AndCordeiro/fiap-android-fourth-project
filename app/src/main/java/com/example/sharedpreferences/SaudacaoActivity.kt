package com.example.sharedpreferences

import android.annotation.SuppressLint
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_saudacao.*

class SaudacaoActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_saudacao)

        // recupera shared preferences
        val salutationPersist = this.getSharedPreferences("salutation", Context.MODE_PRIVATE)

        // recupera os itens do shared preferences
        val name = salutationPersist.getString("name", "")
        val treatment = salutationPersist.getString("treatment", "")

        if (treatment.equals("Sem tratamento")) {
            tvSalutation.text = name
        } else {
            tvSalutation.text = "$treatment $name"
        }
    }
}