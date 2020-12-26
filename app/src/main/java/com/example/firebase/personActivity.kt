package com.example.firebase

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.google.firebase.auth.FirebaseAuth

class personActivity : AppCompatActivity() {
    private lateinit var personInfoTextView:TextView
    private lateinit var passwordChangeButton:Button
    private lateinit var logoutButton: Button

    private lateinit var mAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_person)

        mAuth = FirebaseAuth.getInstance()


        personInfoTextView = findViewById(R.id.personInfoTextView)
        passwordChangeButton = findViewById(R.id.goToPasswordChangebutton)
        logoutButton = findViewById(R.id.logoutButton)


        //currentusershi iwereba momxmareblis informacia null type .uid yvelas tavisi aqvs

        personInfoTextView.text = mAuth.currentUser?.uid

        logoutButton.setOnClickListener {
            mAuth.signOut() // gvishvelis cakivlisgan sesia rom dasruldes currenusershi ukve agaraferi qineba
            startActivity(Intent(this,MainActivity::class.java))
            finish()

        }

        passwordChangeButton.setOnClickListener {

            startActivity(Intent(this,passwordChangeActivity2::class.java))

        }
    }
}