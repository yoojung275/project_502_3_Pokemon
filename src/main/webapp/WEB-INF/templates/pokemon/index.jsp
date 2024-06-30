<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layouts" %>
<c:url var="searchUrl" value="/pokemon" />

<layout:main>
    <section class="layout-width">
        <form name="frmSearch" method="get" action="${searchUrl}" autocomplete="off">
            포켓몬 검색 :
            <input type="text" name="skey" value="${param.skey}" placeholder="검색어를 입력하세요.">
            <button type="submit">검색</button>
        </form>
        <ul class="pokemon-list">
            <c:if test="${items == null || items.isEmpty()}">
                <li class='no-data'>조회된 포켓몬이 없습니다.</li>
            </c:if>
            <c:if test="${items != null && !items.isEmpty()}">
                <c:forEach var="item" items="${items}">
                    <li class="pokemon-data">
                        <a href="<c:url value='/pokemon/view/${item.seq}' />">
                            <img src="${item.frontImage}" alt="${item.nameKr}">
                            <div class="p-name">
                                    ${item.nameKr}(${item.name})
                            </div>
                        </a>
                    </li>
                </c:forEach>
            </c:if>
        </ul>
        <ul>
            <a href="<c:url value="/pokemon?page=1"/>">
                1
            </a>
        </ul>
    </section>
    <util:pagination />
    <script src="js/pokemon/board.js"></script>
</layout:main>