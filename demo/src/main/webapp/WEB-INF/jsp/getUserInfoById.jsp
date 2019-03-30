<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/3/29
  Time: 14:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>查询用户byId</title>
    <meta http-equiv="Content-Type" content="application/json; charset=utf-8">
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="ajax方式">
    <script src="http://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js"></script>

</head>
<body>
<div id="form-div" >
    <div class="row">
        <div class="col-md-12 form form-horizontal">
            <div class="form-body">
                <div class="row">
                    <div class="row">
                        <div class="col-md-12">
                            <div class="form-group">
                                <label class="control-label col-md-3">ID：</label>
                                <div class="col-md-9">
                                    <p class="form-control-static" id="code"></p>

                                </div>

                            </div>
                        </div>
                    </div>
                    <div class="col-md-12">
                        <div class="form-group">
                            <label class="control-label col-md-3">姓名：</label>
                            <div class="col-md-9">
                                <p class="form-control-static" id="name"></p>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-12">
                        <div class="form-group">
                            <div class="col-md-9">
                                <label class="control-label col-md-3">年龄：</label>
                                <p class="form-control-static" id="age"></p>
                            </div>
                        </div>
                    </div>
                </div>

            </div>
        </div>
    </div>

</div>
<script src="../static/getuserbyid.js"></script>
<script type="text/javascript">
    $(function () {
        employeeView.setPath("<%=request.getContextPath()%>/superadmin");
        employeeView.init("2");
    });
</script>
</body>
</html>
