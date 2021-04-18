var vm = new Vue({
	el: '#list',
	
	data: {
		activeIndex: '1',
		username:'',
		password:'',
		phone:'',
		target:'',
		email:'',
		button:'登录',
		dialogVisible:false
		
	},
	mounted: function(){},
	methods:{
		handleSelect:function(key, keyPath){
		},
		showqi:function(){
			var me=this;
			me.show3=false;
		},
		
		getLogin:function(){
			var me=this;
			
			if(!strNotNUllBoolean(me.username) ){
				return me.$message({ message:"请输入用户名！" , type: 'error' });
			}
			if(!strNotNUllBoolean(me.password) ){
				return me.$message({ message:"请输入密码！" , type: 'error' });
			}
			me.button='登录中...'
			var passwd=User(me.password);
			$.post('/login',{'username':me.username,'password':passwd,'target':me.target},function(result){
				if(result.doResult==1){
					me.button='登录成功';
					me.$message({ message:result.message , type: 'success' });
					window.setTimeout("window.location.href= '" +result.url+"'",500);	
				}else{
					me.button="登录";
					me.password='';
					me.$message({ message:result.message , type: 'error' });
				}
			});
			
		},
		regist:function(){
			window.location.href = "/regist"
			
		},
		add:function(){
			var me=this;
			if(!strNotNUllBoolean(me.username) ){
				return me.$message({ message:"请输入用户名！" , type: 'error' });
			}
			if(!strNotNUllBoolean(me.password) ){
				return me.$message({ message:"请输入密码！" , type: 'error' });
			}
			var passwd=User(me.password);
			$.post('/add',{'username':me.username,'password':passwd,'phone':me.phone,'email':me.email},function(result){
				if(result.doResult==1){
				me.$message({type: 'success',message: result.message});
				window.setTimeout("window.location.href= '" +result.url+"'",500);	
				}else{
					me.$message({type: 'error',message: result.message});
				}
				});
		},
		resetForm:function(){
			var me = this;
			me.username='';
			me.password='';
			me.phone='';
			me.email='';
			
			
		},
		 handleClose:function(done) {
	        this.$confirm('确认关闭？')
	          .then(_ => {
	            done();
	          })
	          .catch(_ => {});
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