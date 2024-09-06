import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

import androidx.lifecycle.viewModelScope
import com.example.my_application_myapi.Post
import com.example.my_application_myapi.PostJsonMy
import com.example.my_application_myapi.PostsApi
import com.example.my_application_myapi.Provider
import io.ktor.client.call.body
import io.ktor.client.request.get
import kotlinx.coroutines.launch

/* Created by Taha https://github.com/tahaak67/ at 5/9/2024 */

class PostsViewModel: ViewModel() {

    private var postsApi: PostsApi = PostsApiImpl(Provider.client)

    var postsList by mutableStateOf<PostJsonMy?>(null)
        private set

    init {
        viewModelScope.launch {
            postsList = postsApi.getPosts()
        }
    }

    private fun modifyImagePath(originalPath: String): String {

        return originalPath.replace("https://freefakeapi.io/api/", "https://www.freepik.com/free-vector/website-landing-page-with-abstract-design_2968527.htm#query=login%20background&position=11&from_view=keyword&track=ais_hybrid&uuid=49dc263d-6605-4f52-8cc2-c1f69b2480e1")
    }


}