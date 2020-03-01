<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>参数绑定</title>
</head>
<body style="text-align: center">

    请求参数绑定
    <a href="requestAnnotation/hello?name=jeff">请求参数绑定</a>

    把数据封装body中
    <form action="requestAnnotation/helloBody" method="post">
        姓名：<input type="text" name="username" /><br/>
        密码：<input type="text" name="password" /><br/>
        金额：<input type="text" name="money" /><br/>
        用户姓名：<input type="text" name="user.uname" /><br/>
        用户年龄：<input type="text" name="user.age" /><br/>
        <input type="submit" value="提交" />
    </form>

    <a href="requestAnnotation/hello/1">路径占位符</a><br>

    <a href="requestAnnotation/header">获取请求头部信息</a><br>

    <a href="requestAnnotation/cookies">获取cookies指定的值</a><br>

</body>
</html>
