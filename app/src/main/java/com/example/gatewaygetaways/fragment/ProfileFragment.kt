package com.example.gatewaygetaways.fragment

import android.content.Intent
import android.os.Bundle
import android.provider.MediaStore
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.example.gatewaygetaways.R
import com.example.gatewaygetaways.databinding.FragmentExploreBinding
import com.example.gatewaygetaways.databinding.FragmentProfileBinding


class ProfileFragment : Fragment() {
    lateinit var profileBinding: FragmentProfileBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        profileBinding = FragmentProfileBinding.inflate(layoutInflater,container,false)

        initview()

        return profileBinding.root
    }

    private fun initview() {


        // Pick Image Method
        profileBinding.imgcircleDP.setOnClickListener {
            val Gallery = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI)

        }

    }

//    var Gallery_Launcher = registerForActivityResult<Intent, ActivityResult>(
//        ActivityResultContracts.StartActivityForResult()
//    ) { result ->
//        if (result.resultCode == AppCompatActivity.RESULT_OK){
//            val data = result.data
//            val uri = data!!.data
//            profileBinding.displayimage.setImageURI(uri)
//        }
//    }


}