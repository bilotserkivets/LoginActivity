package com.example.loginactivity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import com.example.loginactivity.databinding.ActivityMainBinding

const val USER_NAME = "USER_NAME"

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    private var launcher: ActivityResultLauncher<Intent>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        launcher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            if (it.resultCode == RESULT_OK) {

            }
        }
        binding.apply {
            loginButton.setOnClickListener {
                if (editUsername.text.isNotEmpty() || editPassword.text.isNotEmpty()) {
                    val userName = editUsername.text.toString().trim()
                    launcher?.launch(Intent(this@MainActivity,
                        ResultActivity::class.java).putExtra(USER_NAME, userName))
                } else {
                    Toast.makeText(this@MainActivity, getString(R.string.error_message),
                        Toast.LENGTH_LONG).show()
                }
        }
        }
    }

    fun loginClick() {
        binding.apply {

        }
    }
}