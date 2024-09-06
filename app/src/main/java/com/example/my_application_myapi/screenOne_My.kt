package com.example.my_application_myapi

import PostsViewModel
import android.app.admin.TargetUser
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import kotlinx.serialization.SerialName
import kotlinx.serialization.json.JsonNull.content


@Composable
fun ScreenOneContent_2(modifier: Modifier) {
    val postsViewModel: PostsViewModel = viewModel()
    LazyColumn(horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.spacedBy(16.dp, Alignment.CenterVertically), modifier = Modifier.fillMaxSize()) {
        item {
            if (postsViewModel.postsList==null) {
                CircularProgressIndicator()
            }
        }


        /*items(postsViewModel.postsList){ PostJsonMy ->
            PostItem(modifier = Modifier.fillMaxWidth(), daysUntil = PostJsonMy.daysUntil, followingProduction = PostJsonMy.followingProduction, id = PostJsonMy.id, posterUrl = PostJsonMy.posterUrl, title = PostJsonMy.title)
        }*/
        item{
            if (postsViewModel.postsList != null) {
                PostItem(modifier = Modifier.fillMaxWidth(), daysUntil = postsViewModel.postsList?.daysUntil!!, followingProduction = postsViewModel.postsList?.followingProduction!!, id = postsViewModel.postsList?.id!!, posterUrl = postsViewModel.postsList?.posterUrl!!, title = postsViewModel.postsList?.title!!)
            }
        }
    }
}
@Composable
fun PostItem(modifier: Modifier = Modifier,daysUntil:Int,followingProduction:FollowingProduction,id:Int,posterUrl:String,title:String ) {
//    val modifiedPicture = picture.replace("https://freefakeapi.io/api/", "https://www.freepik.com/free-vector/website-landing-page-with-abstract-design_2968527.htm#query=login%20background&position=11&from_view=keyword&track=ais_hybrid&uuid=49dc263d-6605-4f52-8cc2-c1f69b2480e1") // تعديل المسار مباشرةً هنا

    Card (modifier = Modifier) {
        Column(modifier.padding(8.dp), verticalArrangement = Arrangement.spacedBy(16.dp)) {
            Text(title, fontSize = 24.sp, fontWeight = FontWeight.Bold)
            Text(content, fontSize = 16.sp)
            AsyncImage(model = "https://img.freepik.com/free-vector/abstract-background-design-with-stars-blue_53876-59271.jpg?t=st=1725554749~exp=1725558349~hmac=fd6c91c85cc3e6f9f2cc8d394246ccbc320349334406e7ba885efa2e10f51c86&w=360", contentDescription = "", modifier = Modifier.size(150.dp))
            Text(text = "$daysUntil")
            Text(text = "$posterUrl")
            Text(text = "$title")


        }
    }
}
