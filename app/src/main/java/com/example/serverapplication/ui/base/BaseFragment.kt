package com.example.serverapplication.ui.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.viewbinding.ViewBinding

abstract class BaseFragment<T : ViewBinding> : Fragment() {

    protected lateinit var binding: T
    abstract fun getViewBinding(): T

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = getViewBinding()
        return binding.root
    }

    protected fun navigateTo(resId: Int, bundle: Bundle? = null) {
        Navigation.findNavController(binding.root).navigate(resId, bundle)
    }

    protected fun backToPrevious() {
        activity?.onBackPressed()
    }

    protected fun showMessage(message: String) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }

}