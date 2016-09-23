#05.springMVC创建RESTFul模式的实例
##RESTful风格
- 创建资源：应该使用 HTTP POST
- 要获取资源：应该使用HTTP GET
- 更新资源：应使用HTTP PUT
- 要删除资源：应使用HTTP DELETE
- 使用springmvc的@RequestMapping(value = "/user/{id}", method = RequestMethod.GET) RequestMethod.POST PUT DELETE 来绑定对应方法。
##HelloWorldRestController.java详解
- @RestController标识返回一个pojo代替视图。所以本实例中无需配置spring-mvc-servlet.xml或HellowWorldConfiguration的映射规则
- @RequestMapping("/hello/{player}")

    public Message message(@PathVariable String player){}
    /hello/{player} 的路径即为RESTFul格式，@PathVariable String player 取出路径中的player参数
##POJO message类指定@XmlRootElement返回xml，不指定默认返回json

