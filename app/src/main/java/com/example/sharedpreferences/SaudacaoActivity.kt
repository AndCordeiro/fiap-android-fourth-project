package com.example.sharedpreferences

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_saudacao.*
import java.io.FileNotFoundException
import java.io.IOException
import java.nio.charset.Charset
import java.util.*

class SaudacaoActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_saudacao)

        val data = recoveryFileData()
        val tokenizer = StringTokenizer(data, ":")
        val name = if (tokenizer.hasMoreTokens()) tokenizer.nextToken() else "Sem nome"
        val treatment = if (tokenizer.hasMoreTokens()) tokenizer.nextToken() else "Sem tratamento"
        if (treatment.equals("Sem tratamento")) {
            tvSalutation.text = name
        } else {
            tvSalutation.text = "$treatment $name"
        }
    }

    private fun recoveryFileData(): String {
        return try {
            val fi = openFileInput("salutation")
            val data = fi.readBytes()
            fi.close()
            data.toString()
            data.toString(Charset.defaultCharset())
        } catch (e: FileNotFoundException) {
            ""
        } catch (e: IOException) {
            ""
        }
    }
}