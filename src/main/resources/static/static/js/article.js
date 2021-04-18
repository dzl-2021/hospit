var vm = new Vue({
	el: '#list',
	
	data: {
		activeIndex: '1',
		title:'',
		author:'',
		textarea:'',
		list:[],
		listDetial:[],
	},
	mounted: function(){
		this.getDetail()
	},
	methods:{
		handleSelect:function(key, keyPath){
		},
		showqi:function(){
			var me=this;
			me.show3=false;
		},
		regist:function(){
			window.location.href = "/regist"
			
		},
		getShow:function(item){
			var me = this;
			me.listDetial = [];
			me.author = item.author;
			me.title = item.title;
			$.post('/article/getArticleBytitle',{'id':item.id},function(result){
					me.listDetial = result.detail;
				});
		},
		
		getDetail:function(){
			var me = this;
			me.list = [];
			me.listDetial = [];
			$.post('/article/getArticles',{},function(result){
					me.list = result.list;
					me.author = result.info.author;
					me.title = result.info.title;
					me.listDetial = result.detail;
					
				});
			
		},
		add:function(){
			var me=this;
			if(!strNotNUllBoolean(me.title) ){
				return me.$message({ message:"写个标题吧~！" , type: 'error' });
			}
			$.post('/article/save',{'title':me.title,'textarea':me.textarea},function(result){
				if(result.doResult==1){
				me.$message({type: 'success',message: result.message});
				window.setTimeout("window.location.href= '" +result.url+"'",500);	
				}else{
					me.$message({type: 'error',message: result.message});
				}
				});
		},
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