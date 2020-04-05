package service.rest

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.*


@JsonIgnoreProperties(ignoreUnknown = true)
class Event(var name: String, var url: String, var images: List<Image>, var dates: Dates, var _embedded: Embedded) {
    @JsonIgnoreProperties(ignoreUnknown = true)
    class Image(var url: String)
    @JsonIgnoreProperties(ignoreUnknown = true)
    class Dates(var start: Start, var status: Status){
        @JsonIgnoreProperties(ignoreUnknown = true)
        class Start(var dateTime: String?, var dateTBD: Boolean, var dateTBA: Boolean, var timeTBA: Boolean, var noSpecificTime: Boolean)
        @JsonIgnoreProperties(ignoreUnknown = true)
        class Status(var code: String)
    }
    @JsonIgnoreProperties(ignoreUnknown = true)
    class Embedded(var venues: List<Venue>){
        @JsonIgnoreProperties(ignoreUnknown = true)
        class Venue(var name: String, var city: City){
            @JsonIgnoreProperties(ignoreUnknown = true)
            class City(var name: String)
        }
    }

    override fun toString(): String {
        val isDateAnnounced = !dates.start.dateTBA and !dates.start.dateTBD and !dates.start.timeTBA and !dates.start.noSpecificTime
        val dateString = if (isDateAnnounced) {
            val inputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.ENGLISH)
            val outputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm", Locale.ENGLISH)
            val date = LocalDateTime.parse(dates.start.dateTime, inputFormatter)
            outputFormatter.format(date)
        } else "Date TBA"

        val venue = if (_embedded.venues.isNotEmpty()) _embedded.venues[0].name + ", " + _embedded.venues[0].city.name else "Venue TBA"
        val info = "$name, $dateString, $venue"
        val message = if (dates.status.code == "onsale") "Hurry up, tickets are on sale already! " else "Tickets not sold currently. "
        val link = "Check <a href=$url target=_blank>here</a>"
        val image = if (images.isNotEmpty()) "<img src=\"${images[0].url}\" height=\"100\" width=\"150\"/>" else ""
        return "<td>$image</td><td>$info <br/>$message$link</td> "
    }

}
