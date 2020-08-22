package can.co.id.room

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class ProdukAdapter(var data:ArrayList<ProdukModel>): RecyclerView.Adapter<ProdukHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProdukHolder {
        return ProdukHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_produk, parent, false))
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: ProdukHolder, position: Int) {
        holder.setData(data[position])
    }
}