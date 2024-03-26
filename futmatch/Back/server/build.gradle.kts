plugins {
    id("java")
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    implementation("org.hibernate.orm:hibernate-core:6.4.4.Final")
    implementation("com.sparkjava:spark-core:2.9.3")
    implementation("org.hibernate.orm:hibernate-jcache:6.4.4.Final")
    implementation("org.hibernate.orm:hibernate-spatial:6.4.4.Final")
    implementation("org.hibernate.orm:hibernate-envers:6.4.4.Final")
    implementation("org.hibernate.orm:hibernate-hikaricp:6.4.4.Final")
    implementation("org.hibernate.orm:hibernate-c3p0:6.4.4.Final")
    implementation("org.hibernate.orm:hibernate-proxool:6.4.4.Final")
    implementation("org.hibernate.orm:hibernate-osgi:6.4.4.Final")
}

tasks.test {
    useJUnitPlatform()
}