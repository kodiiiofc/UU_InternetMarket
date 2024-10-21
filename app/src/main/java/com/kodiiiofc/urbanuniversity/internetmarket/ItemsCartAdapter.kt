package com.kodiiiofc.urbanuniversity.internetmarket

import android.content.Context
import android.support.v4.os.IResultReceiver._Parcel
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.kodiiiofc.urbanuniversity.internetmarket.ItemsAdapter.OnItemClickListener

class ItemsCartAdapter(private val context: Context, private var map: Map<Item, Int>) : RecyclerView.Adapter<ItemsCartAdapter.ItemViewHolder>() {

    private var _itemClickListener: OnItemClickListener? = null;

    inner class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val nameTV: TextView = itemView.findViewById(R.id.tv_name)
        private val imageIV: ImageView = itemView.findViewById(R.id.iv_image)
        private val priceTV: TextView = itemView.findViewById(R.id.tv_price)
        private val countTV: TextView = itemView.findViewById(R.id.tv_count)

        fun onBind(item: Item, count: Int) {
            countTV.text = "${count} шт."
            nameTV.text = item.name
            imageIV.setImageResource(item.imageResource)
            priceTV.text = "${item.price * count} $"
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val viewHolder = ItemViewHolder(LayoutInflater.from(context).inflate(R.layout.list_item_cart, parent, false))
        return viewHolder
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val currentItem = map.toList()[position]
        holder.onBind(currentItem.first, currentItem.second)
        holder.itemView.setOnClickListener {
            _itemClickListener?.onItemClick(position);
        }
    }

    override fun getItemCount(): Int {
        return map.size
    }

    fun interface OnItemClickListener {
        fun onItemClick(position: Int)
    }

    fun setOnItemClickListener(itemClickListener: OnItemClickListener) {
        _itemClickListener = itemClickListener
    }

    fun updateMap(updatedMap: Map<Item, Int>) {
        map = updatedMap
        notifyDataSetChanged()
    }
}