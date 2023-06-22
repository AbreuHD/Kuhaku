package com.abreuhd.kuhakuapp.View.Home

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import androidx.fragment.app.Fragment
import com.abreuhd.kuhakuapp.Controller.API.API
import com.abreuhd.kuhakuapp.View.detail.DetailActivity
import com.abreuhd.kuhakuapp.View.detail.DetailActivity.Companion.URL_SCRAPING
import com.abreuhd.kuhakuapp.databinding.FragmentHomeBinding
import com.google.android.material.search.SearchView
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)

        binding.searchView.editText.setOnEditorActionListener { _, actionId, _ ->
            if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                val query = binding.searchView.editText.text.toString()
                val intent = Intent(requireContext(), DetailActivity::class.java)
                intent.putExtra(URL_SCRAPING, query)
                startActivity(intent)
                true
            } else {
                false
            }
        }
        getAllMovies()


        val root: View = binding.root
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    fun getAllMovies() {
        val ioCoroutineScope = CoroutineScope(Dispatchers.IO)
        val mainCoroutineScope = CoroutineScope(Dispatchers.Main)

        ioCoroutineScope.launch {
            val data = API().getMovieList()
            mainCoroutineScope.launch {
                Log.i("alv", data.toString())

            }
        }
        //ioCoroutineScope.cancel()

    }

}