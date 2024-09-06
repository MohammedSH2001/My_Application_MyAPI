import android.util.Log
import com.example.my_application_myapi.Post
import com.example.my_application_myapi.PostJsonMy
import com.example.my_application_myapi.PostsApi
import com.example.my_application_myapi.Routes
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.plugins.ClientRequestException
import io.ktor.client.plugins.RedirectResponseException
import io.ktor.client.plugins.ServerResponseException
import io.ktor.client.request.*
import okhttp3.Route

/**
 * Created by Taha Ben Ashur (https://github.com/tahaak67) on 04,Feb,2023
 */
class PostsApiImpl(
    private val client: HttpClient
): PostsApi {

    override suspend fun getPosts(): PostJsonMy? {
        return try {
            client.get {
                url("https://www.whenisthenextmcufilm.com/api")
            }.body()
        } catch (e: RedirectResponseException) {
            Log.e("PostsApi", "3XX Error: ${e.message}")
            null
        } catch (e: ClientRequestException) {
            Log.e("PostsApi", "4XX Error: ${e.message}")
           null
        } catch (e: ServerResponseException) {
            Log.e("PostsApi", "5XX Error: ${e.message}")
            null
        } catch (e: Exception) {
            Log.e("PostsApi", "Error: ${e.message}")
            null
        }
    }
}