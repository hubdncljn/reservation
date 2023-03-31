<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<jsp:include page="/resources/include/head.jsp" />
<script>
	let result = '<c:out value="${result}"/>';
	
	checkAlert(result);
	
	function checkAlert(result) {
		if (result === '') {
			return;
		}
		if (result === "regist success") {
			window.confirm('예약이 완료되었습니다.');
		}
		if (result === "delete success") {
			window.confirm('예약이 취소되었습니다.');
		}
	}
	$(document).ready(function() {
		$('header .header .menu li:nth-child(1)').addClass('on');
	});
</script>
<section class="">
	<div class="container ">
		<div class="title clearfix">
			<h1 class="font_title">예약현황</h1>
		</div>
		<div class="has_fixed_title contwrap">
			<form action="/res/list">
				<div class="clearfix2 search_box">
					<p>총 ${totalCount }</p>
				</div>
			</form>
			<table class="list_table table_fixed">
				<colgroup>
					<col width="10%">
					<col width="30%">
					<col width="30%">
					<col width="30%">
				</colgroup>
				<thead>
					<tr class="tr_center">
						<th>예약 번호</th>
						<th>이름</th>
						<th>휴대폰 번호</th>
						<th>예약일</th>
					</tr>
				</thead>
				<c:choose>
					<c:when test="${list.size() ne 0 }">
						<tbody>
							<c:forEach items="${list }" var="mrvo" varStatus="status">
								<tr class="tr_center" onclick="location.href='/res/detail?rno=${mrvo.rno }'">
									<td>${mrvo.rno }</td>
									<td>${mrvo.name }</td>
									<td>${mrvo.phonenum }</td>
									<td>${mrvo.resdate }</td>
								</tr>
							</c:forEach>
						</tbody>
					</c:when>
					<c:otherwise>
						<tbody>
							<tr class="nodata">
								<td colspan="3" class="centerT">데이터가 없습니다.</td>
							</tr>
						</tbody>
					</c:otherwise>
				</c:choose>
			</table>
			<div class="">
				<button type="button" class="submit_btn" onclick="location.href='/res/regist'">예약하기</button>
			</div>
			<div class="pagination">
				<ul class="clearfix">
					<!-- 이전페이지 버튼 -->
					<c:if test="${pageMaker.prev}">
						<li>
							<a href="/res/list?pageNum=${pageMaker.startPage-1}">
								<img src="/resources/img/back_arrow.png" alt="전 페이지로">
							</a>
						</li>
					</c:if>
					<!-- 각 페이지 버튼 -->
					<c:forEach var="num" begin="${pageMaker.startPage}" end="${pageMaker.endPage}">
						<li>
							<a href="/res/list?pageNum=${num}" class="${pageMaker.pgvo.pageNum == num ? "active":"" }">${num}</a>
						</li>
					</c:forEach>
					<!-- 다음페이지 버튼 -->
					<c:if test="${pageMaker.next}">
						<li>
							<a href="/res/list?pageNum=${pageMaker.endPage + 1 }">
								<img src="/resources/img/front_arrow.png" alt="다음 페이지로">
							</a>
						</li>
					</c:if>
				</ul>
			</div>
		</div>
	</div>
</section>
<jsp:include page="/resources/include/footer.jsp" />