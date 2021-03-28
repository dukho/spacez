plugins {
    id("com.android.library")
    id("kotlin-android")
    id("kotlin-kapt")
}

android {
    compileSdkVersion(AppConfig.compileSdkVersion)
    buildToolsVersion(AppConfig.buildToolsVersion)

    defaultConfig {
        minSdkVersion(AppConfig.minSdkVersion)
        targetSdkVersion(AppConfig.targetSdkVersion)
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildFeatures {
        dataBinding = true
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {
    api("org.jetbrains.kotlin:kotlin-stdlib:${Versions.kotlinVersion}")
    api("androidx.core:core-ktx:${Versions.ktxVersion}")
    api("androidx.appcompat:appcompat:${Versions.androidxVersion}")
    api("com.google.android.material:material:1.2.1")
    api("androidx.constraintlayout:constraintlayout:2.0.4")
    api("androidx.lifecycle:lifecycle-common-java8:${Versions.archLifecycleVersion}")
    api("androidx.lifecycle:lifecycle-runtime-ktx:${Versions.lifecycleKtxVersion}")
    api("androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycleKtxVersion}")
    api("androidx.lifecycle:lifecycle-livedata-ktx:${Versions.lifecycleKtxVersion}")

    // Firebase
    api(platform("com.google.firebase:firebase-bom:${Versions.firebaseBomVersion}"))
    api("com.google.firebase:firebase-analytics-ktx")
    api("com.google.firebase:firebase-crashlytics-ktx")
    api("com.google.firebase:firebase-analytics-ktx")

    // DI
    api("com.google.dagger:dagger:${Versions.daggerVersion}")

    // RX
    api("io.reactivex.rxjava2:rxjava:${Versions.rxjavaVersion}")
    api("io.reactivex.rxjava2:rxandroid:${Versions.rxandroidVersion}")
    api("com.jakewharton.rxrelay2:rxrelay:${Versions.rxrelayVersion}")
    api("com.tomasznajda.ktx:rxjava2:${Versions.rxjavaktxVersion}")

    // Logging
    api("com.jakewharton.timber:timber:${Versions.timberVersion}")

    // image loader
    api("io.coil-kt:coil:${Versions.coilVersion}")

    // Coroutine
    api("org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.kotlinCoroutineVersion}")
    api("org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.kotlinCoroutineAndroidVersion}")

    // Network
    api("com.squareup.retrofit2:retrofit:${Versions.retrofit2Version}")
    // implementation "com.squareup.retrofit2:converter-gson:$retrofit2_version"
    api("com.squareup.retrofit2:converter-moshi:${Versions.retrofit2Version}")
    api("com.squareup.okhttp3:okhttp:${Versions.okhttpVersion}")
    api("com.squareup.okhttp3:logging-interceptor:${Versions.okhttpVersion}")
    api("com.squareup.retrofit2:adapter-rxjava2:${Versions.retrofit2Version}")
    api("com.squareup.moshi:moshi:${Versions.moshiVersion}")

    // Annotation processor
    kapt("com.google.dagger:dagger-compiler:${Versions.daggerVersion}")
    kapt("com.google.dagger:dagger-android-processor:${Versions.daggerVersion}")
    kapt("com.squareup.moshi:moshi-kotlin-codegen:${Versions.moshiVersion}")

    // replaced with implementation androidx.lifecycle:lifecycle-common-java8
    // https://stackoverflow.com/questions/49602410/when-should-we-use-android-arch-lifecyclecompiler-or-android-arch-lifecycleco
    // kapt "androidx.lifecycle:lifecycle-compiler:$arch_lifecycle_version"
    kaptAndroidTest("com.google.dagger:dagger-compiler:${Versions.daggerVersion}")
    // kaptAndroidTest "com.google.dagger:dagger-android-processor:$dagger_version"

    testImplementation("junit:junit:4.+")
    androidTestImplementation("androidx.test.ext:junit:1.1.2")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.3.0")
}
