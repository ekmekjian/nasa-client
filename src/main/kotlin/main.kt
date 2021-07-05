import androidx.compose.desktop.Window
import androidx.compose.material.Text
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import io.ktor.application.*
import io.ktor.response.*
import io.ktor.request.*
import io.ktor.client.*
import io.ktor.client.engine.apache.*
import io.ktor.client.features.auth.*
import io.ktor.client.features.json.*
import io.ktor.client.request.*
import kotlinx.coroutines.*
import io.ktor.client.features.logging.*
import io.ktor.http.*
import org.apache.http.HttpHost

suspend fun main() = Window {
    var text by remember { mutableStateOf("Hello, World!") }

    MaterialTheme {
        Button(onClick = {
            text = "Hello, Desktop!"
        }) {
            Text(text)
        }
    }
}
// Example below is a working test of a client call
/*
@Suppress("unused") // Referenced in application.conf
@kotlin.jvm.JvmOverloads
suspend fun main(args: Array<String>) {
    val client = HttpClient(Apache) {
        install(Auth) {
        }
        install(JsonFeature) {
            serializer = GsonSerializer()
        }
        install(Logging) {
            level = LogLevel.HEADERS
        }
        engine {
            followRedirects = true

        }
    }
    val apiKey = "5w6eph1LxKx9CbX1WHenSctAlY0cMS5vRcuctE8R"


        val test: List<APOReturn> = client.get{
            url("https://api.nasa.gov/planetary/apod")
            parameter("api_key",apiKey)
            parameter("count",5)
            contentType(ContentType.Application.Json)
        }
    print(test[0].title)
    }

data class APOReturn(val resource:String, val concept_tags:Boolean,val title:String,val date:String,
                     val url:String,val hdurl:String,val media_type:String,val explanation:String,
                     val concepts:String,val thumbnail:String,val copyright:String,val service_version:String)
 */