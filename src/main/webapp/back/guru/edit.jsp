<%@page pageEncoding="UTF-8" isELIgnored="false" %>
<script>
    $(function () {
        $("#editInputForm").form('load','${pageContext.request.contextPath}/guru/findOne?id=${param.id}');
    })
</script>
<div style="text-align: center;">
    <form id="editInputForm" class="easyui-form" method="post" enctype="multipart/form-data">
        <input type="hidden" name="id" value="${param.id}">
        <div style="margin-top: 70px;">
            名字: <input type="text" name="name" class="easyui-textbox">
        </div>
        <div style="margin-top: 20px;">
            图片: <input name="img"  class="easyui-filebox" data-options="buttonText:'请选择图片',accept:'image/jpeg,image/png,image/gif'">
        </div>
        <div style="margin-top: 20px;">
            性别: <select name="sex"  class="easyui-combobox" style="width: 160px;">
            <option value="m">男</option>
            <option value="n">女</option>
        </select>
    </form>
</div>