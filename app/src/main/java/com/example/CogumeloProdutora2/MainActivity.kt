package com.example.CogumeloProdutora2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.empregaeu4.databinding.ActivityMainBinding
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

//import com.example.recifardas.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val edUsuario = binding.edUsuario
        val btLogin = binding.btLogin
        val edSenha = binding.edSenha

        btLogin.setOnClickListener {
            if(edUsuario.text.toString()=="Ana" && edSenha.text.toString()=="Ana") {
                val inten = Intent(this, Tela2Activity::class.java)
                val texto = edUsuario.text.toString()
                inten.putExtra("intentNomeUsuario", edUsuario.text.toString())
                intent.putExtra("intentSenhaUsuario", edSenha.text.toString())
                //TESTE FIREBASE
                val database = Firebase.database
                val myRef = database.getReference("message")

                myRef.setValue("Hello, World!")
                startActivity(inten)

            }
            else{
                Toast.makeText(this, R.string.msgError, Toast.LENGTH_SHORT).show()
            }
        }

    }
}


