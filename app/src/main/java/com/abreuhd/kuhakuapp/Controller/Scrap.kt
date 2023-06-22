package com.abreuhd.kuhakuapp.Controller

import android.util.Log
import com.abreuhd.kuhakuapp.Model.Movies.MovieDataClass
import it.skrape.core.htmlDocument
import it.skrape.fetcher.BrowserFetcher
import it.skrape.fetcher.response
import it.skrape.fetcher.skrape
import it.skrape.selects.html5.article
import it.skrape.selects.html5.div
import it.skrape.selects.html5.figure
import it.skrape.selects.html5.header
import it.skrape.selects.html5.img


class Scrap {
    fun getMovieDetails(uri: String): MovieDataClass {
        var tittle = ""
        var img = ""
        var description = ""
        val scrapedData = skrape(BrowserFetcher) {
            request {
                url = uri
            }.response {
                htmlDocument {
                    div {
                        div {
                            article {
                                div {
                                    figure {
                                        img = findFirst("img").attribute("src").toString()
                                    }
                                }
                                header {
                                    findFirst {
                                        tittle = text
                                    }
                                }
                                div {
                                    withClass = "Description"
                                    description = findLast().text
                                }
                            }
                        }
                    }
                }
            }
        }
        Log.i("crack", MovieDataClass(tittle,description,img,"202").toString())
        return MovieDataClass(tittle,description,img,"202")
    }

}