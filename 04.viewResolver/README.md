#04.springMVC创建xml,pdf,excel,json视图解析器 根据后缀名解析对应视图
##appconfig.java详解
- configureContentNegotiation用于通过委托给ContentNegotiationManager，以确定所请求的媒体类型的请求是 ContentNegotiationStrategy 
    列表的一个实例。默认情况下PathExtensionContentNegotiationStrategy被查询(使用URL扩展名，例如. .xls, .pdf,.json.)，
    接着ParameterContentNegotiationStrategy(使用请求参数 ‘format=xls’，例如)，其次是HeaderContentNegotiationStrategy(使用HTTP接受头)。
- TEXT_HTML在没有文件扩展名或当文件类型是未知时调用jspViewResovler返回Prefix+reutrn+Suffix的物理视图页面
- contentNegotiatingViewResolver中ContentNegotiationManager manager由spring注入，并为每一个应用程序设置不同的解析器。
##viewresolver文件中则是创建的各个视图的解析器。
