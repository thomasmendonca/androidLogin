package com.example.loginmobile

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Spinner

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //declarando as variáveis

        val editTextNome = findViewById<EditText>(R.id.inputNome);
        val editTextTelefone = findViewById<EditText>(R.id.inputTelefone);
        val editTextEmail = findViewById<EditText>(R.id.inputEmail);
        val spinnerTipoTelefone = findViewById<Spinner>(R.id.optionConta);
        val checkBoxTelefone = findViewById<CheckBox>(R.id.checkBoxTel);
        val checkBoxEmail = findViewById<CheckBox>(R.id.checkBoxEmail);
        val buttonMostrarMensagem = findViewById<Button>(R.id.btnCadastrar);

        val tiposTelefone = arrayOf("Residencial", "Comercial")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, tiposTelefone)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerTipoTelefone.adapter = adapter

        buttonMostrarMensagem.setOnClickListener(View.OnClickListener {
            val nome = editTextNome.text.toString()
            val telefone = editTextTelefone.text.toString()
            val email = editTextEmail.text.toString()
            val tipoTelefone = spinnerTipoTelefone.selectedItem.toString()
            val contaTelefone = checkBoxTelefone.isChecked
            val contaEmail = checkBoxEmail.isChecked



        })

    }
}