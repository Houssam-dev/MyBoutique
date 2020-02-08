package fr.easysoft.myboutique

import android.app.Application
import androidx.room.Room
import fr.easysoft.myboutique.data.persistence.AppDatabase
import fr.easysoft.myboutique.domain.MyBoutiqueService
import fr.easysoft.myboutique.domain.impl.MyBoutiqueServiceImpl
import timber.log.Timber

class App : Application() {

    companion object {
        lateinit var db: AppDatabase;
        lateinit var metier: MyBoutiqueService;
    }

    override fun onCreate() {
        super.onCreate()

        Timber.plant(Timber.DebugTree());

        db = Room.databaseBuilder(this, AppDatabase::class.java, AppDatabase.DATABASE_NAME)
            .build();

        metier = MyBoutiqueServiceImpl();
    }

    override fun onTerminate() {
        super.onTerminate()
        metier.disposeAllDisposable();
    }

    // TODO onTerminate for disposables RXJava2
}

