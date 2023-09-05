package com.abreuhd.kuhakuapp.Controller.Scraping.VideoSource.Common.Slmaxed

import android.util.Log
import it.skrape.core.htmlDocument
import it.skrape.fetcher.BrowserFetcher
import it.skrape.fetcher.HttpFetcher
import it.skrape.fetcher.response
import it.skrape.fetcher.skrape
import org.jsoup.nodes.Document

class SlmaxedSkip {
    lateinit var webPage: Document
    fun Skip(uri: String): String {
        val scrapedData = skrape(BrowserFetcher) {
            request {
                url = uri
            }
            response {
                webPage = htmlDocument {
                    document
                }
            }
        }
        Log.i("htmlparse", webPage.location().toString())
        Log.i("htmlparse", webPage.html())
        return webPage.select("#player > div.jw-wrapper.jw-reset > div.jw-media.jw-reset > video")
            .attr("src").toString()
    }

}