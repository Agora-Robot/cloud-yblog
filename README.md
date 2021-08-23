# cloud-yblog

<p align=center>
  <a href="#">
    <img src="https://gitee.com/youzhengjie/cloud-yblog/raw/master/cloud-yblog-doc/images/bloglogo.jpg" alt="cloud-yblog" style="width:200px;height:200px">
  </a>
</p>
<p align=center>
   cloud-yblog是yblog的微服务版本，是一个基于SpringCloud分布式微服务架构开发的博客系统
</p>

<p align=center>
<img src="https://img.shields.io/badge/JDK-1.8+-green.svg"/>
<img src="https://img.shields.io/badge/springboot-2.3.2.RELEASE-green"/>
<img src="https://img.shields.io/badge/SpringCloud-Hoxton.SR8-brightgreen"/>
<img src="https://img.shields.io/badge/SpringCloud alibaba-2.2.3.RELEASE-brightgreen"/>
</p>

 &emsp;&emsp;cloud-yblog是基于SpringCloud+springCloud alibaba分布式微服务框架开发的博客：**博文管理**、**统计图表**、**接口监控**、**访问记录**、**附件管理**、**用户管理**、**友链管理**、**监控管理**、**抓取博文**，以及**第三方登录**等功能，且一直会对本项目进行加强，请各位大佬多多指点，一起共同进步。
文章无需自己写，可以使用作者自己编写的全自动爬虫工具即可，只需轻轻一点，万千文章到手。

### SpringBoot版的yblog仓库地址
GitHub: https://github.com/youzhengjie9/yblog <br/>
Gitee: https://gitee.com/youzhengjie/springBootBlog


### cloud-yblog的架构图

<p align=center>
  <a href="#">
    <img src="https://gitee.com/youzhengjie/cloud-yblog/raw/master/cloud-yblog-doc/images/jiagou.png" alt="cloud-yblog-jiagou" style="width:200px;height:200px">
  </a>
</p>

### 开发环境

| 类别                |   名称     |   
| -----------------   | -------  |
| 编译器          |    IntelliJ IDEA   |
| 系统1             |   Windows 10   |
| 系统2               |   CentOS 7   |
| CPU              |    Intel i5-9300H   |
| 内存                |    24GB         |

* 注：特别是内存需要>=16GB才能运行,如果不足16GB,可以把各服务的集群变成单体服务即可，如不想关闭集群，则需要大内存支撑。


### 版本对应
| 名称                | 版本    |
| -------------      | -------------  |
| Spring Boot             | 2.3.2.RELEASE      | 
| Spring Cloud            | Hoxton.SR8      | 
| Spring Cloud Alibaba    | 2.2.3.RELEASE   |
| Nacos                  | 1.4.1      |
| Sentinel               | 1.8.0     |
| Seata                  | 1.3.0      |    
| ZipKin                |  2.12.9       |
| elasticSearch         |  7.6.1             |
| Kibana               |   7.6.1         |
| MySQL                  |  5.7            |

* 剩下的版本可以随意，上面写出来的版本要严格对应，不然怕会出现兼容性问题！！！

### 技术栈
#### 后端

| 名称                | 官网                                                         |
| -----------------   | ------------------------------------------------------------ |
| Spring Boot             | https://spring.io/projects/spring-boot               | 
| Spring Cloud        |     https://spring.io/projects/spring-cloud                    |
| Spring Cloud Alibaba     |  https://spring.io/projects/spring-cloud-alibaba                       |
| Nacos      |     https://nacos.io/zh-cn/                    |
| Seata        |   http://seata.io/zh-cn/                      |
| Sentinel     |   https://github.com/alibaba/Sentinel                      |
| ZipKin            |    https://zipkin.io/                                            |
| Redis             | http://www.redis.cn/               | 
| RabbitMQ                   |  https://www.rabbitmq.com/                                  |
| elasticSearch           |    https://www.elastic.co/cn/elasticsearch/                  |
| Kibana               |   https://www.elastic.co/cn/kibana/        |
| MyBatis             | http://www.mybatis.org/mybatis-3/zh/index.html               |         
| Spring Security        | https://spring.io/projects/spring-security/                                   |
| PageHelper         | http://git.oschina.net/free/Mybatis_PageHelper               |
| Maven              | http://maven.apache.org/                                     |
| MySQL              | https://www.mysql.com/                                       |                                  |
| Swagger2                  | https://swagger.io/               |
| Druid                       |    https://github.com/alibaba/druid                    |
| fastjson                          |   https://github.com/alibaba/fastjson/                |
| sjf4j                     |   http://www.slf4j.org/  |
| thumbnailator                         |   https://github.com/coobird/thumbnailator                   |
| Nginx                       |     http://nginx.org/en/download.html
#### 前端

| 名称            | 描述       | 官网                                                     |
| --------------- | ---------- | -------------------------------------------------------- |
| jQuery          | 函数库     | http://jquery.com/                                       |
| Bootstrap       | 前端框架   | https://v3.bootcss.com/                                |
| echarts         | 可视化图表库       | https://echarts.apache.org/zh/index.html        |                        |                             |
| Thymeleaf     | 模板引擎                | https://www.thymeleaf.org/      |
| TinyMCE        |  富文本编辑器         |  http://tinymce.ax-z.cn/  |
| alertJs          |弹框插件          |  https://gitee.com/ydq/alertjs
| layui           | 模块化前端UI框架        | https://www.layui.com/         |


## 如何使用？

> 需要有springCloud alibaba和springCloud+springBoot的基础（最起码要会安装软件！！！）

* 启动Nginx服务器,Nginx.conf配置文件如下：
```text
worker_processes  2;
worker_rlimit_nofile 10240;
events {
    worker_connections  10240;
	
}

http {
    include       mime.types;
    default_type  application/octet-stream;
    sendfile        on;
	
	server_tokens off;
     client_max_body_size    100m;
    #tcp_nopush     on;
    #keepalive_timeout  0;
     keepalive_timeout  65;
	client_header_buffer_size 4k;
	open_file_cache max=10240 inactive=20s;
	open_file_cache_valid 30s;
	open_file_cache_min_uses 1;
    #gzip  on;
     gzip  on; 
     gzip_http_version 1.1; 
     gzip_vary on; 
     gzip_comp_level 6; 
     gzip_proxied any; 
     gzip_types text/plain text/css application/json application/x-javascript text/xml application/xml application/xml+rss text/javascript application/x-httpd-php image/jpeg image/gif image/png; 
     gzip_buffers 16 8k; 
     gzip_disable "MSIE [1-6]\.";
	fastcgi_connect_timeout 300;
	fastcgi_send_timeout 300;
	fastcgi_read_timeout 300;
	fastcgi_buffer_size 64k;
	fastcgi_buffers 4 64k;
	fastcgi_busy_buffers_size 128k;
	fastcgi_temp_file_write_size 128k;
	

	upstream cloudYblog.index.cn{
		server localhost:81 weight=1;
	}
	
	
	upstream cloudYblog.admin.cn{
		server localhost:91 weight=1;
	}
	
	
	#cloud-yblog的web模块首页
    server {
        listen       80;
        server_name  localhost;
		

        location / {
            root   html;
            index  index.html index.htm;
			proxy_pass http://cloudYblog.index.cn;
        }      
        error_page   500 502 503 504  /50x.html;
        location = /50x.html {
            root   html;
        }
    
    }
	
	
	#cloud-yblog的admin模块后台
	 server {
        listen       90;
        server_name  localhost;
		

        location / {
            root   html;
            index  index.html index.htm;
			proxy_pass http://cloudYblog.admin.cn;
        }      
        error_page   500 502 503 504  /50x.html;
        location = /50x.html {
            root   html;
        }
    
    }	 	
}
```

* 把cloud-yblog-doc模块中的工具放到自己的电脑上安装。

* 启动Nacos、seata、sentinel、zipkin、Nginx、Redis、ElasticSearch

* 导入cloud-yblog-doc的sql文件到你们MySQL上

* 注意：如需使用爬虫功能，则需要对mysql做出如下配置。
* 1.修改mysql的配置文件mysql/bin/my.ini, 添加如下内容：
```text
[client]
default-character-set=utf8mb4
 
[mysql]
default-character-set=utf8mb4
 
[mysqld]
character-set-client-handshake=FALSE
character-set-server=utf8mb4
collation-server=utf8mb4_unicode_ci
init_connect='SET NAMES utf8mb4'
```
* 2.重启数据库服务。点击此电脑，右键打开管理，点击服务和应用程序、点击服务、找到MYSQL服务
，右键重新启动即可
* 3.进入mysql命令行，输入ALTER TABLE TABLE_NAME CONVERT TO CHARACTER SET utf8mb4;
把mysql的utf8编码切换成utf8mb4，以支持爬取的emoji表情，不然遇到4字节的宽字符就会插入异常了。

* 如果是虚拟机部署或者docker部署的话，请检查是否有端口占用并打开本系统需要的端口。

* 第一次使用需要初始化cloud-yblog,只需要把cloud-yblog-search模块中的SearchController
的loadArticleToElaticSearch方法的注释解除后运行一次即可，然后再注释回去。


* 评论模块需要自己去https://www.leancloud.cn/ 注册，获取AppID、AppKey，并加入到下面对应的js
```js
new Valine({
        el: '#vcomments',
        appId: 'xxx',
        appKey: 'yyy',
        placeholder: '请输入内容',
        pageSize: 3 ,
        recordIP: true,
        avatar:'',
        requiredFields: ['nick']
    });
````


##### Linux+Docker容器化部署
* 前提：你的Linux系统必须要安装了Docker。（然后按顺序执行下面的命令）
* 首先要启动docker,因为docker默认是关闭的，需要自己去开启
* ```shell script
  systemctl start docker    #启动docker容器
  systemctl start firewalld  #打开防火墙
  firewall-cmd --list-port   #查看防火墙已经打开的端口
  ######重要：记得打开端口
  firewall-cmd --zone=public --add-port=91/tcp --permanent  #打开91端口
  firewall-cmd --zone=public --add-port=2801/tcp --permanent  #打开2801端口
  firewall-cmd --zone=public --add-port=5672/tcp --permanent  #打开5672端口
  firewall-cmd --zone=public --add-port=15672/tcp --permanent #打开15672端口
  firewall-cmd --zone=public --add-port=3306/tcp --permanent
  firewall-cmd --zone=public --add-port=6379/tcp --permanent
  firewall-cmd --zone=public --add-port=5601/tcp --permanent
  firewall-cmd --zone=public --add-port=9100/tcp --permanent
  firewall-cmd --zone=public --add-port=9200/tcp --permanent
  firewall-cmd --zone=public --add-port=1660/tcp --permanent
  firewall-cmd --zone=public --add-port=3201/tcp --permanent
  firewall-cmd --zone=public --add-port=6201/tcp --permanent
  firewall-cmd --zone=public --add-port=8901/tcp --permanent
  firewall-cmd --zone=public --add-port=5566/tcp --permanent
  firewall-cmd --zone=public --add-port=5301/tcp --permanent
  firewall-cmd --zone=public --add-port=1901/tcp --permanent
  firewall-cmd --zone=public --add-port=80/tcp --permanent
  firewall-cmd --zone=public --add-port=81/tcp --permanent
  
  ####因为使用到了springCloud alibaba组件，所以要额外打开一些端口
  firewall-cmd --zone=public --add-port=8848/tcp --permanent  #nacos端口
  firewall-cmd --zone=public --add-port=8720/tcp --permanent  #sentinel传输端口
  firewall-cmd --zone=public --add-port=8080/tcp --permanent #sentinel dashboard
  firewall-cmd --zone=public --add-port=8091/tcp --permanent #seata端口
  firewall-cmd --zone=public --add-port=9411/tcp --permanent #zipkin端口
  
  ####重要：记得重新加载防火墙（不然上面的设置不会生效）
  firewall-cmd --reload
  
  ```
* =>  **1:Docker安装关系型数据库--MySQL 教程**  <=
* ```shell script
    docker pull mysql:5.7  #从从Docker仓库里面拉取mysql5.7
    docker images          #查看从Docker镜像
    docker run -itd --name yblog-mysql -p 3306:3306 -e MYSQL_ROOT_PASSWORD=18420163207 mysql:5.7   #执行从Docker镜像，生成从Docker的mysql容器，返回mysql的实例
    docker ps              #查看从Docker容器实例
    docker exec -it yblog-mysql /bin/bash  #执行mysql容器实例
    mysql -u root -p       #紧接着执行这句命令，然后就输入你的密码就行了
  ```
* =>  **2:Docker安装非关系型数据库--Redis 教程**  <=
* ```shell script
    docker pull redis:latest   #从Docker仓库拉取最新的Redis镜像
    docker run -itd --name yblog-redis -p 6379:6379 redis  #运行redis镜像，生成对应容器实例
    docker exec -it yblog-redis /bin/bash  
    redis-cli    #输入就能进入redis客户端
  ```

* =>  **3:Docker安装消息队列--RabbitMQ 教程**  <=
* ```shell script
    docker pull rabbitmq    #从Docker仓库拉取最新的RabbitMQ镜像
    docker run -d --hostname my-rabbit --name yblog-rabbit -p 15672:15672 -p 5672:5672 rabbitmq  #运行RabbitMQ镜像
    docker exec -it yblog-rabbit /bin/bash   #进入RabbitMQ容器
    rabbitmq-plugins enable rabbitmq_management   #安装RabbitMQ的插件
  ```
* **注意：要打开RabbitMQ的可视化界面，创建一个虚拟主机为：/ems**

* **4:用Navicat把cloud-yblog-doc模块中的数据库全部导入到Docker的mysql中，即可！！！**

* **5:修改配置文件的IP为你的Linux系统的IP然后打成jar包，并且把cloud-yblog各个微服务打出来的Jar包传入到Linux系统，然后通过java -jar jar包名  的命令启动即可**


##### 第三方登录
###### gitee
* 接入gitee第三方授权配置,先在gitee的第三方应用上对网站进行授权，获得Client ID和Client Secret和回调地址,并放到cloud-yblog-web模块的application.yml中即可

###### GitHub
* GitHub第三方配置有点复杂，也弄了一两天，主要还是GitHub中国地区登录很慢
* 我们只需要把cloud-yblog-commons模块中的com.boot.GitHubConstant的CLIENT_ID和CLIENT_SECRET换成自己的
* 然后在login.html的GitHub第三方登录超链接中client_id=xxx换成自己的id，即可





### 图片演示
前台界面👇
![01.png](https://gitee.com/youzhengjie/cloud-yblog/raw/master/cloud-yblog-doc/images/01.png)
![02.png](https://gitee.com/youzhengjie/cloud-yblog/raw/master/cloud-yblog-doc/images/02.png)
![03.png](https://gitee.com/youzhengjie/cloud-yblog/raw/master/cloud-yblog-doc/images/03.png)
后台界面👇
![04.png](https://gitee.com/youzhengjie/cloud-yblog/raw/master/cloud-yblog-doc/images/04.png)
![05.png](https://gitee.com/youzhengjie/cloud-yblog/raw/master/cloud-yblog-doc/images/05.png)
![06.png](https://gitee.com/youzhengjie/cloud-yblog/raw/master/cloud-yblog-doc/images/06.png)
![07.png](https://gitee.com/youzhengjie/cloud-yblog/raw/master/cloud-yblog-doc/images/07.png)
![08.png](https://gitee.com/youzhengjie/cloud-yblog/raw/master/cloud-yblog-doc/images/08.png)
![09.png](https://gitee.com/youzhengjie/cloud-yblog/raw/master/cloud-yblog-doc/images/09.png)
![10.png](https://gitee.com/youzhengjie/cloud-yblog/raw/master/cloud-yblog-doc/images/10.png)
![11.png](https://gitee.com/youzhengjie/cloud-yblog/raw/master/cloud-yblog-doc/images/11.png)
![12.png](https://gitee.com/youzhengjie/cloud-yblog/raw/master/cloud-yblog-doc/images/12.png)
![13.png](https://gitee.com/youzhengjie/cloud-yblog/raw/master/cloud-yblog-doc/images/13.png)
![14.png](https://gitee.com/youzhengjie/cloud-yblog/raw/master/cloud-yblog-doc/images/14.png)
![15.png](https://gitee.com/youzhengjie/cloud-yblog/raw/master/cloud-yblog-doc/images/15.png)
![16.png](https://gitee.com/youzhengjie/cloud-yblog/raw/master/cloud-yblog-doc/images/16.png)
![17.png](https://gitee.com/youzhengjie/cloud-yblog/raw/master/cloud-yblog-doc/images/17.png)
![18.png](https://gitee.com/youzhengjie/cloud-yblog/raw/master/cloud-yblog-doc/images/18.png)
![19.png](https://gitee.com/youzhengjie/cloud-yblog/raw/master/cloud-yblog-doc/images/19.png)
![22.png](https://gitee.com/youzhengjie/cloud-yblog/raw/master/cloud-yblog-doc/images/22.png)
登录界面👇
![20.png](https://gitee.com/youzhengjie/cloud-yblog/raw/master/cloud-yblog-doc/images/20.png)
注册界面👇
![21.png](https://gitee.com/youzhengjie/cloud-yblog/raw/master/cloud-yblog-doc/images/21.png)