import org.gradle.api.JavaVersion

object Config {
    const val compile_sdk = 33
    const val application_id = "com.example.mylibrary"
    const val main_application_id = "com.example.mylibrary"
    const val min_sdk = 25
    const val target_sdk = 33
    const val testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    const val consumerProguardFiles = "consumer-rules.pro"
}

object Release {
    const val version_control = 1
    const val version_name = "1.0"
}


object Versions {
    val java_version = JavaVersion.VERSION_1_8
    const val jvmTarget = "1.8"

    //Material
    const val android_material = "1.9.0"

    //AndroidX
    internal const val CORE_KTX_VER = "1.8.0"
    internal const val APPCOMPAT_VER = "1.6.1"
    const val constraintlayout = "2.1.4"
    const val support_v4 = "1.0.0"
    const val livedata_ktx = "2.5.1"
    const val viewmodel_ktx = "2.5.1"

    //Test
    const val jUnit = "4.13.2"
    const val runner = "1.1.3"
    const val espressoCore = "3.4.0"

    // Rx
    const val rxjava = "3.1.4"
    const val rxkotlin = "3.0.1"
    const val rxandroid = "3.0.0"
    const val adapter = "2.9.0"
    const val reactivestreams = "1.1.1"

    // Retrofit
    const val retrofit = "2.9.0"

    //Dagger
    const val dagger = "2.41"

    //Koin
    const val koin_version = "3.1.2"

    // Timber
    const val timber = "5.0.1"

    //Glide
    const val glide = "4.12.0"

    //Room
    const val room = "2.5.0"
}

object Material {
    const val ANDROID_MATERIAL = "com.google.android.material:material:${Versions.android_material}"
}

object AndroidX {
    const val CORE_KTX_LIB = "androidx.core:core-ktx:${Versions.CORE_KTX_VER}"
    const val APPCOMPAT_LIB = "androidx.appcompat:appcompat:${Versions.APPCOMPAT_VER}"
    const val constraintlayout =
        "androidx.constraintlayout:constraintlayout:${Versions.constraintlayout}"
    const val support_v4 = "androidx.legacy:legacy-support-v4:${Versions.support_v4}"
    const val livedata_ktx = "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.livedata_ktx}"
    const val viewmodel_ktx = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.viewmodel_ktx}"
}

object Test {
    const val jUnit = "junit:junit:${Versions.jUnit}"
    const val runner = "androidx.test.ext:junit:${Versions.runner}"
    const val espressoCore = "androidx.test.espresso:espresso-core:${Versions.espressoCore}"
}

object RX {
    const val rxjava = "io.reactivex.rxjava3:rxjava:${Versions.rxjava}"
    const val rxkotlin = "io.reactivex.rxjava3:rxkotlin:${Versions.rxkotlin}"
    const val rxandroid = "io.reactivex.rxjava3:rxandroid:${Versions.rxandroid}"
    const val adapter = "com.squareup.retrofit2:adapter-rxjava3:${Versions.adapter}"
    const val reactivestreams = "android.arch.lifecycle:reactivestreams:${Versions.reactivestreams}"
}

object Retrofit {
    const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    const val gson = "com.squareup.retrofit2:converter-gson:${Versions.retrofit}"
    const val rxjava3 = "com.squareup.retrofit2:adapter-rxjava3:${Versions.retrofit}"
}

object Dagger {
    const val dagger = "com.google.dagger:dagger:${Versions.dagger}"
}

object Koin {
    const val koin_core = "io.insert-koin:koin-core:${Versions.koin_version}"
    const val koin_android = "io.insert-koin:koin-android:${Versions.koin_version}"
}

object Timber {
    const val timber = "com.jakewharton.timber:timber:${Versions.timber}"
}

object Glide {
    const val glide = "com.github.bumptech.glide:glide:${Versions.glide}"
}

object Room {
    const val room = "androidx.room:room-runtime:${Versions.room}"
}