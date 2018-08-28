package com.nemosw.localpublish

class LocalPublishingExtension {

    private Object artifactId

    LocalPublishingExtension(Object artifactId) {
        this.artifactId = artifactId
    }

    Object getArtifactId() {
        return artifactId
    }

    void artifactId(Object artifactId) {
        this.artifactId = artifactId
    }
}
