package com.digitalhouse.dhwallet.fragmentos

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ConcatAdapter
import com.digitalhouse.dhwallet.R
import com.digitalhouse.dhwallet.adaptadores.AdapterCardInfo
import com.digitalhouse.dhwallet.adaptadores.AdapterCardInfo_2
import com.digitalhouse.dhwallet.databinding.FragmentFragmentoCardInfoBinding
import com.digitalhouse.dhwallet.databinding.LayoutItem2CardInfoBinding
import com.digitalhouse.dhwallet.model.listaCardInfo
import com.digitalhouse.dhwallet.model.listaOfertas


class Fragmento_CardInfo : Fragment(R.layout.fragment_fragmento__card_info) {
    private var _binding: FragmentFragmentoCardInfoBinding? = null
    private val binding get() = _binding!!
    private lateinit var adaptercardinfo2: AdapterCardInfo_2

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFragmentoCardInfoBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecyclerView()
        binding.iconNagigationCardinfo.setOnClickListener {
            parentFragmentManager.beginTransaction().apply {
                replace(R.id.conteiner_fragment_mainactivit,FragmentoTela_Home_transaction())
                setReorderingAllowed(true)
                addToBackStack("Fragmento_CardInfo")
                commit()
            }
        }
        binding.iconBoltCardinfo.setOnClickListener {
            parentFragmentManager.beginTransaction().apply {
                replace(R.id.conteiner_fragment_mainactivit,Fragmento_TelaSendMoney())
                setReorderingAllowed(true)
                addToBackStack("Fragmento_CardInfo")
                commit()
            }
        }
        binding.imagemVoltarCardinfoToolbar.setOnClickListener {
            parentFragmentManager.beginTransaction().apply {
                replace(R.id.conteiner_fragment_mainactivit,Fragmento_Home())
                setReorderingAllowed(true)
                addToBackStack("Fragmento_CardInfo")
                commit()
            }
        }
        binding.iconMoneyCardinfo.setOnClickListener {
            parentFragmentManager.beginTransaction().apply {
                replace(R.id.conteiner_fragment_mainactivit,Fragmento_pagamentos())
                setReorderingAllowed(true)
                addToBackStack("Fragmento_CardInfo")
                commit()
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    private fun initRecyclerView(){
       adaptercardinfo2 = AdapterCardInfo_2()
       binding.recyclerCardInfo.adapter = ConcatAdapter(adaptercardinfo2)
        binding.recycler2CardInfo.adapter = ConcatAdapter(adaptercardinfo2)
       adaptercardinfo2.submitList(listaOfertas)
    }
}