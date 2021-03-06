import org.gradle.plugin.use.PluginDependenciesSpec
import org.gradle.plugin.use.PluginDependencySpec

val PluginDependenciesSpec.androidApplication: PluginDependencySpec
    get() = id("com.android.application")

val PluginDependenciesSpec.androidLibrary: PluginDependencySpec
    get() = id("com.android.library")

val PluginDependenciesSpec.kotlinAndroid: PluginDependencySpec
    get() = id("kotlin-android")

val PluginDependenciesSpec.kotlinKapt: PluginDependencySpec
    get() = id("kotlin-kapt")

val PluginDependenciesSpec.daggerAndroidPlugin: PluginDependencySpec
    get() = id("dagger.hilt.android.plugin")



