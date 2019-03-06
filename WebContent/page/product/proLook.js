layui.use(['form', 'layer'], function() {
	var form = layui.form
	layer = parent.layer === undefined ? layui.layer : top.layer, $ = layui.jquery;

	form.on("submit(addpro)", function(data) {
				// 弹出loading
				var index = top.layer.msg('数据提交中，请稍候', {
							icon : 16,
							time : false,
							shade : 0.8
						});
				// 实际使用时的提交信息
				// $.post("上传路径",{
				// proName : $(".proName").val(), //登录名
				// proEmail : $(".proEmail").val(), //邮箱
				// proSex : data.field.sex, //性别
				// proGrade : data.field.proGrade, //会员等级
				// proStatus : data.field.proStatus, //用户状态
				// newsTime : submitTime, //添加时间
				// proDesc : $(".proDesc").text(), //用户简介
				// },function(res){
				//
				// })
				setTimeout(function() {
							top.layer.close(index);
							top.layer.msg("用户添加成功！");
							layer.closeAll("iframe");
							// 刷新父页面
							parent.location.reload();
						}, 2000);
				return false;
			})

	// 格式化时间
	function filterTime(val) {
		if (val < 10) {
			return "0" + val;
		} else {
			return val;
		}
	}
	// 定时发布
	var time = new Date();
	var submitTime = time.getFullYear() + '-' + filterTime(time.getMonth() + 1)
			+ '-' + filterTime(time.getDate()) + ' '
			+ filterTime(time.getHours()) + ':' + filterTime(time.getMinutes())
			+ ':' + filterTime(time.getSeconds());

})