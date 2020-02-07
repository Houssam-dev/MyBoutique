package fr.easysoft.myboutique.model

import android.os.Parcelable
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.Relation
import kotlinx.android.parcel.Parcelize
import java.io.Serializable

@Parcelize
@Entity
data class CategoriesWithProducts(
    @Embedded val categorie: Categorie,
    @Relation(
        parentColumn = "categorie_id",
        entityColumn = "CAT_ID"
    )
    val products: List<Product>
) : Serializable, Parcelable