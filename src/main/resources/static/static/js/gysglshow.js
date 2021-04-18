Var vm = new Vue({
	el:'#list',
	data:{
		activeIndex: '1',
		supplierName:'',
		listjson:[],
	},
	mounted:function(){
		
	},
	methods:{
        handleSelect:function(){
			
		},
		search:function(){
			var me = this;
			me.listjson=[];
			$.post("gys/listjson",{"supplierName":me.supplierName},function(result){
				me.listjson=result.list;
			},"json");
			
		},
		add:function(){
			
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
		"el-menu": ELEMENT.Menu
	}
});