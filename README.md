# ComposeShadow
Jetpack Compose 的阴影（Shadow）实现，支持颜色、偏移和模糊半径。

具体实现请查看 [Shadow.kt](./app/src/main/java/com/itaqhi/compose/shadow/ui/util/Shadow.kt)。

示例代码：
```kotlin
Box(
    modifier = Modifier
        .size(100.dp)
        .shadow(
            Shadow(
                Color(0xFFDFDFDF),
                Offset(0f, 6f),
                12f
            ),
            RoundedCornerShape(24f)
        )
        .background(
            Color.White,
            RoundedCornerShape(24f)
        )
)
```

> 注意：在 API 28 以下需要关闭硬件加速，如果您没有更好的方式，可以试试这个 [Surface.kt](./app/src/main/java/com/itaqhi/compose/shadow/ui/util/Surface.kt)。

# 截图

![Screenshot](./screenshot/screenshot.png "Screenshot.png")  
