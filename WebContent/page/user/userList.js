layui.use(['form','layer','table','laytpl'],function(){
    var form = layui.form,
        layer = parent.layer === undefined ? layui.layer : top.layer,
        $ = layui.jquery,
        laytpl = layui.laytpl,
        table = layui.table;

    //用户列表
    var tableIns = table.render({
        elem: '#userList',
        //url : '../../json/userList.json',
        url : '/HouseElectricShopManage/user/listPage.action',
        toolbar: true,
        totalRow: true,
        cellMinWidth : 95,
        page : true,
        height : "full-125",
        limit : 10,
        limits : [5,10,15,25],
        id : "userListTable",
        cols : [[
            {type: "checkbox", fixed:"left", width:50},
            {field: 'nickName', title: '用户名', minWidth:100, align:"center"},
            {field: 'email', title: '用户邮箱', minWidth:200, align:'center',templet:function(d){
                return '<a class="layui-blue" href="mailto:'+d.email+'">'+d.email+'</a>';
            }},
            {field: 'sex', title: '用户性别', align:'center'},
            {field: 'userType', title: '用户类型',  align:'center',templet:function(d){
                var user = "";
                if(d.userType == "1"){
                	user = "商家";
                	return '<a class="layui-blue" href="mailto:'+user+'">'+user+'</a>';
                }else{
                	user = "用户";
                	return '<a class="layui-yellow" href="mailto:'+user+'">'+user+'</a>';
                }
            }},
            {field: 'tel', title: '手机号码', align:'center'},
            {field: 'liveAddress', title: '居住地址', align:'center',minWidth:150},
            {field: 'userStatus', title: '用户状态', align:'center',minWidth:150,templet:function(d){
            	if(d.userStatus == "0"){
            		return "已启用";
            	}else if(d.userStatus == "1"){
            		return "已禁用";
            	}
            }},
            {title: '操作', minWidth:175, templet:function(d){
            	if(d.userStatus == "0"){
            		return '<a class="layui-btn layui-btn-xs" lay-event="usable">已启用</a>';
            	}else if(d.userStatus == "1"){
            		return '<a class="layui-btn layui-btn-xs layui-btn-danger" lay-event="usable">已禁用</a>';
            	}
            },fixed:"right",align:"center"}
        ]],
        response: {
      		statusCode: 200 //重新规定成功的状态码为 200，table 组件默认为 0
   	 	},
   	 	parseData: function(res){ //将原始数据解析成 table 组件所规定的数据
   			console.log("res"+JSON.stringify(res));
     		 return {
       			 "code": res.code, //解析接口状态
		       	 "msg": res.msg, //解析提示文本
		         "count": res.count, //解析数据长度
		         "data": res.data //解析数据列表
     		 };
    	}
    });

    //搜索【此功能需要后台配合，所以暂时没有动态效果演示】
    $(".search_btn").on("click",function(){
        if($(".searchVal").val() != ''){
            table.reload("userListTable",{
                page: {
                    curr: 1 //重新从第 1 页开始
                },
                where: {
                    "nickName": $(".searchVal").val()  //搜索的关键字
                }
            })
        }else{
            layer.msg("请输入搜索的内容");
        }
    });

    //添加用户
    function addUser(edit){
        var index = layui.layer.open({
            title : "添加用户",
            type : 2,
            content : "userAdd.html",
            success : function(layero, index){
                var body = layui.layer.getChildFrame('body', index);
                if(edit){
                    body.find(".userName").val(edit.userName);  //登录名
                    body.find(".userEmail").val(edit.userEmail);  //邮箱
                    body.find(".userSex input[value="+edit.userSex+"]").prop("checked","checked");  //性别
                    body.find(".userGrade").val(edit.userGrade);  //会员等级
                    body.find(".userStatus").val(edit.userStatus);    //用户状态
                    body.find(".userDesc").text(edit.userDesc);    //用户简介
                    form.render();
                }
                setTimeout(function(){
                    layui.layer.tips('点击此处返回用户列表', '.layui-layer-setwin .layui-layer-close', {
                        tips: 3
                    });
                },500)
            }
        })
        layui.layer.full(index);
        window.sessionStorage.setItem("index",index);
        //改变窗口大小时，重置弹窗的宽高，防止超出可视区域（如F12调出debug的操作）
        $(window).on("resize",function(){
            layui.layer.full(window.sessionStorage.getItem("index"));
        })
    }
    $(".addNews_btn").click(function(){
        addUser();
    })

    //批量删除
    $(".delAll_btn").click(function(){
        var checkStatus = table.checkStatus('userListTable'),
            data = checkStatus.data,
            newsId = [];
        if(data.length > 0) {
            for (var i in data) {
                newsId.push(data[i].newsId);
            }
            layer.confirm('确定删除选中的用户？', {icon: 3, title: '提示信息'}, function (index) {
                // $.get("删除文章接口",{
                //     newsId : newsId  //将需要删除的newsId作为参数传入
                // },function(data){
                tableIns.reload();
                layer.close(index);
                // })
            })
        }else{
            layer.msg("请选择需要删除的用户");
        }
    })

    //列表操作
    table.on('tool(userList)', function(obj){
        var layEvent = obj.event,
            data = obj.data;

        if(layEvent === 'edit'){ //编辑
            addUser(data);
        }else if(layEvent === 'usable'){ //启用禁用
            var _this = $(this),
            	userStatus = "1",
                usableText = "是否确定禁用此用户？",
                btnText = "已禁用";
            if(_this.text()=="已禁用"){
                usableText = "是否确定启用此用户？",
                btnText = "已启用";
                userStatus = "0";
            }
            layer.confirm(usableText,{
                icon: 3,
                title:'系统提示',
                cancel : function(index){
                    layer.close(index);
                }
            },function(index){
                _this.text(btnText);
                $.ajax({
					url : "/HouseElectricShopManage/user/updateUserStatusById.action",
					data : {
						"userStatus":userStatus,
						"id":data.id
					},
					type : "get",
					success : function(data) {
					},
					error : function(data) {
					}
		
				});
                layer.close(index);
                window.location.reload();
            },function(index){
                layer.close(index);
            });
        }else if(layEvent === 'del'){ //删除
            layer.confirm('确定删除此用户？',{icon:3, title:'提示信息'},function(index){
                // $.get("删除文章接口",{
                //     newsId : data.newsId  //将需要删除的newsId作为参数传入
                // },function(data){
                    tableIns.reload();
                    layer.close(index);
                // })
            });
        }
    });

})
