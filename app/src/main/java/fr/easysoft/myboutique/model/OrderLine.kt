package fr.easysoft.myboutique.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize
import java.io.Serializable

@Parcelize
@Entity
data class OrderLine(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "orderline_id")
    var orderLineId: Long,

    @ColumnInfo(name = "PRODUCT_ID")
    var productId: Long,

    @ColumnInfo(name = "ORDER_ID")
    var orderId: Long
) : Serializable, Parcelable