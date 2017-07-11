**项目说明** 
- boot-businf集成了boot mybatis
<br> 
 
**本地部署**
- 下载源码
- doc 数据库脚本
- 修改application-dev.yml，更新MySQL账号和密码、数据库名称
- Eclipse、IDEA运行BootBusinfApplication.java，则可启动项目
- mybatis运行GeneratorConfig.java，则生成dao、entity、xml代码
- 接口访问路径http://localhost:8081/businf/girl/query.html?id=1

-maven 打包命令  mvn clean:clean package