layui.use(['form','layer','laydate','table','laytpl'],function(){
    var form = layui.form,
        layer = parent.layer === undefined ? layui.layer : top.layer,
        $ = layui.jquery,
        laydate = layui.laydate,
        laytpl = layui.laytpl,
        table = layui.table;

    var tableIns = table.render({
        elem: '#newsList',
        url : '../../../pointDetail/page',
        cellMinWidth : 95,
        page : true,
        height : "full-125",
        limit : 20,
        limits : [10,15,20,25],
        id : "newsListTable",
        cols : [[
            {field: 'personalName', title: '用户姓名',align:'center'},
            {field: 'point', title: '操作积分', align:'center'},
            {field: 'type', title: '操作类型',  align:'center',templet:"#newsStatus"},
            {field: 'remark', title: '备注', align:'center'},
            {field: 'createdate', title: '创建时间', align:'center',templet:function(d){
                return d.createDate.substring(0,10);
             }
            }
        ]]
    });

    //搜索【此功能需要后台配合，所以暂时没有动态效果演示】
    $(".search_btn").on("click",function(){
        table.reload("newsListTable",{
            page: {
                curr: 1 //重新从第 1 页开始
            },
            where: {
            	type: $("#type").val()
            }
        })
    });

})