group = "app.youtubeoculus"

patches {
    about {
        name = "YouTube Oculus Patches"
        description = "Experimental YouTube VR patches for Meta Quest, compatible with Morphe"
        source = "https://github.com/zzz123789465/youtube-oculus-patches"
        author = "YouTube Oculus Patches contributors"
        contact = "https://github.com/zzz123789465/youtube-oculus-patches/issues"
        website = "https://github.com/zzz123789465/youtube-oculus-patches"
        license = "GPLv3"
    }
}

// Separate configuration so gson is available at runtime for the
// generatePatchesList task but never bundled into the APK.
val patchListGeneratorClasspath = configurations.create("patchListGeneratorClasspath")

dependencies {
    compileOnly(libs.gson)
    patchListGeneratorClasspath(libs.gson)
}

tasks {
    register<JavaExec>("generatePatchesList") {
        description = "Build patch with patch list"

        dependsOn(build)

        classpath = sourceSets["main"].runtimeClasspath + patchListGeneratorClasspath
        mainClass.set("util.PatchListGeneratorKt")
    }

    // Used by gradle-semantic-release-plugin.
    publish {
        dependsOn("generatePatchesList")
    }
}
