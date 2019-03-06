layui.use(['form','layer','table','laytpl'],function(){
    var form = layui.form,
        layer = parent.layer === undefined ? layui.layer : top.layer,
        $ = layui.jquery,
        laytpl = layui.laytpl,
        table = layui.table;

    //用户列表
    var tableIns = table.render({
        elem: '#goodsList',
        //url : '../../json/goodsList.json',
        url : '/HouseElectricShopManage/user/findByGoodsStatus.action',
        where:{
        	goodsStatus:"0"
        },
        cellMinWidth : 95,
        page : true,
        height : "full-125",
        limit : 15,
        limits : [10,15,20,25],
        id : "goodsListTable",
        cols : [[
            {type: "checkbox", fixed:"left", width:50},
            {field: 'nickName', title: '用户名', minWidth:100, align:"center"},
            {field: 'email', title: '用户邮箱', minWidth:200, align:'center'},
            {field: 'sex', title: '用户性别', align:'center'},
            {field: 'goodsType', title: '用户类型',  align:'center',templet:function(d){
                return d.goodsType == "1" ? "商家" : "用户";
            }},
            {field: 'tel', title: '手机号码', align:'center'},
            {field: 'liveAddress', title: '居住地址', align:'center',minWidth:150},
            {field: 'goodsLevel', title: '货架数量', align:'center',minWidth:150,templet:function(d){
            	if(d.goodsLevel == "1"){
            		return '<a class="layui-blue" href="mailto:'+d.goodsLevel+'">'+3+'</a>';
            	}else if(d.goodsLevel == "2"){
            		return '<a class="layui-blue" href="mailto:'+d.goodsLevel+'">'+5+'</a>';
            	}
            }},
            {field: 'reserveResult', title: '审核结果',  align:'center',templet:function(d){
            	if(d.goodsStatus == "1"){
            		return "等待审核";
            	}else if(d.goodsStatus == "2"){
            		return "审核通过";
            	}else if(d.goodsStatus == "3"){
            		return "审核不通过";
            	}
            }},
            {title: '操作', minWidth:175, templet:'#goodsListBar',fixed:"right",align:"center"}
        ]]
    });

    //搜索【此功能需要后台配合，所以暂时没有动态效果演示】
    $(".search_btn").on("click",function(){
        if($(".searchVal").val() != ''){
            table.reload("newsListTable",{
                page: {
                    curr: 1 //重新从第 1 页开始
                },
                where: {
                    key: $(".searchVal").val()  //搜索的关键字
                }
            })
        }else{
            layer.msg("请输入搜索的内容");
        }
    });

    //审核通过
    function agree(data){
		$.ajax({
			url : "/HouseElectricShopManage/user/updateGoodsLevelById.action",
			data : {
				"id":data,
				"goodsLevel":"2",
				"goodsStatus":"2"
			},
			type : "post",
			async: true,
			success : function(data) {
				//parent.location.reload();
				window.location.reload();
			}
		});
    }
    //审核不通过
    function disAgree(data){
    	$.ajax({
			url : "/HouseElectricShopManage/user/updateGoodsLevelById.action",
			data : {
				"id":data,
				"goodsLevel":"1",
				"goodsStatus":"3"
			},
			type : "post",
			async: true,
			success : function(data) {
				//parent.location.reload();
				window.location.reload();
			}
		});
    }
    $(".addNews_btn").click(function(){
        addgoods();
    })

    //批量删除
    $(".delAll_btn").click(function(){
        var checkStatus = table.checkStatus('goodsListTable'),
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
    table.on('tool(goodsList)', function(obj){
        var layEvent = obj.event,
            data = obj.data;

        if(layEvent === 'edit'){ //编辑
            addgoods(data);
        }else if(layEvent === 'agree'){ //通过
            agree(data.id);
        }else if(layEvent === 'disAgree'){ //不通过
            disAgree(data.id);
        }else if(layEvent === 'usable'){ //启用禁用
            var _this = $(this),
                usableText = "是否确定禁用此用户？",
                btnText = "已禁用";
            if(_this.text()=="已禁用"){
                usableText = "是否确定启用此用户？",
                btnText = "已启用";
            }
            layer.confirm(usableText,{
                icon: 3,
                title:'系统提示',
                cancel : function(index){
                    layer.close(index);
                }
            },function(index){
                _this.text(btnText);
                layer.close(index);
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
