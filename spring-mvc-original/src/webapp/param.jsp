<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>参数绑定</title>
</head>
<body style="text-align: center">

    <%--请求参数绑定--%>
    <a href="param/testParam?username=hehe&password=123">请求参数绑定</a>

    把数据封装Account类中
    <form action="param/saveAccount" method="post">
        姓名：<input type="text" name="username" /><br/>
        密码：<input type="text" name="password" /><br/>
        金额：<input type="text" name="money" /><br/>
        用户姓名：<input type="text" name="user.uname" /><br/>
        用户年龄：<input type="text" name="user.age" /><br/>
        <input type="submit" value="提交" />
    </form>

    <%--把数据封装Account类中，类中存在list和map的集合
    <form action="param/saveAccount" method="post">
        姓名：<input type="text" name="username" /><br/>
        密码：<input type="text" name="password" /><br/>
        金额：<input type="text" name="money" /><br/>

        用户姓名：<input type="text" name="list[0].uname" /><br/>
        用户年龄：<input type="text" name="list[0].age" /><br/>

        用户姓名：<input type="text" name="map['one'].uname" /><br/>
        用户年龄：<input type="text" name="map['one'].age" /><br/>
        <input type="submit" value="提交" />
    </form>--%>

    自定义类型转换器
    <form action="param/saveUser" method="post">
        用户姓名：<input type="text" name="uname" /><br/>
        用户年龄：<input type="text" name="age" /><br/>
        用户生日：<input type="text" name="date" /><br/>
        <input type="submit" value="提交" />
    </form>


    <a href="param/testServlet">Servlet原生的API</a><br/>

    <button id="btn">异步保存账号</button>

</body>
<script src="static/js/jquery/jquery.min.js"></script>

<script>
    // 页面加载，绑定单击事件
    $(function(){
        $("#btn").click(function(){
            // alert("hello btn");
            // 发送ajax请求
            $.ajax({
                // 编写json格式，设置属性和值
                url:"param/saveAccountJson",
                contentType:"application/json;charset=UTF-8",
                data:'{"username":"jeff","password":"123","money":130}',
                dataType:"json",
                type:"post",
                success:function(data){
                    // data服务器端响应的json的数据，进行解析
                    alert(data.username + data.password + data.age);
                }
            });

        });
    });

</script>
</html>
