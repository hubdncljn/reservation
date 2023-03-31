<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<jsp:include page="/resources/include/head.jsp" />
<script>
	$(document).ready(function() {
		
		$('header .header .menu li:nth-child(1)').addClass('on');
		
		$('#regBtn').click(function(){
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
	
	
	$(function() {
        $("#resdate").datepicker({
        	dateFormat: 'yy-mm-dd'
                ,buttonImageOnly: true
                ,buttonText: "선택" //버튼 호버 텍스트              
                ,yearSuffix: "년" //달력의 년도 부분 뒤 텍스트
                ,monthNamesShort: ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월']
                ,monthNames: ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월']
                ,dayNamesMin: ['일','월','화','수','목','금','토'] //달력의 요일 텍스트
                ,dayNames: ['일요일','월요일','화요일','수요일','목요일','금요일','토요일']
        });
        
        $("#resdate").on("change", function() {
	    	 var resdate = $('#resdate').val();
	         $.ajax({
	             url:'/res/checkDate',
	             type:'post',
	             data:{resdate:resdate},
	             success:function(result){
	                 if(parseInt(result) == 0){
	                	 alert("예약이 가능한 날짜입니다.");
	                 } else {
	                 	alert("이미 선택된 날짜입니다. 다른 날짜를 선택해주세요.");
	                 	$("#resdate").val("");
	                 	$("#resdate").focus();
	                 }
	             },
	             error:function(){
	                 alert("error");
	             }
	         });
		});
    });
</script>
<section class="">
		<div class="container">
			<div class="title">
				<h1 class="font_title">예약</h1>
			</div>
			<div class="has_fixed_title detail_wrap">
				<form action="/res/regist" method="post">
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
									<td><input type="text" id="name" name="name" placeholder="이름"></td>
									<td><input type="text" id="phonenum" name="phonenum" placeholder="휴대폰 번호" maxlength="13"></td>
									<td><input type="text" id="resdate" name="resdate" placeholder="예약일을 선택해주세요." readonly></td>
								</tr>
							</tbody>
						</table>
					</div>
					<div class="btn_wrap centerT mt20">
						<button type="submit" class="submit_btn" id="regBtn">예약</button>
						<button type="button" class="submit_btn border" onclick="location.href='/res/list'">목록</button>
					</div>
				</form>
			</div>
		</div>
	</section>
<jsp:include page="/resources/include/footer.jsp" />