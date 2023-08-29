package com.example.projetocafeteria

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.Spinner
import android.widget.Switch
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.floatingactionbutton.FloatingActionButton
import java.io.ByteArrayOutputStream
import java.util.Random


class blend : AppCompatActivity() {

    private var isButtonAdded = false

    // Método para adicionar o item ao carrinho quando o botão "CarrrinhoDeCompras" for clicado
    private fun adicionarAoCarrinho(imagemId: Int, titulo: String, valor: Int, moagem: String) {
        // Chame a próxima tela (tela do carrinho de compras) e passe os dados do item selecionado como argumentos
        val intent = Intent(this, CarrinhoDeCompras::class.java)
        intent.putExtra("imagemParaCarrinho", imagemId)
        intent.putExtra("titulocarrinho", titulo)
        intent.putExtra("valorParaCarrinho", valor)
        intent.putExtra("moagemParaCarrinho", moagem)
        startActivity(intent)
    }




    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_blend)

        val imageView = findViewById<ImageView>(R.id.receberimagem)
        val descricaoTextView = findViewById<TextView>(R.id.receberdescricao)
        val tituloTextView = findViewById<TextView>(R.id.titulo)
        val valorTextView = findViewById<TextView>(R.id.valor)
        val spinner: Spinner = findViewById(R.id.spinner)


        val adapter = ArrayAdapter<String>(this, android.R.layout.simple_spinner_item)
        for (i in 1..10) {
            adapter.add("$i")
        }
        spinner.adapter = adapter

        val imagemId = intent.getIntExtra("imagem", 0)
        val descricao = intent.getStringExtra("descricao")
        val titulo = intent.getStringExtra("titulo")
        val valor = intent.getIntExtra("valor", 0).toString()



        imageView.setImageResource(imagemId)
        descricaoTextView.text = descricao
        tituloTextView.text = titulo
        valorTextView.text = valor




        val valorInicial = valorTextView.text.toString().toInt()

        spinner.setOnItemSelectedListener(object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                val quantidade = spinner.getItemAtPosition(position).toString().toInt()
                val novoValor = quantidade * valorInicial

                valorTextView.text = novoValor.toString()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                // Implementação vazia, se necessário
            }
        })


        // spinner moagem...........................................................................
        val spinner1 = findViewById<Spinner>(R.id.spinner1)

        val opcoes = arrayOf(
            "Fina(moido para filtros em Geral)",
            "Média(moido para cafeteria Italiana)",
            "Grossa(Moido para prensa Francesa)",
            "Moido para Expresso"
        )

// Criando o ArrayAdapter
        val adapter1 = ArrayAdapter(this, android.R.layout.simple_spinner_item, opcoes)

// Definindo o layout do dropdown do spinner
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

// Definindo o adaptador para o spinner
        spinner1.adapter = adapter1

// Botão "CarrrinhoDeCompras" (Corrigido o nome para CarrinhoDeCompras)
        val btnCarrinhoDeCompras = findViewById<Button>(R.id.CarrrinhoDeCompras)
        btnCarrinhoDeCompras.setOnClickListener {
            val imagemId = intent.getIntExtra("imagem", 0)
            val titulo = intent.getStringExtra("titulo")
            val valor = valorTextView.text.toString().toInt()
            val moagemSelecionada = spinner1.selectedItem.toString()

            // Chame o método adicionarAoCarrinho para adicionar o item selecionado ao carrinho
            adicionarAoCarrinho(imagemId, titulo.toString(), valor, moagemSelecionada)

            // Após a adição do primeiro item, defina a variável isButtonAdded para true
            isButtonAdded = true
        }

    }
}




