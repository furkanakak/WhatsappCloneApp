
object ConfigData {
    const val compileSdkVersion = 34
    const val minSdkVersion = 24
    const val targetSdkVersion = 34
    const val versionCode = 1
    const val versionName = "1.0"
}



object Versions {
    const val  retrofitVersion = "2.9.0"
    const val  interceptorVersion = "4.9.0"
    const val  lifecycle_version = "2.6.1"
    const val  coroutinesVersion = "1.7.2"
    const val  hiltVersion = "2.44"
    const val  hiltNavigationVersion = "1.0.0"
    const val  kotlinVersion = "1.6.1"
    const val  glideVersion = "1.6.1"
    const val  coreVersion = "1.7.0"
    const val  activityCompose = "1.3.1"
    const val  composeUiVersion = "1.2.0"
    const val  navigationVersion = "2.5.3"
    const val  ktorVersionVersion = "1.5.2"
    const val  crashlyticsVersion = "2.9.9"
    const val  materialVersion = "1.1.2"
    const val  pagerVersion = "0.20.3"
    const val  constraintlayoutComposeVersion = "1.0.1"

}

object Libs {


    //core
    const val core = "androidx.core:core-ktx:${Versions.coreVersion}"

    //compose
    const val activityCompose = "androidx.activity:activity-compose:${Versions.activityCompose}"
    const val composeUi = "androidx.compose.ui:ui:${Versions.composeUiVersion}"
    const val composeUiToolingPreview = "androidx.compose.ui:ui-tooling-preview:${Versions.composeUiVersion}"

    //material

    const val material = "androidx.compose.material3:material3:${Versions.materialVersion}"
    const val materialWindow = "androidx.compose.material3:material3-window-size-class:${Versions.materialVersion}"



    //test
    const val junit = "junit:junit:4.13.2"
    const val testExtJunit  = "androidx.test.ext:junit:1.1.5"
    const val espressoCore  = "androidx.test.espresso:espresso-core:3.5.1"
    const val composeUiTest   = "androidx.compose.ui:ui-test-junit4:${Versions.composeUiVersion}"
    const val composeUiTooling   = "androidx.compose.ui:ui-tooling:${Versions.composeUiVersion}"
    const val composeUiTestManifest   = "androidx.compose.ui:ui-test-manifest:${Versions.composeUiVersion}"

    //retrofit
    const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofitVersion}"
    const val retrofitConverter = "com.squareup.retrofit2:converter-gson:${Versions.retrofitVersion}"
    const val interceptor = "com.squareup.okhttp3:logging-interceptor:${Versions.interceptorVersion}"
    const val gson = "com.google.code.gson:gson:${Versions.retrofitVersion}"

    //lifecycle
    const val lifecycle = "androidx.lifecycle:lifecycle-runtime-compose:${Versions.lifecycle_version}"

    //coroutines
    const val coroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutinesVersion}"

    //hilt
    const val hiltAndroid = "com.google.dagger:hilt-android:${Versions.hiltVersion}"
    const val hiltCompiler = "com.google.dagger:hilt-android-compiler:${Versions.hiltVersion}"
    const val hiltNavigationCompose = "androidx.hilt:hilt-navigation-compose:${Versions.hiltNavigationVersion}"



    //Navigation
    const val navigation = "androidx.navigation:navigation-compose:${Versions.navigationVersion}"


    //kotlin
    const val kotlin = "androidx.fragment:fragment-ktx:${Versions.kotlinVersion}"

    //glide
    const val glide = "com.github.skydoves:landscapist-glide:${Versions.glideVersion}"

    //ktor
    const val ktorCore = "io.ktor:ktor-client-core:${Versions.ktorVersionVersion}"
    const val ktorCio = "io.ktor:ktor-client-cio:${Versions.ktorVersionVersion}"
    const val ktorOkhttp = "io.ktor:ktor-client-okhttp:${Versions.ktorVersionVersion}"
    const val ktorjson = "io.ktor:ktor-client-json:${Versions.ktorVersionVersion}"
    const val ktorJvm = "io.ktor:ktor-client-json-jvm:${Versions.ktorVersionVersion}"
    const val ktorLogging = "io.ktor:ktor-client-logging-jvm:${Versions.ktorVersionVersion}"
    const val ktorSerialization = "io.ktor:ktor-client-serialization:${Versions.ktorVersionVersion}"


    //crashlytics
    const val crashlytics = "com.google.firebase:firebase-crashlytics-buildtools:${Versions.crashlyticsVersion}"

    //constraintlayout
    const val constraintlayoutCompose = "androidx.constraintlayout:constraintlayout-compose:${Versions.constraintlayoutComposeVersion}"

    //icon
    const val icon = "androidx.compose.material:material-icons-extended:${Versions.composeUiVersion}"



}