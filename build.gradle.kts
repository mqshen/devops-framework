
val allJarRepo: String by project
val snapshotRepo: String by project
val allJarUsername: String by project
val allJarPassword: String by project

description = "Tencent BlueKing DevOps Framework Build"

plugins {
    kotlin("jvm") version Versions.Kotlin apply false
    kotlin("kapt") version Versions.Kotlin apply false
    kotlin("plugin.spring") version Versions.Kotlin apply false
    id("maven-publish")
    id("io.spring.dependency-management") version Versions.DependencyManagement apply false
    id("io.github.gradle-nexus.publish-plugin") version Versions.NexusPublish
//    id("io.codearte.nexus-staging") version Versions.NexusStaging

}

allprojects {
    group = Release.Group
    version = Release.Version

    repositories {
        mavenCentral()
        jcenter()
        gradlePluginPortal()
    }

    tasks {
        withType<Jar> {
            manifest {
                attributes("Implementation-Title" to (project.description ?: project.name))
                attributes("Implementation-Version" to Release.Version)
            }
        }
    }
}


nexusPublishing {
    repositories {
        create("myNexus") {  //only for users registered in Sonatype after 24 Feb 2021
            nexusUrl = uri(allJarRepo)
            snapshotRepositoryUrl = uri(snapshotRepo)
            allowInsecureProtocol = true
            username = allJarUsername // defaults to project.properties["myNexusUsername"]
            password = allJarPassword // defaults to project.properties["myNexusPassword"]
        }
    }
}

subprojects {
    apply(plugin = "ktlint")
}
