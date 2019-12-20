# spring-boot-assembly

spring-boot项目模板

1. 在spring boot项目中使用`maven profiles`和`maven assembly`插件根据不同环境打包成tar.gz或者zip或者dir
2. 将spring boot项目中的配置文件提取到外部config目录中
3. 将spring boot项目中的启动jar包移动到boot目录中
4. 将spring boot项目中的第三方依赖jar包移动到外部lib目录中
5. bin目录中是启动，停止，重启服务命令

## 主要插件

1. maven-assembly-plugin
2. maven-jar-plugin
3. spring-boot-maven-plugin
4. maven-dependency-plugin
5. maven-resources-plugin

> 涉及到的变量解释：

- `@profileActive@`=`dev`
- `@build.directory@`=`target`
- `@build.outputDirectory@`=`target/classes`
- `@build.finalName@`=`spring-boot-assembly`
- `@build.sourceDirectory@`=`src/main/java`
- `@basedir@`=`.`
- `@project.name@`=`spring-boot-assembly`

## 项目源码结构

```text
├─bin
│      restart.sh
│      shutdown.sh
│      startup.bat
│      startup.sh
├─logs
│      startup.log
├─main
│  ├─assembly
│  │      assembly.xml
│  ├─java
│  │  └─com
│  │      └─quanshi
│  │          └─springbootassembly
│  │              ├─controller
│  │              │     HelloController.java
│  │              ├─orm
│  │              └─Application.java
│  └─resources
│      │  application.yml
│      │  application-dev.yml
│      │  application-prod.yml
│      │  application-test.yml
│      │  logback-spring.xml
│      ├─db
│      │      schema.sql
│      │      data.sql
│      ├─static
│      │      index.js
│      └─templates
│             index.html
└─test
```

## 项目打包

```bash
mvn clean package -Pdev
```

使用package脚本打包

> window

```bash
package.bat dev
```

> linux/mac

```bash
sh package.sh dev
```

打包的压缩包,target目录下

```bash
spring-boot-assembly-${profile}-${version}.tar.gz
```

### linux解压tar.gz

```bash
tar -zxvf spring-boot-assembly-${profile}-${version}.tar.gz
```

解压后的目录结构

```text
└─spring-boot-assembly
│  LICENSE
│  README.md
├─bin
│      restart.sh
│      shutdown.sh
│      startup.bat
│      startup.sh
├─boot
│      spring-boot-assembly.jar
├─config
│  │  application-*.yml
│  │  application.yml
│  │  logback-spring.xml
│  ├─static
│  │      index.js
│  └─templates
│         index.html
└─lib
        **.jar
```

### window启动

```bash
bin/startup.bat
```

### linux启动，停止，重启

```bash
sh bin/startup.sh  [dev|prod|test] 启动项目
sh bin/shutdown.sh  停止服务
sh bin/restart.sh   重启服务
```

### 项目访问

```text
http://localhost:8080/example/hello?name=tom
```

## 参考

- https://docs.spring.io/spring-boot/docs/current/maven-plugin/
- https://maven.apache.org/components/plugins/maven-assembly-plugin/usage.html
- https://maven.apache.org/plugins/maven-jar-plugin/
- https://maven.apache.org/components/plugins/maven-dependency-plugin/
- https://maven.apache.org/plugins/maven-resources-plugin/
- https://maven.apache.org/guides/introduction/introduction-to-profiles.html
