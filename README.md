# Gradle local-publish
It's simple to make publish in Local maven repository. <br/>

## build.gradle
```gradle
plugins {
  id "com.nemosw.local-publish" version "1.0"
}

localPublish {
//  artifactId 'local-publish'
}
```
#### Dynamic plugin apply
```gradle
buildscript {
  repositories {
    maven {
      url "https://plugins.gradle.org/m2/"
    }
  }
  dependencies {
    classpath "gradle.plugin.com.nemosw:spigot-publish:1.0"
  }
}

apply plugin: "com.nemosw.local-publish"
```

### Link
https://plugins.gradle.org/plugin/com.nemosw.local-publish
