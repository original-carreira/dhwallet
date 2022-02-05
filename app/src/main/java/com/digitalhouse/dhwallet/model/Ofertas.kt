package com.digitalhouse.dhwallet.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
@Parcelize
class Ofertas(
    val imagemCartao: String
):Parcelable


var listaOfertas = listOf(
    Ofertas("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTNCS4Itk2AELttQ-qNwJPd6mpG67hC75vIWw&usqp=CAU"),
    Ofertas("https://i.ytimg.com/vi/xhyMqyaTkV0/maxresdefault.jpg"),
    Ofertas("https://www.aguaboanews.com.br/imgsite/noticias/mega-leilao.jpg")
)