plugins {
    alias(libs.plugins.android.application)
}

    android {
    namespace = "dam.iessanjose.composedemo"
        compileSdk {
            version = release(37)
        }

        defaultConfig {
      applicationId = "dam.iessanjose.composedemo"
    minSdk = 36
    targetSdk = 37
    versionCode = 1
    versionName = "1.0"

    }

    buildTypes {
          release {
              optimization {
                  enable = true
                  packageScope = setOf("androidx.**", "kotlin.**", "kotlinx.**")
              }
          }
      }
        compileOptions {
            sourceCompatibility = JavaVersion.VERSION_11
            targetCompatibility = JavaVersion.VERSION_11
        }
    }

  dependencies {
      implementation(libs.androidx.core.ktx)
  }