package com.example.firebase

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class registerActivity : AppCompatActivity() {
    private lateinit var inputEmail:EditText
    private lateinit var inputPassword:EditText
    private lateinit var registerButton:Button

    private lateinit var mAuth:FirebaseAuth


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        mAuth = FirebaseAuth.getInstance()

        inputEmail = findViewById(R.id.signUpEmailEditText)
        inputPassword = findViewById(R.id.signUpPasswordEditText)
        registerButton = findViewById(R.id.signUpButton)


        registerButton.setOnClickListener {
            val email = inputEmail.text.toString()
            val password = inputPassword.text.toString()

            if (email.isEmpty() || password.isEmpty()){
                Toast.makeText(this, "Empty", Toast.LENGTH_SHORT).show()
                
            }else{
                //serverze vgzavnit emails da parols da vadebt complite methods rom aplikaciam ar shewyvitos mushaona
                // da ar daelodos firebas pasuxs
                    //davarqvit task da  serveris pasuxi jdeba taskshi
                mAuth.createUserWithEmailAndPassword(email,password)
                    .addOnCompleteListener {task ->
                        //warmatebuli pasuxi warmatebit daregistrirda
                        if (task.isSuccessful){
                            startActivity(Intent(this,MainActivity::class.java))
                            //backgilakze agar unda moxvdes amitom udna davsrulot mushaoba finish()
                            finish()
                        }else{
                            Toast.makeText(this , "error!", Toast.LENGTH_SHORT).show()
                        }

                }

            }
        }


    }
}