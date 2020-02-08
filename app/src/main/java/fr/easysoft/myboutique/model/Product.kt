package fr.easysoft.myboutique.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize
import java.io.Serializable

@Parcelize
@Entity
data class Product(
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "product_id")
    var productId: Long,

    @ColumnInfo(name = "designation")
    var designation: String,

    @ColumnInfo(name = "price")
    var price: Double,

    @ColumnInfo(name = "selected")
    var selected: Boolean,

    // TODO make pictureData as byteArray instead of string
    @ColumnInfo(name = "picture_data")
    var pictureData: String,

    @ColumnInfo(name = "amount")
    var amount: Int,

    @ColumnInfo(name = "CAT_ID")
    var categorieId: Long
) : Serializable, Parcelable