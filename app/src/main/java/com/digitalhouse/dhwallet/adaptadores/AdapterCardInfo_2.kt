package com.digitalhouse.dhwallet.adaptadores

import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.ViewParent
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.digitalhouse.dhwallet.databinding.LayoutItem2CardInfoBinding
import com.digitalhouse.dhwallet.model.Ofertas

class AdapterCardInfo_2:ListAdapter<Ofertas,AdapterCardInfo_2.AdapterCardInfo2ViewHolder>(DiffCallBack) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterCardInfo2ViewHolder {
        return AdapterCardInfo2ViewHolder.create(parent)
    }

    override fun onBindViewHolder(holder: AdapterCardInfo2ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    companion object {
        private val DiffCallBack = object :DiffUtil.ItemCallback<Ofertas>(){
            override fun areItemsTheSame(oldItem: Ofertas, newItem: Ofertas): Boolean {
                return oldItem.imagemCartao == newItem.imagemCartao
            }

            override fun areContentsTheSame(oldItem: Ofertas, newItem: Ofertas): Boolean {
                return oldItem.equals(newItem)
            }
        }
    }
    class AdapterCardInfo2ViewHolder(
        private val item2CardInfoBinding: LayoutItem2CardInfoBinding
    ):RecyclerView.ViewHolder(item2CardInfoBinding.root){
        fun bind(ofertas: Ofertas){
            item2CardInfoBinding.run {
                Glide.with(imagemCardinfo.context).load(ofertas.imagemCartao).into(imagemCardinfo)
            }
        }
        companion object{
            fun create(parent: ViewGroup):AdapterCardInfo2ViewHolder{
                val item2CardInfoBinding = LayoutItem2CardInfoBinding
                    .inflate(LayoutInflater.from(parent.context),parent,false)
                return AdapterCardInfo2ViewHolder(item2CardInfoBinding)
            }
        }
    }
}