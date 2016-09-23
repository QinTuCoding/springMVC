##SpringMVC实现hibernate的validation form表单验证
### student类中的 @Size  @NotEmpty  @Email....即为hibernate的JSR303规范实现
```java
  @Null   		被注释的元素必须为 null   
  @NotNull    		被注释的元素必须不为 null   
  @AssertTrue     	被注释的元素必须为 true   
  @AssertFalse  	被注释的元素必须为 false   
  @Min(value)     	被注释的元素必须是一个数字，其值必须大于等于指定的最小值   
  @Max(value)     	被注释的元素必须是一个数字，其值必须小于等于指定的最大值   
  @DecimalMin(value)    被注释的元素必须是一个数字，其值必须大于等于指定的最小值   
  @DecimalMax(value)    被注释的元素必须是一个数字，其值必须小于等于指定的最大值   
  @Size(max=, min=)     被注释的元素的大小必须在指定的范围内   
  @Digits (integer, fraction)     被注释的元素必须是一个数字，其值必须在可接受的范围内   
  @Past   		被注释的元素必须是一个过去的日期   
  @Future     		被注释的元素必须是一个将来的日期   
  @Pattern(regex=,flag=)  被注释的元素必须符合指定的正则表达式   
     
  Hibernate Validator   附加的 constraint   
  @NotBlank(message =)  验证字符串非null，且长度必须大于0   
  @Email  		被注释的元素必须是电子邮箱地址   
  @Length(min=,max=)    被注释的字符串的大小必须在指定的范围内   
  @NotEmpty   		被注释的字符串的必须非空   
  @Range(min=,max=,message=)  被注释的元素必须在合适的范围内
```
###jsp中则使用springMVC的form表单，对应student中的约束规则
```jsp
    <form:input type="text" path="lastName" id="lastName" class="form-control input-sm"/>
    <form:radiobutton path="sex" value="M" />Male 
    <form:radiobuttons path="section" items="${sections}" />
    <form:select path="country" id="country" class="form-control input-sm">
        <form:option value="">Select Country</form:option>
  	    <form:options items="${countries}" />
    </form:select>
```
###controller中则控制表单处理及items的返回
```java
	@RequestMapping(method = RequestMethod.POST)
	public String saveRegistration(@Valid Student student,
			BindingResult result, ModelMap model) {

		if (result.hasErrors()) {
			return "enroll";
		}

		model.addAttribute("success", "Dear " + student.getFirstName()
				+ " , your Registration completed successfully");
		return "success";
	}
	
	@ModelAttribute("sections")
	public List<String> initializeSections() {

		List<String> sections = new ArrayList<String>();
		sections.add("Graduate");
		sections.add("Post Graduate");
		sections.add("Research");
		return sections;
	}
```
###messages.properties添加国际化显示
