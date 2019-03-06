function createTime(v){
	var date = new Date(v);
    var y = date.getFullYear();
    var m = date.getMonth()+1;
    m = m<10?'0'+m:m;
    var d = date.getDate();
    d = d<10?("0"+d):d;
    var h = date.getHours();
    h = h<10?("0"+h):h;
    var M = date.getMinutes();
    M = M<10?("0"+M):M;
    var str = y+"-"+m+"-"+d+" "+h+":"+M;
    return str;
}
layui.use(['form','layer','table','laytpl'],function(){
    var form = layui.form,
        layer = parent.layer === undefined ? layui.layer : top.layer,
        $ = layui.jquery,
        laytpl = layui.laytpl,
        table = layui.table;

    //商品列表
    var tableIns = table.render({
        elem: '#proList',
        //url : '../../json/proList.json',
        url : '/HouseElectricShopManage/product/listPage.action',
        cellMinWidth : 95,
        page : true,
        height : "full-125",
        limit : 15,
        limits : [10,15,20,30],
        id : "proListTable",
        cols : [[
            {type: "checkbox", fixed:"left", width:50},
            {field: 'name', title: '商品名称', minWidth:100, align:"center"},
            {field: 'price', title: '销售价格', width:80,  align:'center',templet:function(d){
                return "￥" + d.price;
            }},
            {field: 'market_price', title: '市场价格', width:80, align:'center',templet:function(d){
                return "￥" + d.market_price;
            }},
            {field: 'cost_price', title: '成本价格', width:80, align:'center',templet:function(d){
                return "￥" + d.cost_price;
            }},
            {field: 'createTime', title: '创建时间',minWidth:100, align:'center', 
            	                        templet :function (row){
            		                        return createTime(row.createTime);}},
            {field: 'brand', title: '品牌', width:85, align:'center'},
            {field: 'status', title: '状态', width:85, align:'center'},
            {field: 'func', title: '功能', align:'center'},
            {field: 'hotSpots', title: '选购热点', align:'center',width:100},
            {title: '操作', minWidth:225, templet:'#proListBar',fixed:"right",align:"center"}
        ]]
    });

    //搜索【此功能需要后台配合，所以暂时没有动态效果演示】
    $(".search_btn").on("click",function(){
        if($(".searchVal").val() != ''){
            table.reload("proListTable",{
                page: {
                    curr: 1 //重新从第 1 页开始
                },
                where: {
                    "name": $(".searchVal").val()  //搜索的关键字
                }
            })
        }else{
            layer.msg("请输入搜索的内容");
        }
    });
    
    //添加用户
    function addpro(edit){
        var index = layui.layer.open({
            title : "添加商品",
            type : 2,
            content : "proAdd.html",
            success : function(layero, index){
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
    //查看商品
    function look(data){
        var index = layui.layer.open({
            title : "查看商品",
            type : 2,
            content : "proLook.html?data="+data,
            success : function(layero, index){
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
    //编辑商品
    function edit(data,status){
        var index = layui.layer.open({
            title : "编辑商品",
            type : 2,
            content : "proEdit.html?data="+data+"&status="+status,
            success : function(layero, index){
               setTimeout(function(){
                    layui.layer.tips('点击此处返回用户列表', '.layui-layer-setwin .layui-layer-close', {
                        tips: 3
                    });
                },500);
                /*layui.layer.alert(function(){
                	var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
                	alert(index);
                    parent.layer.close(index);//再执行关闭
                });*/
            },end : function(layero) {
				/*var frameId = $(layero).find("iframe").attr('proEdit');//父页面获取子页面的iframe

				var id = $(window.frames[frameId].document).find("#status").val();//父页面获取子页面指定的id数据
				alert(id);*/
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
        addpro();
    })
    //申请添加货架
    $(".addGoods_btn").click(function(){
        reqAddGoods();
    })
	function reqAddGoods(){
		$.ajax({
			url : "/HouseElectricShopManage/productStatistics/listByProductId.action",
			type : "get",
			async:true,
			success : function(data) {
				//data:{"code":200,"visit":113,"sale_quantity":540,"sale_amount":47}
				if(data.code == "200" && data.visit >= 100 && data.sale_quantity >= 500 && data.sale_amount >= 40){
					$.ajax({
						url : "/HouseElectricShopManage/user/update.action",
						type : "post",
						data:{
							"goodsStatus":"1",
						},
						async:true,
						success : function(data) {
							layer.msg("申请货架成功!");
						}
					});
				}else{
					layer.msg("对不起,您当前的业绩不好,请提高业绩再来申请吧!");
				}
			},
			error : function(data) {
			}
		
		});
	}

    //批量删除
    $(".delAll_btn").click(function(){
        var checkStatus = table.checkStatus('proListTable'),
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
    table.on('tool(proList)', function(obj){
        var layEvent = obj.event,
            data = obj.data;
		if(layEvent === 'look'){
			look(data.id);
		}
		else if(layEvent === 'edit'){ //编辑
            edit(data.id,data.status);
        }else if(layEvent === 'notusable'){ //下架
        	var _this = $(this),
                status = "下架",
                btnText = "下架";
             if(_this.text()=="下架"){
                usableText = "是否确定下架此商品？",
                btnText = "上架";
            }
            layer.confirm(usableText,{
                icon: 3,
                title:'系统提示',
                cancel : function(index){
                    layer.close(index);
                }
            },function(index){
                _this.text(btnText);
                //下架操作
            	$.ajax({
					url : "/HouseElectricShopManage/product/updateStatus.action",
					data : {
						"status":status,
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
        }else if(layEvent === 'usable'){ //上架
            var _this = $(this),
                status = "上架",
                btnText = "上架";
            if(_this.text()=="上架"){
                usableText = "是否确定上架此商品？",
                btnText = "下架";
            }
            layer.confirm(usableText,{
                icon: 3,
                title:'系统提示',
                cancel : function(index){
                    layer.close(index);
                }
            },function(index){
                _this.text(btnText);
                //上架操作
            	$.ajax({
					url : "/HouseElectricShopManage/product/updateStatus.action",
					data : {
						"status":status,
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
            layer.confirm('确定删除此商品？',{icon:3, title:'提示信息'},function(index){
                $.ajax({
					url : "/HouseElectricShopManage/product/deleteById.action",
					data : {
						"id":data.id
					},
					type : "get",
					success : function(data) {
					},
					error : function(data) {
					}
		
				});
                tableIns.reload();
                layer.close(index);
                // })
            });
        }
    });

})
