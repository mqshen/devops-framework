plugins {
    id("maven-publish")
}

publishing {
    publications {
        plugins.findPlugin(JavaPlugin::class.java)?.let {
            create<MavenPublication>("jar") {
                from(components["java"])
            }
        }
        plugins.findPlugin(JavaPlatformPlugin::class.java)?.let {
            create<MavenPublication>("pom") {
                from(components["javaPlatform"])
            }
        }
        create<MavenPublication>("mavenJava") {
            pom {
                name.set(project.name)
                description.set(project.description ?: project.name)
                url.set("https://github.com/bkdevops-projects/devops-framework")
                licenses {
                    license {
                        name.set("The MIT License (MIT)")
                        url.set("https://opensource.org/licenses/MIT")
                    }
                }
                developers {
                    developer {
                        name.set("blueking")
                        email.set("contactus_bk@tencent.com")
                        url.set("https://github.com/TencentBlueKing")
                        roles.set(listOf("Java Developer"))
                    }
                }
                scm {
                    connection.set("scm:git:git://github.com/bkdevops-projects/devops-framework.git")
                    developerConnection.set("scm:git:ssh://github.com/bkdevops-projects/devops-framework.git")
                    url.set("https://github.com/bkdevops-projects/devops-framework")
                }
            }
        }
    }
}