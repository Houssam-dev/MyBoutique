package fr.easysoft.myboutique.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize
import java.io.Serializable


@Parcelize
@Entity
data class User(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "user_id")
    var userId: Long,

    @ColumnInfo(name = "user_name")
    var userName: String,

    @ColumnInfo(name = "password")
    var password: String,

    @ColumnInfo(name = "activated")
    var activated: Boolean
) : Serializable, Parcelable


