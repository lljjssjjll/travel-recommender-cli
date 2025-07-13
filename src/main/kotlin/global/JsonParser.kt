package global

import com.google.gson.Gson

object JsonParser {
    val gson = Gson()

    inline fun <reified T> fromJson(json: String): T {
        return gson.fromJson(json, T::class.java)
    }
}
