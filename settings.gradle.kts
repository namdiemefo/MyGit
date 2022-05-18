dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        jcenter() // Warning: this repository is going to shut down soon
    }
}
rootProject.name = "MyGit"
include(":app")
include(":core:commons")
include(":core:core-profiles")
include(":core-android")
include(":core-android:commons")
include(":core-android:core-profiles")
include(":data:profiles-remote")
include(":domain:profiles-domain")
include(":features:profiles")
include(":ui:core-ui")
include(":ui:profiles-ui")
