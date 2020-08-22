package can.co.id.room

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import can.co.id.room.MyApp.Companion.db
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var listProduk:ArrayList<ProdukModel> = ArrayList()
    lateinit var adapter:ProdukAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //mengambil data dari database
        listProduk = db?.produkDao()?.getAll() as ArrayList<ProdukModel>

        //mempersiakan adapter untuk recyclerview
        adapter = ProdukAdapter(listProduk)

        //menambahkan adapter dan tata letak untuk recyclerview
        main_recy_data.layoutManager = LinearLayoutManager(this)
        main_recy_data.adapter = adapter

        //reload adapter jika ada perubahan data
        adapter.notifyDataSetChanged()

        main_btn_tambah.setOnClickListener {
            //pindah activity
            startActivity(Intent(this@MainActivity, TambahProdukActivity::class.java))
        }
    }

    override fun onResume() {
        super.onResume()

        //mengambil data dari database
        listProduk.clear()
        listProduk.addAll(db?.produkDao()?.getAll() as Collection<ProdukModel>)

        //reload adapter jika ada perubahan data
        adapter.notifyDataSetChanged()
    }
}