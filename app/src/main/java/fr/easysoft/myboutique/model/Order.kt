package fr.easysoft.myboutique.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize
import java.io.Serializable
import java.util.*

@Parcelize
@Entity
data class Order(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "order_id")
    var orderId: Long,

    @ColumnInfo(name = "date_order")
    var dateOrder: Date,

    @ColumnInfo(name = "CLIENT_ID")
    var clientId: Long
) : Serializable, Parcelable