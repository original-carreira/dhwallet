package com.digitalhouse.dhwallet.fragmentos

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ConcatAdapter
import com.digitalhouse.dhwallet.R
import com.digitalhouse.dhwallet.adaptadores.AdapterCardInfo
import com.digitalhouse.dhwallet.adaptadores.AdapterTelaHomeTransaction
import com.digitalhouse.dhwallet.databinding.FragmentFragmentoHomeBinding
import com.digitalhouse.dhwallet.model.listaCardInfo
import com.digitalhouse.dhwallet.model.listaTransaction


class Fragmento_Home : Fragment(R.layout.fragment_fragmento__home) {
    private var _binding: FragmentFragmentoHomeBinding? = null
    private val binding get() = _binding!!
    private lateinit var adapterCardInfo: AdapterCardInfo
    private lateinit var adapterTelaHomeTransaction: AdapterTelaHomeTransaction

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFragmentoHomeBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecyclerView()
        binding.iconeAvancarHome.setOnClickListener {
            parentFragmentManager.beginTransaction().apply {
                replace(R.id.conteiner_fragment_mainactivit,Fragmento_CardInfo())
                setReorderingAllowed(true)
                addToBackStack("Fragmento_Home")
                commit()
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
    private fun initRecyclerView(){
        adapterCardInfo = AdapterCardInfo()
        adapterTelaHomeTransaction = AdapterTelaHomeTransaction()
        binding.recyclerHome.adapter = ConcatAdapter(adapterCardInfo)
        binding.recycler2Home.adapter = ConcatAdapter(adapterTelaHomeTransaction)
        adapterTelaHomeTransaction.submitList(listaTransaction)
        adapterCardInfo.submitList(listaCardInfo)
    }


}