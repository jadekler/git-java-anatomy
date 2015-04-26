# Basic java program compiled as a jar

--

### Compiling and running

```
jadekler at Jeans-MacBook-Pro in ~/workspace/git-java-anatomy/basic-jar on master*
$ tree
.
|____bam
| |____Bam.class
| |____Bam.java
|____boom
| |____Boom.class
| |____Boom.java
|____Kablam.class
|____Kablam.jar
|____Kablam.java
|____manifest.mf
|____README.md

jadekler at Jeans-MacBook-Pro in ~/workspace/git-java-anatomy/basic-jar on master*
$ jar cmf manifest.mf Kablam.jar Kablam.class boom/Boom.class bam/Bam.class

jadekler at Jeans-MacBook-Pro in ~/workspace/git-java-anatomy/basic-jar on master*
$ java -jar Kablam.jar
foo
bar
```

### Notes

- Now we can just deploy a single .jar file that has everything else packaged inside it! Hooray!!
- Manifest must be included, and must contain at least created_by (jdk version) and main-class (entry point for program)
- Inside the jar, manifest gets stored at META-INF/MANIFEST.MF (this will come up later)

### Pain points

- Every single class needs to be included manually
- What if I want an external package? I have to download it into a specific folder directory (whatever the package is - `com.foo.bar.formatter` must live at `com/foo/bar/formatter`)

### What's next

- Let's look at how we can solve the above pain points with a better compiler that has built in dependency management: gradle
- Side note: ant vs maven vs gradle (*bias and subjectivity incoming*)
    - [Apache Ant](http://ant.apache.org/) is the oldest - built on the back of the eclipse IDE. Nice in 2003, not so nice these days
    - [Maven](http://maven.apache.org/plugins/maven-compiler-plugin/) is newer - built to handle dependency management very similarly to how centralized repos and Gemfiles in ruby work, plus a whole bunch of extra junk (task management, property config at compile time, etc). Suffers from bloat, xml-y mystery tags and general badness, and pretty weak documentation
    - [Gradle](https://gradle.org/) is the latest - basically a 1:1 rebuild of maven but written in groovy (allows you to write your own task / build code easily as opposed to xml config) and json, with much newer documentation. Suffers from very slow community adoption (typically find a solution to your problem for maven and have to bootstrap to gradle)
    - Recommend gradle, but whatever you choose try to avoid ant. So bad.