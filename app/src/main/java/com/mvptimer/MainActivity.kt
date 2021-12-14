package com.mvptimer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mvptimer.Adapter.AdapterMvp
import com.mvptimer.model.Mvp

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView_mvp = findViewById<RecyclerView>(R.id.recyclerView_mvp)
        recyclerView_mvp.layoutManager = LinearLayoutManager(this)

        //config adapter
        val mvpList: MutableList<Mvp> = mutableListOf()
        val adapterMvp = AdapterMvp(this, mvpList)
        recyclerView_mvp.adapter = adapterMvp

        val mvp1 = Mvp(
            R.drawable.abelha_rainha,
            "Abelha Rainha",
            "mjolnir_04",
            "02:00",
        )
        mvpList.add(mvp1)

    }
}