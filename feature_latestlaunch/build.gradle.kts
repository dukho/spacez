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
        consumerProguardFiles("consumer-rules.pro")
    }

    buildFeatures {
        dataBinding = true
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled  = false
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
    implementation(project("::base_app"))

    implementation("org.jetbrains.kotlin:kotlin-stdlib:${Versions.kotlinVersion}")
    implementation("androidx.core:core-ktx:${Versions.ktxVersion}")
    implementation("androidx.appcompat:appcompat:${Versions.androidxVersion}")
    implementation("com.google.android.material:material:1.2.1")
    implementation("androidx.constraintlayout:constraintlayout:2.0.4")
    implementation("androidx.lifecycle:lifecycle-common-java8:${Versions.archLifecycleVersion}")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:${Versions.lifecycleKtxVersion}")
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycleKtxVersion}")
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:${Versions.lifecycleKtxVersion}")

    // DI
    implementation("com.google.dagger:dagger:${Versions.daggerVersion}")

    // RX
    implementation("io.reactivex.rxjava2:rxjava:${Versions.rxjavaVersion}")
    implementation("io.reactivex.rxjava2:rxandroid:${Versions.rxandroidVersion}")
    implementation("com.jakewharton.rxrelay2:rxrelay:${Versions.rxrelayVersion}")
    implementation("com.tomasznajda.ktx:rxjava2:${Versions.rxjavaktxVersion}")

    // Logging
    implementation("com.jakewharton.timber:timber:${Versions.timberVersion}")

    // image loader
    implementation("io.coil-kt:coil:${Versions.coilVersion}")

    // Coroutine
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.kotlinCoroutineVersion}")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.kotlinCoroutineAndroidVersion}")

    // Json
    implementation("com.squareup.moshi:moshi-kotlin:${Versions.moshiVersion}")

    // Network
    implementation("com.squareup.retrofit2:retrofit:${Versions.retrofit2Version}")
    // implementation "com.squareup.retrofit2:converter-gson:$retrofit2_version"
    implementation("com.squareup.retrofit2:converter-moshi:${Versions.retrofit2Version}")
    implementation("com.squareup.okhttp3:okhttp:${Versions.okhttpVersion}")
    implementation("com.squareup.okhttp3:logging-interceptor:${Versions.okhttpVersion}")
    implementation("com.squareup.retrofit2:adapter-rxjava2:${Versions.retrofit2Version}")
    implementation("com.squareup.moshi:moshi:${Versions.moshiVersion}")

    // Annotation processor : annotation should be declared even if they were added in the base module because they were required for compilation
    kapt("com.google.dagger:dagger-compiler:${Versions.daggerVersion}")
    kapt("com.google.dagger:dagger-android-processor:${Versions.daggerVersion}")
    kapt("com.squareup.moshi:moshi-kotlin-codegen:${Versions.moshiVersion}")

    kaptAndroidTest("com.google.dagger:dagger-compiler:${Versions.daggerVersion}")

    testImplementation("junit:junit:4.+")
    testImplementation("org.mockito:mockito-core:${Versions.mockitoVersion}")
    testImplementation("androidx.arch.core:core-testing:2.1.0")
    testImplementation("org.jetbrains.kotlinx:kotlinx-coroutines-test:${Versions.kotlinCoroutineVersion}")
    androidTestImplementation("androidx.test.ext:junit:1.1.2")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.3.0")
}
