import com.sbeen.buildlogic.convention.configureHiltKotlin

plugins {
    id("sbeen.kotlin.library")
}

configureHiltKotlin()

dependencies {
    testImplementation(project(":core:testing"))
}
