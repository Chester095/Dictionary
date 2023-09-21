plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
}

android {
    namespace = Config.NAMESPACE
    compileSdk = Config.COMPILE_SDK

    defaultConfig {
        applicationId = Config.APPLICATION_ID
        minSdk = Config.MIN_SDK
        targetSdk = Config.TARGET_SDK
        versionCode = Release.VERSION_CONTROL
        versionName = Release.VERSION_NAME

        testInstrumentationRunner = Config.TEST_INSTRUMENTATION_RUNNER

        kapt {
            arguments {
                arg("room.schemaLocation", "$projectDir/schemas".toString())
            }
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile(Config.PROGUARD_ANDROID_OPTIMIZE), Config.PROGUARD_RULES)
        }
    }
    compileOptions {
        sourceCompatibility = Versions.JAVA_VERSION
        targetCompatibility = Versions.JAVA_VERSION
    }
    kotlinOptions {
        jvmTarget = Versions.JVM_TARGET
    }

    buildFeatures {
        viewBinding = true
    }
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
    implementation(Retrofit.ADAPTER)


    //Dagger
    implementation(Dagger.DAGGER)
    kapt (Dagger.DAGGER)

    //Koin
    implementation(Koin.KOIN_CORE)
    implementation(Koin.KOIN_ANDROID)

    //AndroidX
    implementation(AndroidX.CORE_KTX_LIB)
    implementation(AndroidX.APPCOMPAT_LIB)
    implementation(AndroidX.CONSTRAINT_LAYOUT)
    implementation(AndroidX.SUPPORT_V4)
    implementation(AndroidX.LIVEDATA_KTX)
    implementation(AndroidX.VIEWMODEL_KTX)

    //Splash
    implementation(AndroidX.SPLASH_SCREEN)

    //Material
    implementation(Material.ANDROID_MATERIAL)

    //Test
    implementation(Test.J_UNIT)
    androidTestImplementation (Test.EXT)
    androidTestImplementation (Test.ESPRESSO_CORE)

    // Timber
    implementation(Timber.TIMBER)

    //Glide
    implementation(Glide.GLIDE)
    kapt (Glide.GLIDE)

    //Room
    implementation(Room.RUNTIME)
    kapt (Room.COMPILER)

}