<%@page import="net.sf.json.JSONArray"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="net.sf.json.JSONObject"%>
<%@page import="kr.or.kosa.dto.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//객체를 json 변환
	//1. JSONObject 사용 >> {} 객체 하나 생성
	//2. JSONArray 사용 >> [{},{},{},...]
	
	
	//class(DTO) 가지고 생성
	Member member = new Member();
	JSONObject obj = JSONObject.fromObject(member);
	//{"address":"서울시 강남구","adimin":"1","password":"1004","username":"kosa"}
%>
<%=obj%>
<hr>
<%
List<Member> list = new ArrayList<>();
list.add(new Member("hong","1004","서울시 강남구","0"));
list.add(new Member("kim","1004","서울시 강남구","1"));
list.add(new Member("park","1004","서울시 강남구","0"));

JSONArray memberarray = JSONArray.fromObject(list);
/*
[{"address":"서울시 강남구","adimin":"0","password":"1004","username":"hong"},{"address":"서울시 강남구","adimin":"1","password":"1004","username":"kim"},{"address":"서울시 강남구","adimin":"0","password":"1004","username":"park"}]
*/
%>
<%=memberarray%>
