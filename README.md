# Дипломный проект

---

### Тема

Разработка микросервиса, для объединения данных:
- из сервиса мониторинга сети Zabbix;

    база данных MySQL;
- из сервиса построения и обслуживания сети UserSide;

    база данных MySQL;
- из 1С:Предприятия.

    Предоставляет данные об оборудовании и узлах сети посредством web-сервиса в формате JSON.

Дальнейшая обработка полученных данных, построение цепочек зависимости узлов и предоставление информации через web-сервис в формате JSON. Также, создаваемый web-сервис должен иметь свой небольшой web-интерфейс для отображени обработанных данных.

---

### Технические характеристики

Подразумевается, что микросервис будет работать на отдельном виртуальном хосте, под управлением *Ubuntu Server 20.04*.

Будет предоставлена отдельная, объектно-ориентированная база данных *Neo4j*.

---

### Выбор языка

Реализация проекта будет проводится на языке Java 19 с использование фреймворка Spring Boot.