package com.digitalhouse.dhwallet.fragmentos

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ConcatAdapter
import com.digitalhouse.dhwallet.R
import com.digitalhouse.dhwallet.adaptadores.AdapterRecyclerTelaSendMoney
import com.digitalhouse.dhwallet.databinding.FragmentFragmentoTelaSendMoneyBinding
import com.digitalhouse.dhwallet.model.listaContact

// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_ENTRADA = "paramEntrada"
private const val ARG_SAIDA = "paramSaida"

/**
 * A simple [Fragment] subclass.
 * Use the [Fragmento_TelaSendMoney.newInstance] factory method to
 * create an instance of this fragment.
 */
class Fragmento_TelaSendMoney : Fragment(R.layout.fragment_fragmento__tela_send_money) {
    private var _binding:FragmentFragmentoTelaSendMoneyBinding? = null
    private val binding get() = _binding!!
    private lateinit var adapterRecyclerTelaSendMoney: AdapterRecyclerTelaSendMoney
    private var entrada: String? = null
    private var saida: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            entrada = it.getString(ARG_ENTRADA)
            saida = it.getString(ARG_SAIDA)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentFragmentoTelaSendMoneyBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        inicioRecyclerView()
        binding.imagemVoltarSendmoney.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.conteiner_fragment_mainactivit,FragmentoTela_Home_transaction())
                .addToBackStack(null)
                .commit()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    private fun inicioRecyclerView(){
        adapterRecyclerTelaSendMoney = AdapterRecyclerTelaSendMoney()
        binding.recyclerLayoutSendmoney.adapter = ConcatAdapter(adapterRecyclerTelaSendMoney)
        adapterRecyclerTelaSendMoney.submitList(listaContact)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment Fragmento_TelaSendMoney.
         */

        @JvmStatic
        fun newInstance(paramEntrada: String, paramSaida: String) =
            Fragmento_TelaSendMoney().apply {
                arguments = Bundle().apply {
                    putString(ARG_ENTRADA, paramEntrada)
                    putString(ARG_SAIDA, paramSaida)
                }
            }
    }
}