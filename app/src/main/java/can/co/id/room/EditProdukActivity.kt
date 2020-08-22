package can.co.id.room

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.widget.Toast
import can.co.id.room.MyApp.Companion.db
import kotlinx.android.synthetic.main.activity_edit_produk.*

class EditProdukActivity : AppCompatActivity() {
    @SuppressLint("RestrictedApi")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_produk)

        //menambahkan judul dan tombol kembali di toolbar
        supportActionBar?.title = "Edit Produk"
        supportActionBar?.setDefaultDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        //menerima data yang di kirimkan dengan Intent ketika berpindah Activity
        val data = intent.getParcelableExtra("data") ?: ProdukModel()

        Log.e("data", "${data.harga} .")

        //memasukan data produk ke edittext untuk di perbarui
        edit_edt_harga.setText(data.harga.toString())
        edit_edt_nama.setText(data.nama)


        edit_btn_simpan.setOnClickListener {
            data.harga = edit_edt_harga.text.toString().toInt()
            data.nama = edit_edt_nama.text.toString()

            //menyimpan data yang di edit
            db?.produkDao()?.updateProduk(data)

            //memberi pesan berhasil di perbarui
            Toast.makeText(this@EditProdukActivity, "Produk berhasil di perbarui", Toast.LENGTH_SHORT).show()

            //menutup activity saat ini
            this@EditProdukActivity.finish()
        }

        edit_btn_hapus.setOnClickListener {

            //menghapus produk di database
            db?.produkDao()?.deleteProduk(data)

            //memberi pesan produk dihapus
            Toast.makeText(this@EditProdukActivity, "Produk berhasil di dihapus", Toast.LENGTH_SHORT).show()

            //menutup activity saat ini
            this@EditProdukActivity.finish()
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