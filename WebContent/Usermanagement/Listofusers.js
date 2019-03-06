layui.use(['form','layer','laydate','table','laytpl'],function(){
        var form = layui.form,
            layer = parent.layer === undefined ? layui.layer : top.layer,
            $ = layui.jquery,
            laydate = layui.laydate,
            laytpl = layui.laytpl,
            table = layui.table;

        layui.tree({
            elem: '#demo1' //指定元素
            ,target: '_blank' //是否新选项卡打开（比如节点返回href才有效）
            ,click: function(item){ //点击节点回调
            	//layer.msg(JSON.stringify(item.id));
            	huoqu(item.name,item.id);
            	//预审列表
                var tableIns = table.render({
                    elem: '#newsList',
                    url : 'http://localhost:8080/userInfo/querybuId',
                    where: {
                    	buid:item.id
                    },
                    cellMinWidth : 95,
                    page : true,
                    height : "full-125",
                    limit : 10,
                    limits : [10,15,20,25],
                    id : "newsList",
                    cols : [[
                    	 {type: "checkbox", fixed:"left", width:50},
                         {field: 'uid', title: 'ID', width:100, align:"center"},
                         {field: 'name', title: '姓名', width:200},
                         {field: 'idcard', title: '身份证', width:200},
                         {field: 'phone', title: '手机号', width:200, align:"center"},
                         {field: 'email', title: '邮箱', width:200, align:"center"},
                         {field: 'detailedaddress', title: '具体入住地址', align:"center"},
                         {title: '操作',templet:"#trialListBar",fixed:"right",align:"center"}
                    ]]
                });
            }
            ,nodes: [ //节点
               {
            	   
                    name: '贵州省'
                    ,id: 1
                    ,children: [
                      {
                        name: '贵阳市'
                        ,id: 21
                        ,spread: true
                        ,children: [
                          {
                            name: '市辖区'
                            ,id: '520101'
                          },
                          {
                              name: '南明区'
                              ,id: '520102'
                              ,children: [
                                {
                                  name: '太慈社区艺校居委会'
                                  ,id: '3901'
                                },
                                  {
                                      name: '南明区卫计局'
                                      ,id: '52010200000000'
                                    },
                                    {
                                        name: '南明区公安分局'
                                        ,id: '52010200000001'
                                      },
                           {
                              name: '南明区税务局'
                              ,id: '52010200000002'
                            },
                            {
                                name: '南明区民政局'
                                ,id: '52010200000003'
                              },
                              {
                                  name: '南明区交管局'
                                  ,id: '52010200000009'
                                },
                              ]
                            },{
                              name: '云岩区'
                                  ,id: '520103'
                                  ,children: [
                                    {
                                      name: '云岩区住建局'
                                      ,id: '009415026'
                                    },
                                    {
                                        name: '云岩区教育局'
                                        ,id: '009415069'
                                      },
                                    {
                                        name: '云岩区财政局'
                                        ,id: '009415077'
                                      },
                                      {
                                          name: '云岩区国税局'
                                          ,id: '009415093'
                                        },
                                        {
                                            name: '云岩区地方税务局'
                                            ,id: '009415106'
                                          }
                                  ]
                                },
                                	{
                                    name: '花溪区'
                                        ,id: '520111'
                                        ,children: [
                                          {
                                            name: '花溪区国家税务局'
                                            ,id: '00942001'
                                          },
                                          {
                                              name: '花溪区发展和改革局'
                                              ,id: '009420044'
                                           },
                                         {
                                             name: '花溪区财政局'
                                                 ,id: '009420132'
                                           },
                                         {
	                                         name: '贵阳市公安局花溪分局'
	                                          ,id: '009420167'
	                                       },
                                         {
                                             name: '花溪区农业局'
                                              ,id: '009420247'
                                           }
                                        ]
                                      },
                                      {
                                          name: '乌当区'
                                              ,id: '520112'
                                              ,children: [
                                                {
                                                  name: '贵阳市乌当区农业局'
                                                  ,id: '520112009'
                                                },
                                            {
                                                name: '贵阳市乌当区水务管理局'
                                                ,id: '520112010'
                                              },
                                              {
                                                  name: '贵阳市乌当区商务粮食局'
                                                  ,id: '520112011'
                                                },
                                            {
                                                name: '贵阳市乌当区城市管理局'
                                                ,id: '520112013'
                                              },
                                          {
                                              name: '贵阳市乌当区农业局'
                                              ,id: '520112009'
                                            }
                                              ]
                                            }
                                      ,{
                                          name: '白云区'
                                              ,id: '520113'
                                              ,children: [
                                                {
                                                  name: '白沙关社区政务服务中心'
                                                  ,id: '008600112'
                                                },
                                                {
                                                    name: '大山洞社区政务服务中心'
                                                    ,id: '008600113'
                                                  },
                                          {
                                              name: '艳山红社区政务服务中心'
                                              ,id: '008600114'
                                            },
                                            {
                                                name: '红云社区政务服务中心'
                                                ,id: '008600115'
                                              },
                                              {
                                                  name: '沙文镇人民政府政务服务中心'
                                                  ,id: '008600222'
                                                }
                                              ]
                                            }
                                      ,{
                                          name: '贵阳经开区'
                                              ,id: '520114'
                                              ,children: [
                                                {
                                                  name: '贵阳经济技术开发区国土资源分局'
                                                  ,id: '520114009410401'
                                                },
                                                {
                                                    name: '贵阳市工商行政管理局经开区分局'
                                                    ,id: '520114009410583'
                                                  },
                                                  {
                                                      name: '贵阳经济技术开发区地方税务局'
                                                      ,id: '520114009410591'
                                                    },
                                                    {
                                                        name: '贵阳经济技术开发区产业发展局'
                                                        ,id: '52011400990046'
                                                      },
                                                  {
                                                      name: '贵阳经济技术开发区公安分局'
                                                      ,id: '52011420170712165927007599'
                                                    }
                                              ]
                                            }
                                      ,{
                                          name: '观山湖区'
                                              ,id: '520115'
                                              ,children: [
                                                {
                                                  name: '观山湖区政务中心'
                                                  ,id: '520117999'
                                                }
                                              ],
                                      },{
                                  name: '双龙航空港经济区'
                                      ,id: '520116'
                                      ,children: [
                                        {
                                          name: '双龙政务服务中心'
                                          ,id: '520185000000001'
                                        }
                                      ]},
                                      {
                                      name: '贵阳高新区'
                                          ,id: '520117'
                                          ,children: [
                                            {
                                              name: '高新区政务服务中心'
                                              ,id: '520115789'
                                            }
                                          ],
                                      },
                                      {
                                          name: '开阳县'
                                              ,id: '520121'
                                              ,children: [
                                                {
                                                  name: '开阳县政务中心'
                                                  ,id: '520121999'
                                                }
                                              ]},
                                    {
                                      name: '息烽县'
                                          ,id: '520122'
                                          ,children: [
                                            {
                                              name: '息烽县财政局'
                                              ,id: '009718182'
                                            }
                                          ]
                                    },
                                    {
                                          name: '修文县'
                                              ,id: '520123'
                                              ,children: [
                                                {
                                                  name: '修文县政务中心'
                                                  ,id: '520123888'
                                                }
                                              ]
                                    },
                                    {
                                          name: '清镇市'
                                              ,id: '520181'
                                              ,children: [
                                                {
                                                  name: '清镇市政务中心'
                                                  ,id: '520181999'
                                                }
                                              ]
                                    },
                                    {
                                              name: '小河区'
                                                  ,id: '520183'
                                                  
                                    },{
                                              name: '贵阳综保区'
                                                  ,id: '520184'
                                                  ,children: [
                                                    {
                                                      name: '综保区政务服务中心'
                                                      ,id: '520184008'
                                                    }
                                                 ]
                                            },
                                            {
                                                name: '贵州省体育局'
                                                    ,id: '18404939576950330'
                                            },
                                            {
                                                name: '贵州省发展和改革委员会'
                                                    ,id: '4188128443937240449'
                                            },
                                            {
                                                name: '贵州省卫生和计划生育委员会'
                                                    ,id: '4130465240220517062'
                                            },
                                            {
                                                name: '贵州省水利厅'
                                                    ,id: '4015835234293363918'
                                            },
                                            {
                                                name: '贵州省新闻出版广电局'
                                                    ,id: '7601959127709664009'
                                            }
                                          
				                        ]
				                      }
				                    ]
				                  }
				               ]
				          });
        
    	//用户列表
        var tableIns = table.render({
            elem: '#newsList',
            url : 'http://localhost:8080/userInfo/list',
            cellMinWidth : 95,
            page : true,
            height : "full-125",
            limit : 10,
            limits : [10,15,20,25],
            id : "newsList",
            cols : [[
            	 {type: "checkbox", fixed:"left", width:50},
                 {field: 'uid', title: 'ID', width:100, align:"center"},
                 {field: 'name', title: '姓名', width:200},
                 {field: 'idcard', title: '身份证', width:200},
                 {field: 'phone', title: '手机号', width:200, align:"center"},
                 {field: 'email', title: '邮箱', width:200, align:"center"},
                 {field: 'detailedaddress', title: '具体入住地址', align:"center"},
                 {title: '操作',templet:"#trialListBar",fixed:"right",align:"center"}
            ]]
        });
    //是否置顶
    form.on('switch(newsTop)', function(data){
        var index = layer.msg('修改中，请稍候',{icon: 16,time:false,shade:0.8});
        setTimeout(function(){
            layer.close(index);
            if(data.elem.checked){
                layer.msg("置顶成功！");
            }else{
                layer.msg("取消置顶成功！");
            }
        },500);
    })

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

    //列表操作
    table.on('tool(newsList)', function(obj){
        var layEvent = obj.event,
            data = obj.data;

        if(layEvent === 'edit'){ //编辑
            addNews1(data);
        } else if(layEvent === 'del'){ //删除
        	if(confirm("确定要删除此用户吗？") == true){
            	var params={};
	   		     params.id=data.uid;
	   			 $.ajax({
	   				url: "http://localhost:8080/userInfo/delete",
	   				data:params,
	   				type : "post",
	   				async : true,
	   				success : function(data) {
	   					swal({
				            title: "删除成功！",
				            showCancelButton: true,
				            confirmButtonColor: "#AEDEF4",
				            confirmButtonText: "确定",
				            closeOnConfirm: false
					        }, function() {
					        	location.reload();
					        });
	   				},
	   				error : function(data) {
	   					swal("删除失败！");
					}
	   			});
            }
        }
    });
    function addNews1(data){
    	layui.layer.open({
	        title : "用户添加",
	        type : 2,
	        shadeClose: true,
			maxmin: false,
	        btn: ['提交', '关闭'],
	        content: 'update.html?uid='+data.uid,
	        area:['700px','500px'],
	        yes:function(index){
	        	update();
	    	   }
	     });
    }
})