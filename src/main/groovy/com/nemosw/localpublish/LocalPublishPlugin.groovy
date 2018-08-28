package com.nemosw.localpublish

import org.gradle.api.Action
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.Task
import org.gradle.api.plugins.AppliedPlugin
import org.gradle.api.publish.maven.MavenPublication
import org.gradle.jvm.tasks.Jar

class LocalPublishPlugin implements Plugin<Project> {
    @Override
    void apply(Project target) {

        LocalPublishingExtension ext = target.extensions.create('localPublish', LocalPublishingExtension, target == target.getRootProject() ? target.name : "${target.rootProject.name}-${target.name}")
        def extArtifact = ext.getArtifactId()

        target.pluginManager.withPlugin('maven-publish', new Action<AppliedPlugin>() {

            @Override
            void execute(AppliedPlugin appliedPlugin) {
                target.javadoc {
                    options.encoding = 'UTF-8'
                }

                Jar sourceJar = target.tasks.create('localSourceJar', Jar) {
                    classifier = 'sources'
                    from target.sourceSets.main.java
                    includeEmptyDirs = false
                }

                Task javadocJar = target.tasks.create('localJavadocJar', Jar) {
                    classifier = 'javadoc'
                    from target.javadoc.destinationDir
                    includeEmptyDirs = false
                }

                javadocJar.dependsOn(target.tasks.javadoc)

                target.publishing {
                    publications {
                        spigot(MavenPublication) {
                            artifactId extArtifact
                            from target.components.java
                            artifact sourceJar
                            artifact javadocJar
                        }
                    }
                }
            }
        })

        if (!target.plugins.hasPlugin('maven-publish'))
            target.plugins.apply('maven-publish')
    }
}
