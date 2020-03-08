/**
 * 用户管理
 */
var pageCurr;
var form;
$(function() {
    layui.use('table', function(){
        var table = layui.table;
        form = layui.form;

        tableIns=table.render({
            elem: '#orderTable',
            url:'/rec/order/all/selectByPage',
            method: 'post', //默认：get请求
            cellwidth: 100,
            limit:10,
            limits:[10,20,30,40,50],
            page: true,
            request: {
                pageName: 'offset', //页码的参数名称，默认：pageNum
                limitName: 'limit' //每页数据量的参数名，默认：pageSize
            },
            response:{
                statusName: 'code', //数据状态的字段名称，默认：code
                statusCode: 200, //成功的状态码，默认：0
                countName: 'total', //数据总数的字段名称，默认：count
                dataName: 'rows' //数据列表的字段名称，默认：data
            },
            cols: [[
                {type: 'checkbox'}
                ,{field:'id', title:'编号',align:'center',width:60}
                ,{field:'recDateTime', title:'接单日期',align:'center',width:120}
                ,{field:'goodImgUrl', title:'图片',width:120,templet:function (d) {
                                                                   return '<div class="layer-photos-demo" onclick="img_click()" style="cursor:pointer;">' +
                                                                   '<img layer-pid="goodImgUrl"  layer-src="'+ d.goodImgUrl +
                                                                   '" src="' + d.goodImgUrl + '" alt="图片">' +
                                                                   '</div>'
                                                                                    }}
                ,{field:'website', title:'站点',align:'center',width:100}
                ,{field:'orderInfo', title:'订单信息',align:'left',templet: function(d){
                                                                     return '<div>' +
                                                                     'ASIN：<span style="color: #c00;">'+ d.aSIN +'</span></br>' +
                                                                     '店铺：<span style="color: #c00;">'+ d.mktName +'</span></br>' +
                                                                     '卖家：<span style="color: #c00;">'+ d.sellerWXQQ +'</span></br>' +
                                                                     '类型：<span style="color: #c00;">'+ d.sellerOrderType +'</span></br>' +
                                                                     '订单号：<span style="color: #c00;">'+ (d.goodOrderNum == 'undefined' ? '无':d.goodOrderNum) +'</span></br>'
                                                                     + '</div>'
                                                                   }
                                                                 }
                ,{field:'price', title: '金额',align:'left',width:150,templet: function(d){
                                                                     return '<div>' +
                                                                     '接单金额：<span style="color: #c00;">'+ d.recPrice +'</span></br>' +
                                                                     '下单金额：<span style="color: #c00;">'+ d.xdPrice +'</span></br>' +
                                                                     '</div>'
                                                                        }}
                 ,{field:'workerName', title: '员工信息',align:'left',width:150,templet: function(d){
                                                                      return '<div>' +
                                                                      '员工代码：<span style="color: #c00;">'+ d.workerName +'</span></br>' +
                                                                      '购买ID：<span style="color: #c00;">'+ d.workerName +'</span></br>' +
                                                                      '</div>'
                                                                         }}
                ,{field:'xdRequirement', title: '下单要求',align:'center'}
                ,{field:'remark', title: '备注',align:'center'}
                ,{field:'statusText', title: '状态',align:'center',width:80}
                ,{field:'flag', title: '额外要求',align:'left',width:100,templet: function(d){
                                                                       return '<div>' +
                                                                       '留评：<span style="color: #c00;">'+ d.isLP +'</span></br>' +
                                                                       '换仓：<span style="color: #c00;">'+ d.isHC +'</span></br>' +
                                                                       '回收：<span style="color: #c00;">'+ d.isHS +'</span></br>' +
                                                                       '</div>'
                                                                       }}
                ,{title:'操作',align:'center', toolbar:'#optBar'}
            ]],
            done: function(res, curr, count){
                //如果是异步请求数据方式，res即为你接口返回的信息。
                //如果是直接赋值的方式，res即为：{data: [], count: 99} data为当前页数据、count为数据总长度
                //console.log(res);
                //得到当前页码
                $("[data-field='userStatus']").children().each(function(){
                    if($(this).text()=='1'){
                        $(this).text("启用")
                    }else if($(this).text()=='0'){
                        $(this).text("失效")
                    }
                });
                //得到数据总量
                //console.log(count);
                pageCurr=curr;
            }
        });

        //监听工具条
        table.on('tool(orderTable)', function(obj){
            var data = obj.data;
            if(obj.event === 'find'){
                // 查看
                find(data.id,"查看订单");
            } else if(obj.event === 'edit'){
                //编辑
                edit(data,"编辑订单");
            }else if(obj.event === 'cancel'){
                //取消
                cancel(data,data.id);
            }
        });

        //监听复选框
        table.on('checkbox(userTable)', function(obj){
            console.log(obj.data); //得到checkbox原始DOM对象
            var data = obj.data;
            if (data == null || data.id == null){
                layer.alert("请选择用户（只能单选）")
            }
            deleteUser(data);
        });

        //监听提交
        form.on('submit(userSubmit)', function(data){
            // TODO 校验
            formSubmit(data);
            return false;
        });
    });

    //搜索框
    layui.use(['form','laydate'], function(){
        var form = layui.form ,layer = layui.layer
            ,laydate = layui.laydate;
        //日期
        laydate.render({
            elem: '#startTime'
        });
        laydate.render({
            elem: '#endTime'
        });
        //TODO 数据校验
        //监听搜索框
        form.on('submit(searchSubmit)', function(data){
            //重新加载table
            load(data);
            return false;
        });
    });
});

//提交表单
function formSubmit(obj){
    $.ajax({
        type: "POST",
        data: $("#userForm").serialize(),
        url: "/user/setUser",
        success: function (data) {
            if (data.code == 1) {
                layer.alert(data.msg,function(){
                    layer.closeAll();
                    load(obj);
                });
            } else {
                layer.alert(data.msg);
            }
        },
        error: function () {
            layer.alert("操作请求错误，请您稍后再试",function(){
                layer.closeAll();
                //加载load方法
                load(obj);//自定义
            });
        }
    });
}

// 编辑--打开编辑页面
function edit(data,title){
    if(data==null || data==""){
        $("#id").val("");
    }else{
        $("#id").val(data.id);
        $("#userName").val(data.userName);
        $("#email").val(data.email);
        $("#userMobile").val(data.userMobile);
    }
    layer.open({
        type: 2,
        title: title,
        fixed: false,
        resize: false,
        shadeClose: true,
         area: ['1200px','900px'],
        content:  '/rec/order/edit/' + data.id,
        end: function(){
            cleanUser();
        }
    });
}

function find(id,title) {
        parent.layer.open({
            type: 2,
            title: title,
            fixed: false,
            resize: false,
            shadeClose: true,
            area: ['1200px','900px'],
            content: "/rec/order/find/" + id,
            end: function(){
                cleanUser();
            }
        });
}

function downUser(obj,id,name) {
    layer.confirm('您确定要停用'+name+'用户吗？', {
                    btn: ['确认','返回'] //按钮
                }, function(){
                    $.post("/admin/list/user/updateUserStatus",{"id":id,"userStatus":0},function(data){
                        if (data.code == 200) {
                            layer.alert(data.message,function(){
                                layer.closeAll();
                                load(obj);
                            });
                        } else {
                            layer.alert(data.data);
                        }
                    });
                }, function(){
                    layer.closeAll();
                });
}
//恢复
function recoverUser(obj,id) {
    if(null!=id){
        layer.confirm('您确定要恢复吗？', {
            btn: ['确认','返回'] //按钮
        }, function(){
            $.post("/admin/list/user/updateUserStatus",{"id":id,"userStatus":1},function(data){
                if (data.code == 200) {
                    layer.alert(data.message,function(){
                        layer.closeAll();
                        load(obj);
                    });
                } else {
                    layer.alert(data.message);
                }
            });
        }, function(){
            layer.closeAll();
        });
    }
}

function load(obj){
    //重新加载table
    tableIns.reload({
        where: obj.field
        , page: {
            curr: pageCurr //从当前页码开始
        }
    });
}

function cleanUser(){
    $("#userName").val("");
    $("#userMobile").val("");
    $("#password").val("");
    $('#roleId').html("");
}
