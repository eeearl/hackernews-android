object Dependencies {

    object Kotlin {
        const val stdLib = "stdlib-jdk7"
        const val coroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-core:1.3.2"
    }

    object AndroidX {
        private const val version = "1.1.0"
        const val appCompat = "androidx.appcompat:appcompat:${version}"
        const val ktx = "androidx.core:core-ktx:${version}"
        const val constraintLayout = "androidx.constraintlayout:constraintlayout:1.1.3"
        const val recyclerView = "androidx.recyclerview:recyclerview:1.0.0"

        object Lifecycle {
            private const val version = "2.0.0"
            const val extension = "androidx.lifecycle:lifecycle-extensions:${version}"
            const val viewModel = "androidx.lifecycle:lifecycle-viewmodel-ktx:${version}"
        }

        object Test {
            const val runner = "androidx.test:runner:1.2.0"
            const val espresso = "androidx.test.espresso:espresso-core:3.2.0"
        }
    }

    object Koin {
        private const val version = "2.0.1"
        private const val architecture_version = "0.9.3"
        const val core = "org.koin:koin-core:$version"
        const val android = "org.koin:koin-android:$version"
        const val viewmodel = "org.koin:koin-android-viewmodel:$version"
        const val arch = "org.koin:koin-android-architecture:$architecture_version"
    }

    object Network {
        const val retrofit = "com.squareup.retrofit2:retrofit:2.6.2"
        const val gson = "com.google.code.gson:gson:2.8.6"
        const val okhttp = "com.squareup.okhttp3:okhttp:4.2.2"
    }

    object Test {
        const val jUnit = "junit:junit:4.12"
    }
}