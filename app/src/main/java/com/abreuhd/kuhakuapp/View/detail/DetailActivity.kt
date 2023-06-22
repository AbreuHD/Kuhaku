package com.abreuhd.kuhakuapp.View.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.abreuhd.kuhakuapp.Controller.Scrap
import com.abreuhd.kuhakuapp.R
import com.abreuhd.kuhakuapp.databinding.ActivityDetailBinding
import com.squareup.picasso.Picasso
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class DetailActivity : AppCompatActivity() {

    companion object{
        const val URL_SCRAPING = "url_scraping"
    }

    private lateinit var binding : ActivityDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val uri = intent.getStringExtra(URL_SCRAPING).orEmpty()


        GlobalScope.launch(Dispatchers.IO) {
            // Aquí realizas tu operación de red o llamada a skrape{it}

            // Por ejemplo, puedes llamar a tu función Scrap.getMovieDetails()
            var scrap = Scrap()
            val data = scrap.getMovieDetails(uri)

            runOnUiThread {
                Picasso.get().load(data.img).into(binding.imageView)
                binding.tvDescription.text = data.description
                binding.tvTittle.text = data.tittle
            }

            // Actualiza la interfaz de usuario en el hilo principal utilizando launch(Dispatchers.Main)
            launch(Dispatchers.Main) {
                // Aquí actualizas la interfaz de usuario con los datos obtenidos
            }
        }

    }
}