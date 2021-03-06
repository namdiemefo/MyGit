
plugins {
    androidApplication
    kotlinAndroid
    daggerAndroidPlugin
    kotlinKapt
}

android {

    compileSdk = DefaultConfig.COMPILE_SDK_VERSION
    buildToolsVersion = Versions.BUILD_TOOLS_VERSION

    defaultConfig {
        minSdk = DefaultConfig.MIN_SDK_VERSION
        targetSdk = DefaultConfig.TARGET_SDK_VERSION
        applicationId = DefaultConfig.APPLICATION_ID
        versionCode = DefaultConfig.VERSION_CODE
        versionName = DefaultConfig.VERSION_NAME
        testInstrumentationRunner = DefaultConfig.TEST_INSTRUMENTATION_RUNNER

        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {

        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro"
            )
            buildConfigField("String", "BASE_URL", BASE_URL)
        }

        debug {
            buildConfigField("String", "BASE_URL", BASE_URL)
        }
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }

    compileOptions {
        sourceCompatibility(JavaVersion.VERSION_1_8)
        targetCompatibility(JavaVersion.VERSION_1_8)
    }

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = Versions.COMPOSE_VERSION
        kotlinCompilerVersion = Versions.KOTLIN_GRADLE_VERSION
    }

    packagingOptions {
        exclude("META-INF/AL2.0")
        exclude("META-INF/*.kotlin_module")
        exclude("META-INF/LGPL2.1")
    }

    configurations.all {
        exclude(
            group = "org.jetbrains",
            module = "annotations"
        )
    }

}

dependencies {

    composeDependencies()
    daggerDependencies()
    kotlinDependencies()

    implementation(project(FeatureModules.PROFILES_MODULE))
    implementation(project(CoreModules.CORE_COMMON_MODULE))
    implementation(project(UIModules.CORE_UI))
    implementation(project(UIModules.PROFILES_UI))

    implementation(Dependencies.TIMBER)
    implementation(Dependencies.KTX_CORE)
    implementation(Dependencies.APPCOMPAT)
    implementation(Dependencies.MATERIAL_COMPONENTS)
    implementation(Dependencies.LIFECYCLE_RUNTIME)
    testImplementation(TestDependencies.JUNIT)
    androidTestImplementation(TestDependencies.ANDROIDX_JUNIT)
    androidTestImplementation(TestDependencies.ESPRESSO)
    androidTestImplementation(TestDependencies.COMPOSE_UI)
}