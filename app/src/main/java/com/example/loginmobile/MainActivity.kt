package com.example.loginmobile

import android.annotation.SuppressLint
import android.icu.text.CaseMap.Title
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Message
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Spinner
import androidx.appcompat.app.AlertDialog
import java.lang.StringBuilder

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
            val contatoEmail = checkBoxTelefone.isChecked
            val contatoTelefone = checkBoxEmail.isChecked

            if (nome.isEmpty()) {
                showAlert("Preenche o campo Nome.")
                return@OnClickListener
            }

            if(!contatoTelefone && !contatoEmail){
                showAlert("Selecione pelo menos uma preferência e contato (Telefone ou Email)")
                return@OnClickListener
            }

            if(contatoTelefone && telefone.isEmpty()){
                showAlert("Preencha o campo telefone ou desmarque a preferência do Telefone")
                return@OnClickListener
            }

            if(contatoEmail && email.isEmpty()){
                showAlert("Preencha o campo de Email ou desmarque a preferência do Email")
                return@OnClickListener
            }

            val mensagem = StringBuilder("Nome: $nome\n")
            if (contatoTelefone && !telefone.isEmpty()) {
                mensagem.append("Tipo: $tipoTelefone\n")
                mensagem.append("Telefone: $telefone\n")
            }
            if (contatoEmail && !email.isEmpty()) {
                mensagem.append("Email: $email\n")
            }
            if (checkBoxTelefone.isChecked) {
                mensagem.append("Contato Telefone")
            }
            if (checkBoxEmail.isChecked) {
                mensagem.append("\n Contato Email")
            }
            // Mostrar a mensagem em um Toast
            // Toast.makeText(this, mensagem, Toast.LENGTH_LONG).show()
            // Exibir informações em um AlertDialog
            showInfoDialog("Informações Digitadas", mensagem)
        })
    }



    private fun showAlert(message: String) {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Desculpe! Atenção")
        builder.setMessage(message)
        builder.setPositiveButton("Ok"){dialog,_ -> dialog.dismiss()}
        val dialog = builder.create()
        dialog.show()

    }
    private fun showInfoDialog(title: String, message: StringBuilder) {
        val builder = AlertDialog.Builder(this)
        builder.setTitle(title)
        builder.setMessage(message)
        builder.setPositiveButton("OK"){dialog,_ -> dialog.dismiss()}
        val dialog = builder.create()
        dialog.show()
    }



}


