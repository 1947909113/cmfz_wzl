<%@page pageEncoding="UTF-8" contentType="text/html; charset=utf-8" isELIgnored="false" %>
<script>
    function checkRelPsw(){
        var relpswValue=document.getElementById("realPassword").value;
        var pswValue=document.getElementById("newPassword").value;
        //alert(pswValue);
        var relpsw=document.getElementById("relpswMessageSpan");
        if(relpswValue!=pswValue){
            relpsw.innerHTML="<font color='red'>两次密码不一致</font>";
            return false;
        }else{
            relpsw.innerHTML="<font color='green'>√</font>";
            return true;
        }

    }
</script>
<div style="text-align: center;">
    <form id="updateSubmit"  method="post" enctype="multipart/form-data">
        <div style="margin-top: 70px;">
            原密码: <input id="oldPassword" name="oldPassword" class="easyui-passwordbox">
            <span id="oldpswMessageSpan"></span></td>

        </div>
        <div style="margin-top: 20px;">
            新密码: <input id="newPassword" name="password"  class="easyui-passwordbox">
            <span id="newpswMessageSpan"></span></td>
        </div>
        <div style="margin-top: 20px;">
            确认密码: <input id="realPassword" name="realPassword"  class="easyui-passwordbox" onblur="checkRelPsw()">
            <span id="relpswMessageSpan"></span></td>
        </div>
    </form>
</div>