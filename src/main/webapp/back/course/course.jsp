<%@page isELIgnored="false" pageEncoding="utf-8" %>

<script>
    $(function () {
        $("#dgcourse").datagrid({
            url:'${pageContext.request.contextPath}/course/findAll',
            remoteSort:false,//关闭服务器端排序,
            striped:true,//斑马线效果
            pagination:true,//显示分页工具栏
            toolbar:'#tb',//工具栏
            fitColumns:true,//让列自适应整个容器
            pageNumber:1,//当前页
            pageSize:2,//每页显示记录数
            pageList:[2,5,10,15,30,500],
            fit:true,
            columns:[[
                {title:"名字",field:"title",width:200},
                {title:"功课类别",field:"flag",width:200},
                {title:"添加时间",field:"creatTime",width:200},
            ]],
        });
    });
    //打开添加轮播图对话框函数
    function opensave2(){
        $("#opensaveCourse").dialog({
            buttons:[{
                iconCls:'icon-save',
                text:'保存',
                handler:function(){
                    //保存用户信息
                    $("#saveSubmitCourse").form('submit',{
                        url:'${pageContext.request.contextPath}/course/save',
                        success:function(results){   //响应的一定是json格式字符串   使用应该先转为js对象
                            var resultObj = $.parseJSON(results);
                            if (resultObj.success){
                                //提示信息
                                $.messager.show({title:'提示',msg:"添加成功!!!"});
                            }else{
                                //提示信息
                                $.messager.show({title:'提示',msg:results.message});
                            }
                            //关闭对话框
                            $("#opensaveCourse").dialog('close');
                            //刷新datagrid
                            $("#dgcourse").datagrid('reload');
                        }
                    });
                }
            },{
                iconCls:'icon-cancel',
                text:'关闭',
                handler:function(){
                    $("#opensaveCourse").dialog('close');
                }
            }]
        });
    }

</script>

<table id="dgcourse" data-options="fit:true"></table>
<%--创建工具栏--%>
<div id="tb">
    <a href="#" class="easyui-linkbutton" onclick="opensave2();" data-options="iconCls:'icon-add',plain:true">添加</a>
</div>

<%--保存功课对话框--%>
<div id="opensaveCourse" data-options="href:'${pageContext.request.contextPath}/back/course/save.jsp',draggable:false,iconCls:'icon-save',width:600,height:400,title:'保存功课信息'">

</div>

