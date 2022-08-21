package com.example.shoestore.screens

import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.shoestore.R
import com.example.shoestore.data.Show
import com.example.shoestore.databinding.FragmentShowListBinding
import com.example.shoestore.databinding.ListItemBinding
import com.example.shoestore.models.MainViewModel
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty


class ShowListFragment : Fragment() {
    lateinit var  buinding: FragmentShowListBinding
     val viewModel : MainViewModel by activityViewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        buinding  = DataBindingUtil.inflate(
            layoutInflater,
            R.layout.fragment_show_list,
            container,
            false)

        // Menu Enabling
        setHasOptionsMenu(true)

        viewModel.show.observe(viewLifecycleOwner, Observer { showList ->
            shoeListView(showList)
        })

        buinding.addBtn.setOnClickListener{
            it.findNavController().navigate(R.id.action_showListFragment_to_detalesFragment)
        }

        return buinding.root
    }

    /**
     * Fill the Liner Layout and inflate the Card to View*/
    private fun shoeListView(item: MutableList<Show>?){
        item?.forEach {
            val bindingView=ListItemBinding.inflate(LayoutInflater.from(requireContext()),buinding.myList,false)
            with(bindingView){
                nameTxtShow.text=it.name
                sizeShow.text=it.size
                componyTxtShow.text=it.company
                discriptionShew.text=it.description


                when(it.image){
                    1->shoeImge.setBackgroundColor(R.drawable.ic_shoe_1)
                    2->shoeImge.setBackgroundColor(R.drawable.ic_shoe_2)
                    3->shoeImge.setBackgroundColor(R.drawable.ic_shoe_3)
                    4->shoeImge.setBackgroundColor(R.drawable.ic_shoe_4)
                    5->shoeImge.setBackgroundColor(R.drawable.ic_shoe_5)

                }
            }
            buinding.myList.addView(bindingView.root)
        }
    }


    /**
     * Menu Function */
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.main_menu, menu)
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(item, requireView().findNavController())
                || super.onOptionsItemSelected(item)
    }
}
