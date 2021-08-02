package com.example.fragapplication.ui.home

import android.graphics.drawable.ClipDrawable
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import com.example.fragapplication.MainActivityViewModel
import com.example.fragapplication.MovieModel
import com.example.fragapplication.MoviesAdapter
import com.example.fragapplication.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel
    private var _binding: FragmentHomeBinding? = null
    private lateinit var movieList: ArrayList<MovieModel>
    private lateinit var moviesAdapter: MoviesAdapter
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root
        val recyclerview = binding.mylist
        val itemDecor = DividerItemDecoration(activity, ClipDrawable.HORIZONTAL)
        recyclerview.addItemDecoration(itemDecor)
        moviesAdapter = MoviesAdapter(requireActivity())
        recyclerview.adapter = moviesAdapter
    //you can use a button for each method
        getAllMovies()
        createMovie()
        deleteMovie()
        updateMovie()
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


    private fun getAllMovies() {
        val viewModel: MainActivityViewModel =
            ViewModelProvider(this).get(MainActivityViewModel::class.java)
        viewModel.getLiveDataObserver().observe(viewLifecycleOwner, Observer {
            if (it != null) {
                moviesAdapter.setMovieList(it)
                Log.i("data", "" + it.size)
                moviesAdapter.notifyDataSetChanged()
            } else {
                Toast.makeText(activity, "Error in getting list", Toast.LENGTH_SHORT).show()
            }
        })
        viewModel.getAllMovies()
    }

    private fun createMovie() {
        val viewModel: MainActivityViewModel =
            ViewModelProvider(this).get(MainActivityViewModel::class.java)
        viewModel.getLiveDataObserver().observe(viewLifecycleOwner, Observer {
            if (it != null) {
                moviesAdapter.setMovieList(it)
                moviesAdapter.notifyDataSetChanged()
            } else {
                Toast.makeText(activity, "Error Creating Movie", Toast.LENGTH_SHORT).show()
            }
        })
        viewModel.createMovie()
    }

    private fun deleteMovie() {
        val viewModel: MainActivityViewModel =
            ViewModelProvider(this).get(MainActivityViewModel::class.java)
        viewModel.getLiveDataObserver().observe(viewLifecycleOwner, Observer {
            if (it != null) {
                moviesAdapter.setMovieList(it)
                moviesAdapter.notifyDataSetChanged()
            } else {
                Toast.makeText(activity, "Error Deleting Movie", Toast.LENGTH_SHORT).show()
            }
        })
        viewModel.deleteMovie()
    }

    private fun updateMovie() {
        val viewModel: MainActivityViewModel =
            ViewModelProvider(this).get(MainActivityViewModel::class.java)
        viewModel.getLiveDataObserver().observe(viewLifecycleOwner, Observer {
            if (it != null) {
                moviesAdapter.setMovieList(it)
                moviesAdapter.notifyDataSetChanged()
            } else {
                Toast.makeText(activity, "Error Updating Movie", Toast.LENGTH_SHORT).show()
            }
        })
        viewModel.updateMovie()
    }
}