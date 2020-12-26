package com.example.firebase

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class passwordChangeActivity2 : AppCompatActivity() {

    private lateinit var inputPaswword:EditText
    private lateinit var submitButton: Button

    private lateinit var mAuth:FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_password_change2)
        mAuth= FirebaseAuth.getInstance()

        inputPaswword = findViewById(R.id.newPasswordEditText)
        submitButton = findViewById(R.id.submitButton)


        submitButton.setOnClickListener {
            val newPassword = inputPaswword.text.toString()

            if (newPassword.isEmpty()){

                Toast.makeText(this, "error!", Toast.LENGTH_SHORT).show()
            }else{


                mAuth.currentUser?.updatePassword(newPassword)?.addOnCompleteListener {task ->
                    if (task.isSuccessful){
                        startActivity(Intent(this,personActivity::class.java))
                        finish()

                    }else{
                        Toast.makeText(this, "error!", Toast.LENGTH_SHORT).show()
                    }
                }
            }


        }
    }
}