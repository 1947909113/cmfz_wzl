<%@page pageEncoding="UTF-8" contentType="text/html; charset=utf-8" isELIgnored="false" %>

<div style="text-align: center;">
    <form id="saveSubmit"  method="post" enctype="multipart/form-data">

        <input name="parent_id" value="${param.id}" style="display: none">

        <div style="margin-top: 70px;">
            名字: <input name="title" class="easyui-textbox">
        </div>
        <div style="margin-top: 20px;">
            上传音频: <input name="name"  class="easyui-filebox">
        </div>
    </form>
</div>