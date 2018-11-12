<%@page pageEncoding="UTF-8" contentType="text/html; charset=utf-8" isELIgnored="false" %>

<div style="text-align: center;">
    <form id="saveAlbumSubmit"  method="post" enctype="multipart/form-data">
        <div style="margin-top: 70px;">
            名字: <input name="title" class="easyui-textbox">
        </div>
        <div style="margin-top: 20px;">
            专辑上传时间: <input name="publishDate"  class="easyui-datebox">
        </div>
        <div style="margin-top: 20px;">
            章节数量: <input name="count"  class="easyui-textbox">
        </div>
    </form>
</div>