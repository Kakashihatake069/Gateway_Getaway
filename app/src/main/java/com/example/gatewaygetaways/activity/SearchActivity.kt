package com.example.gatewaygetaways.activity

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.gatewaygetaways.adapter.SearchAdapter
import com.example.gatewaygetaways.databinding.ActivitySearchBinding
import com.example.gatewaygetaways.modelclass.ModelClassForDestinaion
import com.google.firebase.database.*


class SearchActivity : AppCompatActivity() {
    lateinit var firebaseDatabase: DatabaseReference
    lateinit var searchBinding: ActivitySearchBinding
    var searchlist =ArrayList<ModelClassForDestinaion>()
    lateinit var rcvsearch: RecyclerView
    lateinit var searchadapter: SearchAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        searchBinding = ActivitySearchBinding.inflate(layoutInflater)
        setContentView(searchBinding.root)

        initview()
    }

    private fun initview() {


        searchBinding.imgsearch.setOnClickListener {
            firebaseDatabase = FirebaseDatabase.getInstance().reference
            val searchvalue = searchBinding.edtsearchBox.getText().toString()
            Log.e("TAG", "initviewvjfgj: " + searchvalue)

            searchadapter = SearchAdapter(this,searchlist)

            firebaseDatabase.child("mountain").child(searchvalue).addValueEventListener(object : ValueEventListener{
                override fun onDataChange(snapshot: DataSnapshot) {
                    for (i in snapshot.children){
                        var searchdata = i.getValue(ModelClassForDestinaion::class.java)
                        Log.e(
                            "TAG",
                            "mountain:" + searchdata?.image + " " + searchdata?.name)
//                        searchdata?.let{ d -> searchlist.add(d) }
//                        searchdata?.image=i.child("image").value.toString()
//                        searchdata?.name=i.child("name").value.toString()
//                        searchdata?.location=i.child("location").value.toString()
//                        searchdata?.amount=i.child("amount").value.toString()

                        Log.e("TAG", "onData: "+searchdata?.name )
                    }

                    val LayoutManager =
                        LinearLayoutManager(this@SearchActivity, LinearLayoutManager.VERTICAL, false)
                    searchBinding.rcvsearch.layoutManager = LayoutManager
                    searchBinding.rcvsearch.adapter = searchadapter
                }

                override fun onCancelled(error: DatabaseError) {

                }

            })

        }

    }
}