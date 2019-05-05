/**
 * 验证登录，数据交互
 */

function btn1() {
        var yz=/[123456789][0-9]{8}$/;
        if(yz.test($('#name').val())){
            $.post("/admin/adminLogin",
                {"stuId":$('#name').val(),"pwd":$('#pwd').val(),"code":$('#code').val()},
                function(data){
                    if(data == 0){
                        window.location.href = "index.html";
                    }else if(data==1){
                        alert("验证码错误！");
                        return false;
                    }else if(data==2){
                        alert("学号不存在！");
                        return false;
                    }else if(data==4){
                        alert("账户被禁用，请联系超级管理员！");
                        return false;
                    }else{
                        alert("密码错误！");
                        return false;
                    }
                },"json");
        }else{
            alert("请输入正确的学号！")
        }
}
var num=0;
function chang(img){
    var path = "/val/getValimg";
	img.setAttribute("src", path+"?"+num++ );
}

