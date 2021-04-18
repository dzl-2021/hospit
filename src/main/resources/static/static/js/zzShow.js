var vm = new Vue({
	el:'#list',
	data:{
		activeName:'first',
		gysdm:'',
		businessTypeCode:'001',
		loading:true,
		listjsongys:[],
		listjsoncs:[],
		listjsoncp:[],
	},
	
	mounted: function(){
		this.zzshowtj();
		this.getListjsongq();
		this.handleClick();
	},
	methods:{
		handleSelect(key, keyPath) {
	        console.log(key, keyPath);
	      }
		handleClick:function(){//选择选项卡时
			var me =this;
			me.listjsongys=[];
			me.listjsoncs=[];
			me.listjsoncp=[];
		
		    if(me.activeName == 'first'){
				me.getListjsongq('001');
			}else if(me.activeName == 'second'){
				me.getListjsongq('002');
			}else if(me.activeName == 'third'){
				me.getListjsongq('003');
			}
		},
		
		getListjsongq:function(businessTypeCode){
			var me=this;
			me.loading=true;
			me.listjsongys=[];
			me.listjsoncs=[];
			me.listjsoncp=[];
			$.post("/listjsongq",{'businessTypeCode':businessTypeCode},function(result){
				if(businessTypeCode=='001'){
					me.listjsongys=result.listgysgq;
				}else if(businessTypeCode=='002'){
					me.listjsoncs=result.listgysgq;
				}else if(businessTypeCode=='003'){
					me.listjsoncp=result.listgysgq;
				}
				me.loading=false;
			});
			
		},
		zzshowtj:function(){
		   var me=this;
		   var chart = {
				      type: 'column'
				   };
				   var title = {
				      text: '供应商资质信息统计'   
				   };
				   var subtitle = {
				      text: ''  
				   };
				   var xAxis = {
				      categories: ['总体状况','供应商','生厂商','产品'],
				      crosshair: true
				   };
				   var yAxis = {
				      min: 0,
				      title: {
				         text: '数量'         
				      }      
				   };
				   var tooltip = {
				      headerFormat: '<span style="font-size:10px">{point.key}</span><table>',
				      pointFormat: '<tr><td style="color:{series.color};padding:0">{series.name}: </td>' +
				         '<td style="padding:0"><b>{point.y:.1f} mm</b></td></tr>',
				      footerFormat: '</table>',
				      shared: true,
				      useHTML: true
				   };
				   var plotOptions = {
				      column: {
				         pointPadding: 0.2,
				         borderWidth: 0,
				      },
					   series: {
			                cursor: 'pointer',
			                events: {
					              click: function(e) {
					            	  
					            	  location.href = e.point.url;
					                  //上面是当前页跳转，如果是要跳出新页面，那就用
					                  //window.open(e.point.url);
					                  //这里的url要后面的data里给出
					          			}
					      			}
			            }
				   
				   };  
				   var credits = {
				      enabled: false
				   };
				 
				   
				   var series= [{name:'过期',data:[]}];    
				  
				      
				   var json = {};   
				   json.chart = chart; 
				   json.title = title;   
				   json.subtitle = subtitle; 
				   json.tooltip = tooltip;
				   json.xAxis = xAxis;
				   json.yAxis = yAxis;  
				   json.series = series;
				   json.plotOptions = plotOptions;  
				   json.credits = credits;
				  
				  $.post("/listjson",{},function(result){
					 for(var i=0;i<result.listgq.length;i++){
						 var arr={data:parseInt(result.listgq[0]),url:'/zzmxshow'};
						 series[0].data.push(arr);
					 }
					
					  json.series = series;
						$('#container').highcharts(json);
						},'json');				
		}
		
	},
	components: {
		"el-row": ELEMENT.Row,
		"el-col": ELEMENT.Col,
		"el-card": ELEMENT.Card,
		"el-form": ELEMENT.Form,
		"el-form-item": ELEMENT.FormItem,
		"el-button": ELEMENT.Button,
		"el-select": ELEMENT.Select,
		"el-option": ELEMENT.Option,
		"el-input": ELEMENT.Input,
		"el-upload": ELEMENT.Upload,
		"el-menu":ELEMENT.Menu
	}
	
	
});