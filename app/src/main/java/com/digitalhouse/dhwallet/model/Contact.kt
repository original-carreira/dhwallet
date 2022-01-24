package com.digitalhouse.dhwallet.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class Contact(
    val image: String,
    val name: String,
    val type: ContactType
): Parcelable

enum class ContactType(val description: String) {
    IRMA("Irmã"),
    IRMAO("Irmão"),
    ESPOSA("Esposa"),
    AMIGA("Amiga"),
    AMIGO("Amigo"),
    MAE("Mãe"),
}
val listaContact = listOf(
    Contact("https://exame.com/wp-content/uploads/2018/02/naruto.gif?quality=70&strip=info&resize=680,453","Victor",ContactType.AMIGO),
    Contact("https://www.freepnglogos.com/uploads/naruto-png/playground-geek-brushes-naruto-1.png","Manuela",ContactType.ESPOSA),
    Contact("https://www.freepnglogos.com/uploads/naruto-png/naruto-png-22.png","Victoria",ContactType.IRMA),
    Contact("https://pngset.com/images/naruto-naruto-shippuden-anime-naruto-render-clothing-sleeve-text-long-sleeve-transparent-png-326492.png","Vitinho",ContactType.IRMAO))

