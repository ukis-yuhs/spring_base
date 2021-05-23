## 说明
1. spring
2. Spring MVC
3. mybatis
4. druid
5. mysql
6. lombok
7. Jackson
8. logback
9. jsp
10. validator
11. email
12. redis

## 访问说明
1. 测试路径

    1.1 关于访问路径
        工程默认访问路径【http://localhost:8080/springmvc_rbac_war_exploded】,
        但我需要直接访问根目录【http://localhost:8080/】。
        所以需要通过修改tomcat配置
        
        1. 修改URL【http://localhost:8080/springmvc_rbac_war_exploded/】->【http://localhost:8080/】
        2. 修改Deployment的Application context【/springmvc_rbac_war_exploded】->【/】
2. 登录页
    http://localhost:8080/signin.jsp
    用户名:admin@qq.com
    密码:12345678
http://localhost:8080/springmvc_rbac_war_exploded/test/hello.json

## mybatis自动生成工具
    /generator
## 前端ACE模版
    1. 路径 
    /resource/template/ace-master.zip
    2. 说明
    https://blog.csdn.net/alex_chen_16/article/details/50889924