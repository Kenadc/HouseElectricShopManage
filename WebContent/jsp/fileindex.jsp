<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <script type="text/javascript" src="../js/jquery.min.js"></script>
    <title>文件上传</title>
</head>
<body>
    <div style="align-items: center;align-content: center;">
        <h1>文件上传</h1>
        <form id="form" method="post" enctype="multipart/form-data">
            <p>请选择要上传的文件:</p>
            <input id="file" name="file" type="file" multiple="multiple"/>
            <br>
            <input id="upload" name="upload" type="button" value="上传">
        </form>
        
    </div>
</body>
<script>
    $(window).ready(function () {
        $("#upload").click(function () {
           var formData = new FormData($('#form')[0]);//获取表单中的文件
           alert(formData);
           //ajax请求
           $.ajax({
               url:"/HouseElectricShopManage/file/fileup.action",//后台的接口地址
               type:"post",//post请求方式
               data:formData,//参数
               cache: false,
               processData: false,
               contentType: false,
               success:function (data) {
                   alert(data);
               },error:function () {
                   alert("操作失败~");
               }
           })
        });
    });
</script>
</html>
