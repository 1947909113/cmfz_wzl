<%@page isELIgnored="false" pageEncoding="utf-8" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/easyui/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/easyui/themes/icon.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/easyui/jquery.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/easyui/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/easyui/form.validator.rules.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/easyui/easyui-lang-zh_CN.js"></script>
    <script>
        $(function () {
                    $.post("${pageContext.request.contextPath}/admri/menu.json",function (menu) {
                        //遍历一级菜单
                        $.each(menu,function (index,m) {
                            //遍历二级菜单
                            var content="<div style='text-align:center;'>";
                            $.each(m.children,function (index,child) {
                                content += "<a onclick=\"addTabs('"+child.name+"','"+child.iconCls+"','"+child.href+"')\" style='width:95%;margin:10px 0px; border: 2px #95B8E7 solid;' class='easyui-linkbutton' data-options=\"plain:true,iconCls:'"+child.iconCls+"'\">"+child.name+"</a><br>";
                            });
                            content +="</div>"
                            //添加菜单
                            $("#menu").accordion('add',{
                                title:m.name,
                                iconCls:m.iconCls,
                                content:content,
                            })
                        });
            });
        });
        //点击菜单追加选项卡
        function addTabs(title,iconCls,href) {
            if(!$("#tabs").tabs('exists',title)){
                $("#tabs").tabs('add',{
                    title:title,
                    iconCls:iconCls,
                    fit:true,
                    closable:true,
                    href:"${pageContext.request.contextPath}/"+href,
                });
            }else{
                $("#tabs").tabs('select',title);
            }
        }
    </script>
</head>
<body class="easyui-layout">
           <%-- 页面的头部分--%>
           <%-- 页面左侧位置--%>
            <div data-options="region:'west',title:'系统菜单'" style="width: 200px;">
                <div id="menu" class="easyui-accordion" data-options="fit:true"></div>
            </div>
            <%--页面的中间部分--%>
            <div data-options="region:'center'">
                <%--选项卡--%>
                <div id="tabs" class="easyui-tabs" data-options="fit:true"></div>
            </div>
</body>
</html>