# Anatomy of a Spring Project

Walk through from: 

- Basic java program
- Building the same program as a jar
- Spring Boot
- Stripped spring project

# Basic java

#### Pain points

- Class files all over the place
- What if I want an external package? I have to download it into a specific folder directory (whatever the package is - `com.foo.bar.formatter` must live at `com/foo/bar/formatter`)
- What if I want to deploy this on a server? Have to download every file, compile class files for every package - basically set up a dev environment

#### What's next

- Let's look at how we can solve the problem of deployment with jar files

# Basic java jar

#### Pain points

- Every single class needs to be included manually
- What if I want an external package? I have to download it into a specific folder directory (whatever the package is - `com.foo.bar.formatter` must live at `com/foo/bar/formatter`)

#### What's next

- Let's look at how we can solve the above pain points with a better compiler that has built in dependency management: gradle
- Side note: ant vs maven vs gradle (*bias and subjectivity incoming*)
    - [Apache Ant](http://ant.apache.org/) is the oldest - built on the back of the eclipse IDE. Nice in 2003, not so nice these days
    - [Maven](http://maven.apache.org/plugins/maven-compiler-plugin/) is newer - built to handle dependency management very similarly to how centralized repos and Gemfiles in ruby work, plus a whole bunch of extra junk (task management, property config at compile time, etc). Suffers from bloat, xml-y mystery tags and general badness, and pretty weak documentation
    - [Gradle](https://gradle.org/) is the latest - basically a 1:1 rebuild of maven but written in groovy (allows you to write your own task / build code easily as opposed to xml config) and json, with much newer documentation. Suffers from very slow community adoption (typically find a solution to your problem for maven and have to bootstrap to gradle)
    - Recommend gradle, but whatever you choose try to avoid ant

# Spring Boot

#### Pain points

- Spring boot is loaded with defaults. If you're at all interested in making an app that doesn't very closesly fit the springboot way, you're in for a bad time
- Lots and lots of magic via annotations and extension. Your setup may run smoothly 90% of the time developing but the 10% of problem solving might *suck*
- The amount of spring knowledge you have to know rises quickly, and you may find yourself requiring new devs to be 'spring' developers moreso than 'java' developers

#### Spring Boot goodness

- Pretty quick to get up and running compared to most other java frameworks and projects, thanks to example-based documentation
- Magic is frequently nice - lot of stuff comes for free, or without having to figure out how xyz works

#### What's next

Let's make a spring app in which we can:

- Pick-and-choose what your app relies on based on what it *needs* and not what slides in easiest / comes by default
- Have less magic = lower learning curve = easier to get people onto the project
- Adopt a component style (similar to ruby engines) to allow our app to scale well, and have multiple apps to share components
- Avoid using a `main()` method (remember trying to test main in go?)

# End result: stripped spring program

#### Pain points

- Vanilla spring documentation is pretty good, but little documentation around piecing it all together

# Deployment

- If your app includes some sort of `config.xml`, `connection.properties`, `foo.bar` etc. etc., your deployment environment needs one too
- Better, conventional method is to use JNDI: your server gets booted with configuration variables that your app can access

# Servers

- [Jetty](http://eclipse.org/jetty/) and [Tomcat](http://tomcat.apache.org/) are most popular
- Either works just as well. My preference is jetty because it's far more lightweight and terse, and requires much less configuration
- Deploy an app by place your `.war` into the respective `webapps` folder. Next time the server restarts it will run all `.war` files inside the folder
- Specify `.xml` files that define attributes for your app. Jetty example:

    ```
    root.xml

    <?xml version="1.0"?>
    <!DOCTYPE Configure PUBLIC "-//Mort Bay Consulting//DTD Configure//EN" "http://jetty.mortbay.org/configure.dtd">
     
    <Configure class="org.eclipse.jetty.webapp.WebAppContext">

        <Set name="contextPath">/</Set>
        <Set name="war"><Property name="jetty.home" default="." />/path/to/my/app.war</Set>

        <New id="foo" class="org.eclipse.jetty.plus.jndi.EnvEntry">
            <Arg>foo</Arg>
            <Arg type="java.lang.String">"some config thing"</Arg>
        </New>

        <New id="bar" class="org.eclipse.jetty.plus.jndi.EnvEntry">
            <Arg>bar</Arg>
            <Arg type="java.lang.Double">55.0</Arg>
        </New>

        <!-- an XADataSource                                                -->
        <New id="mydatasource99" class="org.eclipse.jetty.plus.jndi.Resource">
            <Arg>jdbc/mydatasource99</Arg>
            <Arg>
            <New class="com.atomikos.jdbc.SimpleDataSourceBean">
                <Set name="xaDataSourceClassName">org.apache.derby.jdbc.EmbeddedXADataSource</Set>
                <Set name="xaDataSourceProperties">databaseName=testdb99;createDatabase=create</Set>
                <Set name="UniqueResourceName">mydatasource99</Set>
            </New>
            </Arg>
        </New>
     
    </Configure>
    ```