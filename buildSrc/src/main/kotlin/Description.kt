import org.gradle.api.JavaVersion

object Config {
    const val COMPILE_SDK = 33
    const val APPLICATION_ID = "com.geekbrains.dictionary"
    const val NAMESPACE = "com.geekbrains.dictionary"
    const val NAMESPACE_CORE = "com.geekbrains.dictionary.core"
    const val NAMESPACE_MODEL = "com.geekbrains.dictionary.model"
    const val NAMESPACE_REPOSITORY = "com.geekbrains.dictionary.repository"
    const val NAMESPACE_HISTORY_SCREEN = "com.geekbrains.dictionary.historyscreen"
    const val MIN_SDK = 26
    const val TARGET_SDK = 33
    const val TEST_INSTRUMENTATION_RUNNER = "androidx.test.runner.AndroidJUnitRunner"
    const val CONSUMER_PROGUARD_FILES = "consumer-rules.pro"
    const val PROGUARD_ANDROID_OPTIMIZE = "proguard-android-optimize.txt"
    const val PROGUARD_RULES = "proguard-rules.pro"
}

object Release {
    const val VERSION_CONTROL = 1
    const val VERSION_NAME = "1.0"
}

object Modules {
    const val app = ":app"
    const val core = ":core"
    const val model = ":model"
    const val repository = ":repository"

//Features
    const val historyScreen = ":historyScreen"
}

object Versions {
    val JAVA_VERSION = JavaVersion.VERSION_1_8
    const val JVM_TARGET = "1.8"

    // Rx
    const val RX_JAVA = "3.1.4"
    const val RX_KOTLIN = "3.0.1"
    const val RX_ANDROID = "3.0.0"
    const val ADAPTER = "2.9.0"
    const val REACTIVE_STREAMS = "1.1.1"

    // Retrofit
    const val RETROFIT = "2.9.0"

    //Dagger
    const val DAGGER = "2.41"

    //Koin
    const val KOIN_VERSION = "3.1.2"

    //AndroidX
    const val CORE_KTX_VER = "1.9.0"
    const val APPCOMPAT_VER = "1.6.1"
    const val CONSTRAINT_LAYOUT = "2.1.4"
    const val SUPPORT_V4 = "1.0.0"
    const val LIVEDATA_KTX = "2.5.1"
    const val VIEWMODEL_KTX = "2.5.1"

    //Material
    const val ANDROID_MATERIAL = "1.8.0"

    //Bom
    const val BOM = "1.8.0"

    //Test
    const val J_UNIT = "4.13.2"
    const val EXT = "1.1.3"
    const val ESPRESSO_CORE = "3.4.0"

    // Timber
    const val TIMBER = "5.0.1"

    //Glide
    const val GLIDE = "4.12.0"

    //Room
    const val ROOM = "2.5.0"
}

object RX {
    const val RX_JAVA = "io.reactivex.rxjava3:rxjava:${Versions.RX_JAVA}"
    const val RX_KOTLIN = "io.reactivex.rxjava3:rxkotlin:${Versions.RX_KOTLIN}"
    const val RX_ANDROID = "io.reactivex.rxjava3:rxandroid:${Versions.RX_ANDROID}"
    const val ADAPTER = "com.squareup.retrofit2:adapter-rxjava3:${Versions.ADAPTER}"
    const val REACTIVE_STREAMS = "android.arch.lifecycle:reactivestreams:${Versions.REACTIVE_STREAMS}"
}

object Retrofit {
    const val RETROFIT = "com.squareup.retrofit2:retrofit:${Versions.RETROFIT}"
    const val GSON = "com.squareup.retrofit2:converter-gson:${Versions.RETROFIT}"
    const val ADAPTER = "com.squareup.retrofit2:adapter-rxjava3:${Versions.RETROFIT}"
}

object Dagger {
    const val DAGGER = "com.google.dagger:dagger:${Versions.DAGGER}"
}

object Koin {
    const val KOIN_CORE = "io.insert-koin:koin-core:${Versions.KOIN_VERSION}"
    const val KOIN_ANDROID = "io.insert-koin:koin-android:${Versions.KOIN_VERSION}"
}

object AndroidX {
    const val CORE_KTX_LIB = "androidx.core:core-ktx:${Versions.CORE_KTX_VER}"
    const val APPCOMPAT_LIB = "androidx.appcompat:appcompat:${Versions.APPCOMPAT_VER}"
    const val CONSTRAINT_LAYOUT =
        "androidx.constraintlayout:constraintlayout:${Versions.CONSTRAINT_LAYOUT}"
    const val SUPPORT_V4 = "androidx.legacy:legacy-support-v4:${Versions.SUPPORT_V4}"
    const val LIVEDATA_KTX = "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.LIVEDATA_KTX}"
    const val VIEWMODEL_KTX = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.VIEWMODEL_KTX}"
}

object Material {
    const val ANDROID_MATERIAL = "com.google.android.material:material:${Versions.ANDROID_MATERIAL}"
}

object Bom{
    const val BOM = "org.jetbrains.kotlin:kotlin-bom:${Versions.BOM}"
}

object Test {
    const val J_UNIT = "junit:junit:${Versions.J_UNIT}"
    const val EXT = "androidx.test.ext:junit:${Versions.EXT}"
    const val ESPRESSO_CORE = "androidx.test.espresso:espresso-core:${Versions.ESPRESSO_CORE}"
}

object Timber {
    const val TIMBER = "com.jakewharton.timber:timber:${Versions.TIMBER}"
}

object Glide {
    const val GLIDE = "com.github.bumptech.glide:glide:${Versions.GLIDE}"
}

object Room {
    const val RUNTIME = "androidx.room:room-runtime:${Versions.ROOM}"
    const val COMPILER = "androidx.room:room-compiler:${Versions.ROOM}"
}