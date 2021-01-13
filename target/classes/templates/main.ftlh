<#import "parts/common.ftlh" as c>
<#import "parts/login.ftlh" as l>

<@c.page>
<@l.logout/>

<div>
    <span><a href="/user"> Перейти на страницу админа </a></span>
</div>

<div>
    <form method="post">
        <input type = "text" name="text" placeholder="Введите сообщение: "/>
        <input type = "text" name="tag" placeholder="Введите тег: "/>
        <input type="hidden" name="_csrf" value="${_csrf.token}"/>
        <button type="submit"> Добавить </button>
    </form>
</div>

    <form method="get" action="/main">
        <input type = "text" name = "filter" placeholder="Поиск по тегу"  value="${filter!}">
        <button type = "submit"> Искать </button>
    </form>

<div>
    <form method="post" action="deleteByTag">
        <input type = "text" name = "deleteByTag" placeholder="Удаление по тегу">
        <input type="hidden" name="_csrf" value="${_csrf.token}"/>
        <button type = "submit"> Удалить </button>
    </form>
</div>


<div>Список сообщений</div>
<#list messages as message>
        <div>
            <b>${message.id}</b>
            <span>${message.name}</span>
            <i>${message.tag}</i>
            <strong>${message.authorName}</strong>
        </div>
<#else>
No message
</#list>
</@c.page>



