function getTime() {
    var date=new Date();
    //获取年
    var year=date.getFullYear();
    var month=date.getMonth();
    var day=date.getDate();
    var h=date.getHours();
    var m=date.getMinutes();
    var s=date.getSeconds();
    //拼接字符串
    var str=year+"年"+(month+1)+"月"+day+"日"+h+":"+m+":"+s;

    $("#timer").html(str);
}

function time() {
    var timer=setInterval(getTime,1000);



}
/*function GetQueryString(name)
{
    var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)");
    var r = window.location.search.substr(1).match(reg);    //search,查询？后面的参数，并匹配正则
    if(r!=null)
        return  unescape(r[2]);
    return null;
}
function addNum() {
    var a=GetRequest();
    /!*var gNum=a['gNum'];*!/
    $('#gNum').val(a['gNum']);
    $('#pNum').val(a['pNum']);
    $('#gName').val(a['gName']);
}*/

/*
function GetRequest() {
    var url = location.search; //获取url中"?"符后的字串
    var theRequest = new Object();
    if (url.indexOf("?") != -1) {
        var str = url.substr(1);
        strs = str.split("&");
        for (var i = 0; i < strs.length; i++) {
            theRequest[strs[i].split("=")[0]] = decodeURIComponent(strs[i].split("=")[1]);
        }
    }
    return theRequest;
}*/
