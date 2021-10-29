package com.itaqhi.compose.shadow.ui.util

import android.os.Build
import android.view.View
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.viewinterop.AndroidView

/**
 * 当 API 低于 28 时，在 View 级关闭硬件加速，可能有更好的方式吧。。。
 */
@Composable
fun SoftSurface(
    content: @Composable () -> Unit
) {
    if (Build.VERSION.SDK_INT < Build.VERSION_CODES.P) {
        AndroidView(
            factory = { context ->
                ComposeView(context).apply {
                    setLayerType(View.LAYER_TYPE_SOFTWARE, null)
                    setContent(content)
                }
            },
            modifier = Modifier.fillMaxSize()
        )
    } else {
        content()
    }
}