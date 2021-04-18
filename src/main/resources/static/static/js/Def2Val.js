//字符串非空判断，空返回false,否则true
function strNotNUllBoolean(str){
	if (str === null || str === undefined || str === '') { 
		return false;
	}
	return true;
}

//字符串非空处理
function strNotNUll(str){
	if (str === null || str === undefined || str === '') { 
		return '';
	}
	return str;
}

function isValidDate(date) {
  return date instanceof Date && !isNaN(date.getTime())
}


//图片验证，不是图片返回false,是返回true
function imgYz(str){
	if(strNotNUllBoolean(str)==false){
		return false;
	}
	if(str.lastIndexOf('.pdf')>-1 || str.lastIndexOf('.PDF')>-1){
		return false;
	}
	return true;
}

//判断一个对象是否为空,空返回false,否则true
function dxIsNull(dx){
	if (dx === null || dx === undefined || dx === '') { 
		return false;
	}
	if(JSON.stringify(dx) == "{}"){ 
		return false;
	}
	return true;
}
//判断对象中是否存在某个字段
function ObjectZd(object,zd){
	if(dxIsNull(object)==false){
		return false;
	}
	return object.hasOwnProperty(zd);
}

//判断一个数组是否为空,空返回false,否则true
function szIsNull(sz){
	if(sz === undefined){
		return false;
	}
	if(sz === ''){
		return false;
	}
	if (sz === null) { 
		return false;
	}
	if(Array.prototype.isPrototypeOf(sz)==false){ 
		return false;
	}
	if(sz.length == 0){ 
		return false;
	}
	return true;
}
//复制数组
function fzsz(sz){
	return sz.slice(0);
}
Date.prototype.Format= function (fmt) { 
    var o = {
        "M+": this.getMonth() + 1, //月份 
        "d+": this.getDate(), //日 
        "h+": this.getHours(), //小时 
        "m+": this.getMinutes(), //分 
        "s+": this.getSeconds(), //秒 
        "q+": Math.floor((this.getMonth() + 3) / 3), //季度 
        "S": this.getMilliseconds() //毫秒 
    };
    if (/(y+)/.test(fmt)) fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
    for (var k in o)
    if (new RegExp("(" + k + ")").test(fmt)) fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
    return fmt;
}
//date格式化输出
function rqDateZZfc(rq,ge){
	if(strNotNUllBoolean(rq)==false){
		return '';
	}
	return new Date(rq).Format(ge);
}
function AddDays(dayIn) {
	var date=new Date();
	var myDate=new Date(date.getTime()+dayIn*24*60*60*1000);
	var year=myDate.getFullYear();
	var month=myDate.getMonth()+1;
	var day=myDate.getDate();
	CurrentDate=year+"-";
	if(month>=10)
	{
		CurrentDate=CurrentDate+month+"-";
	}
	else
	{
		CurrentDate=CurrentDate+"0"+month+"-";
	}
	if(day>=10)
	{
		CurrentDate=CurrentDate+day;
	}
	else
	{
		CurrentDate=CurrentDate+"0"+day;
	}
	return CurrentDate;
}

var DATE_REGEXP = new RegExp("(\\d{4})/(\\d{2})/(\\d{2})([T\\s](\\d{2}):(\\d{2}):(\\d{2})(\\.(\\d{3}))?)?.*");
var DATE_REGEXP_1 = new RegExp("(\\d{4})-(\\d{2})-(\\d{2})([T\\s](\\d{2}):(\\d{2}):(\\d{2})(\\.(\\d{3}))?)?.*");
function toDate(dateString){
	if(typeof dateString === 'string'){
		//处理字符串时间转date带毫秒报错处理
		var dateNew=dateString;
		if(DATE_REGEXP.test(dateString)){
			var str=dateString.split(':');
			if(str.length>3){
				dateNew=str[0]+':'+str[1]+':'+str[2];
			}
	    	var date = new Date(dateNew);
	    	return date;
	    }
	    if(DATE_REGEXP_1.test(dateString)){
	    	var str=dateString.split(':');
			if(str.length>3){
				dateNew=str[0]+':'+str[1]+':'+str[2];
			}
			dateNew=dateNew.replace('-',"/");
			dateNew=dateNew.replace('-',"/");
	    	var date = new Date(dateNew);
	    	return date;
	    }
	    
	    dateNew=dateNew.replace('-',"/");
		dateNew=dateNew.replace('-',"/");
		var str=dateNew.split('/');
		if(str.length==3){
			if(str[2].length==2 || str[2].length==1){
				var date = new Date(dateNew);
		    	return date;
			}
		}
	}
	if(typeof dateString === 'object'){
		if(dxIsNull(dateString)==true){
			return dateString;
		}
	}
    return null;
}

//获取手术日期
function hqssrq(){
	var day=new Date().getDay();
	var xjts=1;
	if(day==5){
		xjts=3;
	}
	var d=AddDays(xjts);
	var rq=rqDateZZfc(d,'yyyy-MM-dd');
	var sj="08:00:00:000";
	var rqsj=(rq+' '+sj).replace(/-/g,"/");
	return toDate(rqsj);
}

//获取要求到货日期
function hqyqdhrq(rq){
	var yqdhrq = new Date(rq.getTime() - 24*60*60*1000);
	var myDate = new Date();
	var d = new Date(yqdhrq); 
	//var yqdhrqNew=d.Format("yyyy-MM-dd") +' '+myDate.getHours()+':'+myDate.getMinutes()+':'+myDate.getSeconds();//日期格式化
	var yqdhrqNew=d.Format("yyyy/MM/dd") +' '+myDate.getHours()+':'+'00'+':'+'00'+':000';//日期格式化
	return toDate(yqdhrqNew);
}
//字符串日期转date
function zfcrqZDate(rq){
	var rq=(rq).replace(/-/g,"/");
	return toDate(rq);
}
//根据下标删除数组数据
function xbScSzsj(index,sz){
	var szNew =fzsz(sz);
	sz=[];
	for(var i=0;i<szNew.length;i++){
		if(i!=index){
			sz.push(szNew[i]);
		}
	}
	return sz;
}
//获取字典长度
function getHqzdcd(zd){
	if(dxIsNull(zd)==false){
		return 0;
	}
	return Object.keys(zd).length;
}

//复制一个对象
function getFzygdx(dx){
	return $.extend({}, dx);
}

//判断一个字符串是否是数字或者小数
function isNumber( s )
{
    var regu = "^[0-9]+\.?[0-9]*$";
//    var regu = "^[0-9]*$";
    var re = new RegExp(regu);
    if (re.test(s)) 
    {
        return true;
    } 
    else 
    {
        return false;
    }
}

//实现缩略图
function ReSizePic(ThisPic,RePicWidth){
    //var RePicWidth = 200; //这里修改为您想显示的宽度值

    //============以下代码请勿修改==================================

    var TrueWidth = ThisPic.width;    //图片实际宽度
    var TrueHeight = ThisPic.height;  //图片实际高度
    var Multiple = TrueWidth / RePicWidth;  //图片缩小(放大)的倍数

    ThisPic.width = RePicWidth;  //图片显示的可视宽度
    ThisPic.height = TrueHeight / Multiple;  //图片显示的可视高度
}

//页面请求，url地址处理
function getContextPath() {
    var pathName = document.location.pathname;
    var index = pathName.substr(1).indexOf("/");
    var result = pathName.substr(0,index+1);
    //return document.location.origin+result+"/";
    return result+'/';
  }
//日期比较：d1是否大于d2
function CompareDate(d1,d2)
{
  return ((new Date(d1.replace(/-/g,"\/"))) > (new Date(d2.replace(/-/g,"\/"))));
}
//从数值头部添加数据
Array.prototype.pushHead = function(){
	for(var i = 0 ;i<arguments.length;i++){
		this.splice(i,0,arguments[i]);
	}
}
//从数值头部移除数据
Array.prototype.popHead = function(count){
	if(typeof count === "undefined"){
		this.splice(0,1);
	}
	if(typeof count === "number"){
		this.splice(0,count);
	}
}

//javascript在计算浮点数（小数）不准确，解决方案
var floatTool = function() {

    /*
     * 判断obj是否为一个整数
     */
    function isInteger(obj) {
        return Math.floor(obj) === obj
    }

    /*
     * 将一个浮点数转成整数，返回整数和倍数。如 3.14 >> 314，倍数是 100
     * @param floatNum {number} 小数
     * @return {object}
     *   {times:100, num: 314}
     */
    function toInteger(floatNum) {
        var ret = {times: 1, num: 0}
        if (isInteger(floatNum)) {
            ret.num = floatNum
            return ret
        }
        var strfi  = floatNum + ''
        var dotPos = strfi.indexOf('.')
        var len    = strfi.substr(dotPos+1).length
        var times  = Math.pow(10, len)
        var intNum = parseInt(floatNum * times + 0.5, 10)
        ret.times  = times
        ret.num    = intNum
        return ret
    }

    /*
     * 核心方法，实现加减乘除运算，确保不丢失精度
     * 思路：把小数放大为整数（乘），进行算术运算，再缩小为小数（除）
     *
     * @param a {number} 运算数1
     * @param b {number} 运算数2
     * @param digits {number} 精度，保留的小数点数，比如 2, 即保留为两位小数
     * @param op {string} 运算类型，有加减乘除（add/subtract/multiply/divide）
     *
     */
    function operation(a, b, op) {
        var o1 = toInteger(a)
        var o2 = toInteger(b)
        var n1 = o1.num
        var n2 = o2.num
        var t1 = o1.times
        var t2 = o2.times
        var max = t1 > t2 ? t1 : t2
        var result = null
        switch (op) {
            case 'add':
                if (t1 === t2) { // 两个小数位数相同
                    result = n1 + n2
                } else if (t1 > t2) { // o1 小数位 大于 o2
                    result = n1 + n2 * (t1 / t2)
                } else { // o1 小数位 小于 o2
                    result = n1 * (t2 / t1) + n2
                }
                return result / max
            case 'subtract':
                if (t1 === t2) {
                    result = n1 - n2
                } else if (t1 > t2) {
                    result = n1 - n2 * (t1 / t2)
                } else {
                    result = n1 * (t2 / t1) - n2
                }
                return result / max
            case 'multiply':
                result = (n1 * n2) / (t1 * t2)
                return result
            case 'divide':
                return result = function() {
                    var r1 = n1 / n2
                    var r2 = t2 / t1
                    return operation(r1, r2, 'multiply')
                }()
        }
    }

    // 加减乘除的四个接口
    //floatTool 包含加减乘除四个方法，能确保浮点数运算不丢失精度
    function add(a, b) {//+
        return operation(a, b, 'add')
    }
    function subtract(a, b) {//-
        return operation(a, b, 'subtract')
    }
    function multiply(a, b) {//*
        return operation(a, b, 'multiply')
    }
    function divide(a, b) {// /
        return operation(a, b, 'divide')
    }

    // exports
    return {
        add: add,
        subtract: subtract,
        multiply: multiply,
        divide: divide
    }
}();


function getArrayNum(arr,n1,n2){

	var arr1=[],len=n2||arr.length-1;
	for(var i=n1;i<=len;i++){
	    arr1.push(arr[i])
	}
	return arr1;
	}

/**
 * 零售价
 * @param dj
 * @returns lsj 零售价
 */
function getLsj(dj){
	var lsj=0;
	var jj=0;
	if (Number(dj)<=100) {//小于100元及以下  加价5%
		jj=Number(dj)*0.05;
	}else if (Number(dj)>100&&Number(dj)<=1000) {//100元以上、1000元及以下  加价4%
		jj=Number(dj)*0.04;
	}else if (Number(dj)>1000&&Number(dj)<=10000) {//1000元以上、10000元及以下  加价3%
		jj=Number(dj)*0.03;
	}else if (Number(dj)>10000) {//10000元以上  加价300
		jj=300;
	}
	lsj=Number(dj)+jj;
	return lsj;
}

/**
 * 零售价
 * @param dj
 * @returns lsj 零售价
 */
function getLsjByBl(dj,bl){
	var lsj=0;
	if (Number(bl)<Number(1)) {
		lsj=Number(dj)+Number(dj)*Number(bl);
	}else {
		lsj=Number(dj)+300;
	}
	return lsj;
}

/**
 * 加价比例
 * @param dj
 * @returns {Number}
 */
function getJjbl(dj){
	var bl=0;
	if (Number(dj)<=100) {//小于100元及以下  加价5%
		bl=0.05;
	}else if (Number(dj)>100&&Number(dj)<=1000) {//100元以上、1000元及以下  加价4%
		bl=0.04;
	}else if (Number(dj)>1000&&Number(dj)<=10000) {//1000元以上、10000元及以下  加价3%
		bl=0.03;
	}else if (Number(dj)>10000) {//10000元以上  加价300
		bl=300;
	}
	return bl;
}
/**
 * 数组去重
 * @param a
 * @param b
 * @returns
 */
function distinct(a, b) {
	  let arr = a.concat(b);
	  return arr.filter((item, index)=> {
	    return arr.indexOf(item) === index
	  })
	}


function getMonthWeek(a, b, c) {
    /**
    * a = d = 当前日期
    * b = 6 - w = 当前周的还有几天过完(不算今天)
    * a + b 的和在除以7 就是当天是当前月份的第几周
    */
    var date = new Date(a, parseInt(b) - 1, c),
        w = date.getDay(),
        d = date.getDate();
    if(w==0){
        w=7;
    }
    var config={
        getMonth:date.getMonth()+1,
        getYear:date.getFullYear(),
        getWeek:Math.ceil((d + 6 - w) / 7),
    }
    return config;
}
function User(str){
	return hex_md5(str);
	
}
function getHqzdrqSydjz(rq){
	var rqNew=toDate(rq);
	var getDate=getMonthWeek(rqDateZZfc(rqNew,'yyyy'), rqDateZZfc(rqNew,'MM'), rqDateZZfc(rqNew,'dd'));
	//console.log("今天是 " + getDate.getYear + " 年的第 "+ getDate.getMonth + " 月的第 " + getDate.getWeek + " 周");
	return getDate.getWeek;
}