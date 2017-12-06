import com.beust.kobalt.plugin.application.application
import com.beust.kobalt.plugin.packaging.assemble
import com.beust.kobalt.project

val p = project {
    name = "kattis"
    group = "my.kattis"
    artifactId = "kattis-problem"
    version = "0.1"

    dependencies {
//        compile("com.beust:jcommander:1.68")
        compile("org.jetbrains.kotlin:kotlin-runtime:1.1.51")
        compile("org.jetbrains.kotlin:kotlin-stdlib:1.1.51")
    }

    dependenciesTest {
        compile("org.testng:testng:6.11")
    }

    assemble {
        jar {
        }
    }

    application {
//        mainClass = "com.example.MainKt"
    }
}
