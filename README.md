# MediaRecyclerView
[![](https://jitpack.io/v/zacdevil10/MediaRecyclerView.svg)](https://jitpack.io/#zacdevil10/MediaRecyclerView)

<img src="/assets/sample.png" width="512">

A dynamic image grid for displaying upto 4 images.

## Gradle
```groovy
repositories {
    maven { url 'https://jitpack.io' }
}

dependencies {
    implementation 'com.github.zacdevil10:MediaRecyclerView:version'
}
```

## Using It
Add MediaRecyclerView as your would a standard View in Android. Currently the height must be set both in xml and programmatically.

```xml
<uk.co.zac_h.mediarecyclerview.ui.MediaRecyclerView
    android:id="@+id/media_recycler_view"
    android:layout_width="match_parent"
    android:layout_height="wrap_content" />
```

```kotlin
val mediaRecyclerView: MediaRecyclerView = findViewById(R.id.media_recycler_view)

//Add as many media models to an array as you want. Only the first 4 will be shown but the rest can be seen in the photo viewer.
//NOTE: In the latest version using MediaType.VIDEO will not show anything but this will be implemented in a future release.
val mediaImage = MediaModel(mediaUrl, MediaType.IMAGE)
val mediaVideo = MediaModel(mediaUrl, MediaType.VIDEO, staticImageUrl)

//MediaRecyclerView accepts image urls as ArrayList<MediaModel>.
mediaRecyclerView.configure(context, media)
//or if you change the height and margin of the MediaRecyclerView
mediaRecyclerView.apply {
    height(height in dp)
    setMargin(margin in px)
    configure(context, media)
}
```

If using the video playback functionality of this library you will need to add the following to your apps build.gradle file:
```groovy
android {
    [...]
    compileOptions {
        targetCompatibility JavaVersion.VERSION_1_8
    }
}
