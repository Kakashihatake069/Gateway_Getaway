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

class MountainAdapter(var context: ExploreFragment, var mountainlist: ArrayList<ModelClassForDestinaion>, var click : (ModelClassForDestinaion) -> Unit, var like : (Int,String) -> Unit ) : RecyclerView.Adapter<MountainAdapter.MyViewHolder>() {


    class MyViewHolder(itemview: View) : RecyclerView.ViewHolder(itemview) {
        var txtimage: ImageView = itemview.findViewById(R.id.txtimage)
        var txtplacelocation: TextView = itemview.findViewById(R.id.txtplacelocation)
        var txtplacename: TextView = itemview.findViewById(R.id.txtplacename)
        var txtplaceamount: TextView = itemview.findViewById(R.id.txtplaceamount)
        var loutonmountain: LinearLayout = itemview.findViewById(R.id.loutonmountain)
        var likeicon: ImageView = itemview.findViewById(R.id.likeicon)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        var v =
            LayoutInflater.from(parent.context).inflate(R.layout.onmountainitemfile, parent, false)
        var view = MyViewHolder(v)
        return view
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        Glide.with(context).load(mountainlist[position].image).into(holder.txtimage)
        holder.txtplacelocation.setText(mountainlist[position].location)
        holder.txtplacename.setText(mountainlist[position].name)
        holder.txtplaceamount.setText(mountainlist[position].amount)

        holder.loutonmountain.setOnClickListener {
            click.invoke(mountainlist[position])
        }

// like invoke
        if(mountainlist[position].status==1)
        {
            holder.likeicon.setImageResource(R.drawable.heartfill)
        } else {
            holder.likeicon.setImageResource(R.drawable.heart)
        }

        holder.likeicon.setOnClickListener {

            if (mountainlist[position].status == 1) {
                like.invoke(0,mountainlist[position].name)
                holder.likeicon.setImageResource(R.drawable.heart)
                mountainlist[position].status = 0
                Log.e(
                    "text",
                    "display:" + mountainlist[position].status.toString() + " " + mountainlist[position].name
                )
            } else {
                like.invoke(1,mountainlist[position].name)
                holder.likeicon.setImageResource(R.drawable.heartfill)
                mountainlist[position].status = 1
            }
        }

    }

    override fun getItemCount(): Int {
        return mountainlist.size
    }

    fun updatelist(mountainlist: java.util.ArrayList<ModelClassForDestinaion>) {
        this.mountainlist = ArrayList()
        this.mountainlist = mountainlist
        notifyDataSetChanged()
    }
}