package com.example.final_exam_project

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class PasswordResetActivity : AppCompatActivity() {

    private lateinit var editTextEmail: EditText
    private lateinit var buttonSend: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_password_reset)

        init()

        registerlisteners()

    }

    private fun init() {

        editTextEmail = findViewById(R.id.editTextEmail)
        buttonSend = findViewById(R.id.buttonSend)

    }
    private fun registerlisteners(){
        buttonSend.setOnClickListener{

            val email = editTextEmail.text.toString()

            if (email.isEmpty()){
                Toast.makeText(this, "Email must not be empty", Toast.LENGTH_SHORT).show()
            }

            FirebaseAuth.getInstance()
                .sendPasswordResetEmail(email)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful){
                        Toast.makeText(this, "Check Email", Toast.LENGTH_SHORT).show()
                    }else{
                        Toast.makeText(this, "Eror!!!", Toast.LENGTH_SHORT).show()
                    }
                }
        }

    }
}