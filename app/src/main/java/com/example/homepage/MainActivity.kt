package com.example.latihan

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.latihan.databinding.ActivityMainBinding // Impor kelas binding

class MainActivity : AppCompatActivity() {

    // Deklarasikan binding
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Inisialisasi binding
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val username = intent.getStringExtra("EXTRA_USERNAME")
        val email = intent.getStringExtra("EXTRA_EMAIL")
        val phone = intent.getStringExtra("EXTRA_PHONE")

        binding.txtWelcome.text = "Welcome $username"

        if (email != null && phone != null) {
            binding.txtEmail.text = "Your email $email has been activated"
            binding.txtPhone.text = "Your phone $phone has been registered"
            binding.txtEmail.visibility = View.VISIBLE
            binding.txtPhone.visibility = View.VISIBLE
        } else {
            // Jika tidak ada TextView disembunyikan
            binding.txtEmail.visibility = View.GONE
            binding.txtPhone.visibility = View.GONE

        }
    }
}