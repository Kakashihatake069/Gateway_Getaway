package com.example.gatewaygetaways.adapter

import android.util.Log
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
import com.example.gatewaygetaways.modelclass.ModelClassForPlaceDetails

class JungleSafariAdapter(var context: ExploreFragment,var junglelist: ArrayList<ModelClassForDestinaion>, var jungleclick : (ModelClassForDestinaion) -> Unit) :
    RecyclerView.Adapter<JungleSafariAdapter.MyViewHolder>() {
    class MyViewHolder(itemview : View) : RecyclerView.ViewHolder(itemview) {
        var txtjungleimage: ImageView = itemview.findViewById(R.id.txtjungleimage)
        var txtjunglelocation: TextView = itemview.findViewById(R.id.txtjunglelocation)
        var txtjunglename: TextView = itemview.findViewById(R.id.txtjunglename)
        var txtjungleamount: TextView = itemview.findViewById(R.id.txtjungleamount)
        var loutjunglesafari: LinearLayout = itemview.findViewById(R.id.loutjunglesafari)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):MyViewHolder {
        var v = LayoutInflater.from(parent.context).inflate(R.layout.junglesafariitemfile, parent, false)
        var view = MyViewHolder(v)
        return view
    }

    override fun onBindViewHolder(holder:MyViewHolder, position: Int) {
       Glide.with(context).load(junglelist[position].image).into(holder.txtjungleimage)
        holder.txtjunglelocation.setText(junglelist[position].location)
        holder.txtjunglename.setText(junglelist[position].name)
        holder.txtjungleamount.setText(junglelist[position].amount)

        holder.loutjunglesafari.setOnClickListener {
            jungleclick.
            invoke(junglelist[position])



        }
    }

    override fun getItemCount(): Int {
        return junglelist.size
    }

    fun updatelist(junglelist: java.util.ArrayList<ModelClassForDestinaion>) {
        this.junglelist = ArrayList()
        this.junglelist = junglelist
        notifyDataSetChanged()
    }
}