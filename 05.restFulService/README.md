#05.springMVC创建RESTFul模式的实例
##HelloWorldRestController.java详解
- @RestController标识返回一个pojo代替视图。所以本实例中无需配置spring-mvc-servlet.xml或HellowWorldConfiguration的映射规则
- @RequestMapping("/hello/{player}")

    public Message message(@PathVariable String player){}
    /hello/{player} 的路径即为RESTFul格式，@PathVariable String player 取出路径中的player参数
##POJO message类指定@XmlRootElement返回xml，不指定默认返回json
