# springMVC
##01.springMVC常用注解实例 使用xml配置
###注解说明
- @Controller        负责注册一个bean 到spring 上下文中
- @RequestMapping    注解为控制器指定可以处理哪些 URL 请求
- @RequestBody       该注解用于读取Request请求的body部分数据
- @ModelAttribute    从隐含对象中获取隐含的模型数据中获取对象，再将请求参数绑定到对象中，再传入入参将方法入参对象添加到模型中 
- @RequestParam　    在处理方法入参处使用 @RequestParam 可以把请求参 数传递给请求方法
- @PathVariable      绑定URL 占位符到入参
- @ExceptionHandler  出现异常时会执行该方法
- @ControllerAdvice　使一个Contoller成为全局的异常处理类，类中用@ExceptionHandler方法注解的方法可以处理所有Controller发生的异常

###示例说明：
    web.xml中配置的DispatcherServlet核心spring转发器，会自动匹配*-servlet.xml。
    *-servlet.xml中的InternalResourceViewResolver会将返回的物理视图转化为 prefix + return + suffix。

##02.springMVC使用Anonation代替xml配置
- [HelloWorldInitianlizer.java](https://github.com/mzkwy/springMVC/blob/master/02.annotationSpringMVC/src/main/java/com/licyun/configuration/HelloWorldInitializer.java)对应[web.xml](https://github.com/mzkwy/springMVC/blob/master/01.helloSpringMVC/src/main/webapp/WEB-INF/web.xml)

- [HelloWorldConfiguration.java](https://github.com/mzkwy/springMVC/blob/master/02.annotationSpringMVC/src/main/java/com/licyun/configuration/HelloWorldConfiguration.java)对应[spring-mvc-servlet.xml](https://github.com/mzkwy/springMVC/blob/master/01.helloSpringMVC/src/main/webapp/WEB-INF/mvc-dispatcher-servlet.xml)


