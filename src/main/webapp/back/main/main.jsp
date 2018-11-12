<%@page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" >
<title>持名法州主页</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/back/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/back/themes/IconExtension.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/back/js/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/back/js/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/back/js/easyui-lang-zh_CN.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/back/js/datagrid-detailview.js"></script>
    <script type="text/javascript">
	<!--菜单处理-->
    $(function () {
        $.ajax({
            url:'${pageContext.request.contextPath}/menu/show',
            type:'post',
            dataType:'json',
            success:function (menu) {
                //遍历一级菜单
                $.each(menu,function (index,m) {
                    //遍历二级菜单
                    var content="<div style='text-align:center;'>";
                    $.each(m.menus,function (index,child) {
                        content += "<a onclick=\"addTabs('"+child.title+"','"+child.iconCls+"','"+child.href+"')\" style='width:95%;margin:10px 0px; border: 2px #95B8E7 solid;' class='easyui-linkbutton' data-options=\"plain:true,iconCls:'"+child.iconCls+"'\">"+child.title+"</a><br>";
                    });
                    content +="</div>"
                    //添加菜单
                    $("#menu").accordion('add',{
                        title:m.title,
                        iconCls:m.iconCls,
                        content:content,
                    })
                });
            },
            error:function () {
                location.href="${pageContext.request.contextPath}/back/login.jsp";
            }
        })
    });
	/*添加选项卡*/
    function addTabs(title,iconCls,href) {
        if(!$("#tt").tabs('exists',title)){
            $("#tt").tabs('add',{
                title:title,
                iconCls:iconCls,
                fit:true,
                closable:true,
                href:'${pageContext.request.contextPath}/'+href,
            })
        }else{
            $("#tt").tabs('select',title);
        }
    }

    //修改密码
    function openUpdatePwd() {
        $("#updatePwd").dialog({
            href:'${pageContext.request.contextPath}/back/main/editpwd.jsp',
            width:500,
            height:300,
            buttons:[
                {
                    iconCls:'icon-edit',
                    text:"修改",
                    handler:function () {
                        $("#updateSubmit").form('submit',{
                            url:"${pageContext.request.contextPath}/admin/editpwd",
                            success:function (result) {
                                var resultObj = $.parseJSON(result);
                                if (resultObj.success){
                                    //提示信息
                                  /*  $.messager.show({title:'提示',msg:"用户修改成功!!!"});*/
                                    location.href="${pageContext.request.contextPath}/back/login.jsp"
                                }else{
                                    //提示信息
                                    $.messager.show({title:'提示',msg:resultObj.message});
                                }
                                $("#updatePwd").dialog('close');
                            }
                        })
                    }
                },
                {
                    iconCls:'icon-cancel',
                    text:"取消",
                    handler:function () {
                        $("#updatePwd") .dialog('close');
                    }
                },
            ]
        })
    }
</script>

</head>
<body class="easyui-layout">   
    <div data-options="region:'north',split:true" style="height:60px;background-color:  #5C160C">
    	<div style="font-size: 24px;color: #FAF7F7;font-family: 楷体;font-weight: 900;width: 500px;float:left;padding-left: 20px;padding-top: 10px" >持名法州后台管理系统</div>
    	<div style="font-size: 16px;color: #FAF7F7;font-family: 楷体;width: 300px;float:right;padding-top:15px">欢迎您:${sessionScope.success.phone} &nbsp;
            <a href="javascript:;" class="easyui-linkbutton" data-options="iconCls:'icon-edit'" onclick="openUpdatePwd()">修改密码</a>&nbsp;&nbsp;
            <a href="${pageContext.request.contextPath}/admin/loginOut" class="easyui-linkbutton" data-options="iconCls:'icon-01'">退出系统</a></div>
    </div>   
    <div data-options="region:'south',split:true" style="height: 40px;background: #5C160C">
    	<div style="text-align: center;font-size:15px; color: #FAF7F7;font-family: 楷体" >&copy;百知教育 htf@zparkhr.com.cn</div>
    </div>   
       
    <div data-options="region:'west',title:'导航菜单',split:true" style="width:220px;">
    	<div id="menu" class="easyui-accordion" data-options="fit:true">
    		
		</div>  
    </div>   
    <div data-options="region:'center'">
    	<div id="tt" class="easyui-tabs" data-options="fit:true,narrow:true,pill:true">   
		    <div title="主页" data-options="iconCls:'icon-neighbourhood',"  style="background-image:url(image/shouye.jpg);background-repeat: no-repeat;background-size:100% 100%;"></div>
        </div>
    </div>

    <%--修改密码对话框--%>
    <div id="updatePwd" data-options="draggable:false,iconCls:'icon-edit',title:'修改密码'"></div>
</body> 
</html>