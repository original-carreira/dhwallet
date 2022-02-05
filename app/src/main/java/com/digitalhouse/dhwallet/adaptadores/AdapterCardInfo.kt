package com.digitalhouse.dhwallet.adaptadores

import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.ViewParent
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.digitalhouse.dhwallet.databinding.LayoutItemCardInfoBinding
import com.digitalhouse.dhwallet.model.Cartao

class AdapterCardInfo:ListAdapter<Cartao,AdapterCardInfo.RecyclerCardInfoViewHolder>(DiffCallBack) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerCardInfoViewHolder {
        return RecyclerCardInfoViewHolder.create(parent)
    }

    override fun onBindViewHolder(holder: RecyclerCardInfoViewHolder, position: Int) {
        holder.bind((getItem(position)))
    }

    companion object{
        private val DiffCallBack = object :DiffUtil.ItemCallback<Cartao>(){
            override fun areItemsTheSame(oldItem: Cartao, newItem: Cartao): Boolean {
                return oldItem.numeracao == newItem.numeracao
            }

            override fun areContentsTheSame(oldItem: Cartao, newItem: Cartao): Boolean {
                return oldItem == newItem
            }
        }
    }

    class RecyclerCardInfoViewHolder(
        private val itemCardInfoBinding: LayoutItemCardInfoBinding
    ):RecyclerView.ViewHolder(itemCardInfoBinding.root){
        fun bind (cartao: Cartao){
            itemCardInfoBinding.run {
                tituloNomeCardInfo.text = cartao.nome
                subtituloNumerocardItemcard3.text = cartao.numeracao.toString()
                campoValidadeCardInfo.text =cartao.validade
                imagemCardinfo.setImageResource(cartao.imagemCard)
            }
        }
        companion object{
            fun create(parent: ViewGroup):RecyclerCardInfoViewHolder{
                val itemCardInfoBinding = LayoutItemCardInfoBinding
                    .inflate(LayoutInflater.from(parent.context),parent,false)
                return RecyclerCardInfoViewHolder(itemCardInfoBinding)
            }
        }
    }
}