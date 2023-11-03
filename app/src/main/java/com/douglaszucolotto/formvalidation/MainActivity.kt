package com.douglaszucolotto.formvalidation

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val edName = findViewById<TextInputEditText>(R.id.edName)
        val edNameL = findViewById<TextInputLayout>(R.id.edNameL)

        edName.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
            override fun afterTextChanged(s: Editable) {
                validateName(edName, edNameL)
            }

        })

        val validarBtn = findViewById<Button>(R.id.validarBtn)
        validarBtn.setOnClickListener {
            if (validateName(edName, edNameL)){
                Toast.makeText(this,"Sucesso!",Toast.LENGTH_LONG).show()
            }else{
                Toast.makeText(this,"Falhou!",Toast.LENGTH_LONG).show()
            }
        }
    }

    private fun validateName(edName: EditText, edNameL: TextInputLayout) :Boolean{
       return when{
            edName.text.toString().trim().isEmpty() ->{
                edNameL.error = "Obrigatório!"
                false
            }
            else ->{
                edNameL.error = null
                true
            }
        }
    }
}