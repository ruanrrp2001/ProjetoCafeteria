package com.example.projetocafeteria

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.BitmapFactory
import android.graphics.BlendMode
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.Spinner
import android.widget.TextView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //blend.....................................................................................

        val imagem1 = R.drawable.blend
        val titulo1 = "Blend"
        val valor1 = 33
        val descricao1 =
            "Bebida doce que causa sensação aveludada no céu da boca. O Frutado tem seu amargor reduzido pela doçura natural da própria fruta. É um café de origem única, que tem como principais diferenciais o corpo, a doçura e as notas de chocolate."


        val imageView = findViewById<ImageView>(R.id.blend)
        imageView.setOnClickListener {
            val intent = Intent(this, blend::class.java)
            intent.putExtra("imagem", imagem1)
            intent.putExtra("descricao", descricao1)
            intent.putExtra("titulo", titulo1)
            intent.putExtra("valor", valor1)
            startActivity(intent)
        }

        //burbon..................................................................................

        val imagem2 = R.drawable.burbonamarelo
        val titulo2 = "Burbon"
        val valor2 = 35
        val descricao2 =
            "Bebida doce que causa sensação aveludada no céu da boca. O Frutado tem seu amargor reduzido pela doçura natural da própria fruta. É um café de origem única, que tem como principais diferenciais o corpo, a doçura e as notas de chocolate."


        val imageView2 = findViewById<ImageView>(R.id.burbon)
        imageView2.setOnClickListener {
            val intent = Intent(this, blend::class.java)
            intent.putExtra("imagem", imagem2)
            intent.putExtra("descricao", descricao2)
            intent.putExtra("titulo", titulo2)
            intent.putExtra("valor", valor2)
            startActivity(intent)
        }



        //Moça......................................................................................

        val imagem3 = R.drawable.moca
        val titulo3 = "Moça"
        val valor3 = 39
        val descricao3 =
            "Ideal para quem busca o equilíbrio perfeito. Um blend do Unique Frutado com o Bourbon Amarelo, um café natural com um cereja descascado. De aroma intenso e sabor doce (notas de caramelo), com torra cor chocolate ao leite."


        val imageView3 = findViewById<ImageView>(R.id.moça)
        imageView3.setOnClickListener {
            val intent = Intent(this, blend::class.java)
            intent.putExtra("imagem", imagem3)
            intent.putExtra("descricao", descricao3)
            intent.putExtra("titulo", titulo3)
            intent.putExtra("valor", valor3)
            startActivity(intent)
        }


        //Frutado......................................................................................

        val imagem4 = R.drawable.frutado
        val titulo4 = "Frutado"
        val valor4 = 37
        val descricao4 =
            "Bebida doce que causa sensação aveludada no céu da boca. O Frutado tem seu amargor reduzido pela doçura natural da própria fruta. É um café de origem única, que tem como principais diferenciais o corpo, a doçura e as notas de chocolate."


        val imageView4 = findViewById<ImageView>(R.id.frutado)
        imageView4.setOnClickListener {
            val intent = Intent(this, blend::class.java)
            intent.putExtra("imagem", imagem4)
            intent.putExtra("descricao", descricao4)
            intent.putExtra("titulo", titulo4)
            intent.putExtra("valor", valor4)
            startActivity(intent)
        }







        // Configurar o botão FAB
        val fabCarrinhoDeCompras = findViewById<FloatingActionButton>(R.id.fabCarrinhoDeCompras)
        fabCarrinhoDeCompras.setOnClickListener {
            val intent = Intent(this, CarrinhoDeCompras::class.java)
            startActivity(intent)
        }
    }
}
