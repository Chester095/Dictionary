plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = Config.NAMESPACE_MODEL
    compileSdk = Config.COMPILE_SDK

    defaultConfig {
        minSdk = Config.MIN_SDK

        testInstrumentationRunner = Config.TEST_INSTRUMENTATION_RUNNER
        consumerProguardFiles(Config.CONSUMER_PROGUARD_FILES)
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
}

dependencies {

    //AndroidX
    implementation(AndroidX.CORE_KTX_LIB)
    implementation(AndroidX.APPCOMPAT_LIB)

    //Material
    implementation(Material.ANDROID_MATERIAL)

    // Bom
    implementation(platform(Bom.BOM))

    //Test
    implementation(Test.J_UNIT)
    androidTestImplementation (Test.EXT)
    androidTestImplementation (Test.ESPRESSO_CORE)
}