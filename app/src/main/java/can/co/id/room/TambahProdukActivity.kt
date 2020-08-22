package can.co.id.room

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import can.co.id.room.MyApp.Companion.db
import kotlinx.android.synthetic.main.activity_tambah_produk.*

class TambahProdukActivity : AppCompatActivity() {

    @SuppressLint("RestrictedApi")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tambah_produk)

        //menambahkan judul dan tombol kembali di toolbar
        supportActionBar?.title = "Tambah Produk"
        supportActionBar?.setDefaultDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        tambah_btn_simpan.setOnClickListener {

            //memasukan data dari inputan kedalam model
            val data = ProdukModel()
            data.nama = tambah_tv_nama.text.toString()
            data.harga = tambah_tv_harga.text.toString().toInt()

            //menyimpan data ke dalam database
            db?.produkDao()?.insertProduk(data)

            //memberi pesan berhasil
            Toast.makeText(this@TambahProdukActivity, "Tambah produk berhasil", Toast.LENGTH_SHORT).show()

            //menutup activity saat ini
            this@TambahProdukActivity.finish()
        }
    }

    //menghandel fungsi tombol kembali di toolbar
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            android.R.id.home->onBackPressed()
        }
        return super.onOptionsItemSelected(item)
    }
}