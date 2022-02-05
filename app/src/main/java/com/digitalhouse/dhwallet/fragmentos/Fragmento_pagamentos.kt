package com.digitalhouse.dhwallet.fragmentos

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ConcatAdapter
import com.digitalhouse.dhwallet.R
import com.digitalhouse.dhwallet.adaptadores.AdapterPagamentos
import com.digitalhouse.dhwallet.databinding.FragmentFragmentoPagamentosBinding
import com.digitalhouse.dhwallet.model.listaPagamentos

class Fragmento_pagamentos : Fragment(R.layout.fragment_fragmento_pagamentos) {
    private var _binding: FragmentFragmentoPagamentosBinding? = null
    private val binding get() = _binding!!
    private lateinit var adapterPagamentos: AdapterPagamentos

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFragmentoPagamentosBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        iniciarRecyclerView()
        binding.imagemVoltarPagamento.setOnClickListener {
            parentFragmentManager.beginTransaction().apply {
                replace(R.id.conteiner_fragment_mainactivit,Fragmento_TelaSendMoney())
                setReorderingAllowed(true)
                addToBackStack("Fragmento_pagamentos")
                commit()
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    private fun iniciarRecyclerView(){
        adapterPagamentos = AdapterPagamentos()
        binding.recyclerLayoutPagamentos.adapter = ConcatAdapter(adapterPagamentos)
        adapterPagamentos.submitList(listaPagamentos)
    }
}