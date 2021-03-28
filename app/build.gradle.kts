plugins {
    id("com.android.application")
    id("kotlin-android")
    id("kotlin-kapt")
    id("com.google.gms.google-services")
    id("com.google.firebase.crashlytics")
}

android {
    compileSdkVersion(AppConfig.compileSdkVersion)
    buildToolsVersion(AppConfig.buildToolsVersion)

    defaultConfig {
        applicationId = AppConfig.applicationId
        minSdkVersion(AppConfig.minSdkVersion)
        targetSdkVersion(AppConfig.targetSdkVersion)
        versionCode = appVersionCode()
        versionName = appVersionName()

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildFeatures {
        dataBinding = true
    }

    signingConfigs {
        getByName("debug") {
            keyAlias = "spacex"
            keyPassword = "space1234"
            storeFile = file("spacex.debug.keystore")
            storePassword = "space1234"
        }
        create("release") {
            keyAlias = if (project.hasProperty("keyAlias")) project.properties["keyAlias"] as String else System.getenv("keyAlias")
            keyPassword = if (project.hasProperty("keyPass")) project.properties["'keyPass"] as String else System.getenv("keyPass")
            storeFile = file("spacex.release.keystore")
            storePassword = keyPassword
        }
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled  = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
            signingConfig = signingConfigs.getByName("release")
        }
        getByName("debug") {
            isMinifyEnabled  = false
            signingConfig = signingConfigs.getByName("debug")
            isDebuggable = true
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

fun appVersionCode(): Int {
    println("appVersionCode = " + System.getenv("appVersionCode"))

    return System.getenv("appVersionCode")?.let {
        it.toInt()
    } ?: Versions.DEFAULT_VERSION_CODE
}

fun appVersionName(): String {
    return "${Versions.MAJOR}.${Versions.MINOR}.${Versions.PATCH}"
}

//configurations {
//    ktlint
//}

dependencies {
    implementation(project("::base_app"))
    implementation(project("::feature_latestlaunch"))

    // Annotation processor : annotation should be declared even if they were added in the base module because they were required for compilation
    kapt("com.google.dagger:dagger-compiler:${Versions.daggerVersion}")
    kapt("com.google.dagger:dagger-android-processor:${Versions.daggerVersion}")
    kapt("com.squareup.moshi:moshi-kotlin-codegen:${Versions.moshiVersion}")

    kaptAndroidTest("com.google.dagger:dagger-compiler:${Versions.daggerVersion}")

    testImplementation("junit:junit:4.+")
    // androidTestImplementation("'androidx.test.ext:junit:1.1.2")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.3.0")
}

//task ktlint(type: JavaExec, group: "verification") {
//    description = "Check Kotlin code style."
//    classpath = configurations.ktlint
//    main = "com.pinterest.ktlint.Main"
//    args "src/**/*.kt"
//    // to generate report in checkstyle format prepend following args:
//    // "--reporter=plain", "--reporter=checkstyle,output=${buildDir}/ktlint.xml"
//    // see https://github.com/pinterest/ktlint#usage for more
//}
//check.dependsOn ktlint
//
//task ktlintFormat(type: JavaExec, group: "formatting") {
//    description = "Fix Kotlin code style deviations."
//    classpath = configurations.ktlint
//    main = "com.pinterest.ktlint.Main"
//    args "-F", "src/**/*.kt"
//}
