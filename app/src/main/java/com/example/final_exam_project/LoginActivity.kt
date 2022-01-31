package com.example.final_exam_project

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.final_exam_project.fragments.HomeFragment
import com.google.firebase.auth.FirebaseAuth

class LoginActivity : AppCompatActivity() {

    private lateinit var editTextEmail: EditText
    private lateinit var editTextPassword: EditText
    private lateinit var buttonLogin: Button
    private lateinit var buttonRegister: Button
    private lateinit var buttonPasswordReset: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        init()

        registerlisteners()

    }


    private fun init() {

        editTextEmail = findViewById(R.id.editTextEmail)
        editTextPassword = findViewById(R.id.editTextPassword)
        buttonLogin = findViewById(R.id.buttonLogin)
        buttonRegister = findViewById(R.id.buttonRegister)
        buttonPasswordReset = findViewById(R.id.buttonPasswordReset)

    }

    private fun registerlisteners() {

        buttonRegister.setOnClickListener{
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }

        buttonPasswordReset.setOnClickListener{
            val intent =    Intent(this, PasswordResetActivity::class.java)
            startActivity(intent)
        }
        buttonLogin.setOnClickListener{
            val email = editTextEmail.text.toString()
            val password = editTextPassword.text.toString()

            if(email.length < 6 || !email.contains("@")){
                Toast.makeText(this,"Email Must be length of 6 or more, and also must contain @", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            if(password.length < 8 || password[0].isLowerCase()){
                Toast.makeText(this,"Password must be length of 8 or more, and first letter must be Capitalze",
                    Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            FirebaseAuth.getInstance()
                .signInWithEmailAndPassword(email, password)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        gotoProfile()
                    }else{
                        Toast.makeText(this, "Error!!!", Toast.LENGTH_SHORT).show()
                    }

                }
        }

    }
    private fun gotoProfile() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()

    }



}