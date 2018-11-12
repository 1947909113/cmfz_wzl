<%@page pageEncoding="UTF-8" contentType="text/html; charset=utf-8" isELIgnored="false" %>

<div style="text-align: center;">
    <form id="saveSubmitCourse"  method="post" enctype="multipart/form-data">

        <div style="margin-top: 70px;">
            课程: <input name="title" class="easyui-textbox">
        </div>
        <div style="margin-top: 20px;">
            课程类别: <select name="flag"  class="easyui-combobox" style="width: 160px;">
            <option value="必修">必修</option>
            <option value="选修">选修</option>
        </select>
        </div>
        <div style="margin-top: 20px;">
            时间: <input name="creatTime"  class="easyui-datebox">
        </div>
    </form>
</div>