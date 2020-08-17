package cl.desafiolatam.desafiounobase

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.constraintlayout.widget.ConstraintLayout
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {
    lateinit var nameInput: TextInputEditText
    lateinit var advance: Button
    lateinit var container: ConstraintLayout

    lateinit var mSharedPreferences : SharedPreferences
    var mUserKey = "adminUsers"
    lateinit var usersListString : MutableSet<String>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        nameInput = findViewById(R.id.name_input)
        advance = findViewById(R.id.login_button)
        container = findViewById(R.id.container)

        val boxPreferences = "cl.desafiolatam.sesafiounobase"
        mSharedPreferences = getSharedPreferences(boxPreferences, Context.MODE_PRIVATE)

        setUpListeners()
    }

    private fun setUpListeners() {
        advance.setOnClickListener {
            if (nameInput.text!!.isNotEmpty()) {

                //mSharedPreferences.edit().putString(mUserKey,nameInput.text.toString()).commit()

                val intent: Intent

                if (hasSeenWelcome(nameInput.text.toString())) {
                    intent = Intent(this, HomeActivity::class.java)
                } else {
                    intent = Intent(this, WelcomeActivity::class.java)
                }
                startActivity(intent)
            } else {
                Snackbar.make(container, "El nombre no puede estar vacío", Snackbar.LENGTH_SHORT).show()
            }
        }
    }

    private fun hasSeenWelcome(nameUser:String): Boolean {
        if (/*mSharedPreferences.contains(nameInput.text.toString()) == null*/           ) {
            return true
        }else{
        return false}
    }
}
