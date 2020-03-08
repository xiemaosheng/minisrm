/**
 * 接单管理
 */
var pageCurr;
var form;
$(function() {
  layui.use(['form','layer'], function(){
             $ = layui.jquery;
            var form = layui.form
            ,layer = layui.layer;
            form.render();
            //自定义验证规则
            form.verify({
              mktName: function(value){
                if(value == null){
                  return '店铺名称不能为空';
                }
              }
              ,ASIN: function(value){
                              if(value == null){
                                return 'ASIN不能为空';
                              }
                            }
            });

            //监听提交
            form.on('submit(add)', function(data){
              console.log(data);
              //发异步，把数据提交给php
              formSubmit(data);

              return false;
            });
          });
});

function formSubmit(obj){
    $.ajax({
        type: "POST",
        data: $("#orderForm").serialize(),
        url: "/rec/order/save",
        success: function (data) {
            if (data.code == 200) {
                layer.alert(data.message,function(){
                    layer.closeAll();
                    window.parent.layer.closeAll();
                });
            } else {
                layer.alert(data.message);
                 window.parent.layer.closeAll();
            }

        },
        error: function () {
            layer.alert("操作请求错误，请您稍后再试",function(){
                layer.closeAll();
            });
        }
    });
}
