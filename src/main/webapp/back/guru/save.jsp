<%@page pageEncoding="UTF-8" contentType="text/html; charset=utf-8" isELIgnored="false" %>

<div style="text-align: center;">
    <form id="saveSubmit"  method="post" enctype="multipart/form-data">
        <div style="margin-top: 70px;">
            名字: <input name="name" class="easyui-textbox">
        </div>
        <div style="margin-top: 20px;">
            图片: <input name="img"  class="easyui-filebox" data-options="buttonText:'请选择图片',accept:'image/jpeg,image/png,image/gif'">
        </div>
        <div style="margin-top: 20px;">
            性别: <select name="sex"  class="easyui-combobox" style="width: 160px;">
            <option value="m">男</option>
            <option value="n">女</option>
        </select>
        </div>
    </form>
</div>