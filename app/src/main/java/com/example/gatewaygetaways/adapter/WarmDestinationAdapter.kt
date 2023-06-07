package com.example.gatewaygetaways.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.gatewaygetaways.modelclass.ModelClassForDestinaion
import com.example.gatewaygetaways.R
import com.example.gatewaygetaways.fragment.ExploreFragment

class WarmDestinationAdapter(var context: ExploreFragment, var warmdestinationlist: ArrayList<ModelClassForDestinaion>,var clickonwarmdestination : (ModelClassForDestinaion) -> Unit) : RecyclerView.Adapter<WarmDestinationAdapter.MyViewHolder>() {


    class MyViewHolder(itemview: View): RecyclerView.ViewHolder(itemview) {
        var txtwarmimage: ImageView = itemview.findViewById(R.id.txtwarmimage)
        var txtwarmlocation: TextView = itemview.findViewById(R.id.txtwarmlocation)
        var txtwarmname: TextView = itemview.findViewById(R.id.txtwarmname)
        var txtwarmamount: TextView = itemview.findViewById(R.id.txtwarmamount)
        var loutwarmdestination : LinearLayout = itemview.findViewById(R.id.loutwarmdestination)

    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        var v =
            LayoutInflater.from(parent.context).inflate(R.layout.warmdestinationitemfile, parent, false)
        var view = MyViewHolder(v)
        return view
    }

    override fun onBindViewHolder(holder:MyViewHolder, position: Int) {
        Glide.with(context).load(warmdestinationlist[position].image).into(holder.txtwarmimage)
        holder.txtwarmlocation.setText(warmdestinationlist[position].location)
        holder.txtwarmname.setText(warmdestinationlist[position].name)
        holder.txtwarmamount.setText(warmdestinationlist[position].amount)

        holder.loutwarmdestination.setOnClickListener {
            clickonwarmdestination.invoke(warmdestinationlist[position])
        }


    }

    override fun getItemCount(): Int {
        return warmdestinationlist.size
    }
}