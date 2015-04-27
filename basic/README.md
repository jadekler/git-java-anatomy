# Basic java program compiled with javac

--

### Compiling and running

```
jadekler at Jeans-MacBook-Pro in ~/workspace/git-java-anatomy/basic on master*
$ tree
.
|____bam
| |____Bam.java
|____boom
| |____Boom.java
|____Kablam.java
|____README.md

jadekler at Jeans-MacBook-Pro in ~/workspace/git-java-anatomy/basic on master*
$ javac Kablam.java

jadekler at Jeans-MacBook-Pro in ~/workspace/git-java-anatomy/basic on master*
$ tree
.
|____bam
| |____Bam.class
| |____Bam.java
|____boom
| |____Boom.class
| |____Boom.java
|____Kablam.class
|____Kablam.java
|____README.md

jadekler at Jeans-MacBook-Pro in ~/workspace/git-java-anatomy/basic on master*
$ java Kablam
foo
bar
```

### Notes

- `javac` creates .class files for each package
- Class names must be the same as file names
- Package names must conform to directory structure relative to classpath
- Classpath is default `.` (current directory)
- Therefore... MUST compile at project root
- Therefore in conversation you may find that classes and files, and packages and directories, are used interchangeable