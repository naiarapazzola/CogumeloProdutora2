package com.example.CogumeloProdutora2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.CogumeloProdutora2.databinding.ActivityCadastroBinding
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class cadastroActivity : AppCompatActivity() {

    private lateinit var binding : ActivityCadastroBinding
    private lateinit var dbRef: DatabaseReference


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_cadastro)
        binding = ActivityCadastroBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var edNome = binding.editTextTextPersonName
        var edEmail = binding.editTextTextEmailAddress
        var edSenha = binding.editTextTextPassword
        var edSenhaConfirmar = binding.editTextNumberPassword2
        var BotaoConfirmar = binding.button2

        dbRef = FirebaseDatabase.getInstance().getReference("Clientes")

        BotaoConfirmar.setOnClickListener{
            val NomeCliente = edNome.text.toString()
            val EmailCliente = edEmail.text.toString()
            val SenhaCliente = edSenha.text.toString()

            if(NomeCliente.isEmpty()){
                edNome.error = "Por favor insira seu nome"
            }
            if(EmailCliente.isEmpty()){
                edEmail.error = "Por favor insira seu Email"
            }
            if(SenhaCliente.isEmpty()){
                edSenha.error = "Por favor insira uma Senha"
            }

            val empId = dbRef.push().key!!

            val Clientes = ClienteModelo(empId, NomeCliente, EmailCliente, SenhaCliente)

            dbRef.child(empId).setValue(Clientes) .addOnCompleteListener{
                Toast.makeText(this, "Cadastro realizado com sucesso, Obrigado!", Toast.LENGTH_SHORT).show()

                edNome.text.clear()
                edEmail.text.clear()
                edSenha.text.clear()
            }.addOnFailureListener{err ->
            Toast.makeText(this, "Error ${err.message}", Toast.LENGTH_SHORT).show()
        }


        }

    }
}