package com.abreuhd.kuhakuapp.Controller.Scraping.WebPages.Cuevana

import android.util.Log
import com.abreuhd.kuhakuapp.Model.Servers.VideoServerTypeDataClass
import it.skrape.core.htmlDocument
import it.skrape.fetcher.BrowserFetcher
import it.skrape.fetcher.HttpFetcher
import it.skrape.fetcher.response
import it.skrape.fetcher.skrape
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.jsoup.nodes.Document
import org.jsoup.nodes.Element
import org.jsoup.select.Elements


class CuevanaGetMovieLinks(uri: String) {
    lateinit var webPage: Document
    var servers: List<VideoServerTypeDataClass> = emptyList()

    init {
        val scrapedData = skrape(HttpFetcher) {
            request {
                url = uri
            }
            response {
                webPage = htmlDocument {
                    document
                }
            }
        }
        val movieDocuments =
            webPage.select("#top-single > div.video.cont > ul > li > div:nth-child(2) > ul > li")
        movieDocuments.forEach { element ->
            val server = VideoServerTypeDataClass(
                "${ServerLang(element.attr("data-lang").toString())}",
                "${VideoLink(element.attr("data-tplayernv").toString(), webPage)}",
                "${ServerType(element.attr("data-server").toString())}"
            )
            servers = servers + server
        }

        Log.i("serverList", servers.toString())
    }

    private fun ServerLang(sv: String): String {
        val data = sv.toInt()
        return when (data) {
            48 -> "Latino"
            210 -> "Castellano"
            51 -> "Subtitulado"
            else -> "No Identificado"
        }
    }

    private fun VideoLink(tplayernv: String, element: Element): String {
        return element.select("#$tplayernv> iframe").attr("data-src").toString()
    }

    private fun ServerType(id: String): String {
        val data = id.toInt()
        return when (data) {
            101007 -> "Slmaxed"
            101009 -> "StreamSB"
            55625 -> "Google"
            54846 -> "Streamtape"
            28190 -> "Fembed"
            else -> "Server No Identificado"
        }
    }

//    fun getServers(): List<VideoServerTypeDataClass> {
//        return servers
//    }
}

