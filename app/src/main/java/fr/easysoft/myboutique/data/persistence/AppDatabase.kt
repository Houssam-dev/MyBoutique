package fr.easysoft.myboutique.data.persistence

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import fr.easysoft.myboutique.data.persistence.converter.DateConverter
import fr.easysoft.myboutique.model.*

@Database(
    entities = [
        Categorie::class,
        Client::class,
        Order::class,
        OrderLine::class,
        Product::class,
        Role::class,
        User::class,
        Address::class
    ],
    version = 1,
    exportSchema = false)
@TypeConverters(DateConverter::class)
abstract class AppDatabase : RoomDatabase() {

    // TODO importing all daos

    companion object {
        const val DATABASE_NAME = "db_myboutique"
    }
}

