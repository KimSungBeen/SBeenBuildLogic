import com.sbeen.buildlogic.convention.configureHiltKotlin

plugins {
    id("heydealer.recruit.kotlin.library")
}

with(plugins) {
    apply("org.jetbrains.kotlin.plugin.serialization")
}

configureHiltKotlin()

dependencies {
    implementation(project(":core:network"))
    testImplementation(project(":core:testing"))
}
