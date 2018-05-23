# webblog
自己的博客

前端使用React技术栈，使用create-myapp脚手架搭建

服务端使用Java SpringBoot

功能包括：
* 文章上传
* 文章列表展示
* 文章内容展示（支持markdown）
* 个人信息展示及友链

结果截图：

![](https://github.com/shaomaicheng/webblog/blob/master/img/list.jpeg?raw=true)

--------------------------

![](https://github.com/shaomaicheng/webblog/blob/master/img/art1.jpeg?raw=true)

--------------------------

![](https://github.com/shaomaicheng/webblog/blob/master/img/art2.jpeg?raw=true)


server端 todo-list
* ~~上传md文件接口~~
* ~~查询文章列表接口~~
* ~~查询具体文章信息接口~~
* 文章分类归档接口
* 评论接口
* 评论反馈


web前端 todo-list
* ~~首页个人信息~~
* ~~首页文章列表~~
* ~~文章详情页面~~
* ~~文章支持markdown~~
* 文章支持语法高亮
* 加入Redux
* 文章分类归档
* 评论

技术栈：
* react
* create-react-app
* react-markdown
* react-router

* SpringBoot
* MyBatis
* JUnit
* Mockito


###### 如果您想运行此项目
1. 启动服务器
```
cd server
mvn spring-boot:run
```

2. 根据server/sql 里的建表语句建表

3. 启动前端
```
cd blog
npm install
npm start
```
