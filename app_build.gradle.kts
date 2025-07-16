plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.nithish.quoteofday"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.nithish.quoteofday"
        minSdk = 21
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"
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
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    kotlinOptions {
        jvmTarget = "17"
    }

    buildFeatures {
        viewBinding = true
    }
}

dependencies {
    val mainCore = "androidx.core:core-ktx:1.12.0"
    val uiCompat = "androidx.appcompat:appcompat:1.6.1"
    val materialDesignLib = "com.google.android.material:material:1.10.0"
    val constraintStuff = "androidx.constraintlayout:constraintlayout:2.1.4"
    val testBase = "junit:junit:4.13.2"
    val androidJUnit = "androidx.test.ext:junit:1.1.5"
    val espressoTestLib = "androidx.test.espresso:espresso-core:3.5.1"

    implementation(mainCore)
    implementation(uiCompat)
    implementation(materialDesignLib)
    implementation(constraintStuff)

    testImplementation(testBase)
    androidTestImplementation(androidJUnit)
    androidTestImplementation(espressoTestLib)
}
