<%--
  Created by IntelliJ IDEA.
  User: Coolway26
  Date: 2020/12/1
  Time: 17:41
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="cn">
<head>
    <title>学生列表</title>
    <link rel="stylesheet" type="text/css" href="../ui/css/tableStyle.css">
    <script type="text/javascript" src="../ui/js/jquery-3.5.1.js"></script>
    <%--    <script src="http://lib.sinaapp.com/js/jquery/2.0.2/jquery-2.0.2.min.js"></script>--%>
    <script type="text/javascript">
        window.onload = function () {
            $.ajax({
                url: "http://localhost:8080/stuSpringMVC/student/autoShowAllStudent",
                type: "post",
                dataType: "json",
                async: true,
                success: function (data) {
                    showData(data);//我们仅做数据展示
                },
                error: function (msg) {
                    alert("ajax连接异常：" + msg);
                }
            });

            // 搜索
            $("#ssButton").click(function () {
                var nameOrClazz = $("#searchValue").val();
                $.ajax({
                    url: "http://localhost:8080/stuSpringMVC/student/showStudentByNameOrClazz",
                    async: true,
                    type: "post",
                    dataType: "json",
                    data:{nameOrClazz : nameOrClazz},
                    success: function (data) {
                        showData(data);//我们仅做数据展示
                    },
                    error: function (msg) {
                        alert("ajax连接异常：" + msg);
                    }
                });
            })
        }

        //将数据加载到前端显示
        function showData(data) {
            var str = "";//定义用于拼接的字符串
            for (var i = 0; i < data.length; i++) {
                //拼接表格的行和列
                str = "<tr><td>" + data[i].name + "</td><td>" + data[i].clazz + "</td><td>" + data[i].sex + "</td><td>" + data[i].age + "</td><td hidden=\"hidden\">" + data[i].id + "</td></tr>";
                //追加到table中
                $("#tab").append(str);
            }
        }


    </script>
</head>


<body>
<table id="tab" style="border: 1px solid black">
    <div class="gjSearch" style="border:0px solid black; margin:auto; margin-top: 100px; width: 40%">
        <input id="searchValue" type="text" placeholder="请输入姓名/班级"
               style="width: 200px; height: 30px; border:1px solid darkgrey; border-radius: 10px"/>
        <button id="ssButton" style="height: 30px; background: aqua; ">搜索</button>
    </div>
    <caption style="margin-bottom: 10px;color: #666" align="top">学生信息表</caption>
    <tr>
        <th>姓名</th>
        <th>班级</th>
        <th>性别</th>
        <th>年龄</th>
        <th hidden="hidden">id</th>
    </tr>
</table>
</body>
</html>

