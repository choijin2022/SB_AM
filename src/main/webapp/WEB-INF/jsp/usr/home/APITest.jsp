<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="pageTitle" value="API" />
<%@ include file="../common/head.jsp"%>

<script>

	const API_KEY = 'eCIuH7bLNd1BmdIIqpFa2FTMadwqxJ539ME6QtSZmTYlwAsadP88mzc4vBo%2BnxSaE32b6SeLZ7wKfLxE42jSxQ%3D%3D';
	
	async function getData(){
		const url = 'http://apis.data.go.kr/1790387/covid19HospitalBedStatus/covid19HospitalBedStatusJson?serviceKey='+API_KEY;
		
		const response = await fetch(url);
		const data = await response.json();
		console.log(data);
		
// 		$('.APITest').html(data.response.result[0].</div>)
	}
	
	
	getData();
	
</script>



<%@ include file="../common/foot.jsp"%>