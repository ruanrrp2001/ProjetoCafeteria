package com.example.projetocafeteria

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import android.widget.TextView
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatImageButton
import androidx.core.content.ContextCompat
import androidx.core.graphics.drawable.toBitmap

class TelaPosLogin : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela_pos_login)



        // Obtendo a referência para o botão de segunda tela e definindo o listener de clique
        val bt_segundaTela = findViewById<Button>(R.id.bt_button)
        bt_segundaTela.setOnClickListener {
            poslogin()

        }
        // Obtendo a referência para o TextView de tela de cadastro e definindo o listener de clique
        val txtTelaCadastro = findViewById<TextView>(R.id.text_cadastrar)
        txtTelaCadastro.setOnClickListener {
            cadastrar()
        }
    }
    // Função responsável por iniciar a tela de cadastro
    private fun cadastrar() {
        val TelaCadastro = Intent(this, TelaDeCadastro::class.java)
        startActivity(TelaCadastro)
    }

    // Função responsável por iniciar a tela após o login
    private fun poslogin() {
        val TelaLogin = Intent(this, TelaPosLogin::class.java)
        startActivity(TelaLogin)
    }

}



















