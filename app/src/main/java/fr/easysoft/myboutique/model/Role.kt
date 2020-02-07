package fr.easysoft.myboutique.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize
import java.io.Serializable

@Parcelize
@Entity
data class Role(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "role_id")
    var roleId: Long,

    @ColumnInfo(name = "role_name")
    var roleName: String,

    @ColumnInfo(name = "user_id")
    var userId: Long
) : Serializable, Parcelable
