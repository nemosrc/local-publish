# Gradle local-publish
It's simple to make public in Local maven repository. <br/>
프로젝트를 로컬 메이븐 저장소에 공개하는 테스크를 작성하는 플러그인입니다.<br/>
(내부적으로 maven-publish 플러그인을 사용합니다.)

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
