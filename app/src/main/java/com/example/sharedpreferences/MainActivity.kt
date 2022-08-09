package com.example.sharedpreferences

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnSave.setOnClickListener(View.OnClickListener {
            val salutationPersist = this.getSharedPreferences("salutation", Context.MODE_PRIVATE)
            val edit = salutationPersist.edit()

            edit.putString("name", etName.text.toString())
            edit.putString("treatment", sListTreatment.selectedItem.toString())
            edit.apply()

            Toast.makeText(this, "Salvo com Sucesso", Toast.LENGTH_SHORT).show()
        })

        btnShow.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, SaudacaoActivity::class.java)
            startActivity(intent)
        })
    }
}