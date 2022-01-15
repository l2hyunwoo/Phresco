plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("kapt")
    id("de.mannodermaus.android-junit5")
}

android {
    compileSdk = Constants.compileSdk
    buildToolsVersion = "30.0.3"

    defaultConfig {
        applicationId = Constants.packageName
        minSdk = Constants.minSdk
        targetSdk = Constants.targetSdk
        versionCode = Constants.versionCode
        versionName = Constants.versionName
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = Versions.javaVersion
        targetCompatibility = Versions.javaVersion
    }
    kotlinOptions {
        jvmTarget = Versions.jvmVersion
    }
    buildFeatures {
        dataBinding = true
        viewBinding = true
    }
}

dependencies {
    // Kotlin
    implementation(KotlinDependencies.kotlin)

    // AndroidX
    implementation(AndroidXDependencies.coreKtx)
    implementation(AndroidXDependencies.appCompat)
    implementation(AndroidXDependencies.coroutines)
    implementation(AndroidXDependencies.lifeCycleKtx)
    implementation(AndroidXDependencies.lifecycleJava8)

    // Third-Party
    implementation(ThirdPartyDependencies.glide)
    kapt(KaptDependencies.glide)
    implementation(ThirdPartyDependencies.timber)

    testImplementation(TestDependencies.junit5Api)
    testImplementation(TestDependencies.junit5Engine)
    testImplementation(TestDependencies.junit5Params)
    testImplementation(TestDependencies.truth)
}