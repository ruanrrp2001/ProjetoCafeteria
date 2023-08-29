package com.example.projetocafeteria

import android.annotation.SuppressLint
import android.app.Activity
import android.content.ClipData
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.preference.PreferenceManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken


class CarrinhoDeCompras : AppCompatActivity() {

    private var isFirstItemAdded = false

    // Classe interna para representar cada item no carrinho
    data class CartItem(
        val itemName: String,
        val imageResId: Int,
        val itemValue: Int,
        val moagem: String
    )

    companion object {
        // Lista estática para armazenar os itens do carrinho
        private val cartItems = mutableListOf<CartItem>()

        fun getCartItems(): List<CartItem> {
            return cartItems
        }

        fun addItemToCart(cartItem: CartItem) {
            cartItems.add(cartItem)
        }
    }

    // Lista para manter referência aos itens do carrinho anterior
    private var previousCartItems = mutableListOf<CartItem>()

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_carrinho_de_compras)

        // Após a chamada da função displayItems()
        if (getCartItems().isNotEmpty()) {
            isFirstItemAdded = true
        }


        // Recuperar a lista de itens do Intent
        val extras = intent.extras
        if (extras != null) {
            val imageResId = extras.getInt("imagemParaCarrinho")
            val titulo = extras.getString("titulocarrinho")
            val valor = extras.getInt("valorParaCarrinho", 0)
            val moagem = extras.getString("moagemParaCarrinho")

            // Adicionar o item à lista de carrinho com todas as informações
            if (titulo != null && moagem != null) {
                addItemToCart(CartItem(titulo, imageResId, valor, moagem))
                // Exibir os itens diretamente no layout
                displayItems()
            }
        }
    }


    private fun displayItems() {
        val cartItemsLayout = findViewById<LinearLayout>(R.id.cartItemsLayout1)
        val inflater = LayoutInflater.from(this)

        // Limpar o layout para evitar duplicação dos itens
        cartItemsLayout.removeAllViews()

        var totalValue = 0 // Variável para armazenar o valor total

        for (cartItem in getCartItems()) {
            val itemView =
                inflater.inflate(R.layout.activity_carrinho_de_compras, cartItemsLayout, false)
            itemView.findViewById<TextView>(R.id.tvItemName1).text = cartItem.itemName
            itemView.findViewById<ImageView>(R.id.ivItemImage1)
                .setImageResource(cartItem.imageResId)

            // Adicionar o prefixo "R$" antes do valor
            itemView.findViewById<TextView>(R.id.tvItemValue).text =
                "R$" + cartItem.itemValue.toString()

            itemView.findViewById<TextView>(R.id.moagem).text = cartItem.moagem // Exibir a moagem

            cartItemsLayout.addView(itemView)

            // Somar o valor de cada item ao valor total
            totalValue += cartItem.itemValue
        }

        // Criar um novo TextView para exibir o valor total
        val valorTotalTextView = TextView(this)
        valorTotalTextView.text = "Valor Total: R$ $totalValue"
        valorTotalTextView.textSize = 16f
        valorTotalTextView.setTextColor(ContextCompat.getColor(this, android.R.color.black))
        valorTotalTextView.layoutParams = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.WRAP_CONTENT,
            LinearLayout.LayoutParams.WRAP_CONTENT
        )

        // Definir as margens para o novo TextView
        val margin = resources.getDimensionPixelSize(R.dimen.icon_size)
        val params = valorTotalTextView.layoutParams as ViewGroup.MarginLayoutParams
        params.topMargin = margin
        params.marginStart = margin
        params.marginEnd = margin

        // Adicionar o novo TextView ao LinearLayout
        cartItemsLayout.addView(valorTotalTextView)


        // Definir o botão "Continuar comprando"
        val btnContinuarComprando = findViewById<Button>(R.id.btnContinuarComprando)

        // Verificar se há mais de um item no carrinho e ocultar o botão "Continuar comprando" se for o primeiro item
        if (isFirstItemAdded) {
            btnContinuarComprando.visibility = View.GONE
        } else {
            btnContinuarComprando.visibility =
                if (getCartItems().isEmpty()) View.GONE else View.VISIBLE
        }

        // Definir o clique do botão "Continuar comprando"
        btnContinuarComprando.setOnClickListener {
            // Voltar à tela principal (MainActivity) para continuar comprando
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}






























