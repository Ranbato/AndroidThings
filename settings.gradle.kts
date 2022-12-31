pluginManagement {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()

    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        maven { url = uri( "https://jitpack.io") }
        jcenter() // for com.google.android.things.contrib items.  May need to add to project eventually
    }
}
rootProject.name = "My Application"
include (":app")
