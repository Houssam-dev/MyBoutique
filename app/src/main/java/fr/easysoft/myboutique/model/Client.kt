package fr.easysoft.myboutique.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize
import java.io.Serializable

@Parcelize
@Entity
data class Client(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "client_id")
    var clientId: Long,

    @ColumnInfo(name = "name_client")
    var nameClient: String,

    @ColumnInfo(name = "email")
    var email: String,

    @ColumnInfo(name = "fixed_telephone")
    var fixedTelephone: String,

    @ColumnInfo(name = "mobile_telephone")
    var mobileTelephone: String
) : Serializable, Parcelable