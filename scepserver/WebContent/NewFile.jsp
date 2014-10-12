<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>

<%@ page import="java.util.Iterator" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="scep.Scep" %>

<%
SimpleDateFormat format = new SimpleDateFormat("hh:mm:SSS");
System.out.println("scep : " + format.format(new Date()));

Map<String, String[]> map = request.getParameterMap();
Iterator<String> iter = map.keySet().iterator();
while (iter.hasNext()) {
	String key = iter.next();
	System.out.println(key + " : " + map.get(key)[0]);
}

Scep scep = new Scep();
scep.service(request, response);

System.out.println("\n");
%>
