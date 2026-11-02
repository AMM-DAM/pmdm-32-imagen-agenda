package com.pmdm.agenda.ui.features.components

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.painter.BitmapPainter
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImagePainter.State.Empty.painter
import com.pmdm.androidtemplate.R
import com.pmdm.androidtemplate.ui.theme.AndroidTemplateTheme

@Composable
fun ImagenContacto(
    modifier: Modifier = Modifier,
    foto: ImageBitmap?,
    anchoBorde : Dp = 4.dp
) {
    val imageBitmap = foto ?: ImageBitmap.imageResource(id = R.drawable.face_2_24px)
    val painter = remember(imageBitmap) { BitmapPainter(imageBitmap) }

    Image(
        painter = painter,
        contentScale = ContentScale.Crop,
        contentDescription = "Imagen contacto",
        modifier = Modifier.clip(CircleShape)
            .aspectRatio(1f)
            .background(MaterialTheme.colorScheme.surface)
            .border(
                width = anchoBorde,
                color = MaterialTheme.colorScheme.inversePrimary,
                shape = CircleShape
            )
    )
}

@Preview(showBackground = true, widthDp = 200, heightDp = 100 )
@Preview(showBackground = true, widthDp = 200, heightDp = 100,
         uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun ImagenContactoPreviewSinFoto() {
    val imagenResource = if(isSystemInDarkTheme()) R.drawable.bg_dark else R.drawable.bg_light
    Box(contentAlignment = Alignment.Center) {
        Image(
            painter = painterResource(id = imagenResource),
            contentDescription = "Imagen fondo",
            contentScale = ContentScale.FillBounds,
            modifier = Modifier.matchParentSize()
        )
        ImagenContacto(
            modifier = Modifier.fillMaxHeight(),
            foto = ImageBitmap.imageResource(R.drawable.foto_prueba),
        )
    }
}