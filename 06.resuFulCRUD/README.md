#springMVC配合AugularJS实现RESTFul格式的数据交互及表单验证
##1. app.js  Angularjs的引导模块，加载该模块为应用程序的主入口点
```js
  'use strict';
  var App = angular.module('myApp',[]);
```
##2.user_service.js 使用AngularJS的$http服务和后端spring REST API进行通讯。
```js
'use strict';
App.factory('UserService', ['$http', '$q', function($http, $q){

	return {
		
			fetchAllUsers: function() {
					return $http.get('http://localhost:8080/user/')
							.then(
									function(response){
										return response.data;
									}, 
									function(errResponse){
										console.error('Error while fetching users');
										return $q.reject(errResponse);
									}
							);
			},
```
##3.user_controller.js Augular控制器,用户输入表单验证
```js
'use strict';

App.controller('UserController', ['$scope', 'UserService', function($scope, UserService) {
          var self = this;
          self.user={id:null,username:'',address:'',email:''};
          self.users=[];
              
          self.fetchAllUsers = function(){
              UserService.fetchAllUsers()
                  .then(
      					       function(d) {
      						        self.users = d;
      					       },
            					function(errResponse){
            						console.error('Error while fetching Currencies');
            					}
      			       );
          };
```
##4.configuration/HelloWorldInitializer.java  注册过滤器类
```java
    @Override
    protected Filter[] getServletFilters() {
    	Filter [] singleton = { new CORSFilter() };
    	return singleton;
	}
```
##5.configuration/CORSFilter.java创建过滤器处理同源策略的问题 
```java
public class CORSFilter implements Filter {

	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
		HttpServletResponse response = (HttpServletResponse) res;
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Methods", "POST, GET, PUT, OPTIONS, DELETE");
		response.setHeader("Access-Control-Max-Age", "3600");
		response.setHeader("Access-Control-Allow-Headers", "x-requested-with, Content-Type");
		chain.doFilter(req, res);
	}

	public void init(FilterConfig filterConfig) {}

	public void destroy() {}
```
##6.controller/HelloWorldRestController.java REST控制器
```java
@RestController
public class HelloWorldRestController {
 
    @Autowired
    UserService userService;  //Service which will do all data retrieval/manipulation work
 
    
    //-------------------Retrieve All Users--------------------------------------------------------
     
    @RequestMapping(value = "/user/", method = RequestMethod.GET)
    public ResponseEntity<List<User>> listAllUsers() {
        List<User> users = userService.findAllUsers();
        if(users.isEmpty()){
            return new ResponseEntity<List<User>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<User>>(users, HttpStatus.OK);
    }
```

  
