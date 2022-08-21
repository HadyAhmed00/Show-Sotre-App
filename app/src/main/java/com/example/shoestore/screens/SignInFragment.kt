package com.example.shoestore.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.shoestore.R
import com.example.shoestore.databinding.FragmentSignInBinding


class SignInFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val buinder : FragmentSignInBinding = DataBindingUtil.inflate(inflater,
            R.layout.fragment_sign_in,
        container,false)

        buinder.SignInBtn.setOnClickListener{
            // adding the navigation right here
            it.findNavController().navigate(R.id.action_signInFragment_to_welcomeFragment)

        }
        buinder.SignUpTxt.setOnClickListener{
            Toast.makeText(this.context,"We will go to the SignUp from here",Toast.LENGTH_SHORT).show()
        }


        return buinder.root
    }


}