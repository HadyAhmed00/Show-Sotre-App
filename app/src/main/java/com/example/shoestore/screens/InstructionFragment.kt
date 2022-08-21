package com.example.shoestore.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.shoestore.R
import com.example.shoestore.databinding.FragmentInstructionBinding


class InstructionFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var binding : FragmentInstructionBinding= DataBindingUtil.inflate(
            layoutInflater, R.layout.fragment_instruction,
            container,false)
        binding.nextBtn.setOnClickListener{
            it.findNavController().navigate(R.id.action_instructionFragment_to_showListFragment)
        }
        return binding.root
    }

}