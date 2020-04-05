package service.rest

import com.fasterxml.jackson.annotation.JsonIgnoreProperties


@JsonIgnoreProperties(ignoreUnknown = true)
class Lyrics(var lyrics: String?) {

    override fun toString(): String {
        return when {
            lyrics != null -> lyrics!!.replace("\n","</br>")
            else -> "Lyrics not found"
        }
    }
}