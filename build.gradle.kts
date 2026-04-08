plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
    id("com.vanniktech.maven.publish") version "0.36.0"
    id("signing")
}

group = "io.github.gllflplaystore"
version = "1.0.2"

android {
    namespace = "com.omnissolutio.paymentsdk"
    compileSdk = 36

    defaultConfig {
        minSdk = 24
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    // Modern SDKs should target Java 17+
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    kotlinOptions {
        jvmTarget = "17"
    }

    buildFeatures {
        compose = true
    }
}



dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)

    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.compose.ui)
    implementation(libs.androidx.compose.material3)

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}
mavenPublishing {
    // FORCED S01 HOST: Required for all new io.github projects
    publishToMavenCentral(true)
    signAllPublications()

    coordinates(
        "io.github.gllflplaystore",
        "omnis-solutio-payment-sdk-android",
        "1.0.1"
    )

    pom {
        name.set("Omnis Solutio Payment SDK")
        description.set("Android Kotlin SDK for payment gateway integration")
        inceptionYear.set("2026")
        url.set("https://github.com/gllflplaystore/omnis-solutio-payment-sdk-android")

        licenses {
            license {
                name.set("The Apache Software License, Version 2.0")
                url.set("https://www.apache.org/licenses/LICENSE-2.0.txt")
            }
        }

        developers {
            developer {
                id.set("gllflplaystore")
                name.set("GLLFL")
                url.set("https://github.com/gllflplaystore")
            }
        }

        scm {
            connection.set("scm:git:github.com/gllflplaystore/omnis-solutio-payment-sdk-android.git")
            developerConnection.set("scm:git:ssh://github.com/gllflplaystore/omnis-solutio-payment-sdk-android.git")
            url.set("https://github.com/gllflplaystore/omnis-solutio-payment-sdk-android")
        }
    }
}

// ← ADD THIS ENTIRE BLOCK
signing {
    useInMemoryPgpKeys(
        project.findProperty("signingInMemoryKeyId") as String?,
        project.findProperty("signingInMemoryKey") as String?,
        project.findProperty("signingInMemoryKeyPassword") as String?
    )
}
