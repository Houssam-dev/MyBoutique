package fr.easysoft.myboutique

import android.app.Application
import androidx.room.Room
import fr.easysoft.myboutique.data.persistence.AppDatabase
import timber.log.Timber

class App : Application() {

    companion object {
        lateinit var db: AppDatabase;
        //lateinit var metier
    }

    override fun onCreate() {
        super.onCreate()

        Timber.plant(Timber.DebugTree());

        db = Room.databaseBuilder(this, AppDatabase::class.java, AppDatabase.DATABASE_NAME)
            .build();
    }

    // TODO onTerminate for disposables RXJava2
}

