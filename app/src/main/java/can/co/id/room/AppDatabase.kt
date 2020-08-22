package can.co.id.room

import androidx.room.Database
import androidx.room.RoomDatabase


@Database(entities = [ProdukModel::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun produkDao(): ProdukDao?
}