<!DOCTYPE HTML>
<html>
<head>
    <title>Getting Started: Serving Web Content</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
</head>
<body>

<div>
    <form action="/logout" method="post">
        <input type="hidden" name="_csrf" value="{{_csrf.token}}"/>
        <input type="submit" value="Sign Out"/>
    </form>
</div>

<div>
    <form method="post">
        <input type = "text" name="text" placeholder="Введите сообщение: "/>
        <input type = "text" name="tag" placeholder="Введите тег: "/>
        <input type="hidden" name="_csrf" value="{{_csrf.token}}"/>
        <button type="submit"> Добавить </button>
    </form>
</div>

<div>
    <form method="post" action="filter">
        <input type = "text" name = "filter" placeholder="Поиск по тегу">
        <input type="hidden" name="_csrf" value="{{_csrf.token}}"/>
        <button type = "submit"> Искать </button>
    </form>

    <form method="post" action="deleteByTag">
        <input type = "text" name = "deleteByTag" placeholder="Удаление по тегу">
        <input type="hidden" name="_csrf" value="{{_csrf.token}}"/>
        <button type = "submit"> Удалить </button>
    </form>

</div>

<div>Список сообщений</div>

{{#messages}}
    <div>
        <b>{{id}}</b>
        <span>{{name}}</span>
        <i>{{tag}}</i>
        <strong>{{AuthorName}}</strong>
    </div>
{{/messages}}

</body>
</html>