package com.example.final_exam_project

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import com.google.firebase.auth.FirebaseAuth

class RegisterActivity : AppCompatActivity() {

    private lateinit var editTextName: EditText
    private lateinit var editTextSurname: EditText
    private lateinit var editTextEmail: EditText
    private lateinit var editTextPassword: EditText
    private lateinit var editTextRepeatPassword: EditText
    private lateinit var radioMale: RadioButton
    private lateinit var radioFemale: RadioButton
    private lateinit var buttonRegister: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        init()

        registerListeners()

    }

    private fun init() {
        editTextName = findViewById(R.id.editTextName)
        editTextSurname = findViewById(R.id.editTextSurname)
        editTextEmail = findViewById(R.id.editTextEmail)
        editTextPassword = findViewById(R.id.editTextPassword)
        editTextRepeatPassword = findViewById(R.id.editTextRepeatPassword)
        radioMale = findViewById(R.id.radioMale)
        radioFemale = findViewById(R.id.radioFemale)
        buttonRegister = findViewById(R.id.buttonRegister)
    }
    private fun registerListeners() {
        buttonRegister.setOnClickListener{

            val email = editTextEmail.text.toString()
            val password = editTextPassword.text.toString()
            val repeatPassword = editTextRepeatPassword.text.toString()
            val name = editTextName.text.toString()
            val surname = editTextSurname.text.toString()


            if(email.length < 8 || !email.contains("@")){
                Toast.makeText(this,"Email Must be length of 8 or more, and also must contain @", Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }
            if(password.length < 8 || password[0].isLowerCase()){
                Toast.makeText(this,"Password must be length of 8 or more, and first letter must be Capitalze",
                    Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }
            if(repeatPassword != password){
                Toast.makeText(this,"Make sure the both password values are same!",
                    Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }
            if(!radioMale.isChecked && !radioFemale.isChecked){
                Toast.makeText(this,"Gender must be selected!",
                    Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }
            if(name.isEmpty()){
                Toast.makeText(this, "Name field is empty!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            if(surname.isEmpty()){
                Toast.makeText(this, "Name field is empty!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            FirebaseAuth.getInstance()
                .createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener { task ->
                    if(task.isSuccessful){
                        val intent = Intent(this, LoginActivity::class.java)
                        startActivity(intent)
                        finish()
                    }else{
                        Toast.makeText(this, "Error!!!", Toast.LENGTH_SHORT).show()
                    }
                }

        }
    }

}