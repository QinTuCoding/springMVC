#springMVC实现hibernate多对多映射规则
![many to many](/08.hibernateManyToManyCRUD/manytomany.png)
- APP_USER :包含用户。一个用户可以有多个配置[USER，ADMIN，DBA]。

- USER_PROFILE : 包含用户配置文件。配置文件可以链接到多个用户。

- APP_USER_USER_PROFILE : 这是一个连接表连接APP_USER＆USER_PROFILE中的多对多关系。
##持久化类user的多对多映射规则如下
```java
	@NotEmpty
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "APP_USER_USER_PROFILE", 
             joinColumns = { @JoinColumn(name = "USER_ID") }, 
             inverseJoinColumns = { @JoinColumn(name = "USER_PROFILE_ID") })
	private Set<UserProfile> userProfiles = new HashSet<UserProfile>();
```
    @ManyToMany表示多对多映射,fetch = FetchType.LAZY指定延迟加载
    @JoinTable表示它使用两个表的表外键链接来约束自己的主键
    @joinColumns是指拥有方(用户ID)的列名，@inverseJoinColumns是指关系的反向端(USER_PROFILE的ID)的列

##dao层继承AbstractDao,AbstractDao封装了数据库的持久化方法,继承类使用如下方法进行查询
```java
    Criteria crit = createEntityCriteria();
		crit.add(Restrictions.eq("ssoId", sso));
		User user = (User)crit.uniqueResult();
```
