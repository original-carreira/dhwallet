package com.digitalhouse.dhwallet.fragmentos

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ConcatAdapter
import com.digitalhouse.dhwallet.R
import com.digitalhouse.dhwallet.adaptadores.AdapterTelaHomeTransaction
import com.digitalhouse.dhwallet.databinding.FragmentFragmentoTelaHomeTransactionBinding
import com.digitalhouse.dhwallet.model.listaTransaction
import kotlinx.android.synthetic.main.fragment_fragmento_tela__home_transaction.*

private const val ARG_ENTRADA = "arg_entrada"
private const val ARG_SAIDA = "arg_saida"

/**
 * A simple [Fragment] subclass.
 * Use the [FragmentoTela_Home_transaction.newInstance] factory method to
 * create an instance of this fragment.
 */
class FragmentoTela_Home_transaction : Fragment(R.layout.fragment_fragmento_tela__home_transaction) {
    private var _binding: FragmentFragmentoTelaHomeTransactionBinding? = null
    private val  binding get() = _binding!!
    private lateinit var adapterTelaHomeTransaction: AdapterTelaHomeTransaction
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
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentFragmentoTelaHomeTransactionBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecyclerView()

        binding.let {
            campo_valorEntrada_hometransaction.text = entrada
            campo_valorSaida_hometransaction.text = saida
        }
        binding.iconeAvancarHometransaction.setOnClickListener {
            val proximoFragemnto = Fragmento_TelaSendMoney()
            val transaction = parentFragmentManager.beginTransaction()
            transaction.replace(R.id.conteiner_fragment_mainactivit,proximoFragemnto)
            transaction.addToBackStack(null)
            transaction.commit()
        }
        binding.imagemVoltarHomeTransactionToolbar.setOnClickListener {
            parentFragmentManager.beginTransaction().apply {
                replace(R.id.conteiner_fragment_mainactivit,Fragmento_CardInfo())
                setReorderingAllowed(true)
                addToBackStack("FragmentoTela_Home_transaction")
                commit()
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding =null
    }

    private fun initRecyclerView(){
        adapterTelaHomeTransaction = AdapterTelaHomeTransaction()
        binding.recyclerLayoutTelaHometransaction.adapter = ConcatAdapter(adapterTelaHomeTransaction)
        adapterTelaHomeTransaction.submitList(listaTransaction)
    }

    companion object {

        @JvmStatic
        fun newInstance(paramEntrada: String, paramSaida: String) =
            FragmentoTela_Home_transaction().apply {
                arguments = Bundle().apply {
                    putString(ARG_ENTRADA, paramEntrada)
                    putString(ARG_SAIDA, paramSaida)
                }
            }
    }
}