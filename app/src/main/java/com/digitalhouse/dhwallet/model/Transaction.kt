package com.digitalhouse.dhwallet.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class Transaction(
    val imagem: String,
    val title: String,
    val subtitle: String,
    val value: String,
): Parcelable

val listaTransaction = listOf<Transaction>(
    Transaction("https://supermercadosfortaleza.com.br/assets/images/cpia-de-segurana-de-cpia-de-segurana-de-nova-logo-s.m.-fortaleza-296x121.png","Supermercado Fortaleza","Pagamento","R$ 689,50"),
    Transaction("https://upload.wikimedia.org/wikipedia/pt/thumb/3/3f/Auto_Posto_%28s%C3%A9rie%29.jpg/640px-Auto_Posto_%28s%C3%A9rie%29.jpg","Auto Posto Firmino","Pagamento","R$ 100,00"),
    Transaction("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS8vVgZH6sU_P5jEb-smeLeynD--jp2QJpAWvVgOedS5xsHhlEZgfPI74Jo5-5A95NZzwg&usqp=CAU","Aroldo Fernades Rocha","Recebido Pix","R$ 52,00")
)
