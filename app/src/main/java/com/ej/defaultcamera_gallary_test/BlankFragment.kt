package com.ej.defaultcamera_gallary_test

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.ej.defaultcamera_gallary_test.databinding.FragmentBlankBinding


class BlankFragment : Fragment() {
    lateinit var binding : FragmentBlankBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding =  DataBindingUtil.inflate(inflater,R.layout.fragment_blank,container,false)
        binding.lifecycleOwner = this.viewLifecycleOwner
        return binding.root
    }

    companion object {

        @JvmStatic
        fun newInstance() =
            BlankFragment()
    }
}