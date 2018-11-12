<%@page isELIgnored="false" pageEncoding="utf-8" %>

    <script>
        $(function () {
            $("#hh").treegrid({
                url:'${pageContext.request.contextPath}/album/findAll',
              //  remoteSort:false,//关闭服务器端排序,
                striped:true,//斑马线效果
                pagination:true,//显示分页工具栏
                toolbar:'#tb2',//工具栏
                fitColumns:true,//让列自适应整个容器
                pageNumber:1,//当前页
                pageSize:2,//每页显示记录数
                pageList:[2,5,10,15,30,500],
                idField:'id',
                treeField:'title',
                animate:true,
                columns:[[
                    {title:"名字",field:"title",width:200},
                    {title:"下载路径",field:"downPath",width:200},
                    {title:"章节大小",field:"size",width:200},
                    {title:"章节时长",field:"duration",width:200},
                ]],

            });
        });
        //打开添加章节对话框函数
        function opensavechapter(){
            if($("#hh").treegrid("getSelected")==null){
                $.messager.show({title:'提示',msg:"请选择一个专辑"});
            }else if($("#hh").treegrid("getSelected").downPath!=null){
                $.messager.show({title:'提示',msg:"请选择专辑"});
            }else{
                var result= $("#hh").treegrid("getSelected");
                var id=result.id;

            $("#opensavechapter").dialog({
                href:'${pageContext.request.contextPath}/back/album/save.jsp?id='+id,
                buttons:[{
                    iconCls:'icon-save',
                    text:'保存',
                    handler:function(){
                        //保存章节信息
                        $("#saveSubmit").form('submit',{
                            url:'${pageContext.request.contextPath}/chapter/save',
                            success:function(results){   //响应的一定是json格式字符串   使用应该先转为js对象
                                var resultObj = $.parseJSON(results);
                                if (resultObj.success){
                                    //提示信息
                                    $.messager.show({title:'提示',msg:"添加成功!!!"});
                                }else{
                                    //提示信息
                                    $.messager.show({title:'提示',msg:"添加失败!!!"});
                                }
                                //关闭对话框
                                $("#opensavechapter").dialog('close');
                                //刷新datagrid
                                $("#hh").treegrid('reload');
                            }
                        });
                    }
                },{
                    iconCls:'icon-cancel',
                    text:'关闭',
                    handler:function(){
                        $("#opensavechapter").dialog('close');
                    }
                }]
            });
        }
        }
        //打开添加专辑对话框函数
        function opensavealbum(){
            $("#opensavealbum").dialog({
                buttons:[{
                    iconCls:'icon-save',
                    text:'保存',
                    handler:function(){
                        //保存用户信息
                        $("#saveAlbumSubmit").form('submit',{
                            url:'${pageContext.request.contextPath}/album/save',
                            success:function(results){   //响应的一定是json格式字符串   使用应该先转为js对象
                                var resultObj = $.parseJSON(results);
                                if (resultObj.success){
                                    //提示信息
                                    $.messager.show({title:'提示',msg:"添加成功!!!"});
                                }else{
                                    //提示信息
                                    $.messager.show({title:'提示',msg:"添加失败!!!"});
                                }
                                //关闭对话框
                                $("#opensavealbum").dialog('close');
                                //刷新datagrid
                                $("#hh").datagrid('reload');
                            }
                        });
                    }
                },{
                    iconCls:'icon-cancel',
                    text:'关闭',
                    handler:function(){
                        $("#opensavealbum").dialog('close');
                    }
                }]
            });
        }

        //下载音频
        function downBatchRows2(){
            if($("#hh").treegrid("getSelected")==null){
                $.messager.show({title:'提示',msg:"请选择一个音频"});
            }else if($("#hh").treegrid("getSelected").downPath==null){

                $.messager.show({title:'提示',msg:"请选择章节"});
            }else{
                var result= $("#hh").treegrid("getSelected");

                var downPath1=result.downPath;
                $("#downLoad").attr('href','${pageContext.request.contextPath }/chapter/downLoad?openStyle=attachment&downPath='+downPath1)
            }
        }

        //打开专辑详情对话框函数
        function opensave3(){
            if($("#hh").treegrid("getSelected")==null){
                $.messager.show({title:'提示',msg:"请选择一个专辑"});
            }else if($("#hh").treegrid("getSelected").downPath!=null){
                $.messager.show({title:'提示',msg:"请选择专辑"});
            }else{
                var result= $("#hh").treegrid("getSelected");
                var id=result.id;
                $("#openAlbumShow").dialog({
                    href:'${pageContext.request.contextPath}/back/album/albumShow.jsp?id='+id,
                    buttons:[{
                        iconCls:'icon-cancel',
                        text:'关闭',
                        handler:function(){
                            $("#openAlbumShow").dialog('close');
                        }
                    }]
                });
            }
        }

    </script>

      <table id="hh" data-options="fit:true"></table>
      <%--创建工具栏--%>
      <div id="tb2">
          <a href="#" class="easyui-linkbutton" onclick="opensave3();" data-options="iconCls:'icon-add',plain:true">专辑详情</a>
          <a href="#" class="easyui-linkbutton" onclick="opensavealbum();" data-options="iconCls:'icon-add',plain:true">添加专辑</a>
          <a href="#" class="easyui-linkbutton" onclick="opensavechapter();" data-options="iconCls:'icon-add',plain:true">添加章节</a>
          <a href="#" id="downLoad" class="easyui-linkbutton" onclick="downBatchRows2();" data-options="iconCls:'icon-delete',plain:true">下载音频</a>
      </div>

      <%--保存章节对话框--%>
      <div id="opensavechapter" data-options="href:'${pageContext.request.contextPath}/back/album/save.jsp',draggable:false,iconCls:'icon-save',width:600,height:400,title:'保存章节信息'">

      </div>

    <%--保存专辑对话框--%>
    <div id="opensavealbum" data-options="href:'${pageContext.request.contextPath}/back/album/savealbum.jsp',draggable:false,iconCls:'icon-add',width:600,height:400,title:'保存专辑信息'">

    </div>

    <%--专辑详情对话框--%>
    <div id="openAlbumShow" data-options="href:'${pageContext.request.contextPath}/back/album/albumShow.jsp',draggable:false,iconCls:'icon-add',width:600,height:400,title:'专辑详情'">

    </div>
