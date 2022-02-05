package com.digitalhouse.dhwallet.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class Pagamentos (
    val titulo:String,
    val endereco:String,
    val logo:String
        ):Parcelable

val listaPagamentos = listOf(
    Pagamentos("Creative Eletric Service","Rua quintão, 1256, Vancouver. Canadá","https://www.skillsit.com.br/wp-content/uploads/2017/09/gestao-de-fornecedores-de-ti.jpg"),
    Pagamentos("Link3 Tecnologia","Rua timão,122, Salinopolis","https://www.castgroup.com.br/wp-content/uploads/2020/07/logo-ok.png"),
    Pagamentos("Green Soluções"," Rua Tinquerbell, 1200, Santa Marta, Nova Yorque","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTXeSLzRKuws7P1QF4KWezcIyD_5yqSouBAZA&usqp=CAU"),
    Pagamentos("R.Texeira Empreendimentos","Rua moisés,56. Laguinho","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSmmADiP5roH6KJmZBPq5YH-KFwCl5uZ2fid7dFmfokffk5IcgoLpxPWM9rxf6vgTZUnRo&usqp=CAU"),
    Pagamentos("Fibra Soluções","Rua Armando Texeira,701","https://ferragut.com.br/assets/images/ferragut-logo-2-380x122.png"),
    Pagamentos("Oi Tecnologia","Santa Marta, EUA","https://s.tmimgcdn.com/scr/800x500/85100/modelo-de-logotipo-de-solucao-de-ti_85180-original.jpg")
)