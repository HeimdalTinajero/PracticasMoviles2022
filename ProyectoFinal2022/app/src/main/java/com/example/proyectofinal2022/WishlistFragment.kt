package com.example.proyectofinal2022

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.viewModels
import androidx.fragment.app.viewModels
import com.example.proyectofinal2022.databinding.FragmentWishlistBinding

class WishlistFragment : Fragment() {

    private val mainViewModel: MainViewModel by viewModels()
    private lateinit var binding : FragmentWishlistBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,

        savedInstanceState: Bundle?
    ): View? {

        Log.d("deq","Paso2")
        // Inflate the layout for this fragment
        mainViewModel.getUser()
        //viewLifecycleOwner en lugar de this para fragment


        mainViewModel.savedUsers.observe(viewLifecycleOwner, {usersList->
            if(!usersList.isNullOrEmpty()){
                for(user in usersList){
                    Log.d("deq",user.user_name)
                    binding.recyclerView.adapter=WishlistFragmentAdapter(usersList)
                }
            }else
                Log.d("deq","null or empty")
        })
        return inflater.inflate(R.layout.fragment_wishlist, container, false)
    }
}