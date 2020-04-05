package service.rest

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(ignoreUnknown = true)
class EventInfo(var _embedded: Embedded?) {
    class Embedded(var events: List<Event>)

    override fun toString(): String {
        return if (_embedded != null)
         "<table><tr>" + _embedded!!.events.joinToString("</tr><tr>") + "</tr></table>"
        else "No upcoming concerts"
    }

}
