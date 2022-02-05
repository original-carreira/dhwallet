package com.digitalhouse.dhwallet.model

import android.os.Parcelable
import androidx.annotation.DrawableRes
import com.digitalhouse.dhwallet.R
import kotlinx.android.parcel.Parcelize

data class Cartao(
    val nome:String,
    val validade:String,
    val numeracao:Int,
    @DrawableRes
    val imagemCard: Int
)

val listaCardInfo = listOf(
    Cartao("Victor Carreira","12/27",2733, R.mipmap.ic_card_banco),
    Cartao("Victo P Carreira","09/22",5433,R.mipmap.ic_card_banco2),
    Cartao("Victor Pinheiro","09/24",1321,R.mipmap.ic_card_banco3)
)
