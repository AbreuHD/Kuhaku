package com.abreuhd.kuhakuapp.View.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.abreuhd.kuhakuapp.Controller.API.API
import com.abreuhd.kuhakuapp.Controller.Scrap
import com.abreuhd.kuhakuapp.R
import com.abreuhd.kuhakuapp.databinding.ActivityDetailBinding
import com.squareup.picasso.Picasso
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class DetailActivity : AppCompatActivity() {

    companion object{
        const val ID_MOVIE = "id_movie"
    }

    private lateinit var binding : ActivityDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val id = intent.getLongExtra(ID_MOVIE, 1012801)



//        GlobalScope.launch(Dispatchers.IO) {
//            // Aquí realizas tu operación de red o llamada a skrape{it}
//
//            // Por ejemplo, puedes llamar a tu función Scrap.getMovieDetails()
//            var scrap = Scrap()
//            val data = scrap.getMovieDetails(uri)
//
//            runOnUiThread {
//                Picasso.get().load(data.img).into(binding.imageView)
//                binding.tvDescription.text = data.description
//                binding.tvTittle.text = data.tittle
//            }
//
//            // Actualiza la interfaz de usuario en el hilo principal utilizando launch(Dispatchers.Main)
//            launch(Dispatchers.Main) {
//                // Aquí actualizas la interfaz de usuario con los datos obtenidos
//            }
//        }

        val ioCoroutineScope = CoroutineScope(Dispatchers.IO)
        val mainCoroutineScope = CoroutineScope(Dispatchers.Main)
        ioCoroutineScope.launch {
            val data = API().getMovieByTMBDID(id)
            mainCoroutineScope.launch {
                Log.i("alv", data.toString())
                if (data != null) {
                    Picasso.get().load("https://image.tmdb.org/t/p/w500/${data.posterPath}").into(binding.imageView)
                    binding.tvDescription.text = data.overview
                    binding.tvTittle.text = data.title
                }

            }
        }

    }
}


