package com.abreuhd.kuhakuapp.Controller.Scraping

import com.abreuhd.kuhakuapp.Controller.Scraping.WebPages.Cuevana.CuevanaGetMovieLinks
import com.abreuhd.kuhakuapp.Model.Servers.VideoServerTypeDataClass


class Scrap {
    lateinit var dataLinks: List<VideoServerTypeDataClass>

    suspend fun ScrapSelect(link: String): List<VideoServerTypeDataClass> {
        if(link.contains("cuevana3.ai")){
            dataLinks = CuevanaGetMovieLinks(link).servers
            return dataLinks
        }
        return dataLinks
    }

}