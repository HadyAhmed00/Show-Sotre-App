package com.example.shoestore.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.shoestore.R
import com.example.shoestore.databinding.FragmentWelcomeBinding


class WelcomeFragment : Fragment() {



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val buinding : FragmentWelcomeBinding=DataBindingUtil.inflate(inflater,
            R.layout.fragment_welcome,
            container,false)

        buinding.letsBtn.setOnClickListener{
            it.findNavController().navigate(R.id.action_welcomeFragment_to_instructionFragment)
//            Toast.makeText(this.context,"next Act",Toast.LENGTH_SHORT).show()

        }

        return buinding.root
    }

}