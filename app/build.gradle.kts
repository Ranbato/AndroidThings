import com.android.build.gradle.internal.cxx.configure.gradleLocalProperties

plugins {
    id ("com.android.application")
    id ("org.jetbrains.kotlin.android")
    id ("org.jetbrains.kotlin.plugin.serialization") // required for serialization classes to exist
    id("org.openapi.generator") version "5.4.0" // "6.0.1"
}

val myProp = gradleLocalProperties(rootDir)

android {
    compileSdk =32

    defaultConfig {
        applicationId = "com.example.myapplication"
        minSdk = 27
        targetSdk = 27
        version = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {


        release {
            isMinifyEnabled = true
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")

            myProp.forEach{entry -> if(entry.key != "sdk.dir")  buildConfigField("String", entry.key.toString(), entry.value.toString()) }
        }

        debug {
            isMinifyEnabled = false
            myProp.forEach{entry -> if(entry.key != "sdk.dir")  buildConfigField("String", entry.key.toString(), entry.value.toString()) }
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        viewBinding = true
    }

//    println("=== Original Main Paths ${sourceSets.findByName("main")?.kotlin?.srcDirs() }")
//    sourceSets.findByName("main")?.java?.srcDir(File("${projectDir}/src/generated/src/main/kotlin"))
//    sourceSets.findByName("test")?.java?.srcDir(File("${projectDir}/src/generated/src/test/kotlin"))
}



dependencies {

    compileOnly ("com.google.android.things:androidthings:1.0")

    implementation ("androidx.core:core-ktx:1.7.0")
    implementation ("androidx.appcompat:appcompat:1.5.1")
    implementation ("com.google.android.material:material:1.6.1")
    implementation ("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation ("androidx.navigation:navigation-fragment-ktx:2.5.2")
    implementation ("androidx.navigation:navigation-ui-ktx:2.5.2")
    implementation("org.jetbrains.kotlin:kotlin-reflect:1.7.20")
    implementation("com.squareup.moshi:moshi-kotlin:1.14.0")
    implementation("com.squareup.moshi:moshi-adapters:1.14.0")
    implementation("com.squareup.okhttp3:okhttp:4.10.0")
    implementation("org.jetbrains.kotlin:kotlin-reflect:1.7.20")




    testImplementation ("junit:junit:4.13.2")
    androidTestImplementation ("androidx.test.ext:junit:1.1.3")
    androidTestImplementation ("androidx.test.espresso:espresso-core:3.4.0")


    compileOnly ("com.google.android.things:androidthings:1.0")

    implementation("com.google.android.things.contrib:driver-button:1.0")
    implementation("com.google.android.things.contrib:driver-bmx280:1.0")
    implementation("com.google.android.things.contrib:driver-ht16k33:1.0")
    implementation("com.google.android.things.contrib:driver-apa102:1.0")
    implementation("com.google.android.things.contrib:driver-pwmspeaker:1.0")
    implementation("com.google.android.things.contrib:driver-rainbowhat:1.0")
    implementation("com.google.zxing:core:3.5.0")
    implementation("com.google.zxing:javase:3.5.0")
    implementation("com.github.kenglxn.QRGen:android:2.6.0")

    // Kotlin logging helper https://github.com/MicroUtils/kotlin-logging
    implementation("io.github.microutils:kotlin-logging-jvm:3.0.0")

    // https://mvnrepository.com/artifact/com.android.volley/volley
//    implementation("com.android.volley:volley:1.2.1")

    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.4.0")

//    implementation("org.jetbrains.kotlin:kotlin-reflect:1.6.20")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin:2.13.4")



}


//// Validating a single specification
//// https://github.com/OpenAPITools/openapi-generator/blob/master/modules/openapi-generator-gradle-plugin/README.adoc#openapivalidate-1
//tasks.openApiValidate {
//    // This should be the YAML for this project
//    inputSpec.set("$projectDir/api/unifiapi.yaml")
//    recommend.set(true)
//}
//
//// https://github.com/OpenAPITools/openapi-generator/blob/master/modules/openapi-generator-gradle-plugin/README.adoc
//// https://github.com/OpenAPITools/openapi-generator/blob/master/bin/configs/kotlin-spring-boot.yaml
//// https://github.com/OpenAPITools/openapi-generator/blob/master/bin/configs/kotlin-jvm-okhttp4-coroutines.yaml
//tasks.openApiGenerate {
//    generatorName.set("kotlin")
//    library.set("jvm-okhttp4")
//    inputSpec.set("$projectDir/api/unifiapi.yaml")
//    outputDir.set("${projectDir}/src/generated")
//    apiPackage.set("org.lambertland.androidthings.unifiapi.generated.api")
//    packageName.set("org.lambertland.androidthings.unifiapi.generated")
//    modelPackage.set("org.lambertland.androidthings.unifiapi.generated.model")
//
//    generateModelDocumentation.set(true)
//    generateApiDocumentation.set(true)
//    generateModelTests.set(true)
//    generateApiTests.set(false) // This seems to interact poorly with "reactive" to "true".  Probably better to generate once and modify for now.  @TODO submit bug report
//
//    // https://github.com/OpenAPITools/openapi-generator/blob/master/docs/generators/spring.md
//    configOptions.set(
//        mapOf(
//            "dateLibrary" to "java8",
//            "hideGenerationTimestamp" to "true",
////            "useTags" to "true",
//            "performBeanValidation" to "true",
//            "beanValidations" to "true",
//            "modelMutable" to "true",
//            "skipOverwrite" to "false", // XXX Warning!  TRUE means you have to do a clean if you want to regenerate!
//            "enumPropertyNaming" to "UPPERCASE"
//        )
//    )
//}
//
//// Guarantee execution order
//tasks.build.configure {dependsOn("openApiGenerate")}
//
//// Guarantee execution order
//tasks.check.configure {
//    dependsOn("openApiValidate")
//}
//
