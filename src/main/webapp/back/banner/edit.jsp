<%@page pageEncoding="UTF-8" isELIgnored="false" %>
<script>
    $(function () {
        $("#editInputForm").form('load','${pageContext.request.contextPath}/banner/findOne?id=${param.id}');
    })
</script>
<div style="text-align: center;">
    <form id="editInputForm" class="easyui-form" method="post" enctype="multipart/form-data">
        <input type="hidden" name="id" value="${param.id}">
        <div style="margin-top: 70px;">
            名字: <input type="text" name="title" class="easyui-textbox">
        </div>
        <div style="margin-top: 20px;">
            图片: <input name="img"  class="easyui-filebox" data-options="buttonText:'请选择图片',accept:'image/jpeg,image/png,image/gif'">
        </div>
        <div style="margin-top: 20px;">
            状态: <select name="status"  class="easyui-combobox" style="width: 160px;">
            <option value="y">y</option>
            <option value="n">n</option>
        </select>
    </form>
</div>