# Spring boot sample

[Official spring boot sample](https://github.com/spring-projects/spring-boot/tree/master/spring-boot-samples/spring-boot-sample-simple)

### Compiling and running

```
jadekler at Jeans-MacBook-Pro in ~/workspace/git-java-anatomy/spring-boot on master*
$ gradle bootRun
:compileJava UP-TO-DATE
:processResources
:classes
:findMainClass
:bootRun

  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
 :: Spring Boot ::  (v1.3.0.BUILD-SNAPSHOT)

2015-04-26 14:26:36.680  INFO 39124 --- [           main] sample.simple.SampleSimpleApplication    : Starting SampleSimpleApplication on Jeans-MacBook-Pro.local with PID 39124 (/Users/jadekler/workspace/git-java-anatomy/spring-boot/build/classes/main started by jadekler in /Users/jadekler/workspace/git-java-anatomy/spring-boot)
2015-04-26 14:26:36.714  INFO 39124 --- [           main] s.c.a.AnnotationConfigApplicationContext : Refreshing org.springframework.context.annotation.AnnotationConfigApplicationContext@1a1d6a08: startup date [Sun Apr 26 14:26:36 MDT 2015]; root of context hierarchy
2015-04-26 14:26:37.127  INFO 39124 --- [           main] o.s.j.e.a.AnnotationMBeanExporter        : Registering beans for JMX exposure on startup
Hello Phil
2015-04-26 14:26:37.138  INFO 39124 --- [           main] sample.simple.SampleSimpleApplication    : Started SampleSimpleApplication in 0.648 seconds (JVM running for 0.939)
2015-04-26 14:26:37.139  INFO 39124 --- [       Thread-1] s.c.a.AnnotationConfigApplicationContext : Closing org.springframework.context.annotation.AnnotationConfigApplicationContext@1a1d6a08: startup date [Sun Apr 26 14:26:36 MDT 2015]; root of context hierarchy
2015-04-26 14:26:37.139  INFO 39124 --- [       Thread-1] o.s.j.e.a.AnnotationMBeanExporter        : Unregistering JMX-exposed beans on shutdown

BUILD SUCCESSFUL

Total time: 4.801 secs
```

(search for..)

```
Hello Phil
```

![](http://s2.quickmeme.com/img/69/69fbf7240f42620c870bdc173856ead82781e930db2ac505e941931fc2c24ea1.jpg)

### Gradle niceties

- Super easy to define your own tasks
- Dependencies are auto-downloaded from pre-specified repositories whenever they're needed by a task (like `gradle build`)
- `gradle build` - boom! a jar, ready to for deployment
- Other nice tasks: `gradle clean`, `gradle test`, `gradle dependenciesGraph` etc. (the former is a plugin you can install)

### Spring Boot pain points

- Spring boot is loaded with defaults. If you're at all interested in making an app that doesn't very closesly fit the springboot way, you're in for a bad time
- Lots and lots of magic via annotations and extension. Your setup may run smoothly 90% of the time developing but the 10% of problem solving might *suck*
- The amount of spring knowledge you have to know rises quickly, and you may find yourself requiring new devs to be 'spring' developers moreso than 'java' developers

### Spring Boot goodness

- Pretty quick to get up and running compared to most other java frameworks and projects, thanks to example-based documentation
- Magic is frequently nice - lot of stuff comes for free, or without having to figure out how xyz works

### Spring Boot documentation
- Seriously lacking documentation in some areas - for instance, how to build a web app! Also, 'usecase' driven documentation means that if your docume
- Usecase style documentation
    - Super, super nice set of examples written with both gradle and maven in mind
    - Great if your case matches, otherwise bad times
    - Very, very biased (e.x. of the few 'webapp' examples, thymeleaf templating is exclusively used - good luck trying to get JSPs compiled!)
- Huuuuuuuuuge breadth of topics and complete lack of deprecation
    - You'll search for a solution and find yourself looking at two solutions going, 'Wait, what? What is the different between spring REST and spring HATEOS??'
    - You'll find solutions from 2009 that sort-of do sort-of don't match your problem... ALL THE TIME
    - You'll start using a part of spring only to realize spring-boot 100% does not support it
- Spring team is very dedicated to keeping their documentation up to date