# Fat Jar
To create the fat jar I copied the multi-project of the challenge 1 of Gradle and followed the instructions of the next link [Gradle Fat Jar](https://www.baeldung.com/gradle-fat-jar), where in the build.gradle file put the next code:

```gradle
task customFatJar(type: Jar) {
    manifest {
        attributes 'Main-Class': 'vehiclefactory.VehicleFactory'
    }
    baseName = 'all-in-one-jar'
    from { configurations.compile.collect { it.isDirectory() ? it : zipTree(it) } }
    with jar
}
```
This code I put in the root build.gradle of the project and run the command:

```gradle
gradle build
```
without errors

I copied and pasted the fatJar.jar in the root of the project.