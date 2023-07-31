plugins {
    kotlin("jvm")
    id("java-gradle-plugin")
    id("publish")
}

description = "DevOps Publish Gradle Plugin"

dependencies {
    implementation(project(":devops-boot-project:devops-boot-tools:devops-gradle-plugin-common"))
    implementation(Libs.KotlinGradlePlugin)
    implementation(Libs.DependencyManagement)
}

gradlePlugin {
    plugins {
        create("DevOpsPublishPlugin") {
            id = "com.tencent.devops.publish"
            displayName = "DevOps Publish Gradle Plugin"
            description = "DevOps Publish Gradle Plugin"
            implementationClass = "com.tencent.devops.DevOpsPublishPlugin"
        }
    }
}
