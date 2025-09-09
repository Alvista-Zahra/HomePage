package com.example.latihan

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.latihan.databinding.ActivityRegisterBinding

class RegisterActivity : AppCompatActivity() {

    // Deklarasikan binding
    private lateinit var binding: ActivityRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Inisialisasi binding
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Tombol Register untuk kirim data ke homepage
        binding.btnRegister.setOnClickListener {
            val username = binding.edtUsername.text.toString().trim()
            val email = binding.edtEmail.text.toString().trim()
            val phone = binding.edtPhone.text.toString().trim()
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
                putExtra("EXTRA_PHONE", phone)
                putExtra("EXTRA_EMAIL", email)
            }
            startActivity(intent)
        }

        // Tombol Login untuk ke LoginActivity
        binding.btnLogin.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
    }
}
