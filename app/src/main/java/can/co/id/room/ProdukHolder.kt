package can.co.id.room

import android.content.Intent
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ProdukHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val tvNama = itemView.findViewById<TextView>(R.id.iproduk_tv_nama)
    val tvHarga = itemView.findViewById<TextView>(R.id.iproduk_tv_harga)
    val ctx = itemView.context

    fun setData(model:ProdukModel){
        tvNama.text = model.nama
        tvHarga.text = model.harga.toString()

        //menambahkan fungsi ketika rootview dari textview nama di klik
        tvNama.rootView.setOnClickListener {

            //pindah Activity ke Edit dan membawa model produk
            val go = Intent(ctx, EditProdukActivity::class.java)
            go.putExtra("data", model)
            ctx.startActivity(go)
        }
    }
}