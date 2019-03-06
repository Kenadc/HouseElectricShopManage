layui.use(['form','layer','table','laytpl'],function(){
    var form = layui.form,
        layer = parent.layer === undefined ? layui.layer : top.layer,
        $ = layui.jquery,
        laytpl = layui.laytpl,
        table = layui.table;

    //用户列表
    var tableIns = table.render({
        elem: '#dataList',
        //url : '../../json/userList.json',
        url : '/HouseElectricShopManage/productStatistics/findListByDate.action?type=2',
        toolbar: true,
        totalRow: true,
        cellMinWidth : 95,
        page : true,
        height : "full-125",
        limit : 10,
        limits : [5,10,15,25],
        id : "dataListTable",
        cols : [[
            {type: "checkbox", fixed:"left", width:50},
            {field: 'titleNav', title: '日期', minWidth:100, align:"center"},
            {field: 'visit_count', title: '浏览次数', minWidth:200, align:'center',templet:function(d){
                return '<a class="layui-blue" href="mailto:'+d.visit_count+'">'+d.visit_count+'</a>';
            }},
            {field: 'sale_quantity', title: '销售总量', align:'center'},
            {field: 'sale_amount', title: '销售总额(单位￥)',  align:'center'}
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

})
