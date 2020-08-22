package can.co.id.room

import android.app.Application
import androidx.room.Room

class MyApp : Application() {

    override fun onCreate() {
        super.onCreate()
        db = Room.databaseBuilder(
            getApplicationContext(),
            AppDatabase::class.java, "toko"
        ).allowMainThreadQueries().build()
    }

    companion object {
        var db: AppDatabase? = null
    }
}