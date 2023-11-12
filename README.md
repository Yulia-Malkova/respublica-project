<p align="center">
<a href="https://www.respublica.ru/"> <img width=50%" src="media/logo.png"> </a></h1>
<p align="center">

# <p align="center"> Проект по автоматизации тестовых API сценариев для  магазина "Республика" <p align="center">

## ![##46C3D3](https://placehold.co/15x15/46C3D3/46C3D3.png) Использованный стек технологий
<p align="center">
<img width="6%" title="IntelliJ IDEA" src="media/Intelij_IDEA.svg">
<img width="6%" title="Java" src="media/Java.svg">
 <img width="5%" title="Rest Assured" src="media/rest_assured.png">
<img width="6%" title="Allure Report" src="media/Allure_Report.svg">
<img width="5%" title="Allure TestOps" src="media/AllureTestOps.svg">
<img width="6%" title="Gradle" src="media/Gradle.svg">
<img width="6%" title="JUnit5" src="media/JUnit5.svg">
<img width="6%" title="GitHub" src="media/GitHub (1).svg">
<img width="6%" title="Jenkins" src="media/Jenkins.svg">
<img width="6%" title="Telegram" src="media/Telegram (1).svg">
<img width="5%" title="Jira" src="media/Jira.svg">
</p>

- В данном проекте автотесты написаны на языке <code>Java</code> с использованием фреймворков <code>Rest Assured</code> и <code>JUnit 5</code>.
- В качестве сборщика был использован - <code>Gradle</code>.
- Для удаленного запуска реализована джоба в Jenkins с формированием Allure-отчета и отправкой результатов в <code>Telegram</code> при помощи бота.
- Осуществлена интеграция с <code>Allure TestOps </code> и <code>Jira</code>.
  
## ![##46C3D3](https://placehold.co/15x15/46C3D3/46C3D3.png) Реализованные проверки
- Авторизация пользователя с валидными и невалидными данными
- Изменение данных в личном кабинете пользователя
- Получение товаров по разделам каталога
- Поиск товаров
- Добавление товара в корзину
- Удаление товара из корзины

## ![##46C3D3](https://placehold.co/15x15/46C3D3/46C3D3.png) Запуск автотестов

### Запуск тестов из терминала

Команда для запуска всех тестов из терминала:
```
gradle clean test
```

Для запуска можно выбрать один из четырех тест-сьютов:
```
gradle clean
${TEST_JOB}
```

```mermaid
flowchart LR
node1([Test Suites]) --> node2([Запуск тестов, связанных с авторизацией]) --> node3([login])
node1([Test Suites]) --> node4([Запуск тестов, связанных с личным кабинетом]) --> node5([account])
node1([Test Suites]) --> node6([Запуск тестов, связанных с каталогом]) --> node7([catalog])
node1([Test Suites]) --> node8([Запуск тестов, связанных с корзиной]) --> node9([basket])
```

## ![##46C3D3](https://placehold.co/15x15/46C3D3/46C3D3.png) Сборка в [Jenkins](https://jenkins.autotests.cloud/job/021-Yulia_Malkova-respublica_project/)
<p align="center">
<img title="Jenkins Build" src="media/jenkins.png">
</p>

## ![##46C3D3](https://placehold.co/15x15/46C3D3/46C3D3.png) Пример [Allure-отчета](https://jenkins.autotests.cloud/job/021-Yulia_Malkova-respublica_project/allure/)
### Overview

<p align="center">
<img title="Allure Overview" src="media/allure-overview.png">
</p>

### Результат выполнения теста

<p align="center">
<img title="Test Results in Alure" src="media/allure_test_result.png">
</p>

## ![##46C3D3](https://placehold.co/15x15/46C3D3/46C3D3.png) Интеграция с [Allure TestOps](https://allure.autotests.cloud/project/3752/dashboards)

Выполнена интеграция сборки <code>Jenkins</code> с <code>Allure TestOps</code>.
Результат выполнения автотестов отображается в <code>Allure TestOps</code>
На Dashboard в <code>Allure TestOps</code> отображена статистика пройденных тестов.

<p align="center">
<img title="Allure TestOps DashBoard" src="media/allure_test_ops.png">
</p>

## ![##46C3D3](https://placehold.co/15x15/46C3D3/46C3D3.png) Интеграция с [Jira](https://jira.autotests.cloud/browse/HOMEWORK-931)

Реализована интеграция <code>Allure TestOps</code> с <code>Jira</code>, в тикете отображается информация, какие тест-кейсы были написаны в рамках задачи и результат их прогона.

<p align="center">
<img title="Jira Task" src="media/jira_integration.png">
</p>

## ![##46C3D3](https://placehold.co/15x15/46C3D3/46C3D3.png) Уведомления в Telegram с использованием бота

После завершения сборки, бот созданный в <code>Telegram</code>, автоматически обрабатывает и отправляет сообщение с результатом.

<p align="center">
<img width="70%" title="Telegram Notifications" src="media/telegram_bot.png">
</p>

