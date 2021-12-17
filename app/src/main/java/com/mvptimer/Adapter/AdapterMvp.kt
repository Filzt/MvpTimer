package com.mvptimer.Adapter

import android.content.Context
import android.os.CountDownTimer
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.mvptimer.R
import com.mvptimer.model.Mvp
import java.util.concurrent.TimeUnit


class AdapterMvp(private val context: Context, private val mvps: MutableList<Mvp>) :
    RecyclerView.Adapter<AdapterMvp.MvpViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MvpViewHolder {
        val itemList = LayoutInflater.from(context).inflate(R.layout.mvp_item, parent, false)
        val holder = MvpViewHolder(itemList)
        return holder
    }

    fun formatTimer(timer: Long): String {
         var formattedtime = context.getString(
            R.string.formatted_time,
            TimeUnit.MINUTES.toMinutes(timer) % 60,
            TimeUnit.MINUTES.toSeconds(timer) % 60)
        return formattedtime
    }

    override fun onBindViewHolder(holder: MvpViewHolder, position: Int) {
        holder.photo.setImageResource(mvps[position].image)
        holder.name.text = mvps[position].name
        holder.map.text = mvps[position].map
        holder.timer.text = formatTimer(mvps[position].timer)
        holder.cd = object : CountDownTimer(1000 * 30, 1000) {
            override fun onTick(millisUnitFinished: Long) {
                //update text
//                holder.timer.text = context.getString(
//                   // formatTimer()
//                )
            }

            override fun onFinish() {
                isStarted = false
            }

        }


        holder.timer.setOnClickListener {
            (holder.cd as CountDownTimer).start()

        }
    }


    private var isStarted = false


    override fun getItemCount(): Int = mvps.size

    inner class MvpViewHolder(itemView: View) : ViewHolder(itemView) {
        var cd: CountDownTimer? = null
        val photo = itemView.findViewById<ImageView>(R.id.mvp_image)
        val name = itemView.findViewById<TextView>(R.id.mvp_name)
        val map = itemView.findViewById<TextView>(R.id.mvp_map)
        val timer = itemView.findViewById<Button>(R.id.mvp_timer_btn)
    }
}