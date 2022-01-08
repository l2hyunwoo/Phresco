object KotlinDependencies {
    const val kotlin = "org.jetbrains.kotlin:kotlin-stdlib:${Versions.kotlinVersion}"
}

object AndroidXDependencies {
    const val coreKtx = "androidx.core:core-ktx:${Versions.coreKtxVersion}"
    const val appCompat = "androidx.appcompat:appcompat:${Versions.appCompatVersion}"
    const val constraintLayout =
        "androidx.constraintlayout:constraintlayout:${Versions.constraintLayoutVersion}"
    const val hilt = "com.google.dagger:hilt-android:${Versions.hiltVersion}"
    const val fragment = "androidx.fragment:fragment-ktx:${Versions.fragmentKtxVersion}"
    const val legacy = "androidx.legacy:legacy-support-v4:${Versions.legacySupportVersion}"
    const val security = "androidx.security:security-crypto:${Versions.securityVersion}"
    const val coroutines =
        "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutinesAndroidVersion}"
    const val lifeCycleKtx = "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.lifecycleVersion}"
    const val lifecycleJava8 =
        "androidx.lifecycle:lifecycle-common-java8:${Versions.lifecycleVersion}"
    const val startUp = "androidx.startup:startup-runtime:${Versions.startupVersion}"
}

object TestDependencies {
    const val junit5Api = "org.junit.jupiter:junit-jupiter-api:${Versions.junitJupiterVersion}"
    const val junit5Engine =
        "org.junit.jupiter:junit-jupiter-engine:${Versions.junitJupiterVersion}"
    const val junit5Params =
        "org.junit.jupiter:junit-jupiter-params:${Versions.junitJupiterVersion}"
    const val truth = "com.google.truth:truth:${Versions.truthVersion}"
}

object MaterialDesignDependencies {
    const val materialDesign =
        "com.google.android.material:material:${Versions.materialDesignVersion}"
}

object KaptDependencies {
    const val hiltCompiler = "com.google.dagger:hilt-compiler:${Versions.hiltVersion}"
    const val glide = "com.github.bumptech.glide:compiler:${Versions.glideVersion}"
}

object ThirdPartyDependencies {
    const val gson = "com.google.code.gson:gson:${Versions.gsonVersion}"
    const val glide = "com.github.bumptech.glide:glide:${Versions.glideVersion}"
    const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofitVersion}"
    const val retrofitGsonConverter =
        "com.squareup.retrofit2:converter-gson:${Versions.retrofitVersion}"
    const val okHttpBom = "com.squareup.okhttp3:okhttp-bom:${Versions.okHttpVersion}"
    const val okHttp = "com.squareup.okhttp3:okhttp"
    const val okHttpLoggingInterceptor = "com.squareup.okhttp3:logging-interceptor"
    const val timber = "com.jakewharton.timber:timber:${Versions.timberVersion}"
}

object ClassPathPlugins {
    const val hilt = "com.google.dagger:hilt-android-gradle-plugin:${Versions.hiltVersion}"
    const val junit5 =
        "de.mannodermaus.gradle.plugins:android-junit5:${Versions.androidJunit5PluginVersion}"
}
