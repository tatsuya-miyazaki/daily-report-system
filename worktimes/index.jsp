<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:import url="/WEB-INF/views/layout/app.jsp">
    <c:param name="content">
        <c:if test="${flush != null}">
            <div id="flush_success">
                <c:out value="${flush}"></c:out>
            </div>
        </c:if>
        <h2>出退勤時間　一覧</h2>
        <table id="worktime_list">
            <tbody>
                <tr>
                    <th class="worktime_name">氏名</th>
                    <th class="worktime_date">日付</th>
                    <th class="worktime_start">出勤時間</th>
                    <th class="worktime_end">退勤時間</th>
                </tr>
                <c:forEach var="worktime" items="${worktimes}" varStatus="status">
                    <tr class="row${status.count % 2}">
                        <td class="worktime_name"><c:out value="${worktime.employee.name}" /></td>
                        <td class="worktime_date"><fmt:formatDate value='${worktime.report_date}' pattern='yyyy-MM-dd' /></td>
                        <td class="worktime_start"><fmt:formatDate value='${worktime.start_hour}' pattern='HH' />：<fmt:formatDate value='${worktime.start_minit}' pattern='mm' /></td>
                        <td class="worktime_start"><fmt:formatDate value='${worktime.end_hour}' pattern='HH' />：<fmt:formatDate value='${worktime.end_minit}' pattern='mm' /></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>

        <div id="pagination">
            （全 ${worktimes_count} 件）<br />
            <c:forEach var="i" begin="1" end="${((worktimess_count - 1) / 15) + 1}" step="1">
                <c:choose>
                    <c:when test="${i == page}">
                        <c:out value="${i}" />&nbsp;
                    </c:when>
                    <c:otherwise>
                        <a href="<c:url value='/worktime/index?page=${i}' />"><c:out value="${i}" /></a>&nbsp;
                    </c:otherwise>
                </c:choose>
            </c:forEach>
        </div>
        <p><a href="<c:url value='/worktime/new' />">出勤時間の登録</a></p>
        <p><a href="<c:url value='/worktime/edit' />">退勤時間の登録</a></p>

    </c:param>
</c:import>