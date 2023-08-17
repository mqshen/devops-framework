val snapshotRepo: String by project
val allJarUsername: String by project
val allJarPassword: String by project

plugins {
    kotlin("jvm")
    id("java-gradle-plugin")
    id("com.gradle.plugin-publish") version "1.1.0"
}

description = "DevOps Boot Gradle Plugin"

dependencies {
    implementation(Libs.KotlinGradlePlugin)
    implementation(Libs.SpringBootGradlePlugin)
    implementation(Libs.DependencyManagement)
    implementation(Libs.KotlinSpringGradlePlugin)
    implementation(Libs.GoogleJibPlugin)
    implementation(Libs.KtLint) {
        // ktlint 引用了1.4.31版本，和项目引入的1.6.21有冲突
        exclude(group = "org.jetbrains.kotlin", module = "kotlin-stdlib-jdk8")
    }
}

gradlePlugin {
    website = "https://ifp3-dev.cloudbills.cn/"
    vcsUrl = "https://ifp3-dev.cloudbills.cn/"
    plugins {
        create("DevOpsBootPlugin") {
            id = "com.tencent.devops.boot"
            displayName = "DevOps Boot Gradle Plugin"
            description = "DevOps Boot Gradle Plugin"
            tags = listOf("DevOps")
            implementationClass = "com.tencent.devops.DevOpsBootPlugin"
        }
    }
}

publishing {
    repositories {
        maven {
            url = uri(snapshotRepo)
            isAllowInsecureProtocol = true
            credentials {
                username = allJarUsername
                password = allJarPassword
            }
        }
    }
}