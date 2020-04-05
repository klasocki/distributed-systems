package service.rest

import com.fasterxml.jackson.annotation.JsonIgnoreProperties


@JsonIgnoreProperties(ignoreUnknown = true)
class Quote(var en: String?, var author: String?, var id: String?, var _id: String?) {

    override fun toString(): String {
        return "'$en' ~ $author"
    }
}