package com.aurora_visual.watchd.models


import android.content.Context
import android.content.res.Resources
import com.aurora_visual.watchd.R
import org.json.JSONException
import java.io.Serializable
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

/**
 * Created by admin on 14.10.17.
 */
class Category(type: Enum<Categories>, res: Resources) : Serializable {

    lateinit var res: Resources
     var name: String? = null
        private set
        get() = this.title()
    lateinit var type: Enum<Categories>
        private set

    private lateinit var photoDate: String

    init {
        try {
            this.res = res
            this.type = type
//            photoDate = photoJSON.getString(PHOTO_DATE)
//            humanDate = convertDateToHumanDate()
//            explanation = photoJSON.getString(PHOTO_EXPLANATION)
//            url = photoJSON.getString(PHOTO_URL)
        } catch (e: JSONException) {
            e.printStackTrace()
        }

    }

    private fun title(): String {
        when (type) {
            Categories.MOVIES       -> { return res.getString(R.string.category_movies) }
            Categories.COLLECTIONS  -> { return res.getString(R.string.category_collections) }
            Categories.SERIES       -> { return res.getString(R.string.category_series) }
            Categories.PEOPLE       -> { return res.getString(R.string.category_people) }
        }

        return res.getString(R.string.unnamed_category)
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
        private val CATEGORY_MOVIES = "movies"
        private val CATEGORY_COLLECTIONS = "collections"
        private val CATEGORY_SERIES = "series"
        private val CATEGORY_PEOPLE = "people"
    }
}

enum class Categories { MOVIES, COLLECTIONS, SERIES, PEOPLE }
