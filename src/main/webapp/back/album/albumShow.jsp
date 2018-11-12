<%@page pageEncoding="UTF-8" contentType="text/html; charset=utf-8" isELIgnored="false" %>

<script>
    $(function () {
        $("#ShowAlbumSubmit").form('load','${pageContext.request.contextPath}/album/showalbum?id=${param.id}');
    })
</script>

<div style="text-align: center;">
    <form id="ShowAlbumSubmit"  method="post" enctype="multipart/form-data">

        <input name="id" value="${param.id}" style="display: none">

        <div style="margin-top: 70px;">
            专辑名称: <input name="title" class="easyui-textbox">
        </div>
        <div style="margin-top: 20px;">
            专辑上传时间: <input name="publishDate"  class="easyui-textbox">
        </div>
        <div style="margin-top: 20px;">
            章节数量: <input name="count"  class="easyui-textbox">
        </div>
    </form>
</div>