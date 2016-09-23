##02.springMVC使用Anonation代替xml配置
- [HelloWorldInitianlizer.java](https://github.com/mzkwy/springMVC/blob/master/02.annotationSpringMVC/src/main/java/com/licyun/configuration/HelloWorldInitializer.java)对应[web.xml](https://github.com/mzkwy/springMVC/blob/master/01.helloSpringMVC/src/main/webapp/WEB-INF/web.xml)
```java
public void onStartup(ServletContext container) throws ServletException {

		AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
		ctx.register(HelloWorldConfiguration.class);
		ctx.setServletContext(container);

		ServletRegistration.Dynamic servlet = container.addServlet(
				"dispatcher", new DispatcherServlet(ctx));

		servlet.setLoadOnStartup(1);
		servlet.addMapping("/");
	}
}
//或者简写为
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class HelloWorldInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class[] { HelloWorldConfiguration.class };
	}
 
	@Override
	protected Class<?>[] getServletConfigClasses() {
		return null;
	}
 
	@Override
	protected String[] getServletMappings() {
		return new String[] { "/" };
	}

}
```
对应
```xml
    <servlet>
		<servlet-name>mvc-dispatcher</servlet-name>
		<servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
        <load-on-startup>1</load-on-startup>
	</servlet>

	<servlet-mapping>
		<servlet-name>mvc-dispatcher</servlet-name>
		<url-pattern>/</url-pattern>
	</servlet-mapping>
```

- [HelloWorldConfiguration.java](https://github.com/mzkwy/springMVC/blob/master/02.annotationSpringMVC/src/main/java/com/licyun/configuration/HelloWorldConfiguration.java)对应[spring-mvc-servlet.xml](https://github.com/mzkwy/springMVC/blob/master/01.helloSpringMVC/src/main/webapp/WEB-INF/mvc-dispatcher-servlet.xml)
```java
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.licyun")
public class HelloWorldConfiguration {
	
	@Bean(name="HelloWorld")
	public ViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setViewClass(JstlView.class);
		viewResolver.setPrefix("/WEB-INF/views/");
		viewResolver.setSuffix(".jsp");

		return viewResolver;
	}

}
```
对应
```
<context:component-scan base-package="com.licyun"/>
    <bean
            class="org.springframework.web.servlet.view.InternalResourceViewResolver">
        <property name="prefix">
            <value>/WEB-INF/pages/</value>
        </property>
        <property name="suffix">
            <value>.jsp</value>
        </property>
    </bean>
```
