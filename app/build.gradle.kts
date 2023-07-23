plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
}

android {

    compileSdk = Config.compile_sdk

    defaultConfig {
        applicationId = Config.main_application_id
        minSdk = Config.min_sdk
        targetSdk = Config.target_sdk
        versionCode = Release.version_control
        versionName = Release.version_name

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

//        javaCompileOptions {
//            annotationProcessorOptions {
//                arguments = ["room.schemaLocation":"$projectDir/schemas".toString()]
//            }
//        }

        kapt {
            arguments {
                arg("room.schemaLocation", "$projectDir/schemas".toString())
            }
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
        sourceCompatibility = Versions.java_version
        targetCompatibility = Versions.java_version
    }
    kotlinOptions {
        jvmTarget = Versions.jvmTarget
    }

    buildFeatures {
        viewBinding = true
    }
    namespace = "com.geekbrains.dictionary"
}

dependencies {
    // Rx
    implementation(RX.rxjava)
    implementation(RX.rxkotlin)
    implementation(RX.rxandroid)
    implementation(RX.adapter)
    implementation(RX.reactivestreams)

    // Retrofit
    implementation(Retrofit.retrofit)
    implementation(Retrofit.gson)
    implementation(Retrofit.rxjava3)

    //Dagger
    implementation(Dagger.dagger)
    kapt(Dagger.dagger)

    //Koin
    implementation(Koin.koin_core)
    implementation(Koin.koin_android)

    //Libs
    implementation(Material.ANDROID_MATERIAL)
    implementation(AndroidX.CORE_KTX_LIB)
    implementation(AndroidX.APPCOMPAT_LIB)
    implementation(AndroidX.constraintlayout)
    implementation(AndroidX.support_v4)
    implementation(AndroidX.livedata_ktx)
    implementation(AndroidX.viewmodel_ktx)

    //Test
    androidTestImplementation(Test.jUnit)

    // Timber
    implementation(Timber.timber)

    //Glide
    implementation(Glide.glide)
    kapt(Glide.glide)

    //Room
    implementation(Room.room)
    kapt(Room.room)


    implementation(project(":mylibrary"))
}