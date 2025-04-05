import com.sbeen.buildlogic.convention.configureHiltKotlin

plugins {
    id("heydealer.recruit.kotlin.library")
}

configureHiltKotlin()

dependencies {
    testImplementation(project(":core:testing"))
}
