Почитать что такое mapStruct на baedulng тут
https://www.baeldung.com/mapstruct
https://www.baeldung.com/mapstruct-custom-mapper
Документация очень хорошо описана с множеством примеров https://mapstruct.org/

Как запустить проект:
1) Здесь используется MySql, поэтому нужно создать базу данных с именем "crudTasks" и в application.properties прописать свои настройки подключения к БД
2) Если вы используете другую БД, то нужно в application.properties прописать свои настройки подключения к БД. Например значения для Postgres:
spring.datasource.url=jdbc:postgresql://localhost:5432/crudTasks
3) В бд, в таблице Role нужно создать две роли: ROLE_USER и ROLE_ADMIN
4) Запустить проект и перейти по ссылке http://localhost:8080/. Должна открыться страница логина, нажмите на ссылку "Register" и зарегистрируйте нового пользователя.