##springMVC配合hibernate返回json对象 使用xml配置

##application.xml配置文件如下
```xml
    <!-- 使用C3P0数据源，MySQL数据库 -->
    <bean id="dataSource" class="com.mchange.v2.c3p0.ComboPooledDataSource"
          destroy-method="close">
        <!-- MySQL5 -->
        <property name="driverClass" value="${database.driverClass}"></property>
        <property name="jdbcUrl" value="${database.jdbcUrl}"></property>
        <property name="user" value="${database.user}"></property>
        <property name="password" value="${database.password}"></property>
        <property name="maxPoolSize" value="40"></property>
        <property name="minPoolSize" value="1"></property>
        <property name="initialPoolSize" value="1"></property>
        <property name="maxIdleTime" value="20"></property>
    </bean>
    <!-- session工厂 -->
    <bean id="sessionFactory"
          class="org.springframework.orm.hibernate4.LocalSessionFactoryBean">
        <property name="dataSource" ref="dataSource" />
        <property name="packagesToScan" value="com.licyun.model" />
        <property name="hibernateProperties">
            <props>
                <prop key="hibernate.hbm2ddl.auto">${hibernate.hbm2ddl.auto}</prop>
                <prop key="hibernate.dialect">${hibernate.dialect}</prop>
                <prop key="hibernate.show_sql">${hibernate.show_sql}</prop>
                <prop key="hibernate.format_sql">${hibernate.format_sql}</prop>
                <prop key="hibernate.jdbc.lob.non_contextual_creation">true</prop>
            </props>
        </property>
    </bean>
    <!-- 事务配置 -->
    <bean id="transactionManager"
          class="org.springframework.orm.hibernate4.HibernateTransactionManager">
        <property name="sessionFactory" ref="sessionFactory"></property>
    </bean>
    <!-- 声明事务配置使用注解方式 -->
    <tx:annotation-driven transaction-manager="transactionManager" />
```
