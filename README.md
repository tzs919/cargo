# 一个分布式系统部署运行的例子
## 一、docker环境部署
+ cd到docker/default子目录运行：
+ 中华人民共和国
####  `docker-compose up`
+ 或者要运行customerservice服务的多个实例：
####  `docker-compose up --scale customerservice=2`
## 二、部署的服务有：
![img.png](img.png)
## 三、调用接口
+ 获得zuul路由信息：
####  `localhost:5555/routes`
+ 访问Cargo Service服务：
####  `localhost:5555/api/cargo/v1/customers/1/cargos/3`
####  `localhost:5555/api/cargo/v1/customers/4/cargos/7`
+ 访问Customer Service服务：
####  `localhost:5555/api/customer/v1/customers/3`
####  `localhost:5555/api/customer/v1/customers/4`

## 四、生成镜像
+ cd到服务所在目录，运行：
####  `mvn clean package docker:build`