plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = Config.IMPL_APPLICATION_ID
    compileSdk = Config.COMPILE_SDK

    defaultConfig {
        minSdk = Config.MIN_SDK
        targetSdk = Config.TARGET_SDK

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
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
}

dependencies {
    implementation(Material.ANDROID_MATERIAL)
    implementation(AndroidX.CORE_KTX_LIB)
    implementation(AndroidX.APPCOMPAT_LIB)

    //Test
    testImplementation(Test.J_UNIT)
    androidTestImplementation(Test.RUNNER)
    androidTestImplementation(Test.ESPRESSO_CORE)


    implementation(project(":mylibrary_api"))
}