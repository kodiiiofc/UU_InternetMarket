package com.kodiiiofc.urbanuniversity.internetmarket

import android.content.Context
import android.support.v4.os.IResultReceiver._Parcel
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ItemsAdapter(private val context: Context, private val list: List<Item>) : RecyclerView.Adapter<ItemsAdapter.ItemViewHolder>() {

    private var _itemClickListener: OnItemClickListener? = null;

    inner class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val nameTV: TextView = itemView.findViewById(R.id.tv_name)
        private val imageIV: ImageView = itemView.findViewById(R.id.iv_image)
        private val priceTV: TextView = itemView.findViewById(R.id.tv_price)

        fun bind(item: Item) {
            nameTV.text = item.name
            imageIV.setImageResource(item.imageResource)
            priceTV.text = "${item.price} $"
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val viewHolder = ItemViewHolder(LayoutInflater.from(context).inflate(R.layout.list_item, parent, false))
        return viewHolder
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val currentItem = list[position]
        holder.bind(currentItem)
        holder.itemView.setOnClickListener {
            _itemClickListener?.onItemClick(position);
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

    fun setOnItemClickListener(itemClickListener: OnItemClickListener) {
        _itemClickListener = itemClickListener
    }

    fun interface OnItemClickListener {
        fun onItemClick(position: Int)
    }

}