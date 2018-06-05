本项目 主要是针对电商里的秒杀功能 做的一个简单demo
127.0.0.1/demo/login/login
1.使用springboot +thymeleaf+mybatis+rabbitmq+redis
2.在秒杀页面 添加验证码，对访问连接进行次数限制
3.利用thymeleafViewResolver.getTemplateEngine().process +redis 缓存秒杀商品页面
4.将商品的秒杀数量利用 定时任务 定时缓存到redis 中。每次秒杀提交前先判断rediis 里是否还有商品
5.生成秒杀订单通过mq解耦，秒杀成功后方式mq 消息，后台接受到mq 消息后生成秒杀订单信息入库，并将该人员的秒杀信息放入redis 用户判断是否重复秒杀
6.该项目中使用到的mq 需要到rabbitmq 中先创建队列 



