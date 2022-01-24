package com.digitalhouse.dhwallet

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.digitalhouse.dhwallet.databinding.ActivityMainBinding
import com.digitalhouse.dhwallet.fragmentos.FragmentoTela_Home_transaction
import com.digitalhouse.dhwallet.fragmentos.Fragmento_TelaSendMoney

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val fragmentFragmentoTelaSendMoney = Fragmento_TelaSendMoney()
        val fragmentotelaHomeTransaction = FragmentoTela_Home_transaction()
        supportFragmentManager.beginTransaction()
            .replace(R.id.conteiner_fragment_mainactivit,FragmentoTela_Home_transaction.newInstance("R$45,00","R$640,00"))
            .addToBackStack("fragmentotelaHomeTransaction")
            .commit()
    }
}