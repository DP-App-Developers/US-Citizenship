pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
//        maven("https://nexus.m3.ebay.com/nexus/content/groups/public")
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
//        maven("https://nexus.m3.ebay.com/nexus/content/groups/public")
    }
}

rootProject.name = "US Citizenship"
include(":app")
