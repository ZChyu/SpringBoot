<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/3/29
  Time: 13:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>login test</title>
    <meta http-equiv="Content-Type" content="application/json; charset=utf-8"></meta>
    <meta http-equiv="pragma" content="no-cache"></meta>
    <meta http-equiv="cache-control" content="no-cache"></meta>
    <meta http-equiv="expires" content="0"></meta>
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3"></meta>
    <meta http-equiv="description" content="ajax方式"></meta>
    <script src="http://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js"></script>
    <script type="text/javascript">
        function login() {
            var rurl="<%=request.getContextPath()%>/superadmin";
            $.ajax({
                //几个参数需要注意一下
                type: "POST",//方法类型
                dataType: "json",//预期服务器返回的数据类型
                url: rurl+"/loginuser" ,//url
                data: $('#form1').serialize(),
                success: function (result) {
                    console.log(result);//打印服务端返回的数据(调试用)
                    if (result["success"]==true) {
                        window.location.href = "<%=request.getContextPath()%>/index/getUserById";
                    }else{
                        alert(result["msg"]);
                    }
                    ;
                },
                error : function() {
                    alert("异常！");
                }
            });
        }
    </script>
</head>
<body>
<div id="form-div" >

    <form id="form1" onsubmit="return false" action="##" method="post" align="center">

        <p>用户名：<input name="Name" type="text" id="txtUserName" tabindex="2" size="20" value=""> </input> </p>
        <p>密　码：<input name="Password" type="password" id="TextBox2" tabindex="2" size="20" value=""></input></p>
        <p><input type="button"  value="登录" onclick="login()"></input>&nbsp;<input type="reset" value="重置"></input></p>
    </form>
</div>
</body>
</html>
