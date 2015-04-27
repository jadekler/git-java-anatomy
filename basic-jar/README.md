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