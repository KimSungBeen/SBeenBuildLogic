package com.sbeen.buildlogic.convention

import com.sbeen.buildlogic.extensions.androidExtension
import com.sbeen.buildlogic.extensions.libs
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

internal fun Project.configureCompose() {
    with(plugins) {
        apply("org.jetbrains.kotlin.plugin.compose")
    }

    val libs = extensions.libs

    androidExtension.apply {
        buildFeatures {
            compose = true
        }

        composeOptions {
            kotlinCompilerExtensionVersion = "1.5.1"
        }

        dependencies {
            add("implementation", libs.findLibrary("androidx.activity.compose").get())

            val bom = libs.findLibrary("compose-bom").get()
            add("implementation", platform(bom))

            add("implementation", libs.findLibrary("compose.material3").get())
            add("implementation", libs.findLibrary("compose.ui").get())
            add("implementation", libs.findLibrary("compose.ui.tooling.preview").get())
            add("debugImplementation", libs.findLibrary("compose.ui.tooling").get())
        }
    }
}
