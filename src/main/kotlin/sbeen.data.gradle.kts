import com.sbeen.buildlogic.convention.configureHiltKotlin

plugins {
    id("sbeen.kotlin.library")
}

with(plugins) {
    apply("org.jetbrains.kotlin.plugin.serialization")
}

configureHiltKotlin()

dependencies {
    implementation(project(":core:network"))
    testImplementation(project(":core:testing"))
}
