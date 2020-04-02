<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>剧集列表</title>
<%
	pageContext.setAttribute("APP_PATH", request.getContextPath());
%>
<!-- web路径
不以/开始的相对路径，找资源，以当前资源的路径为基准，经常容易出问题
以/开始的相对路径，找资源，以服务器的路径为标准（http://localhost:3306），需要加上项目名
 -->
<script type="text/javascript"
	src="${APP_PATH }/static/js/jquery-1.12.4.min.js"></script>
<link
	href="${APP_PATH }/static/bootstrap-3.3.7-dist/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="${APP_PATH }/static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
</head>
<body>

	<!-- 剧集修改的模态框  -->
	<div class="modal fade" id="draUpdateModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title">剧集修改</h4>
				</div>
				<div class="modal-body">
					<form class="form-horizontal">
						<div class="form-group">
							<label class="col-sm-2 control-label">剧集名称</label>
							<div class="col-sm-10">
								<p class="form-control-static" id="dra_update_static"></p>
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-2 control-label">当前集数</label>
							<div class="col-sm-10">
								<input type="text" name="dramaCurrent" class="form-control"
									id="draCurrent_update_input" placeholder="看到哪一集了(´｀;)？">
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-2 control-label">已观时长</label>
							<div class="col-sm-10">
								<input type="text" name="dramaCurrentAdd" class="form-control"
									id="draCurrentAdd_update_input" placeholder="这集看到哪了(゜-゜)">
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-2 control-label">总集数</label>
							<div class="col-sm-10">
								<input type="text" name="dramaAll" class="form-control"
									id="draAll_update_input" placeholder="这个剧多少集(O_o)?? ">
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-2 control-label">剧集类型</label>
							<div class="col-sm-4">
								<!-- 类型提交类型ID即可 -->
								<select class="form-control" name="typeId"
									id="type_update_select"></select>
							</div>
						</div>

					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
					<button type="button" class="btn btn-primary" id="dra_update_btn">更新</button>
				</div>
			</div>
		</div>
	</div>

	<!-- 剧集添加的模态框  -->
	<div class="modal fade" id="draAddModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">剧集添加</h4>
				</div>
				<div class="modal-body">
					<form class="form-horizontal">
						<div class="form-group">
							<label class="col-sm-2 control-label">剧集名称</label>
							<div class="col-sm-10">
								<input type="text" name="dramaName" class="form-control"
									id="draName_add_input" placeholder="看的叫啥[・_・?]"> <span
									class="help-block"></span>
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-2 control-label">当前集数</label>
							<div class="col-sm-10">
								<input type="text" name="dramaCurrent" class="form-control"
									id="draCurrent_add_input" placeholder="看到哪一集了(´｀;)？">
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-2 control-label">已观时长</label>
							<div class="col-sm-10">
								<input type="text" name="dramaCurrentAdd" class="form-control"
									id="draCurrentAdd_add_input" placeholder="这集看到哪了(゜-゜)">
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-2 control-label">总集数</label>
							<div class="col-sm-10">
								<input type="text" name="dramaAll" class="form-control"
									id="draAll_add_input" placeholder="这个剧多少集(O_o)?? ">
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-2 control-label">剧集类型</label>
							<div class="col-sm-4">
								<!-- 类型提交类型ID即可 -->
								<select class="form-control" name="typeId" id="type_add_select"></select>
							</div>
						</div>

					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
					<button type="button" class="btn btn-primary" id="dra_save_btn">保存</button>
				</div>
			</div>
		</div>
	</div>

	<!-- 显示页面 -->
	<div class="container">
		<!-- 标题 -->
		<div class="row">
			<div class="col-md-12">
				<h1>剧集戳</h1>
			</div>
		</div>
		<!-- 按钮 -->
		<div class="row">
			<div class="col-md-4 col-md-offset-8">
				<button class="btn btn-primary" id="dra_add_modal_btn">
					<span class="glyphicon glyphicon-plus-sign"></span> 新增
				</button>
				<button class="btn btn-danger" id="dra_delete_all_btn">
					<span class="glyphicon glyphicon-trash"></span> 删除
				</button>
			</div>
		</div>
		<!-- 显示表格数据 -->
		<div class="row">
			<div class="col-md-12">
				<table class="table table-hover" id="dramas_table">
					<thead>
						<tr>
							<th>
								<input type="checkbox" id="check_all"/>
								<span class="glyphicon glyphicon-check"></span>全选
								
							</th>
							<th>剧集名称</th>
							<th>当前集数</th>
							<th>已观时长</th>
							<th>总集数</th>
							<th>剧集类型</th>
							<th>操作</th>
						</tr>
					</thead>
					<tbody>

					</tbody>
				</table>
			</div>
		</div>
		<!-- 显示分页信息 -->
		<div class="row">
			<!-- 分页文字信息 -->
			<div class="col-md-6" id="page_info_area"></div>
			<!-- 分页条 -->
			<div class="col-md-6" id="page_nav_area"></div>
		</div>

	</div>
	<script type="text/javascript">
		var totalRecord,currentPage;
		//1.在页面加载完成以后，直接发送ajax请求，要到分页数据
		$(function() {
			//去首页
			to_Page(1);
		});

		function to_Page(pn) {
			$.ajax({
				url : "${APP_PATH}/dramas",
				data : "pn=" + pn,
				type : "GET",
				success : function(result) {
					//console.log(result);
					//1.解析并显示员工数据
					build_dramas_table(result);
					//2.解析并显示分页信息
					build_page_info(result);
					//2.解析并显示分页条数据
					build_page_nav(result);
				}
			});
		}

		function build_dramas_table(result) {
			//清空table表格
			$("#dramas_table tbody").empty();
			var dramas = result.extend.pageInfo.list;
			$.each(dramas, function(index, item) {
				var checkBoxTd = $("<td></td>").append($("<input>").attr("type","checkbox").addClass("check_item").attr("check_del_id",item.dramaId));
				var dramaIdTd = $("<td></td>").append(item.dramaId);
				var dramaNameTd = $("<td></td>").append(item.dramaName);
				var dramaCurrentTd = $("<td></td>").append(item.dramaCurrent);
				var dramaCurrentAddTd = item.dramaCurrentAdd;
				if (dramaCurrentAddTd == "" || dramaCurrentAddTd == null) {
					dramaCurrentAddTd = $("<td></td>").append("(没有数据呐亲(￣.￣))");
				} else {
					dramaCurrentAddTd = $("<td></td>").append(
							item.dramaCurrentAdd);
				}

				var dramaAllTd = $("<td></td>")
						.append(
								item.dramaAll == null ? "(没有数据呐亲(￣.￣))"
										: item.dramaAll);
				var typeNameTd = $("<td></td>").append(item.type.typeName);
				var editBtn = $("<button></button>").addClass(
						"btn btn-info btn-sm edit_btn").append(
						$("<span></span>").addClass(
								"glyphicon glyphicon-pencil")).append(" ")
						.append("编辑");
				//为编辑按钮添加一个自定义属性，来表示当前剧集ID
				editBtn.attr("edit-id",item.dramaId);
				var delBtn = $("<button></button>").addClass(
						"btn btn-danger btn-sm delete_btn").append(
						$("<span></span>")
								.addClass("glyphicon glyphicon-trash")).append(
						" ").append("删除");
				//为删除按钮添加一个自定义属性，来表示当前剧集ID
				delBtn.attr("del-id",item.dramaId);
				var btnTd = $("<td></td>").append(editBtn).append(" ").append(
						delBtn);
				//append方法执行完成后还是返回原来的元素
				//.append(dramaIdTd)
				$("<tr></tr>").append(checkBoxTd).append(dramaNameTd).append(
						dramaCurrentTd).append(dramaCurrentAddTd).append(
						dramaAllTd).append(typeNameTd).append(btnTd).appendTo(
						"#dramas_table tbody");
			});
		}
		//解析显示分页信息
		function build_page_info(result) {
			$("#page_info_area").empty();
			$("#page_info_area").append(
					"当前第" + result.extend.pageInfo.pageNum + "页,共"
							+ result.extend.pageInfo.pages + "页，共"
							+ result.extend.pageInfo.total + "记录");
			totalRecord = result.extend.pageInfo.total;
			currentPage = result.extend.pageInfo.pageNum;
		}
		//解析显示分页条
		function build_page_nav(result) {
			$("#page_nav_area").empty();
			var ul = $("<ul></ul>").addClass("pagination");
			//构建元素
			var firstPageLi = $("<li></li>").append(
					$("<a></a>").append("首页").attr("href", "#"));
			var prePageLi = $("<li></li>").append(
					$("<a></a>").append("&laquo;"));
			if (result.extend.pageInfo.hasPreviousPage == false) {
				firstPageLi.addClass("disabled");
				prePageLi.addClass("disabled");
			} else {
				//添加事件
				firstPageLi.click(function() {
					to_Page(1);
				});
				prePageLi.click(function() {
					to_Page(result.extend.pageInfo.pageNum - 1);
				});
			}

			var nextPageLi = $("<li></li>").append(
					$("<a></a>").append("&raquo;"));
			var lastPageLi = $("<li></li>").append(
					$("<a></a>").append("末页").attr("href", "#"));
			if (result.extend.pageInfo.hasNextPage == false) {
				nextPageLi.addClass("disabled");
				lastPageLi.addClass("disabled");
			} else {
				nextPageLi.click(function() {
					to_Page(result.extend.pageInfo.pageNum + 1);
				});
				lastPageLi.click(function() {
					to_Page(result.extend.pageInfo.pages);
				});
			}

			//添加首页和前一页的提示
			ul.append(firstPageLi).append(prePageLi);
			//遍历给ul添加页码提示
			$.each(result.extend.pageInfo.navigatepageNums, function(index,
					item) {

				var numLi = $("<li></li>").append($("<a></a>").append(item));
				if (result.extend.pageInfo.pageNum == item) {
					numLi.addClass("active");
				}
				numLi.click(function() {
					to_Page(item);
				});
				ul.append(numLi);
			});
			//添加下一页和末页提示
			ul.append(nextPageLi).append(lastPageLi);
			//吧ul加入到nav
			var navEle = $("<nav></nav>").append(ul);
			navEle.appendTo("#page_nav_area");
		}

		//清除表单数据（表单完整重置（数据+样式））
		function reset_form(ele) {
			$(ele)[0].reset();
			//清空表单样式
			$(ele).find("*").removeClass("has-success has-error");
			$(ele).find(".help-block").text("");
		}

		//点击新增按钮弹出模态框
		$("#dra_add_modal_btn").click(function() {

			reset_form("#draAddModal form");
			//发送ajax请求，查出类型信息显示在下拉列表中
			getTypes("#type_add_select");
			//弹出
			$("#draAddModal").modal({
				backdrop : "static"
			});
		});

		//查出所有的类型信息，并显示在下拉列表中
		function getTypes(ele) {
			$(ele).empty();
			$.ajax({
				url : "${APP_PATH}/types",
				type : "GET",
				success : function(result) {
					//显示类别信息在下拉列表中
					$.each(result.extend.types, function() {
						var optionEle = $("<option></option>").append(
								this.typeName).attr("value", this.typeId);
						optionEle.appendTo(ele);
					});

				}
			});
		}

		//校验表单数据
		function validate_add_form() {
			//拿到要校验的数据
			var draName = $("#draName_add_input").val();
			var regName = /^[\s\S]*.*[^\s][\s\S]*$/;
			if (!regName.test(draName)) {
				show_validate_msg("#draName_add_input", "error",
						"剧集名称不可为空哟Σ (ﾟДﾟ;) ");
				return false;
			} else {
				show_validate_msg("#draName_add_input", "success", "");

			}
			return true;

		}

		function show_validate_msg(ele, status, msg) {
			//清除这个元素之前的样式
			$(ele).parent().removeClass("has-success has-error");
			$(ele).next("span").text("");
			if ("success" == status) {
				$(ele).parent().addClass("has-success");
				$(ele).next("span").text(msg);
			} else if ("error" == status) {
				$(ele).parent().addClass("has-error");
				$(ele).next("span").text(msg);
			}
		}

		$("#draName_add_input").change(
				function() {
					//发送ajax请求校验剧集是否重复
					var draName = this.value;
					$.ajax({
						url : "${APP_PATH}/cheskuser",
						data : "draName=" + draName,
						type : "POST",
						success : function(result) {
							if (result.code == 100) {
								show_validate_msg("#draName_add_input",
										"success", "新剧哟(￣▽￣)／");
								$("#dra_save_btn").attr("ajax-va", "success");
							} else {
								show_validate_msg("#draName_add_input",
										"error", result.extend.va_msg);
								$("#dra_save_btn").attr("ajax-va", "error");
							}
						}
					});
				});

		//点击保存保存剧集
		$("#dra_save_btn").click(
				function() {

					//先对数据校验
					if (!validate_add_form()) {
						return false;
					}
					;

					//判断剧集校验是否成功
					if ($(this).attr("ajax-va") == "error") {
						return false;
					}
					//1.模态框中填写的表单数据提交给服务器进行保存
					//2.发送ajax请求保存剧集

					$.ajax({
						url : "${APP_PATH}/dra",
						type : "POST",
						data : $("#draAddModal form").serialize(),
						success : function(result) {
							//alert(result.msg);
							if (result.code == 100) {
								//剧集保存成功
								//1.关闭模态框
								$('#draAddModal').modal('hide');
								//2.来到最后一页，显示刚才保存的数据
								//发送ajax请求显示最后一页即可
								to_Page(totalRecord);
							} else {

								//显示失败信息
								//console.log(result);
								//有哪个字段的错误信息就显示哪个字段的
								show_validate_msg("#draName_add_input",
										"error",
										result.extend.errorFields.dramaName);

							}

						}
				});

		});
		
		//1.我们是按钮创建之前就绑定了click
		//1）.可以在创建按钮的时候绑定事件 2).绑定单击.live()
		//jquery新版没有live,使用on进行替代
		$(document).on("click",".edit_btn",function(){
			//alert("edit");
			//1.查出类型信息并显示类型列表
			getTypes("#draUpdateModal select");
			//2.查出剧集信息并显示剧集信息
			getDra($(this).attr("edit-id"));
			//把剧集id传递给更新按钮
			$("#dra_update_btn").attr("edit-id",$(this).attr("edit-id"));
			$("#draUpdateModal").modal({
				backdrop : "static"
			});
		});
		
		function getDra(id) {
			$.ajax({
				url:"${APP_PATH}/dra/"+id,
				type:"GET",
				success:function(result){
					//console.log(result);
					var draData = result.extend.dra;
					$("#dra_update_static").text(draData.dramaName);
					$("#draCurrent_update_input").val(draData.dramaCurrent);
					$("#draCurrentAdd_update_input").val(draData.dramaCurrentAdd);
					$("#draAll_update_input").val(draData.dramaAll);
					$("#draUpdateModal select").val([draData.typeId]);
				}
			});
		}
		
		//点击更新更新剧集信息
		$("#dra_update_btn").click(function(){
			//发送ajax请求保存剧集数据
			$.ajax({
				url:"${APP_PATH}/dra/"+$(this).attr("edit-id"),
				type:"PUT",
				data:$("#draUpdateModal form").serialize(),
				success:function(result){
					//alert(result.msg);
					//关闭对话框回到本页面
					$("#draUpdateModal").modal("hide");
					to_Page(currentPage);
				}
			});
		});
		
		//单个删除
		$(document).on("click",".delete_btn",function(){
			//弹出是否确认删除对话框
			var draName = $(this).parents("tr").find("td:eq(1)").text();
			var draId = $(this).attr("del-id");
			if (confirm("要删除【"+draName+"】剧集嘛o(ﾟДﾟ)っ！")) {
				//确认，发送ajax请求删除即可
				$.ajax({
					url:"${APP_PATH}/dra/"+draId,
					type:"DELETE",
					success:function(result){
						//alert(result.msg);
						//回到本页
						to_Page(currentPage);
					}
				});
			}
		});
		
		//全选全不选功能
		$("#check_all").click(function(){
			//使用prop使用原生属性dom，attr获取自定义属性
			$(".check_item").prop("checked",$(this).prop("checked"));
		});
		
		$(document).on("click",".check_item",function(){
			//判断当前选中的元素是否5个
			var flag = $(".check_item:checked").length==$(".check_item").length;
			$("#check_all").prop("checked",flag);
		});
		
		//点击全部删除就批量删除
		$("#dra_delete_all_btn").click(function(){
			var draNames = "";
			var del_idstr = "";
			$.each($(".check_item:checked"),function(){
				draNames += $(this).parents("tr").find("td:eq(1)").text()+"，";
				//组装ID字符串
				del_idstr += $(this).attr("check_del_id")+"-";
			});
			//去除draNames多余“，”
			draNames = draNames.substring(0,draNames.length-1);
			//去除del_idstr多余（“-”）
			del_idstr = del_idstr.substring(0,del_idstr.length-1);
			if (confirm("要删除【"+draNames+"】等剧集嘛(#ﾟДﾟ)")) {
				//确认，发送ajax请求删除即可
				$.ajax({
					url:"${APP_PATH}/dra/"+del_idstr,
					type:"DELETE",
					success:function(result){
						//alert(result.msg);
						//回到本页
						//alert(result.msg);
						to_Page(currentPage);
					}
				});
			}
		});
	</script>

</body>
</html>