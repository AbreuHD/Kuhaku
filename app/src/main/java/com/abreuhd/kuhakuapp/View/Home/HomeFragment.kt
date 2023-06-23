package com.abreuhd.kuhakuapp.View.Home

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.abreuhd.kuhakuapp.Controller.API.API
import com.abreuhd.kuhakuapp.Controller.Adapters.SearchView.SearchViewAdapter
import com.abreuhd.kuhakuapp.View.detail.DetailActivity
import com.abreuhd.kuhakuapp.View.detail.DetailActivity.Companion.ID_MOVIE
import com.abreuhd.kuhakuapp.databinding.FragmentHomeBinding
import com.google.android.material.snackbar.Snackbar
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    private lateinit var searchAdapter: SearchViewAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)

        getAllSearchMovies("")
        binding.searchView.editText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                //nah
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                getAllSearchMovies(s.toString())
            }

            override fun afterTextChanged(s: Editable?) {
                //nah
            }
        })


        searchAdapter = SearchViewAdapter {
            getSnackBar(it)
        }
        binding.rvMovieSearch.setHasFixedSize(true)
        binding.rvMovieSearch.layoutManager = LinearLayoutManager(context)
        binding.rvMovieSearch.adapter = searchAdapter




        val root: View = binding.root
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    fun getAllSearchMovies(name: String) {
        val ioCoroutineScope = CoroutineScope(Dispatchers.IO)
        val mainCoroutineScope = CoroutineScope(Dispatchers.Main)

        ioCoroutineScope.launch {
            val data = API().getMovieList(name)
            mainCoroutineScope.launch {
                Log.i("alv", data.toString())
                if (data != null) {
                    searchAdapter.onUpdateList(data)
                }

            }
        }
        //ioCoroutineScope.cancel()

    }

    fun getSnackBar(id: Long){
//        val snackbar = Snackbar.make(requireView(), "El id es ${id}", Snackbar.LENGTH_LONG)
//        snackbar.setAction("Botón", View.OnClickListener {
//            snackbar.dismiss() // Oculta el Snackbar al hacer clic en el botón
//        })
//        snackbar.show()
        val intent = Intent(requireContext(), DetailActivity::class.java)
        intent.putExtra(ID_MOVIE, id)
        startActivity(intent)
    }

}