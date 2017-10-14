package com.aurora_visual.watchd.models


import org.json.JSONException
import org.json.JSONObject
import java.io.Serializable
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

/**
 * Created by admin on 14.10.17.
 */
class Category(categoryName: String) : Serializable {

    lateinit var name: String
        private set

    private lateinit var photoDate: String
    lateinit var humanDate: String
        private set
    lateinit var explanation: String
        private set
    lateinit var url: String
        private set

    init {
        try {
            name = categoryName
//            photoDate = photoJSON.getString(PHOTO_DATE)
//            humanDate = convertDateToHumanDate()
//            explanation = photoJSON.getString(PHOTO_EXPLANATION)
//            url = photoJSON.getString(PHOTO_URL)
        } catch (e: JSONException) {
            e.printStackTrace()
        }

    }

    private fun convertDateToHumanDate(): String {

        val dateFormat = SimpleDateFormat("yyyy-MM-dd")
        val humanDateFormat = SimpleDateFormat("dd MMMM yyyy")
        try {
            val parsedDateFormat = dateFormat.parse(photoDate)
            val cal = Calendar.getInstance()
            cal.time = parsedDateFormat
            return humanDateFormat.format(cal.time)
        } catch (e: ParseException) {
            e.printStackTrace()
            return ""
        }

    }

    companion object {
        private val NAME = "name"
        private val PHOTO_DATE = "date"
        private val PHOTO_EXPLANATION = "explanation"
        private val PHOTO_URL = "url"
    }
}
