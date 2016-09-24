#springMVC实现单文件上传和多文件上传
##initializer中注册上传文件类MultiPartConfigElement
```java
	@Override
	protected void customizeRegistration(ServletRegistration.Dynamic registration) {
		registration.setMultipartConfig(getMultipartConfigElement());
	}

	private MultipartConfigElement getMultipartConfigElement() {
		MultipartConfigElement multipartConfigElement = new MultipartConfigElement(	LOCATION, MAX_FILE_SIZE, MAX_REQUEST_SIZE, FILE_SIZE_THRESHOLD);
		return multipartConfigElement;
	
	private static final String LOCATION = "/upload"; // Temporary location where files will be stored

	private static final long MAX_FILE_SIZE = 5242880; // 5MB : Max file size.
														// Beyond that size spring will throw exception.
	private static final long MAX_REQUEST_SIZE = 20971520; // 20MB : Total request size containing Multi part.
	
	private static final int FILE_SIZE_THRESHOLD = 0; // Size threshold after which files will be written to disk
```
##创建上传文件模型类,这是一个 multipart 请求获得上传文件的表示
```java
public class FileBucket {

	MultipartFile file;
	
	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}

}
```
##FileUploadController核心上传控制器
```java
  //自动装载表单验证方法
  @Autowired
      FileValidator fileValidator;
  //对表单数据绑定,将filebucket对象绑定到fileValidator用于验证，并赋值给隐藏对象binder
  @InitBinder("fileBucket")
  protected void initBinderFileBucket(WebDataBinder binder) {
  	binder.setValidator(fileValidator);
  }
  //FileBucket获取客户端传递的文件数据,BindingResult获得上面验证方法
  @RequestMapping(value = "/singleUpload", method = RequestMethod.POST)
  	public String singleFileUpload(@Valid FileBucket fileBucket,
  			BindingResult result, ModelMap model, HttpServletRequest request) throws IOException {
  //指定上传路径
  String path=request.getSession().getServletContext().getRealPath("/upload/");
  //创建MultipartFile对象用以获取文件信息
		MultipartFile multipartFile = fileBucket.getFile();
		//FileCopyUtils工具类流从源复制到目的地
		FileCopyUtils.copy(fileBucket.getFile().getBytes(), new File( path + fileBucket.getFile().getOriginalFilename()));
```
##singleFileUpload.jsp客户端上传文件信息
```jsp
//controller匹配fileBucket。文件格式为multipart/form-data
<form:form method="POST" modelAttribute="fileBucket" enctype="multipart/form-data" class="form-horizontal">
//输出biner.hasError()的错误信息
<form:errors path="files[${vs.index}].file" class="help-inline"/>
```
