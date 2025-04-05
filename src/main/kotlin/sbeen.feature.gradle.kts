import com.sbeen.buildlogic.convention.configureHiltAndroid
import com.sbeen.buildlogic.convention.configureCompose
import com.sbeen.buildlogic.extensions.libs

plugins {
    id("heydealer.recruit.android.library")
}

with(plugins) {
    apply("org.jetbrains.kotlin.plugin.serialization")
}

configureCompose()
configureHiltAndroid()

dependencies {
    implementation(project(":core:designsystem"))
    testImplementation(project(":core:testing"))

    val libs = project.extensions.libs
    implementation(libs.findLibrary("kotlinx.serialization.json").get())
    implementation(libs.findLibrary("androidx.compose.navigation").get())
    implementation(libs.findLibrary("hilt.navigation.compose").get())
    implementation(libs.findLibrary("kotlinx.immutable").get())
    testImplementation(libs.findLibrary("turbine").get())
}
