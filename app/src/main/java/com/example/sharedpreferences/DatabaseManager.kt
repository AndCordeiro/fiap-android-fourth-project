package com.example.sharedpreferences

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DatabaseManager(context: Context, name: String?) : SQLiteOpenHelper(context, name, null, 1) {

    // cria tabela no banco
    override fun onCreate(p0: SQLiteDatabase?) {
        p0?.execSQL(
            "CREATE TABLE SAUDACAO(\n" +
                    "\tID_SAUDACAO INT NOT NULL,\n" +
                    "\tNOME VARCHAR(20),\n" +
                    "\tTRATAMENTO VARCHAR(20),\n" +
                    "PRIMARY KEY (ID_SAUDACAO)\n" +
                    "\t);"
        )
    }

    // faz upgrade na tabela do banco
    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        p0?.execSQL("DROP TABLE IF EXISTS SAUDACAO")
        p0?.execSQL(
            "CREATE TABLE SAUDACAO(\n" +
                    "\tID_SAUDACAO INT NOT NULL,\n" +
                    "\tNOME VARCHAR(20),\n" +
                    "\tTRATAMENTO VARCHAR(20),\n" +
                    "PRIMARY KEY (ID_SAUDACAO)\n" +
                    "\t);"
        )
    }

    // insere item no banco
    fun insertSalutation(id: Int, name: String, treatment: String) {
        val db = this.writableDatabase
        val cv = ContentValues()
        cv.put("ID_SAUDACAO", id)
        cv.put("NOME", name)
        cv.put("TRATAMENTO", treatment)
        db.insert("SAUDACAO", "ID_SAUDACAO", cv)
    }

    // lista itens no banco
    fun listSalutation(): Cursor {
        val db = this.readableDatabase
        return db.rawQuery("select nome, tratamento from saudacao", null)
    }

    // remove item id 1 do banco
    fun removeSalutation() {
        val db = this.writableDatabase
        db.delete("SAUDACAO", "ID_SAUDACAO=1", null)
    }

}
