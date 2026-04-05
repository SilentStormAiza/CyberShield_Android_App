package com.example.cyberarmour.Auth

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.cyberarmour.R

class ScamAdapter(
    private var scamList: List<Scam>,
    private val onItemClick: (Scam) -> Unit
) : RecyclerView.Adapter<ScamAdapter.ScamViewHolder>() {

    class ScamViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val title: TextView = view.findViewById(R.id.scamTitle)
        val spinner: Spinner = view.findViewById(R.id.scamSpinner)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ScamViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_scam, parent, false)
        return ScamViewHolder(view)
    }

    override fun onBindViewHolder(holder: ScamViewHolder, position: Int) {
        val scam = scamList[position]
        holder.title.text = scam.title

        val adapter = ArrayAdapter.createFromResource(
            holder.itemView.context,
            R.array.view_options,
            android.R.layout.simple_spinner_item
        )
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        holder.spinner.adapter = adapter

        holder.itemView.setOnClickListener {
            onItemClick(scam)
        }
    }

    override fun getItemCount(): Int = scamList.size

    fun updateList(newList: List<Scam>) {
        scamList = newList
        notifyDataSetChanged()
    }
}
