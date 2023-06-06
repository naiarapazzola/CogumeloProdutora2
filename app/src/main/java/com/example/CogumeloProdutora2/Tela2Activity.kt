package com.example.CogumeloProdutora2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.CogumeloProdutora2.databinding.ActivityTela2Binding

class Tela2Activity : AppCompatActivity() {

    private lateinit var binding: ActivityTela2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityTela2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        val usuarioNome = binding.tvUsuarioNome
        val nome = intent.getStringExtra("intentNomeUsuario")
        usuarioNome.text = nome

        val btOrcamento = binding.button

        btOrcamento.setOnClickListener {
            val intent = Intent(this, activity_tela3::class.java)

            startActivity(intent)

        }

    }
}