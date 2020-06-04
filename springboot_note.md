## 一、springboot

- 开发流程
    - 创建一个maven工程
    - 导入springboot相关的依赖
    - 编写主程序，是启动springboot应用的
    - 编写相关的controller、service，无需配置
    - 运行主程序

- 部署流程
    - 导入maven插件
    - 打包成jar包，在命令行执行"java -jar"命令可运行起来
    - 目标服务器无需安装tomcat，jar包中自带tomcat环境

- Pom文件
    - 父项目<parent>还有父项目，管理springboot的所有依赖版本
    - 导入的依赖：spring-boot-starter-web，springboot的一个
        场景启动器，导入web模块运行需要的组件

- 主程序类
    - @SpringBootApplication，标记主程序是springboot应用程序，包含：
      - @SpringBootConfiguration，配置类
      - @EnableAutoConfiguration，开启自动配置功能
      - 将主配置类（@SpringBootApplication标记的类）的包及下面子包中的所有组件扫描到Spring容器

## 二、配置文件

- 全局配置文件
    - application.properties
    - application.yml

- yml语法
    - k: v （中间的空格不能少）
    - 左对齐的是同一层级的，缩进的矮一级
    - 区分大小写，字符串无需加引号
```yml
a. 基本数据类型(&包装类)
server:
  port: 8090
  path: /hi

b. 引用数据类型
person:
    name: liu
    age: 20
或
person: {name: liu, age: 20}

c. 数组\集合
pets:
    - cat
    - dog
    - fish
或
pets: {cat,dog,fish}
```
