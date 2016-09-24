#springMVC下载项目内文件和项目外文件
##controller/FileDownloadController.java 
```java
  //项目内文件
  private static final String INTERNAL_FILE="irregular-verbs-list.pdf";
  //项目外文件
	private static final String EXTERNAL_FILE_PATH="D:/licyun.zip";
```
##下载步骤
- 创建一个InputStream到文件用于下载。
- 查找MIME类型下载文件的内容。
- 可以是application/pdf, text/html,application/xml,image/png等等。
- 将内容类型与上述发现的MIME类型响应（HttpServletResponse）。
- response.setContentType(mimeType);
- 针对以上找到MIME类型设置内容长度。
- response.setContentLength(file.getLength());//length in bytes
- 为响应设置内容处理标头。
- response.setHeader(“Content-Disposition”, “attachment; filename=” + fileName); 
//随着“附件”文件将下载。可能会显示一个“另存为”基于浏览器的设置对话框。
- response.setHeader(“Content-Disposition”, “inline; filename=” + fileName);
//通过“内联”浏览器将尝试显示内容到浏览器中（图片，PDF，文本，...）。对于其他内容类型，文件将直接下载。

- 从InputStream中复制字节响应到 OutputStream。
- 一旦复制完成后，关闭输入输出流。
