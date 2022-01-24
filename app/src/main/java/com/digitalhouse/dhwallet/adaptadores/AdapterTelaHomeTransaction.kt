package com.digitalhouse.dhwallet.adaptadores

import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.ViewParent
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.digitalhouse.dhwallet.databinding.LayoutItemTransactionBinding
import com.digitalhouse.dhwallet.model.Transaction

class AdapterTelaHomeTransaction:ListAdapter<Transaction,AdapterTelaHomeTransaction.RecyclerTelaHomeTransactionViewHolder> (DiffCallBack){

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RecyclerTelaHomeTransactionViewHolder {
        return RecyclerTelaHomeTransactionViewHolder.create(parent)
    }

    override fun onBindViewHolder(holder: RecyclerTelaHomeTransactionViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
    companion object{
        private val DiffCallBack = object :DiffUtil.ItemCallback<Transaction>(){
            override fun areItemsTheSame(oldItem: Transaction, newItem: Transaction): Boolean {
                return oldItem.title == newItem.title
            }

            override fun areContentsTheSame(oldItem: Transaction, newItem: Transaction): Boolean {
                return newItem.equals(oldItem)
            }
        }
    }
    class RecyclerTelaHomeTransactionViewHolder(
        private val itemTransactionBinding: LayoutItemTransactionBinding
    ):RecyclerView.ViewHolder(itemTransactionBinding.root){
        fun bind(transaction: Transaction){
            itemTransactionBinding.run {
                Glide.with(imagemLancamentoItemTransaction.context).load(transaction.imagem).into(imagemLancamentoItemTransaction)
                tituloTextoLancamentoItemtransaction.text = transaction.title
                tituloTextoTipoLancamentoItemTransaction.text = transaction.subtitle
                campoValorLancamentoItemTransaction.text = transaction.value
            }
        }
        companion object{
            fun create(parent: ViewGroup):RecyclerTelaHomeTransactionViewHolder{
                val itemTransactionBinding = LayoutItemTransactionBinding
                    .inflate(LayoutInflater.from(parent.context),parent,false)
                return RecyclerTelaHomeTransactionViewHolder(itemTransactionBinding)
            }
        }
    }
}