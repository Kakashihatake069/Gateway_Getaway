package com.example.gatewaygetaways.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.window.OnBackInvokedCallback
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.gatewaygetaways.R
import com.example.gatewaygetaways.adapter.BookingTripAdapter
import com.example.gatewaygetaways.adapter.JungleSafariAdapter
import com.example.gatewaygetaways.adapter.MountainAdapter
import com.example.gatewaygetaways.databinding.FragmentBookingBinding
import com.example.gatewaygetaways.databinding.FragmentExploreBinding
import com.example.gatewaygetaways.modelclass.ModelClassForDestinaion
import com.example.gatewaygetaways.modelclass.ModelClassForPlaceDetails
import com.google.firebase.database.*


class BookingFragment : Fragment() {
    lateinit var bookingBinding: FragmentBookingBinding
    lateinit var firebaseDatabase: DatabaseReference


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        bookingBinding = FragmentBookingBinding.inflate(layoutInflater,container,false)
        initview()

        return bookingBinding.root
    }


    private fun initview() {


//
//        val value = arguments?.getString("name").toString()
//        Log.e("TAG", "mountainname: "+value)
//
//
//        firebaseDatabase = FirebaseDatabase.getInstance().reference
//        firebaseDatabase.child("mountain").child(value).child("details").addValueEventListener(object : ValueEventListener {
//            override fun onDataChange(snapshot: DataSnapshot) {
//
//                var image = snapshot.child("image").value.toString()
//                var name = snapshot.child("name").value.toString()
//                var rateing = snapshot.child("rateing").value.toString()
//                var amount = snapshot.child("amount").value.toString()
//                var details = snapshot.child("info").value.toString()
//
//                Log.e("TAG", "onDataChangemountain: "+image+" "+name+" "+rateing+" "+amount)
//
//                Glide.with(this@BookingFragment).load(image).placeholder(R.drawable.defalutimage).into(bookingBinding.imgplaceimage)
//                bookingBinding.txtplacename.text = name
//                bookingBinding.txtrateing.text = rateing
//                bookingBinding.txtfragamount.text = amount
//                bookingBinding.txtabouttheplace.text =details


                //////////////


//                for (i in snapshot.children){
//                    var bookingdata = i.getValue(ModelClassForPlaceDetails::class.java)
//
//                    Log.e("TAG", "bookingplace: "+ bookingdata?.image+ " " +bookingdata?.name+ " " + bookingdata?.rateing+" "+bookingdata?.amount+ " " +bookingdata?.details)
//
//                    bookingdata?.let{ d -> bookdestinationlist.add(d) }
//                    bookingdata?.image=i.child("image").value.toString()
//                    bookingdata?.name=i.child("name").value.toString()
//                    bookingdata?.rateing=i.child("rateing").value.toString()
//                    bookingdata?.amount=i.child("amount").value.toString()
//
//
//
//                }

//                val LayoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
//                bookingBinding.rcvbookingdestination.layoutManager = LayoutManager
//                bookingBinding.rcvbookingdestination.adapter = bookingplaceadapter
            }

//            override fun onCancelled(error: DatabaseError) {
//
//            }
//
//        })
//
//
//
//    }


}