<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Hello Vue</title>
		<script src="https://unpkg.com/vue"></script>
	</head>
	<body>
		<div id="one">
			{{message}}
		</div>
		<div id="two">
			<span v-bind:title="showTitle">
				悬停几秒看时间
			</span>
		</div>
		<div id="three">
			<span v-if="seen">一会儿多个D</span>
		</div>
		<div id="four">
			<ol>
				<li v-for="todo in todos">
					{{todo.text}}
				</li>
			</ol>
		</div>
		<div id="five">
			<p>{{message}}</p>
			<button v-on:click="reverse">Reverse</button>
		</div>
		<div id="six">
			<p>{{message}}</p>
			<input v-model="message">
		</div>
		<div id="seven">
			<ol>
			  <!-- 创建一个 todo-item 组件的实例 -->
			  <com-test></com-test>
			</ol>
		</div>
		<div id="app-7">
		  <ol>
		    <!--
		      现在我们为每个 todo-item 提供 todo 对象
		      todo 对象是变量，即其内容可以是动态的。
		      我们也需要为每个组件提供一个“key”，晚些时候我们会做个解释。
		    -->
		    <todo-item
		      v-for="item in groceryList"
		      v-bind:todo="item"
		      v-bind:key="item.id">
		    </todo-item>
		  </ol>
		</div>
	</body>
	<script type="text/javascript">
		var one = new Vue({
			el:"#one",
			data:{
				message:"Hello World!"
			}
		})
		var two = new Vue({
			el:"#two",
			data:{
				showTitle:"北京时间：" + new Date().toLocaleString()
			}
		})
		var three = new Vue({
			el:"#three",
			data:{
				seen:"true"
			}
		})
		function change(){
			if(three.seen){
				three.seen = false;
			}else{
				three.seen = true;
			}
		}
		setInterval("change()",1000);
		var four = new Vue({
			el:"#four",
			data:{
				todos:[
					{text:"A"},
					{text:"B"},
					{text:"C"}
				]
			}
		})
		function changeFour(){
			var length = four.todos.length;
			if(length == 3){
				four.todos.push({text:'D'})
			}else{
				four.todos.splice(3,1);
			}
		}
		setInterval("changeFour()",1000);
		var five = new Vue({
			el:"#five",
			data:{
				message:"Hello World!"
			},
			methods:{
				reverse:function(){
					this.message = this.message.split('').reverse().join("");
				}
			}
		})
		var six = new Vue({
			el:"#six",
			data:{
				message:"Hello World!"
			}
		})
		Vue.component('com-test', {
			template: '<li>这是个待办项</li>'
		})
		var seven = new Vue({
			el:"#seven"
		})
		Vue.component('todo-item', {
		  props: ['todo'],
		  template: '<li>{{ todo.text }}</li>'
		})
		var app7 = new Vue({
		  el: '#app-7',
		  data: {
		    groceryList: [
		      { id: 0, text: '蔬菜' },
		      { id: 1, text: '奶酪' },
		      { id: 2, text: '随便其他什么人吃的东西' }
		    ]
		  }
		})
	</script>
</html>