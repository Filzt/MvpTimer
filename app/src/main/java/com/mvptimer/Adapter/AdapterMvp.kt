package com.mvptimer.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.mvptimer.R
import com.mvptimer.model.Mvp
import org.w3c.dom.Text


class AdapterMvp(private val context: Context, private val mvps: MutableList<Mvp>): RecyclerView.Adapter<AdapterMvp.MvpViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MvpViewHolder {
        val itemList = LayoutInflater.from(context).inflate(R.layout.mvp_item, parent, false)
        val holder = MvpViewHolder(itemList)
        return holder
    }

    override fun onBindViewHolder(holder: MvpViewHolder, position: Int) {
        holder.photo.setImageResource(mvps[position].image)
        holder.name.text = mvps[position].name
        holder.map.text = mvps[position].map
        holder.timer.text = mvps[position].timer
    }

    override fun getItemCount(): Int = mvps.size

    inner class MvpViewHolder(itemView: View) : ViewHolder(itemView) {
        val photo = itemView.findViewById<ImageView>(R.id.mvp_image)
        val name = itemView.findViewById<TextView>(R.id.mvp_name)
        val map = itemView.findViewById<TextView>(R.id.mvp_map)
        val timer = itemView.findViewById<TextView>(R.id.mvp_timer)
    }
}