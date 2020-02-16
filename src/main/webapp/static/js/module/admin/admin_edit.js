/**
 * 用户管理
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
              userName: function(value){
                if(value.length < 5){
                  return '昵称至少得5个字符啊';
                }
              }
              ,password: [/(.+){6,12}$/, '密码必须6到12位']
              ,repass: function(value){
                  if($('#L_pass').val()!=$('#L_repass').val()){
                      return '两次密码不一致';
                  }
              }
            });

            //监听提交
            form.on('submit(edit)', function(data){
              console.log(data);
              //发异步，把数据提交给php
              formSubmit(data);
              layer.alert("修改成功", {icon: 6},function () {
                  // 获得frame索引
                  var index = parent.layer.getFrameIndex(window.name);
                  //关闭当前frame
                  parent.layer.close(index);
              });
              return false;
            });
          });
});

function formSubmit(obj){
    $.ajax({
        type: "POST",
        data: $("#userForm").serialize(),
        url: "/admin/list/edit",
        success: function (data) {
            if (data.code == 200) {
                layer.alert(data.msg,function(){
                    layer.closeAll();
                });
            } else {
                layer.alert(data.msg);
            }
        },
        error: function () {
            layer.alert("操作请求错误，请您稍后再试",function(){
                layer.closeAll();
            });
        }
    });
}
