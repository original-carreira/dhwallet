package com.digitalhouse.dhwallet.adaptadores

import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.ViewParent
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.digitalhouse.dhwallet.databinding.LayoutItemPagamentoBinding
import com.digitalhouse.dhwallet.model.Pagamentos

class AdapterPagamentos:ListAdapter<Pagamentos,AdapterPagamentos.PagamentosViewHolder>(DiffCallBack) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PagamentosViewHolder {
        return PagamentosViewHolder.create(parent)
    }

    override fun onBindViewHolder(holder: PagamentosViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    companion object{
        private val DiffCallBack = object :DiffUtil.ItemCallback<Pagamentos>(){
            override fun areItemsTheSame(oldItem: Pagamentos, newItem: Pagamentos): Boolean {
                return oldItem.titulo == newItem.titulo
            }

            override fun areContentsTheSame(oldItem: Pagamentos, newItem: Pagamentos): Boolean {
                return oldItem.equals(newItem)
            }
        }
    }

    class PagamentosViewHolder(
        private val itemPagamentoBinding: LayoutItemPagamentoBinding
    ):RecyclerView.ViewHolder(itemPagamentoBinding.root){
        fun bind(pagamentos: Pagamentos){
            itemPagamentoBinding.run {
                tituloTextoLancamentoItempagamento.text = pagamentos.titulo
                tituloTextoTipoLancamentoItempagamento.text = pagamentos.endereco
                Glide.with(imagemLancamentoItempagamento.context).load(pagamentos.logo).into(imagemLancamentoItempagamento)
            }
        }
        companion object{
            fun create(parent: ViewGroup):PagamentosViewHolder{
                val itemPagamentoBinding = LayoutItemPagamentoBinding.inflate(LayoutInflater.from(parent.context),parent,false)
                return PagamentosViewHolder(itemPagamentoBinding)
            }
        }
    }
}