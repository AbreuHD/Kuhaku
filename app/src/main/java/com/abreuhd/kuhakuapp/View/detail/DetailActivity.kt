package com.abreuhd.kuhakuapp.View.detail

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import androidx.appcompat.app.AlertDialog
import androidx.core.view.isVisible
import com.abreuhd.kuhakuapp.Controller.API.API
import com.abreuhd.kuhakuapp.Controller.Scraping.Scrap
import com.abreuhd.kuhakuapp.Model.Movies.MovieDetail
import com.abreuhd.kuhakuapp.Model.Servers.VideoServerTypeDataClass
import com.abreuhd.kuhakuapp.databinding.ActivityDetailBinding
import com.google.android.material.snackbar.Snackbar
import com.squareup.picasso.Picasso
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DetailActivity : AppCompatActivity() {

    companion object {
        const val ID_MOVIE = "id_movie"
    }

    private lateinit var snackbar: Snackbar
    private lateinit var data: MovieDetail
    private lateinit var binding: ActivityDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val id = intent.getLongExtra(ID_MOVIE, 1012801)



        binding.btnPlay.setOnClickListener {

            val webPageTitle = data.movieLinks.map { it.link.subSequence(11, 19) }
            val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, webPageTitle)
            val builder = AlertDialog.Builder(this)
                .setTitle("Pagina base")
                .setAdapter(adapter) { dialog: DialogInterface, which: Int ->
                    binding.btnPlay.text = "Cargando links..."
                    binding.btnPlay.isEnabled = false
                    binding.progressBar.isVisible = true
                    CoroutineScope(Dispatchers.IO).launch {
                        val data = Scrap().ScrapSelect(data.movieLinks[which].link)
                        runOnUiThread{

                            serverSelect(data)
                        }
                    }

                }
                .setNegativeButton("Cancel") { dialog: DialogInterface, _ ->
                    binding.progressBar.isVisible = false
                    binding.btnPlay.text = "Reproducir"
                    binding.btnPlay.isEnabled = true
                    dialog.dismiss()
                }

            builder.create().show()

        }


        val ioCoroutineScope = CoroutineScope(Dispatchers.IO)
        val mainCoroutineScope = CoroutineScope(Dispatchers.Main)
        ioCoroutineScope.launch {
            data = API().getMovieByTMBDID(id)!!
            mainCoroutineScope.launch {
                Log.i("alv", data.toString())
                if (data != null) {
                    Picasso.get().load("https://image.tmdb.org/t/p/w500/${data.posterPath}")
                        .into(binding.imageView)
                    binding.tvDescription.text = data.overview
                    binding.tvTittle.text = data.title
                }

            }
        }
    }

    fun serverSelect(svList: List<VideoServerTypeDataClass>) {
        binding.progressBar.isVisible = false
        binding.btnPlay.text = "Reproducir"
        binding.btnPlay.isEnabled = true
        val serverVideoList = svList.map { "${it.Language} | ${it.Type}"  }
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, serverVideoList)
        val builder = AlertDialog.Builder(this)
            .setTitle("Selecciona el servidor")
            .setAdapter(adapter) { dialog: DialogInterface, which: Int ->
                showSnackbar(svList[which].Link)
            }
            .setNegativeButton("Cancel") { dialog: DialogInterface, _ ->
                dialog.dismiss()
            }
        builder.create().show()

    }

    private fun showSnackbar(message: String) {
        snackbar = Snackbar.make(binding.root, message, Snackbar.LENGTH_LONG)
            .setAction("Cerrar") {
                snackbar.dismiss()
            }

        snackbar.show()
    }
}


