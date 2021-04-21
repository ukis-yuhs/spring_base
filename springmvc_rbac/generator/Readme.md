## mybatis Generator生成配置
1. 单独配置
    1. 配置generatorConfig.xm，按实际情况填写
    2. 命令行运行[java -jar mybatis-generator-core-1.3.2.jar -configfile generator.xml -overwrite]
2. 集成到pom配置
    1. 在pom.xml添加plugin，并指定generatorConfig.xml位置
    2. 配置generatorConfig.xm，按实际情况填写
    3. 运行[Plugins] -> mybatis-generator -> mybatis-generator:generate