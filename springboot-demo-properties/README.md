META-INF 相当于一个信息包，目录中的文件和目录获得 Java 2 平台的认可与解释，用来配置应用程序、扩展程序、类加载器和服务 manifest.mf 文件，在用 jar 打包时自动生成。

WEB-INF是Java的WEB应用的安全目录。所谓安全就是客户端无法访问，只有服务端可以访问的目录。如果想在页面中直接访问其中的文件，必须通过web.xml文件对要访问的文件进行相应映射才能访问。


springBoot 读取配置属性的值:
1.通过Environment读取配置信息
```
Environment是用来读取应用程序运行时的环境变量的类，可以通过key-value的方式
读取application.properties和系统环境变量，命令行输入参数，系统属性等.

```
2.通过@Value注解读取配置信息（推荐使用）

3.通过@ConfigurationProperties注解读取配置信息
```
@ConfigurationProperties注解用于指定前缀
@ConfigurationProperties只能加载以application为前缀开头的配置文件
生效方式：
方式1：配置@Component
方式2：启动类添加@EnableConfigurationProperties(ReadProperties.class)

当我们引用第三方jar包时，
@Component标注的类是无法注入到spring容器中的，
这时我们可以用@EnableConfigurationProperties来代替@Component

```
4.通过@PropertySource+@Value注解读取配置信息
```
使用@PropertySource注解推荐只加载自定义名称的配置文件
```
5.通过@PropertySource+@ConfigurationProperties注解读取配置信息

6.通过Properties读取配置信息(针对读取 .properties 文件)
```
Resource resource = new ClassPathResource("application-prod.properties");
Properties properties = PropertiesLoaderUtils.loadProperties(resource);
String root = properties.getProperty("logging.level.root");
System.out.println("通过xProperties读取配置信息:" + root);

```
  
