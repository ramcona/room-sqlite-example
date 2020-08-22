package can.co.id.room

import androidx.room.*

@Dao
interface ProdukDao {

    @Query("SELECT * FROM produkmodel ORDER BY id DESC")
    fun getAll(): List<ProdukModel>

    @Insert
    fun insertProduk(vararg produk: ProdukModel)

    @Update
    fun updateProduk(vararg produk: ProdukModel)

    @Delete
    fun deleteProduk(vararg produk: ProdukModel)
}