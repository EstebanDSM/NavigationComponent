package com.example.android.navigation

import android.os.Bundle
import android.view.*
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.android.navigation.databinding.FragmentTitleBinding


/**
 * A simple [Fragment] subclass.
 *
 */
class TitleFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val binding: FragmentTitleBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_title, container, false)


        //The complete onClickListener with Navigation
        //        binding.playButton.setOnClickListener { view: View ->
        //            view.findNavController().navigate(R.id.action_titleFragment_to_gameFragment)
        //        }


        //The complete onClickListener with Navigation using createNavigateOnClickListener
        binding.playButton.setOnClickListener { view: View ->
            view.findNavController().navigate(TitleFragmentDirections.actionTitleFragmentToGameFragment()) }

        // We need to tell Android that our TitleFragment has a menu. In onCreateView call setHasOptionsMenu(true).
        setHasOptionsMenu(true)

        return binding.root
    }


    // We need to override onCreateOptionsMenu and inflate our new menu resource using the provided menu inflater and menu structure.
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.overflow_menu, menu)
    }

    // Finally, we need to override onOptionsItemSelected to connect it to our NavigationUI.
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(item, requireView().findNavController())
                || super.onOptionsItemSelected(item)
    }


}


