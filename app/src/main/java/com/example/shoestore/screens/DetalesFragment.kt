package com.example.shoestore.screens

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.shoestore.R
import com.example.shoestore.data.Show
import com.example.shoestore.databinding.FragmentDetalesBinding
import com.example.shoestore.models.MainViewModel
import kotlin.random.Random


class DetalesFragment : Fragment() {

    lateinit var buinding : FragmentDetalesBinding
    val viewMode : MainViewModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        buinding  = DataBindingUtil.inflate(layoutInflater,
            R.layout.fragment_detales,container,false)

        buinding.lifecycleOwner = this

        buinding.saveBtn.setOnClickListener{
            val a : Int = Random(5).nextInt()
            val tmpShow = Show( buinding.nameEditTxt.text.toString(),
                            buinding.componyEditTxt.text.toString(),
                            buinding.sizeEditTxt.text.toString(),
                            buinding.descriptionEditTxt.text.toString(),a)

            if(!tmpShow.isOk())
            {
                viewMode.addShow(tmpShow)
                findNavController().navigateUp()
            }else{
                Toast.makeText(this.context,"Pleas fill All the fields",Toast.LENGTH_SHORT).show()
            }

        }

        buinding.cancelBtn.setOnClickListener{
            findNavController().navigateUp()
        }
        return buinding.root
    }


}