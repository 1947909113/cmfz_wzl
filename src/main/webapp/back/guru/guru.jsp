<%@page isELIgnored="false" pageEncoding="utf-8" %>

    <script>
        $(function () {
            $("#dg").datagrid({
                url:'${pageContext.request.contextPath}/guru/findAll',
                remoteSort:false,//关闭服务器端排序,
                striped:true,//斑马线效果
                pagination:true,//显示分页工具栏
                toolbar:'#tb1',//工具栏
                fitColumns:true,//让列自适应整个容器
                pageNumber:1,//当前页
                pageSize:2,//每页显示记录数
                pageList:[2,5,10,15,30,500],
                fit:true,
                columns:[[
                    {title:"cks",field:"cks",checkbox:true},
                    {title:"名字",field:"name",width:200},
                    {title:"性别",field:"sex",width:200},
                    {title:"路径",field:"headPic",width:200,/*formatter:function(value,row,index){
                            return "<img src='${pageContext.request.contextPath}/"+value+"' style='width:100px;height:80px'>";
                        }*/},
                    {title:"options",field:"options",width:200,
                        formatter:function(value,row,index){
                            return "<a href='javascript:;' class='options'  onclick=\"OpenEditDialog('"+row.id+"')\" data-options=\"iconCls:'icon-edit',plain:true\">修改</ahref>";
                        }
                    }
                ]],
                onLoadSuccess:function () {
                    $(".options").linkbutton();
                },
                view: detailview,
                detailFormatter: function(rowIndex, rowData){
                    return '<table><tr>' +
                        '<td rowspan=2 style="border:0"><img src="${pageContext.request.contextPath}' + rowData.headPic + '" style="height:50px;"></td>' +
                        '<td style="border:0">' +
                        '<p>Name: ' + rowData.name + '</p>' +
                        '<p>Sex: ' + rowData.sex + '</p>' +
                        '</td>' +
                        '</tr></table>';
                }
            });
        });
        //打开添加轮播图对话框函数
        function opensave(){
            $("#opensaveBanner").dialog({
                buttons:[{
                    iconCls:'icon-save',
                    text:'保存',
                    handler:function(){
                        //保存用户信息
                        $("#saveSubmit").form('submit',{
                            url:'${pageContext.request.contextPath}/guru/save',
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
                                $("#opensaveBanner").dialog('close');
                                //刷新datagrid
                                $("#dg").datagrid('reload');
                            }
                        });
                    }
                },{
                    iconCls:'icon-cancel',
                    text:'关闭',
                    handler:function(){
                        $("#opensaveBanner").dialog('close');
                    }
                }]
            });
        }
        //批量删除
        function delBatchRows() {
            var rows=$("#dg").datagrid('getSelections');
            if(rows.length<=0){
                $.messager.show({title:'提示',msg:"至少选中一行!!!"});
            }else{
                var ids = [];
                for (var i=0;i<rows.length;i++){
                    ids.push(rows[i].id);
                }
                $.ajax({
                    url:"${pageContext.request.contextPath}/guru/delAll",
                    type:"POST",
                    traditional:true,
                    data:{id:ids},
                    success:function (result) {
                        //消息提示
                        $.messager.show({title:'提示',msg:"删除成功!!!"});
                        //刷新datagrid
                        $("#dg").datagrid('reload');
                    },
                    error:function () {
                        //消息提示
                        $.messager.show({title:'提示',msg:"删除失败!!!"});
                        //刷新datagrid
                        $("#dg").datagrid('reload');
                    }
                })
            }
        }
        //修改
        function OpenEditDialog(id) {
            $("#editDialog").dialog({
                href:'${pageContext.request.contextPath}/back/guru/edit.jsp?id='+id,
                buttons:[
                    {
                        iconCls:'icon-edit',
                        text:"修改",
                        handler:function () {
                            $("#editInputForm").form('submit',{
                                url:"${pageContext.request.contextPath}/guru/edit",
                                success:function (result) {
                                    var resultObj = $.parseJSON(result);
                                    if (resultObj.success){
                                        //提示信息
                                        $.messager.show({title:'提示',msg:"用户修改成功!!!"});
                                    }else{
                                        //提示信息
                                        $.messager.show({title:'提示',msg:resultObj.message});
                                    }

                                    $("#editDialog").dialog('close');

                                    $("#dg").datagrid('reload');
                                }
                            })
                        }
                    },
                    {
                        iconCls:'icon-cancel',
                        text:"取消",
                        handler:function () {
                            $("#editDialog") .dialog('close');
                        }
                    },
                ]
            })
        }
    </script>

      <table id="dg" data-options="fit:true"></table>
      <%--创建工具栏--%>
      <div id="tb1">
          <a href="#" class="easyui-linkbutton" onclick="opensave();" data-options="iconCls:'icon-add',plain:true">添加</a>
          <a href="#" class="easyui-linkbutton" onclick="delBatchRows();" data-options="iconCls:'icon-delete',plain:true">批量删除</a>

      </div>

      <%--保存上师对话框--%>
      <div id="opensaveBanner" data-options="href:'${pageContext.request.contextPath}/back/guru/save.jsp',draggable:false,iconCls:'icon-save',width:600,height:400,title:'保存上师信息'">

      </div>

      <%--更新上师对话框--%>
      <div id="editDialog" data-options="draggable:false,iconCls:'icon-edit',width:600,height:400,title:'更新上师信息'">

      </div>
