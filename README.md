# Anatomy of a Spring Project

Walk through from a basic java program, to building the same program as a jar, to Spring Boot, to a stripped spring project.

### End result: stripped spring program

Idea:

- Pick-and-choose what your app relies on based on what it *needs* and not what slides in easiest / comes by default
- Less magic = lower learning curve = easier to get people onto the project
- Component style (similar to ruby engines) allows an app to scale well, and multiple apps to share components
- No `main()` method (remember trying to test main in go?)

### Deployment

- If your app includes some sort of `config.xml`, `connection.properties`, `foo.bar` etc. etc., your deployment environment needs one too
- Better, conventional method is to use JNDI: your server gets booted with configuration variables that your app can access

### Servers

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