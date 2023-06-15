package com.example.gatewaygetaways.activity

import android.content.Intent
import android.content.SharedPreferences
import android.content.pm.PackageInfo
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.example.gatewaygetaways.*
import com.example.gatewaygetaways.databinding.ActivityDashboardBinding
import com.example.gatewaygetaways.fragment.BookingFragment
import com.example.gatewaygetaways.fragment.ExploreFragment
import com.example.gatewaygetaways.fragment.ProfileFragment
import com.example.gatewaygetaways.fragment.WishlistFragment
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.material.navigation.NavigationBarView
import com.google.android.material.navigation.NavigationView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference

class DashboardActivity : AppCompatActivity() {
    lateinit var dashboardBinding: ActivityDashboardBinding
    lateinit var storageReference: StorageReference
    lateinit var firebaseDatabase: FirebaseDatabase
    lateinit var auth: FirebaseAuth
    lateinit var storage: FirebaseStorage
    lateinit var toggle: ActionBarDrawerToggle
    lateinit var googleSignInClient: GoogleSignInClient

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dashboardBinding = ActivityDashboardBinding.inflate(layoutInflater)
        setContentView(dashboardBinding.root)

        storage = FirebaseStorage.getInstance()
        auth = FirebaseAuth.getInstance()
        storageReference = storage.getReference()

        initview()
    }

    private fun initview() {
        firebaseDatabase = FirebaseDatabase.getInstance()


        dashboardBinding.drawermenu.setOnClickListener {
            dashboardBinding.navigationdrawer.openDrawer(GravityCompat.START)
        }

        dashboardBinding.imgsearchbtn.setOnClickListener {
            val intent = Intent(this, SearchActivity::class.java)

            startActivity(intent)
        }

        dashboardBinding.btnlogout.setOnClickListener {
            var sharedPreferences = getSharedPreferences("MySharePref", MODE_PRIVATE)
            var myEdit: SharedPreferences.Editor = sharedPreferences.edit()
            myEdit.remove("isLogin")
            myEdit.commit()
            var intent = Intent(this, TypesOfLoginActivity::class.java)
            startActivity(intent)

        }

        // google logout
        // Initialize sign in client
        googleSignInClient =
            GoogleSignIn.getClient(this@DashboardActivity, GoogleSignInOptions.DEFAULT_SIGN_IN)
        dashboardBinding.txtlogoutGoogle.setOnClickListener {
            // Sign out from google
            googleSignInClient.signOut().addOnCompleteListener { task ->
                // Check condition
                if (task.isSuccessful) {
                    // When task is successful sign out from firebase
                    auth.signOut()
                    // Display Toast
                    Toast.makeText(applicationContext, "Logout successful", Toast.LENGTH_SHORT)
                        .show()
                    // Finish activity
                    finish()
                }
            }
        }

        val pack: PackageManager =packageManager
        val info: PackageInfo =pack.getPackageInfo(packageName,0)
        val version: String=info.versionName
        dashboardBinding.txtversion.text=version

        loadFragment(ExploreFragment())
        dashboardBinding.bottomNavigationView.setOnItemSelectedListener(object : NavigationView.OnNavigationItemSelectedListener, NavigationBarView.OnItemSelectedListener {

            override fun onNavigationItemSelected(item: MenuItem): Boolean {
                lateinit var fragment: Fragment
                when (item.itemId) {
                    R.id.explore_bottom -> {
                        fragment = ExploreFragment()
                        loadFragment(fragment)
                    }
                    R.id.booking_bottom -> {
                        fragment = BookingFragment()
                        loadFragment(fragment)
                    }
                    R.id.wishlist_bottom -> {
                        fragment = WishlistFragment()
                        loadFragment(fragment)
                    }
                    R.id.profile_bottom -> {
                        fragment = ProfileFragment()
                        loadFragment(fragment)
                    }
                }
                return true
            }
        })

    }

    private fun loadFragment(frag: Fragment) {

        val fm : FragmentManager = supportFragmentManager
        val fragmentTransaction : FragmentTransaction = fm.beginTransaction()
        fragmentTransaction.replace(R.id.frameLayout,frag)
        fragmentTransaction.commit()
    }


}
