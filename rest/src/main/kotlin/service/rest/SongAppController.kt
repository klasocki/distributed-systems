package service.rest

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.client.RestTemplate


@RestController
class SongAppController {
    val restTemplate = RestTemplate()

    @GetMapping("/error")
    fun error(): String{
        return "Trouble getting info, check the song and artist names"
    }

    @GetMapping("/songinfo")
    fun getSongInfo(@RequestParam(value = "artist_name", defaultValue = "ACDC") artist: String,
                    @RequestParam(value = "song_title", defaultValue = "Thunderstruck") song: String): String {
        val quote = restTemplate.getForObject(
                "https://programming-quotes-api.herokuapp.com/quotes/random",
                Quote::class.java
        )
        val artistSanitized = artist.replace("[?:/.]".toRegex(), "")
        val songSanitized = song.replace("[?:/.]".toRegex(), "")
        val lyrics = restTemplate.getForObject(
                "https://api.lyrics.ovh/v1/$artistSanitized/$songSanitized", Lyrics::class.java
        )
        val tabUri = "http://www.songsterr.com/a/wa/bestMatchForQueryString?s=$songSanitized&a=$artistSanitized&inst=%s"

        val events = restTemplate.getForObject(
                "https://app.ticketmaster.com/discovery/v2/events.json?keyword=$artistSanitized&countryCode=PL&apikey=${APIAuth.ticketmasterKey}",
                EventInfo::class.java)


        return template.format(
                quote,
                song,
                artist,
                tabUri.format("guitar"),
                tabUri.format("bass"),
                tabUri.format("drums"),
                events,
                lyrics
        )
    }

    val template = """
        <p>Programming quote of the day: <br/>%s</p>
        <p>Song: %s <br/> Artist: %s</p>
        <p>Tabs:<ul>
            <li><a href="%s" target="_blank">Guitar</a></li>
            <li><a href="%s" target="_blank">Bass</a></li>
            <li><a href="%s" target="_blank">Drums</a></li>
        </ul>
        <p>Upcoming events in Poland:<br/>%s</p>
        <p>Lyrics:<br/>%s</p>
    """.trimIndent()

}