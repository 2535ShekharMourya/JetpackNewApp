package com.example.mynewnewsapp.ui.presentation.component

import android.graphics.Paint.Style
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.compose.AsyncImagePainter.State.Empty.painter
import coil.request.ImageRequest
import com.example.mynewnewsapp.R
import com.example.mynewnewsapp.domain.model.Article
import com.example.mynewnewsapp.util.dateFormatter

@Composable
fun NewsArticleCard(
    modifier: Modifier = Modifier,
    article: Article,
    onCordClicked: (Article) -> Unit
) {
    val date=dateFormatter(article.publishedAt)
    Card(modifier = modifier.clickable { onCordClicked(article) })
    {
        Column(modifier = modifier.padding(12.dp)) {
          ImageHolder(imageUrl = article.urlToImage)
           Spacer(modifier = Modifier.height(8.dp))
            Text(text = article.title,
                style = MaterialTheme.typography.titleMedium,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
            Spacer(modifier = Modifier.height(8.dp))
            Row(
                modifier=Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = article.source.name ?:"",
                    style = MaterialTheme.typography.bodySmall
                )
                Text(
                    text = date,
                    style = MaterialTheme.typography.bodySmall
                )
            }

        }
    }

}
