layui.use(['form','layer'],function(){
    var form = layui.form
        layer = parent.layer === undefined ? layui.layer : top.layer,
        $ = layui.jquery;

    form.on("submit(addpro)",function(data){
        //弹出loading
        var index = top.layer.msg('数据提交中，请稍候',{icon: 16,time:false,shade:0.8});
        // 实际使用时的提交信息
        console.log($("#status").val()+"--------"+$("#hotSpots").val()+"--------"+$("#func").val());
        $.ajax({
			url : "/HouseElectricShopManage/product/insert.action",
			data : {
				"id":u,
				"name":$("#name").val(),
				"price":$("#price").val(),
				"market_price":$("#market_price").val(),
				"cost_price":$("#cost_price").val(),
				"status":$("#status").val(),
				"createTime":$("#createTime").val(),
				"brand":$("#brand").val(),
				"hotSpots":$("#hotSpots").val(),
				"func": $("#func").val(),
				"content":$("#content").val(),
				"purchase_quantity":$("#purchase_quantity").val()
			},
			type : "get",
			success : function(data) {
				top.layer.close(index);
				top.layer.msg("商品添加成功！");
				layer.closeAll("iframe");
				parent.location.reload();
			},
			error : function(data) {
				top.layer.close(index);
				top.layer.msg("商品修改失败！");
				layer.closeAll("iframe");
				// 刷新父页面
				parent.location.reload();
			}
		});
		return false;
    })

    //格式化时间
    function filterTime(val){
        if(val < 10){
            return "0" + val;
        }else{
            return val;
        }
    }
    //定时发布
    var time = new Date();
    var submitTime = time.getFullYear()+'-'+filterTime(time.getMonth()+1)+'-'+filterTime(time.getDate())+' '+filterTime(time.getHours())+':'+filterTime(time.getMinutes())+':'+filterTime(time.getSeconds());

})