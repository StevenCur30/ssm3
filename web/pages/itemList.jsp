<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>查询商品列表</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.8.3.js"></script>
    <script type="text/javascript">
        $(function () {
            $("#selectAll").click(function () {
                //复选框实现全选全不选
                $("input[name='ids']").attr("checked", this.checked);
            });

            $("#bnt").click(function () {
                //发送ajax请求
                $.ajax({
                    type:"post",
                    url:"${pageContext.request.contextPath }/testJson.do",
                    data:{"name":"测试商品","price":99.9},
                    success:function(data){
                        alert(data.name+" "+data.price);
                    }
                });

               /* $.post("${pageContext.request.contextPath }/testJson.do",{"name":"测试商品","price":99.9},function (data) {
                alert(data.name+" "+data.price);
                })*/

            });
        });
    </script>
</head>
<body>
<form action="${pageContext.request.contextPath }/queryitem.do" method="post">
    查询条件：
    <table width="100%" border=1>
        <tr>
            <td><input type="submit" value="查询"/></td>
            <td><input type="text" name="name" placeHolder="商品名称"/></td>
        </tr>
    </table>
    商品列表：
    <table width="100%" border=1>
        <tr>
            <td><input type="checkbox" id="selectAll"/></td>
            <td>商品名称</td>
            <td>商品价格</td>
            <td>生产日期</td>
            <td>商品描述</td>
            <td>操作</td>
        </tr>
        <c:forEach items="${itemList }" var="item">
            <tr>
                <td><input type="checkbox" name="ids" value="${item.id }"/></td>
                <td>${item.name }</td>
                <td>${item.price }</td>
                <td><fmt:formatDate value="${item.createtime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
                <td>${item.detail }</td>
                <td><a href="${pageContext.request.contextPath }/itemEdit/${item.id}">修改</a></td>
            </tr>
        </c:forEach>
    </table>
</form>
<button id="bnt">json测试</button>
</body>

</html>