package com.example.latihan

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.latihan.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    // Deklarasikan binding
    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Inisialisasi binding
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Tombol Login ke Homepage
        binding.btnLogin.setOnClickListener {
            val username = binding.edtUsername.text.toString().trim()
            val password = binding.edtPw.text.toString().trim()

            // validasi
            if (username.isEmpty()) {
                binding.edtUsername.error = "Username tidak boleh kosong"
                return@setOnClickListener
            }

            if (password.isEmpty()) {
                binding.edtPw.error = "Password tidak boleh kosong"
                return@setOnClickListener
            }

            // lanjut ke activity berikutnya
            val intent = Intent(this, MainActivity::class.java).apply {
                putExtra("EXTRA_USERNAME", username)
            }
            startActivity(intent)
        }

        // Tombol Register ke halaman Register
        binding.btnRegister.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }
    }
}
