package fr.easysoft.myboutique.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Cart(var items: MutableMap<Product, Int>)
    : Parcelable {

}