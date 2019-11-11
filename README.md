# appapidemo

> A spring-boot project

## 项目说明

- 此项目为图书管理系统后台，使采用的是springboot+mybatis等技术实现数据持久化以及api服务调用，
前台使用vue.js,vue-resource,vue-router,iView2.0UI框架,vue-quill-editor等技术实现前台页面，前台地址是:[Vue-iView-Demo](https://github.com/yangyuscript/Vue-iView-demo.git)
- 由于前期没有上传后台项目springboot的application.porperties文件，故此次一并上传，大家就不必到issue中寻找了。

## 项目启动
- 1.数据库：mysql5.6执行以下脚本,前台项目下脚本文件--sbm.sql  （数据库脚本在前台项目下，请移步：[Vue-iView-Demo](https://github.com/yangyuscript/Vue-iView-demo.git)）
- 2.后台启动：导入项目，进入控制台，到项目所在路径，执行命令：mvn clean spring-boot:run
- 3.前台启动：导入项目，进入控制台，到项目所在路径，执行命令：npm run dev，访问地址：http://localhost:8075  进入到登录界面，打开数据库中t_reader表获取用户名和密码


## 效果展示
![](https://github.com/yangyuscript/Vue-iView-demo/blob/master/static/1.png?raw=true)
![](https://github.com/yangyuscript/Vue-iView-demo/blob/master/static/2.png?raw=true)
![](https://github.com/yangyuscript/Vue-iView-demo/blob/master/static/3.png?raw=true)
![](https://github.com/yangyuscript/Vue-iView-demo/blob/master/static/4.png?raw=true)
![](https://github.com/yangyuscript/Vue-iView-demo/blob/master/static/5.png?raw=true)
![](https://github.com/yangyuscript/Vue-iView-demo/blob/master/static/6.png?raw=true)
![](https://github.com/yangyuscript/Vue-iView-demo/blob/master/static/7.png?raw=true)
![](https://github.com/yangyuscript/Vue-iView-demo/blob/master/static/8.png?raw=true)
![](https://github.com/yangyuscript/Vue-iView-demo/blob/master/static/9.png?raw=true)


### tip
鉴于star该项目的同学越来越多，鄙人觉得应当补充以上信息供大家交流学习，如果大家有任何建议均可issue，一定尽一切办法解决各位的问题，希望大家一起进步，oh yeah!

For a detailed explanation on how things work, check out the [guide](http://vuejs-templates.github.io/webpack/) and [docs for vue-loader](http://vuejs.github.io/vue-loader).
