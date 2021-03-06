###注解说明
- @Service  用于标注业务层组件
- @Transactional 事务管理，声明这个service所有方法都需要事务管理
- @Controller  用于标注控制层组件（如struts中的action）
- @restController @RestController标识返回一个pojo代替视图
- @Repository  用于标注数据访问组件，即DAO组件
- @Component泛指组件，当组件不好归类的时候，我们可以使用这个注解进行标注。
- @RequestMapping    注解为控制器指定可以处理哪些 URL 请求
```java
    @RequestMapping("/hello")
    public String hello(Model model) {
```
- @ResponseBody       直接返回匹配的对象。无需映射到物理视图
```java
    @ResponseBody
    public String authorInfo(Model model) {
        return "saved";
    }
```
- @ModelAttribute    在put或者get前执行，并返回指定参数或对象。
```java
    //在form表单返回之前返回sections对象
	@ModelAttribute("sections")
	public List<String> initializeSections() {

		List<String> sections = new ArrayList<String>();
		sections.add("Graduate");
		sections.add("Post Graduate");
		sections.add("Research");
		return sections;
	}
```
- @Autowired  自动装配省略set和get方法
```java
UserService userService;
```
- @RequestParam　    在处理方法入参处使用 @RequestParam 可以把请求参 数传递给请求方法
```java
 public String setupForm(@RequestParam("petId") int petId, ModelMap model) {  
        Pet pet = this.clinic.loadPet(petId);  
```
- @PathVariable      绑定URL 占位符到入参
```java
    @RequestMapping("/web/fe/{sitePrefix}/{language}/document/{id}/{naturalText}")
    public String documentView(Model model,
            @PathVariable(value = "sitePrefix") String sitePrefix,
            @PathVariable(value = "language") String language,
            @PathVariable(value = "id") Long id,
            @PathVariable(value = "naturalText") String naturalText) {
    
        model.addAttribute("sitePrefix", sitePrefix);
        model.addAttribute("language", language);
        model.addAttribute("id", id);
        model.addAttribute("naturalText", naturalText);
```
- @ExceptionHandler  出现异常时会执行该方法
- @ControllerAdvice　使一个Contoller成为全局的异常处理类，类中用@ExceptionHandler方法注解的方法可以处理所有Controller发生的异常
- @Override 重写父方法

###示例说明：
    web.xml中配置的DispatcherServlet核心spring转发器，会自动匹配*-servlet.xml。
    *-servlet.xml中的InternalResourceViewResolver会将返回的物理视图转化为 prefix + return + suffix。
