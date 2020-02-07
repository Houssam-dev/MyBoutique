package fr.easysoft.myboutique.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize
import java.io.Serializable

@Parcelize
@Entity
data class Address(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "address_id")
    var addressId: Long,

    @ColumnInfo(name = "type_street")
    var typeStreet: String,

    @ColumnInfo(name = "number")
    var number: String,

    @ColumnInfo(name = "name_street")
    var nameStreet: String,

    @ColumnInfo(name = "postcode")
    var postcode: String,

    @ColumnInfo(name = "CLIENT_ID")
    var clientId: Long
) : Serializable, Parcelable