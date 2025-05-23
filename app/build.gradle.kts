plugins {
    alias(libs.plugins.android.application)
}

android {
    namespace = "com.example.mad_prac2"
    compileSdk = 35 // Use a stable version

    defaultConfig {
        applicationId = "com.example.mad_prac2"
        minSdk = 24
        targetSdk=34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
}

dependencies {
    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)

        implementation("com.google.android.gms:play-services-location:21.0.1")

    implementation("com.google.maps.android:android-maps-utils:2.2.3")
    implementation ("com.squareup.retrofit2:retrofit:2.9.0")
    implementation ("com.squareup.retrofit2:converter-gson:2.9.0")
    implementation(libs.play.services.maps)

    // REMOVED the circular dependency on ":app"

    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)
}
