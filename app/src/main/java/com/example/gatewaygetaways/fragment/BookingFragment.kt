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


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        bookingBinding = FragmentBookingBinding.inflate(layoutInflater, container, false)
        initview()

        return bookingBinding.root
    }


    private fun initview() {


    }
}