<p align="center">
<a href="https://www.respublica.ru/"> <img width=50%" src="media/logo.png"> </a></h1>
<p align="center">

# <p align="center"> Проект по автоматизации тестовых API сценариев для  магазина Respublica <p align="center">

## ![##46C3D3](https://placehold.co/15x15/46C3D3/46C3D3.png) Использованный стек технологий
<p align="center">
<img width="6%" title="IntelliJ IDEA" src="media/Intelij_IDEA.svg">
<img width="6%" title="Java" src="media/Java.svg">
<img width="6%" title="Selenide" src="media/Selenide.svg">
<img width="6%" title="Selenoid" src="media/Selenoid.svg">
<img width="6%" title="Allure Report" src="media/Allure_Report.svg">
<img width="5%" title="Allure TestOps" src="media/AllureTestOps.svg">
<img width="6%" title="Gradle" src="media/Gradle.svg">
<img width="6%" title="JUnit5" src="media/JUnit5.svg">
<img width="6%" title="GitHub" src="media/GitHub.svg">
<img width="6%" title="Jenkins" src="media/Jenkins.svg">
<img width="6%" title="Telegram" src="media/Telegram.svg">
<img width="5%" title="Jira" src="media/Jira.svg">
</p>

- В данном проекте автотесты написаны на языке <code>Java</code> с использованием фреймворка для тестирования Selenide.
- В качестве сборщика был использован - <code>Gradle</code>.
- Использованы фреймворки <code>JUnit 5</code> и [Selenide](https://selenide.org/).
- При прогоне тестов браузер запускается в [Selenoid](https://aerokube.com/selenoid/).
- Для удаленного запуска реализована джоба в Jenkins с формированием Allure-отчета и отправкой результатов в <code>Telegram</code> при помощи бота.
- Осуществлена интеграция с <code>Allure TestOps </code> и <code>Jira</code>.

Содержание Allure-отчета:
* Шаги теста;
* Скриншот страницы на последнем шаге;
* Page Source;
* Логи браузерной консоли;
* Видео выполнения автотеста.

## ![##46C3D3](https://placehold.co/15x15/46C3D3/46C3D3.png) Запуск автотестов

### Запуск тестов из терминала

Команда для запуска всех тестов из терминала:
```
gradle clean test
```
При выполнении команды тесты запустятся удаленно в <code>Selenoid</code>.

Для запуска можно выбрать один из трех тест-сьютов:

```mermaid
flowchart LR
node1([Test Suites]) --> node2([Запуск всех тестов]) --> node3([test])
node1([Test Suites]) --> node4([Запуск тестов, связанных с корзиной]) --> node5([basket])
node1([Test Suites]) --> node6([Запуск тестов, связанных с каталогом]) --> node7([catalog])
```
При необходимости также можно переопределить параметры запуска

```
gradle clean
${TEST_JOB}
-Dbrowser=${BROWSER}
-Dversion=${BROWSER_VERSION}
 -DbrowserSize=${BROWSER_SIZE}
 -DwebDriver=${WEB_DRIVER}
```
### Параметры сборки

* <code>TEST_JOB</code> – тестовый сьют.
* <code>BROWSER_NAME</code> – браузер, в котором будут выполняться тесты. По умолчанию - <code>chrome</code>.
* <code>BROWSER_VERSION</code> – версия браузера, в которой будут выполняться тесты. По умолчанию - <code>100.0</code>.
* <code>BROWSER_SIZE</code> – размер окна браузера, в котором будут выполняться тесты. По умолчанию - <code>1920x1080</code>.
* <code>WEB_DRIVER</code> – адрес удаленного сервера, на котором будут запускаться тесты.

## ![##46C3D3](https://placehold.co/15x15/46C3D3/46C3D3.png) Сборка в [Jenkins](https://jenkins.autotests.cloud/job/021-Yulia_Malkova-WB_project/)
<p align="center">
<img title="Jenkins Build" src="media/ jenkins.png">
</p>

## ![##46C3D3](https://placehold.co/15x15/46C3D3/46C3D3.png) Пример [Allure-отчета](https://jenkins.autotests.cloud/job/021-Yulia_Malkova-WB_project/13/allure/)
### Overview

<p align="center">
<img title="Allure Overview" src="media/allure-overview.png">
</p>

### Результат выполнения теста

<p align="center">
<img title="Test Results in Alure" src="media/allure_test_result.png">
</p>

## ![##46C3D3](https://placehold.co/15x15/46C3D3/46C3D3.png) Интеграция с [Allure TestOps](https://allure.autotests.cloud/project/3682/dashboards)

Выполнена интеграция сборки <code>Jenkins</code> с <code>Allure TestOps</code>.
Результат выполнения автотестов отображается в <code>Allure TestOps</code>
На Dashboard в <code>Allure TestOps</code> отображена статистика пройденных тестов.

<p align="center">
<img title="Allure TestOps DashBoard" src="media/allure_test_ops.png">
</p>

## ![##46C3D3](https://placehold.co/15x15/46C3D3/46C3D3.png) Интеграция с [Jira](https://jira.autotests.cloud/browse/HOMEWORK-893)

Реализована интеграция <code>Allure TestOps</code> с <code>Jira</code>, в тикете отображается информация, какие тест-кейсы были написаны в рамках задачи и результат их прогона.

<p align="center">
<img title="Jira Task" src="media/jira_integration.png">
</p>

## ![##46C3D3](https://placehold.co/15x15/46C3D3/46C3D3.png) Уведомления в Telegram с использованием бота

После завершения сборки, бот созданный в <code>Telegram</code>, автоматически обрабатывает и отправляет сообщение с результатом.

<p align="center">
<img width="70%" title="Telegram Notifications" src="media/telegram_bot.png">
</p>

