package com.example.gatewaygetaways.activity

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.gatewaygetaways.R
import com.example.gatewaygetaways.adapter.HotelAdapter
import com.example.gatewaygetaways.databinding.ActivityDisplayplaceBinding
import com.example.gatewaygetaways.fragment.GoogleMapsFragment
import com.example.gatewaygetaways.modelclass.ModelClassForDestinaion
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.razorpay.Checkout
import kotlinx.coroutines.NonCancellable.key
import org.json.JSONException
import org.json.JSONObject


class DisplayplaceActivity : AppCompatActivity() {

    lateinit var binding : ActivityDisplayplaceBinding
    lateinit var firebaseDatabase: DatabaseReference
    lateinit var mountainlist: ArrayList<ModelClassForDestinaion>
    lateinit var adapterhotel: HotelAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDisplayplaceBinding.inflate(layoutInflater)
        supportActionBar?.hide()
        setContentView(binding.root)
        loadingmap()
        initview()
        hotel()
        payment()

    }

    private fun initview() {

        if (key != null && intent.hasExtra("topddestination")) {
            // for trending destination

            firebaseDatabase = FirebaseDatabase.getInstance().reference
            var trendingvalue = intent.getStringExtra("name").toString()
            Log.e("TAG", "initview " + trendingvalue)

            firebaseDatabase.child("trendingdestination").child(trendingvalue).child("details")
                .addValueEventListener(object : ValueEventListener {
                    override fun onDataChange(snapshot: DataSnapshot) {
                        var image4 = snapshot.child("image").value.toString()
                        var name4 = snapshot.child("name").value.toString()
                        var rateing4 = snapshot.child("rateing").value.toString()
                        var amount4 = snapshot.child("amount").value.toString()
                        var details4 = snapshot.child("info").value.toString()

//                        val mFragmentManagertopdestination = supportFragmentManager
//                        val mFragmentTransactiontopdestination = mFragmentManagertopdestination.beginTransaction()
//                        val mFragmenttopdestination = GoogleMapsFragment()


                        Log.e(
                            "TAG",
                            "onDataChangemountain: " + image4 + " " + name4 + " " + rateing4 + " " + amount4
                        )

                        Glide.with(this@DisplayplaceActivity).load(image4)
                            .placeholder(R.drawable.defalutimage).into(binding.imgplaceimage)
                        binding.txtplacename.text = name4
                        binding.txtrateing.text = rateing4
                        binding.txtfragamount.text = amount4
                        binding.txtabouttheplace.text = details4

//                        val bundle = Bundle()
//                        bundle.putString("name",name4)
//                        Log.e("TAG", "Tvalue: "+name4 )
//                        bundle.putBoolean("topddestination",true)
//                        mFragmenttopdestination.arguments = bundle
//                        mFragmentTransactiontopdestination.add(R.id.mapframe,mFragmenttopdestination).commit()
//                        Log.e("TAG", "onDataChangfgde: "+ bundle )
                    }

                    override fun onCancelled(error: DatabaseError) {

                    }

                })
        }
        else if (key != null && intent.hasExtra("loadsPosition")) {
//            for mountain travel
            firebaseDatabase = FirebaseDatabase.getInstance().reference
            var value = intent.getStringExtra("name").toString()
            Log.e("TAG", "mountainvalue: " + value)

            firebaseDatabase.child("mountain").child(value).child("details")
                .addValueEventListener(object :
                    ValueEventListener {
                    override fun onDataChange(snapshot: DataSnapshot) {

                        var image = snapshot.child("image").value.toString()
                        var name = snapshot.child("name").value.toString()
                        var rateing = snapshot.child("rateing").value.toString()
                        var amount = snapshot.child("amount").value.toString()
                        var details = snapshot.child("info").value.toString()

                        val mFragmentManager = supportFragmentManager
                        val mFragmentTransaction = mFragmentManager.beginTransaction()
                        val mFragment = GoogleMapsFragment()

                        Log.e(
                            "TAG",
                            "displayactivity:" + image + " " + name + " " + rateing + " " + amount
                        )

                        Glide.with(getApplicationContext()).load(image)
                            .placeholder(R.drawable.defalutimage).into(binding.imgplaceimage)
                        binding.txtplacename.text = name
                        binding.txtrateing.text = rateing
                        binding.txtfragamount.text = amount
                        binding.txtabouttheplace.text = details

                        val bundle = Bundle()
                        bundle.putString("name", name)
                        Log.e("TAG", "Bvalue: " + name)
                        bundle.putBoolean("loadsPosition", true)
                        mFragment.arguments = bundle
                        mFragmentTransaction.add(R.id.mapframe, mFragment).commit()
                        Log.e("TAG", "onDataChangfgde: " + bundle)


                        // setting recyclerView layoutManager
//                        val layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
//                        binding.rcvhotel.layoutManager = layoutManager
//                        binding.rcvhotel.adapter = ad


                    }

                    override fun onCancelled(error: DatabaseError) {

                    }

                })

//                binding.imglike.setOnClickListener {
//                    firebaseDatabase.child("mountain").child(value).child("details").child("status").setValue(1)
//                }

        }
        else if (key != null && intent.hasExtra("jungledestination")) {
//            for jungle safari
            firebaseDatabase = FirebaseDatabase.getInstance().reference
            val junglevalue = intent.getStringExtra("name").toString()
            Log.e("TAG", "junglesafarivalue: " + junglevalue)
            firebaseDatabase.child("junglesafari").child(junglevalue).child("details")
                .addValueEventListener(object : ValueEventListener {
                    override fun onDataChange(snapshot: DataSnapshot) {
                        var image1 = snapshot.child("image").value.toString()
                        var name1 = snapshot.child("name").value.toString()
                        var rateing1 = snapshot.child("rateing").value.toString()
                        var amount1 = snapshot.child("amount").value.toString()
                        var info1 = snapshot.child("info").value.toString()

                        val mFragmentManagerjunglesafari = supportFragmentManager
                        val mFragmentTransactionjunglesafari =
                            mFragmentManagerjunglesafari.beginTransaction()
                        val mFragmentjunglesafari = GoogleMapsFragment()

                        Log.e("TAG", "onDataChangejungle: " + name1)

                        Glide.with(this@DisplayplaceActivity).load(image1)
                            .placeholder(R.drawable.defalutimage).into(binding.imgplaceimage)
                        binding.txtplacename.text = name1
                        binding.txtrateing.text = rateing1
                        binding.txtfragamount.text = amount1
                        binding.txtabouttheplace.text = info1

                        val bundle = Bundle()
                        bundle.putString("name", name1)
                        Log.e("TAG", "junglebundlepass: " + name1)
                        bundle.putBoolean("jungledestination", true)
                        mFragmentjunglesafari.arguments = bundle
                        mFragmentTransactionjunglesafari.add(R.id.mapframe, mFragmentjunglesafari)
                            .commit()
                        Log.e("TAG", "junglesafari bundle value: " + bundle)

                        Log.e("TAG", "onDataChangedjungle: " + name1)
                    }

                    override fun onCancelled(error: DatabaseError) {

                    }

                })

        }
        else if (key != null && intent.hasExtra("beachdestination")) {
//                for warm destination
            firebaseDatabase = FirebaseDatabase.getInstance().reference
            val beachvalue = intent.getStringExtra("name").toString()
            Log.e("TAG", "warmdestination: " + beachvalue)

            firebaseDatabase.child("warmdestination").child(beachvalue).child("details")
                .addValueEventListener(object : ValueEventListener {
                    override fun onDataChange(snapshot: DataSnapshot) {

                        var image2 = snapshot.child("image").value.toString()
                        var name2 = snapshot.child("name").value.toString()
                        var rateing2 = snapshot.child("rateing").value.toString()
                        var amounnt2 = snapshot.child("amount").value.toString()
                        var info2 = snapshot.child("info").value.toString()

                        val mFragmentManagerforbeach = supportFragmentManager
                        val mFragmentTransactionforbeach =
                            mFragmentManagerforbeach.beginTransaction()
                        val mFragmentforbeach = GoogleMapsFragment()

                        Log.e("TAG", "onDataChangewarmdestination: " + name2)

                        Glide.with(this@DisplayplaceActivity).load(image2)
                            .placeholder(R.drawable.defalutimage).into(binding.imgplaceimage)
                        binding.txtplacename.text = name2
                        binding.txtrateing.text = rateing2
                        binding.txtfragamount.text = amounnt2
                        binding.txtabouttheplace.text = info2

                        val bundle = Bundle()
                        bundle.putString("name", name2)
                        Log.e("TAG", "junglebundlepass: " + name2)
                        bundle.putBoolean("beachdestination", true)
                        mFragmentforbeach.arguments = bundle
                        mFragmentTransactionforbeach.add(R.id.mapframe, mFragmentforbeach).commit()
                        Log.e("TAG", "warm destination bundle value: " + bundle)

                        Log.e("TAG", "onDataChangedbeach: " + name2)

                        Log.e(
                            "TAG",
                            "onDataChangewarmplacea: " + name2 + " " + rateing2 + " " + amounnt2 + " " + info2
                        )
                    }

                    override fun onCancelled(error: DatabaseError) {

                    }


                })
        }
        else if (key != null && intent.hasExtra("culturalsite")) {
//            for cultural sites
            firebaseDatabase = FirebaseDatabase.getInstance().reference
            val beachvalue = intent.getStringExtra("name").toString()
            Log.e("TAG", "culturalsitevalue: " + beachvalue)

            firebaseDatabase.child("culturalsites").child(beachvalue).child("details")
                .addValueEventListener(object : ValueEventListener {
                    override fun onDataChange(snapshot: DataSnapshot) {
                        var image3 = snapshot.child("image").value.toString()
                        var name3 = snapshot.child("name").value.toString()
                        var rateing3 = snapshot.child("rateing").value.toString()
                        var amounnt3 = snapshot.child("amount").value.toString()
                        var info3 = snapshot.child("info").value.toString()

                        val mFragmentManagertemple = supportFragmentManager
                        val mFragmentTransactiontemple = mFragmentManagertemple.beginTransaction()
                        val mFragmenttemple = GoogleMapsFragment()

                        Log.e("TAG", "onDataChangewarmdestination: " + name3)

                        Glide.with(this@DisplayplaceActivity).load(image3)
                            .placeholder(R.drawable.defalutimage).into(binding.imgplaceimage)
                        binding.txtplacename.text = name3
                        binding.txtrateing.text = rateing3
                        binding.txtfragamount.text = amounnt3
                        binding.txtabouttheplace.text = info3

                        val bundle = Bundle()
                        bundle.putString("name", name3)
                        Log.e("TAG", "templebundlepass: " + name3)
                        bundle.putBoolean("culturalsite", true)
                        mFragmenttemple.arguments = bundle
                        mFragmentTransactiontemple.add(R.id.mapframe, mFragmenttemple).commit()

                        Log.e("TAG", "temple destination bundle value: " + bundle)

                        Log.e("TAG", "onDataChangedtemple: " + name3)


                        Log.e(
                            "TAG",
                            "onDataChangewarmplacea: " + name3 + " " + rateing3 + " " + amounnt3 + " " + info3
                        )

                    }

                    override fun onCancelled(error: DatabaseError) {
                        TODO("Not yet implemented")
                    }

                })


        }
    }

    private fun hotel() {

    }

    private fun loadingmap() {
        supportFragmentManager.beginTransaction().replace(R.id.mapframe, GoogleMapsFragment())
            .commit()

    }

    private fun payment() {
        binding.txtaddtocart.setOnClickListener {
            // on below line we are getting
            // amount that is entered by user.
            val samount = 5000

            // rounding off the amount.
            val amount = Math.round(samount.toFloat() * 100)

            // initialize Razorpay account.
            val checkout = Checkout()

            // set your id as below
            checkout.setKeyID("rzp_test_fxJGVKoODm36ZT")

            // set image
//                checkout.setImage(R.drawable.)

            // initialize json object
            val `object` = JSONObject()
            try {
                // to put name
                `object`.put("name", "Tour Package ")

                // put description
                `object`.put("description", "Package Payment")

                // to set theme color
                `object`.put("theme.color", "")

                // put the currency
                `object`.put("currency", "INR")

                // put amount
                `object`.put("amount", amount)

                // put mobile number
                `object`.put("prefill.contact", "9284064503")

                // put email
                `object`.put("prefill.email", "akshaypatel@gmail.com")

                // open razorpay to checkout activity
                checkout.open(this@DisplayplaceActivity, `object`)
            } catch (e: JSONException) {
                e.printStackTrace()
            }
        }
    }

    fun onPaymentSuccess(p0: String?) {
        Toast.makeText(this, "Payment is Successfull", Toast.LENGTH_SHORT).show()
    }

    fun onPaymentError(p0: Int, p1: String?) {
        Toast.makeText(this, "Something went Wrong", Toast.LENGTH_SHORT).show()
    }


}
