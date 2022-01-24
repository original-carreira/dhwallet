package com.digitalhouse.dhwallet.adaptadores

import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.ViewParent
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.digitalhouse.dhwallet.databinding.LayoutItemContatoBinding
import com.digitalhouse.dhwallet.model.Contact

class AdapterRecyclerTelaSendMoney:ListAdapter<Contact,AdapterRecyclerTelaSendMoney.RecyclerTelaSendMoneyViewHolder>(DiffCallBack) {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RecyclerTelaSendMoneyViewHolder {
        return RecyclerTelaSendMoneyViewHolder.create(parent)
    }

    override fun onBindViewHolder(holder: RecyclerTelaSendMoneyViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
    companion object{
        private val DiffCallBack = object :DiffUtil.ItemCallback<Contact>(){
            override fun areContentsTheSame(oldItem: Contact, newItem: Contact): Boolean {
                return oldItem.name == newItem.name
            }

            override fun areItemsTheSame(oldItem: Contact, newItem: Contact): Boolean {
                return oldItem == newItem
            }
        }
    }

    class RecyclerTelaSendMoneyViewHolder(
        private val itemContatoBinding: LayoutItemContatoBinding
    ):RecyclerView.ViewHolder(itemContatoBinding.root){
        fun bind(contact: Contact){
            itemContatoBinding.run {
                tituloLayoutItemContato.text =contact.name
                subtituloLayoutItemContato.text = contact.type.toString()
                Glide.with(imagemContato.context).load(contact.image).circleCrop().into(imagemContato)
            }
        }
        companion object{
            fun create(parent: ViewGroup):RecyclerTelaSendMoneyViewHolder{
                val itemContatoBinding = LayoutItemContatoBinding
                    .inflate(LayoutInflater.from(parent.context),parent,false)
                return RecyclerTelaSendMoneyViewHolder(itemContatoBinding)
            }
        }
    }
}