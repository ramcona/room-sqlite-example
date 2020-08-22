package can.co.id.room

import android.os.Parcel
import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class ProdukModel() :Parcelable {
    @PrimaryKey(autoGenerate = true)
    var id = 0

    @ColumnInfo(name = "nama")
    var nama: String? = ""

    @ColumnInfo(name = "harga")
    var harga: Int = 0

    constructor(parcel: Parcel) : this() {
        id = parcel.readInt()
        nama = parcel.readString()
        harga = parcel.readInt()
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(id)
        parcel.writeString(nama)
        parcel.writeInt(harga)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<ProdukModel> {
        override fun createFromParcel(parcel: Parcel): ProdukModel {
            return ProdukModel(parcel)
        }

        override fun newArray(size: Int): Array<ProdukModel?> {
            return arrayOfNulls(size)
        }
    }
}