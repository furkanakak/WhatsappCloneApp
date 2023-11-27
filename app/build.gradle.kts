plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
    id("dagger.hilt.android.plugin")
    id("com.google.dagger.hilt.android")
    id("org.jetbrains.kotlin.plugin.serialization").version("1.6.21")

}

android {
    namespace = "com.furkanakak.whatsappcloneapp"
    compileSdk = ConfigData.compileSdkVersion



    defaultConfig {
        applicationId = "com.furkanakak.whatsappcloneapp"
        minSdk =  ConfigData.minSdkVersion
        targetSdk = ConfigData.targetSdkVersion
        versionCode = ConfigData.versionCode
        versionName = ConfigData.versionName

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.2.0"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    implementation(Libs.core)
    implementation(Libs.activityCompose)
    implementation(Libs.composeUi)
    implementation(Libs.composeUiToolingPreview)
    implementation(Libs.material)
    implementation(Libs.materialWindow)
    testImplementation(Libs.junit)
    androidTestImplementation(Libs.testExtJunit)
    androidTestImplementation(Libs.espressoCore)
    androidTestImplementation(Libs.composeUiTest)
    debugImplementation(Libs.composeUiTooling)
    debugImplementation(Libs.composeUiTestManifest)


    //lifecycle
    implementation(Libs.lifecycle)

    //coroutines
    implementation(Libs.coroutines)

    //hilt
    implementation(Libs.hiltAndroid)
    kapt(Libs.hiltCompiler)
    implementation(Libs.hiltNavigationCompose)
    implementation(Libs.navigation)

    // Kotlin
    implementation(Libs.kotlin)

    //Glide
    implementation(Libs.glide)

    //Ktor
    implementation(Libs.ktorCore)
    implementation(Libs.ktorCio)
    implementation(Libs.ktorOkhttp)
    implementation(Libs.ktorjson)
    implementation(Libs.ktorJvm)
    implementation(Libs.ktorLogging)
    implementation(Libs.ktorSerialization)

    //crashlytics
    implementation(Libs.crashlytics)

    //constraintlayout
    implementation(Libs.constraintlayoutCompose)
    //icon
    implementation(Libs.icon)


}

kapt {
    correctErrorTypes = true
}