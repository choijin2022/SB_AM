<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="pageTitle" value=" JOIN " />
<%@ include file="../common/head.jsp"%>

<script>

let validLoginId = '';




function MemberJoin__submit(form) {
	form.loginId.value = form.loginId.value.trim();
	form.loginPw.value = form.loginPw.value.trim();
	form.loginPwConfirm.value = form.loginPwConfirm.value.trim();
	form.name.value = form.name.value.trim();
	form.nickname.value = form.nickname.value.trim();
	form.cellphoneNum.value = form.cellphoneNum.value.trim();
	form.email.value = form.email.value.trim();
	
	
	
	
	
	if (form.loginId.value.length == 0) {
		alert('아이디를 입력해주세요');
		form.loginPw.focus();
	
		return;
		
	}
	if(form.loginId.value != validLoginId){
		alert(form.loginId.value + '은(는) 사용할 수 없는 아이디입니다.');
		form.loginId.focus();
		return;
	}
	
	if (form.loginPw.value.length == 0) {
		alert('비밀번호를 입력해주세요');
		form.loginPw.focus();
	
		return;
		
	}
	
	if (form.loginPwConfirm.value.length == 0) {
		alert('비밀번호 확인을 입력해주세요');
		form.loginPwConfirm.focus();
	
		return;
	}
	
	if (form.loginPw.value != form.loginPwConfirm.value) {
		alert('비밀번호가 일치하지 않습니다');
		form.loginPw.focus();
	
		return;
	}
	if (form.name.value.length == 0) {
		alert('이름을 입력해주세요');
		form.name.focus();
	
		return;
		
	}
	if (form.nickname.value.length == 0) {
		alert('닉네임을 입력해주세요');
		form.nickname.focus();
	
		return;
		
	}
	if (form.cellphoneNum.value.length == 0) {
		alert('전화번호를 입력해주세요');
		form.cellphoneNum.focus();
	
		return;
		
	}
	if (form.email.value.length == 0) {
		alert('이메일을 입력해주세요');
		form.email.focus();
	
		return;
		
	}
	
	form.submit();
	

	
}

function checkLoginIdDup(el){
	$(".loginId-msg").empty();
	const form = $(el).closest('form').get(0);
	
	if(form.loginId.value.length==0){
		return;
	}
	
	
	$.get('getLoginIdDup', {
		loginId : form.loginId.value,
		ajaxMode : 'Y'
	}, function(data){
		$(".loginId-msg").html(data.data1+'은(는)'+data.msg);
		if(data.success){
			validLoginId = data.data1;
		}else{
			validLoginId = '';
		}
		
	}, 'json');
}


// function checkLoginIdDup(el){
// 	$(".loginId-msg").empty();
// 	const form = $(el).closest('form').get(0);
	
// 	if(form.loginId.value.length==0){
// 		return;
// 	}
	
	
// 	$.get('getLoginIdDup', {
// 		loginId : form.loginId.value,
// 		ajaxMode : 'Y'
// 	}, function(data){
// 		$(".loginId-msg").html(data.data1+'은(는)'+data.msg);
// 		if(data.success){
// 			validLoginId = data.data1;
// 		}else{
// 			validLoginId = '';
// 		}
		
// 	}, 'json');
// }


</script>

<section class="mt-8 text-xl">
	<div class="container mx-auto px-3">
	<form action="doJoin" method="POST" onsubmit="MemberJoin__submit(this); return false;">
		
		<div class="table-box-type-1">
			<table>
				<colgroup>
					<col width="200"/>
				</colgroup>

				<tbody>
				
					<tr height = "105">
						<th>아이디</th>
						<td>
							<input class="input input-bordered w-full max-w-xs" type="text" name="loginId" placeholder="아이디를 입력해주세요" onblur='checkLoginIdDup(this)'>
							<div class="loginId-msg test-sm mt-1 h-5 test-red-500"></div>
						</td>
					</tr>
					<tr>
						<th>비밀번호</th>
						<td>
							<input class="input input-bordered w-full max-w-xs" type="text" name="loginPw" placeholder="비밀번호를 입력해주세요" onblur='requiredData(this)'>
							<div class="required-msg test-sm mt-1 h-5 test-red-500"></div>
						</td>
					<tr>
							<th>비밀번호 확인</th>
							<td><input class="input input-bordered w-full max-w-xs" type="text" name="loginPwConfirm" placeholder="비밀번호 확인을 입력해주세요" /></td>
						</tr>
					<tr>
						<th>이름</th>
						<td><input class="input input-bordered w-full max-w-xs" type="text" name="name" placeholder="이름을 입력해주세요" "/></td>
					</tr>
						<tr>
							<th>닉네임</th>
							<td><input class="input input-bordered w-full max-w-xs" type="text" name="nickname" placeholder="닉네임을 입력해주세요" /></td>
						</tr>
						<tr>
							<th>전화번호</th>
							<td><input class="input input-bordered w-full max-w-xs" type="text" name="cellphoneNum" placeholder="전화번호를 입력해주세요"/></td>
						</tr>
						<tr>
							<th>이메일</th>
							<td><input class="input input-bordered w-full max-w-xs" type="text" name="email" placeholder="이메일을 입력해주세요" /></td>
						</tr>
						<tr>
							<td colspan="2"><button>회원가입</button></td>
						</tr>
				</tbody>
			</table>
		</div>
		<div class="btns">
			<button class="btn-text-link" type="button" onclick="history.back();">뒤로가기</button>
		</div>
		</form>
	</div>
</section>
<%@ include file="../common/foot.jsp"%>