plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
}

android {

    compileSdk = Config.COMPILE_SDK

    defaultConfig {
        applicationId = Config.MAIN_APPLICATION_ID
        minSdk = Config.MIN_SDK
        targetSdk = Config.TARGET_SDK
        versionCode = Release.VERSION_CONTROL
        versionName = Release.VERSION_NAME

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
        sourceCompatibility = Versions.JAVA_VERSION
        targetCompatibility = Versions.JAVA_VERSION
    }
    kotlinOptions {
        jvmTarget = Versions.JVM_TARGET
    }

    this.buildFeatures {
        viewBinding = true
    }
    namespace = "com.geekbrains.dictionary"
}

dependencies {
    // Rx
    implementation(RX.RX_JAVA)
    implementation(RX.RX_KOTLIN)
    implementation(RX.RX_ANDROID)
    implementation(RX.ADAPTER)
    implementation(RX.REACTIVE_STREAMS)

    // Retrofit
    implementation(Retrofit.RETROFIT)
    implementation(Retrofit.GSON)
    implementation(Retrofit.RX_JAVA_3)

    //Dagger
    implementation(Dagger.DAGGER)
    kapt(Dagger.DAGGER)

    //Koin
    implementation(Koin.KOIN_CORE)
    implementation(Koin.KOIN_ANDROID)

    //Libs
    implementation(Material.ANDROID_MATERIAL)
    implementation(AndroidX.CORE_KTX_LIB)
    implementation(AndroidX.APPCOMPAT_LIB)
    implementation(AndroidX.CONSTRAINT_LAYOUT)
    implementation(AndroidX.SUPPORT_V4)
    implementation(AndroidX.LIVEDATA_KTX)
    implementation(AndroidX.VIEWMODEL_KTX)

    //Test
    androidTestImplementation(Test.J_UNIT)

    // Timber
    implementation(Timber.TIMBER)

    //Glide
    implementation(Glide.GLIDE)
    kapt(Glide.GLIDE)

    //Room
    implementation(Room.ROOM)
    kapt(Room.ROOM)


    implementation(project(":mylibrary"))
}