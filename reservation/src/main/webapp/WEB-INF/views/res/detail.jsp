<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<jsp:include page="/resources/include/head.jsp" />
<script>
	let result = '<c:out value="${result}"/>';
	
	checkAlert(result);
	
	function checkAlert(result) {
		if (result === '') {
			return;
		}
		if (result === "modify success") {
			window.confirm('예약 변경이 완료되었습니다.');
		}
	}
	$(document).ready(function() {
		
		$('header .header .menu li:nth-child(1)').addClass('on');
		
		$('#modBtn').click(function(){
			if($("#name").val() == "" || $("#name").val() == null){
			    alert("이름을 입력해주세요.");
			    $("#name").focus();
			    return false;
			}
			if($("#phonenum").val() == "" || $("#phonenum").val() == null){
			    alert("휴대폰 번호를 입력해주세요.");
			    $("#phonenum").focus();
			    return false;
			}
			if($("#resdate").val() == "" || $("#resdate").val() == null){
			    alert("예약일을 선택해주세요.");
			    $("#resdate").focus();
			    return false;
			}
			
			var regExp = /^(?:(010-\d{4})|(01[1|6|7|8|9]-\d{3,4}))-(\d{4})$/;
    	    if(!regExp.test($("#phonenum").val())){
    	    	alert("휴대폰번호가 올바르지 않습니다.");
    	    	$("#phonenum").focus();
    	   		return false;
    	    }
		});
		
	    $("#phonenum").on("keyup", function() {
		      $(this).val($(this).val().replace(/[^0-9]/g,""));
		      $(this).val( $(this).val().replace(/[^0-9]/g, "").replace(/(^02|^0505|^1[0-9]{3}|^0[0-9]{2})([0-9]+)?([0-9]{4})$/,"$1-$2-$3").replace("--", "-") );
		});
	});
</script>
<section class="">
		<div class="container">
			<div class="title">
				<h1 class="font_title">예약 상세정보</h1>
			</div>
			<div class="has_fixed_title detail_wrap">
				<form action="/res/delete" method="post">
					<input type="hidden" id="rno" name="rno" value="${mrvo.rno }">
					<div class="">
						<table>
							<thead>
								<tr class="tr_center">
									<th>이름</th>
									<th>휴대폰 번호</th>
									<th>예약일</th>
								</tr>
							</thead>
							<tbody>
								<tr class="tr_center">
									<td><input type="text" id="name" name="name" placeholder="이름" value="${mrvo.name }" readonly></td>
									<td><input type="text" id="phonenum" name="phonenum" placeholder="휴대폰 번호" maxlength="13" value="${mrvo.phonenum }" readonly></td>
									<td><input type="text" id="resdate" name="resdate" placeholder="예약일" value="${mrvo.resdate }"readonly></td>
								</tr>
							</tbody>
						</table>
					</div>
					<div class="btn_wrap centerT mt20">
						<button type="submit" class="submit_btn" id="delBtn">예약 취소</button>
						<button type="button" class="submit_btn" onclick="location.href='/res/modify?rno=${mrvo.rno }'">예약 변경</button>
						<button type="button" class="submit_btn border" onclick="location.href='/res/list'">목록</button>
					</div>
				</form>
			</div>
		</div>
	</section>
<jsp:include page="/resources/include/footer.jsp" />