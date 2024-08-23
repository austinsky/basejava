package com.urise.webapp;

import com.urise.webapp.model.*;

import java.util.*;

public class ResumeTestData {
    public static void main(String[] args) {
        Resume resume = new Resume("Григорий Кислин");

        resume.setContact(ContactType.PHONE, "+7(921) 855-0482");
        resume.setContact(ContactType.SKYPE, "skype:grigory.kislin");
        resume.setContact(ContactType.EMAIL, "gkislin@yandex.ru");
        resume.setContact(ContactType.GITHUB, "https://github.com/gkislin");
        resume.setContact(ContactType.LINKEDIN, "https://www.linkedin.com/in/gkislin");
        resume.setContact(ContactType.STACKOVERFLOW, "https://stackoverflow.com/users/548473/grigory-kislin");
        resume.setContact(ContactType.WEBSITE, "http://gkislin.ru/");

        resume.setSection(SectionType.OBJECTIVE, new TextSection("Ведущий стажировок и корпоративного обучения по Java Web и Enterprise технологиям"));

        resume.setSection(SectionType.PERSONAL, new ListSection("Аналитический склад ума", "сильная логика", "креативность",
                "инициативность", "Пурист кода и архитектуры"));


        resume.setSection(SectionType.ACHIEVEMENT, new ListSection(
                "Организация команды и успешная реализация Java проектов для сторонних заказчиков: приложения автопарк на стеке Spring Cloud/микросервисы, система мониторинга показателей спортсменов на Spring Boot, участие в проекте МЭШ на Play-2, многомодульный Spring Boot + Vaadin проект для комплексных DIY смет",
                "С 2013 года: разработка проектов \"Разработка Web приложения\",\"Java Enterprise\", \"Многомодульный maven. Многопоточность. XML (JAXB/StAX). Веб сервисы (JAX-RS/SOAP). Удаленное взаимодействие (JMS/AKKA)\". Организация онлайн стажировок и ведение проектов. Более 3500 выпускников.",
                "Реализация двухфакторной аутентификации для онлайн платформы управления проектами Wrike. Интеграция с Twilio, DuoSecurity, Google Authenticator, Jira, Zendesk",
                "Налаживание процесса разработки и непрерывной интеграции ERP системы River BPM. Интеграция с 1С, Bonita BPM, CMIS, LDAP. Разработка приложения управления окружением на стеке: Scala/Play/Anorm/JQuery. Разработка SSO аутентификации и авторизации различных ERP модулей, интеграция CIFS/SMB java сервера.",
                "Реализация c нуля Rich Internet Application приложения на стеке технологий JPA, Spring, Spring-MVC, GWT, ExtGWT (GXT), Commet, HTML5, Highstock для алгоритмического трейдинга.",
                "Создание JavaEE фреймворка для отказоустойчивого взаимодействия слабо-связанных сервисов (SOA-base архитектура, JAX-WS, JMS, AS Glassfish). Сбор статистики сервисов и информации о состоянии через систему мониторинга Nagios. Реализация онлайн клиента для администрирования и мониторинга системы по JMX (Jython/ Django).",
                "Реализация протоколов по приему платежей всех основных платежных системы России (Cyberplat, Eport, Chronopay, Сбербанк), Белоруcсии(Erip, Osmp) и Никарагуа."
        ));

        resume.setSection(SectionType.QUALIFICATIONS, new ListSection(
                "JEE AS: GlassFish (v2.1, v3), OC4J, JBoss, Tomcat, Jetty, WebLogic, WSO2",
                "Version control: Subversion, Git, Mercury, ClearCase, Perforce",
                "DB: PostgreSQL(наследование, pgplsql, PL/Python), Redis (Jedis), H2, Oracle, MySQL, SQLite, MS SQL, HSQLDB",
                "Languages: Java, Scala, Python/Jython/PL-Python, JavaScript, Groovy",
                "XML/XSD/XSLT, SQL, C/C++, Unix shell scripts",
                "Java Frameworks: Java 8 (Time API, Streams), Guava, Java Executor, MyBatis, Spring (MVC, Security, Data, Clouds, Boot), JPA (Hibernate, EclipseLink), Guice, GWT(SmartGWT, ExtGWT/GXT), Vaadin, Jasperreports, Apache Commons, Eclipse SWT, JUnit, Selenium (htmlelements).",
                "Python: Django.",
                "JavaScript: jQuery, ExtJS, Bootstrap.js, underscore.js",
                "Scala: SBT, Play2, Specs2, Anorm, Spray, Akka",
                "Технологии: Servlet, JSP/JSTL, JAX-WS, REST, EJB, RMI, JMS, JavaMail, JAXB, StAX, SAX, DOM, XSLT, MDB, JMX, JDBC, JPA, JNDI, JAAS, SOAP, AJAX, Commet, HTML5, ESB, CMIS, BPMN2, LDAP, OAuth1, OAuth2, JWT.",
                "Инструменты: Maven + plugin development, Gradle, настройка Ngnix",
                "администрирование Hudson/Jenkins, Ant + custom task, SoapUI, JPublisher, Flyway, Nagios, iReport, OpenCmis, Bonita, pgBouncer",
                "Отличное знание и опыт применения концепций ООП, SOA, шаблонов проектрирования, архитектурных шаблонов, UML, функционального программирования",
                "Родной русский, английский 'upper intermediate'"
        ));



        resume.setSection(SectionType.EXPERIENCE, new CompanySection(
                Arrays.asList(
                        new Company("Java Online Projects", "javaops.ru", Arrays.asList(
                                new Period(10, 2013, 0, 0,
                                 "Автор проекта.", "Создание, организация и проведение Java онлайн проектов и стажировок."
                                ))),

                        new Company("Wrike", "-", Arrays.asList(
                                new Period(10, 2014, 1, 2016,
                                 "Старший разработчик (backend)",
                                "Проектирование и разработка онлайн платформы управления проектами Wrike (Java 8 API, Maven, Spring, MyBatis, Guava, Vaadin, PostgreSQL, Redis). Двухфакторная аутентификация, авторизация по OAuth1, OAuth2, JWT SSO."
                                ))),

                        new Company("RIT Center", "-", Arrays.asList(
                                new Period(4,2012, 10, 2014,
                                 "Java архитектор",
                                "Организация процесса разработки системы ERP для разных окружений: релизная политика, версионирование, ведение CI (Jenkins), миграция базы (кастомизация Flyway), конфигурирование системы (pgBoucer, Nginx), AAA via SSO. Архитектура БД и серверной части системы. Разработка интергационных сервисов: CMIS, BPMN2, 1C (WebServices), сервисов общего назначения (почта, экспорт в pdf, doc, html). Интеграция Alfresco JLAN для online редактирование из браузера документов MS Office. Maven + plugin development, Ant, Apache Commons, Spring security, Spring MVC, Tomcat,WSO2, xcmis, OpenCmis, Bonita, Python scripting, Unix shell remote scripting via ssh tunnels, PL/Python"
                                ))),

                        new Company("Luxoft (Deutsche Bank)", "-", Arrays.asList(
                                new Period(12, 2010, 4, 2012,
                                 "Ведущий программист",
                                "Участие в проекте Deutsche Bank CRM (WebLogic, Hibernate, Spring, Spring MVC, SmartGWT, GWT, Jasper, Oracle). Реализация клиентской и серверной части CRM. Реализация RIA-приложения для администрирования, мониторинга и анализа результатов в области алгоритмического трейдинга. JPA, Spring, Spring-MVC, GWT, ExtGWT (GXT), Highstock, Commet, HTML5."
                                ))),

                        new Company("Yota", "-", Arrays.asList(
                                new Period(6, 2008, 12, 2010,
                                 "Ведущий специалист",
                                "Дизайн и имплементация Java EE фреймворка для отдела \"Платежные Системы\" (GlassFish v2.1, v3, OC4J, EJB3, JAX-WS RI 2.1, Servlet 2.4, JSP, JMX, JMS, Maven2). Реализация администрирования, статистики и мониторинга фреймворка. Разработка online JMX клиента (Python/ Jython, Django, ExtJS)"
                                ))),

                        new Company("Enkata", "-", Arrays.asList(
                                new Period(3, 2007, 6, 2008,
                                "Разработчик ПО",
                                "Реализация клиентской (Eclipse RCP) и серверной (JBoss 4.2, Hibernate 3.0, Tomcat, JMS) частей кластерного J2EE приложения (OLAP, Data mining)."
                                ))),

                        new Company("Siemens AG", "-", Arrays.asList(
                                new Period(1, 2005, 7, 2007,
                                 "Разработчик ПО",
                                "Разработка информационной модели, проектирование интерфейсов, реализация и отладка ПО на мобильной IN платформе Siemens @vantage (Java, Unix)."
                                ))),

                        new Company("Alcatel", "-", Arrays.asList(
                                new Period(9, 1997, 1, 2005,
                                 "Инженер по аппаратному и программному тестированию",
                                "Тестирование, отладка, внедрение ПО цифровой телефонной станции Alcatel 1000 S12 (CHILL, ASM)."
                                )))
                )));

        resume.setSection(SectionType.EDUCATION, new CompanySection(
                Arrays.asList(
                        new Company("Coursera", "-", Arrays.asList(
                                new Period(3, 2013, 5, 2013,
                                        "'Functional Programming Principles in Scala' by Martin Odersky",
                                        "-")
                        )),

                        new Company("Luxoft", "-", Arrays.asList(
                                new Period(3, 2011, 4, 2011,
                                        "Курс 'Объектно-ориентированный анализ ИС. Концептуальное моделирование на UML.'",
                                        "-")
                        )),

                        new Company("Siemens AG", "-", Arrays.asList(
                                new Period(1, 2005, 4, 2005,
                                        "3 месяца обучения мобильным IN сетям (Берлин)",
                                        "-")
                        )),

                        new Company("Alcatel", "-", Arrays.asList(
                                new Period(9, 1997, 3, 1998,
                                        "6 месяцев обучения цифровым телефонным сетям (Москва)",
                                        "-")
                        )),

                        new Company("Санкт-Петербургский национальный исследовательский университет информационных технологий, механики и оптики", "-", Arrays.asList(
                                new Period(9, 1993, 7, 1996,
                                        "Аспирантура (программист С, С++)",
                                        "-"),
                                new Period(9, 1987, 7, 1994,
                                        "Инженер (программист Fortran, C)",
                                        "-")
                        )),

                        new Company("Заочная физико-техническая школа при МФТИ", "-", Arrays.asList(
                                new Period(9, 1984, 6, 1987,
                                        "Закончил с отличием",
                                        "-")
                        )))));

        printResume(resume);
    }

    public static void printResume(Resume resume) {
        System.out.println("Имя: " + resume.getFullName());
        System.out.println();

        System.out.println("Контакты");
        System.out.println("Телефон: "      + resume.getContacts().get(ContactType.PHONE));
        System.out.println("Skype: "        + resume.getContacts().get(ContactType.SKYPE));
        System.out.println("Email: "        + resume.getContacts().get(ContactType.EMAIL));
        System.out.println("LinkedIn: "     + resume.getContacts().get(ContactType.LINKEDIN));
        System.out.println("GitHub: "       + resume.getContacts().get(ContactType.GITHUB));
        System.out.println("StackOverflow: "+ resume.getContacts().get(ContactType.STACKOVERFLOW));
        System.out.println("WEB SITE:"      + resume.getContacts().get(ContactType.WEBSITE));

        System.out.println();
        System.out.println("Позиция");
        System.out.println(((TextSection)(resume.getSections().get(SectionType.OBJECTIVE))).get());
        System.out.println();

        System.out.println("Личностные качества");
        for (String str : (List<String>)(((ListSection)(resume.getSections().get(SectionType.PERSONAL))).get())) {
            System.out.println(" - " + str);
        }
        System.out.println();
//
        System.out.println("Достижения");
        for (String str : (List<String>)(((ListSection)(resume.getSections().get(SectionType.ACHIEVEMENT))).get())) {
            System.out.println(" - " + str);
        }
        System.out.println();
//
        System.out.println("Квалификация");
        for (String str : (List<String>)(((ListSection)(resume.getSections().get(SectionType.QUALIFICATIONS))).get())) {
            System.out.println(" - " + str);
        }
        System.out.println();


        System.out.println("Опыт работы");
        printCompany((CompanySection)(resume.getSections().get(SectionType.EXPERIENCE)), true);
        System.out.println();

        System.out.println("Образование");
        printCompany((CompanySection)(resume.getSections().get(SectionType.EDUCATION)), false);
        System.out.println();
    }

    public static void printCompany(CompanySection companySection, boolean isPrintDescription) {
        for (Company company : companySection.get()) {

            System.out.println(company.getName());
            for (Period period : company.getPeriods()) {
                String startDate;
                String endDate;
                String itogDate;

                startDate = period.getBeginMonth() + "/" + period.getBeginYear();
                if (period.getEndMonth() == 1 && period.getEndYear() == 0) {
                    endDate = "Настоящее время";
                }  else {
                    endDate = period.getEndMonth() + "/" + period.getEndYear();
                }
                itogDate = startDate + " - " + endDate;

                if (!itogDate.isEmpty()) {
                    System.out.println(itogDate + "       " + period.getTitle());
                    if (isPrintDescription) System.out.println("       " + period.getDescription());
                }
            }

            System.out.println();
        }
    }

    public static Resume createResume(String uuid, String fullName, String phone, String skype,
                                      String email, String github, String linkedin, String stackoverflow,
                                      String website, String objective) {
        Resume resume = new Resume(uuid, fullName);
        resume.setContact(ContactType.PHONE, phone);
        resume.setContact(ContactType.SKYPE, skype);
        resume.setContact(ContactType.EMAIL, email);
        resume.setContact(ContactType.GITHUB, github);
        resume.setContact(ContactType.LINKEDIN, linkedin);
        resume.setContact(ContactType.STACKOVERFLOW, stackoverflow);
        resume.setContact(ContactType.WEBSITE, website);

        resume.setSection(SectionType.OBJECTIVE, new TextSection(objective));

        resume.setSection(SectionType.PERSONAL, new ListSection("Аналитический склад ума", "сильная логика", "креативность",
                "инициативность", "Пурист кода и архитектуры"));

        resume.setSection(SectionType.ACHIEVEMENT, new ListSection(
                "Организация команды и успешная реализация Java проектов для сторонних заказчиков: приложения автопарк на стеке Spring Cloud/микросервисы, система мониторинга показателей спортсменов на Spring Boot, участие в проекте МЭШ на Play-2, многомодульный Spring Boot + Vaadin проект для комплексных DIY смет",
                "С 2013 года: разработка проектов \"Разработка Web приложения\",\"Java Enterprise\", \"Многомодульный maven. Многопоточность. XML (JAXB/StAX). Веб сервисы (JAX-RS/SOAP). Удаленное взаимодействие (JMS/AKKA)\". Организация онлайн стажировок и ведение проектов. Более 3500 выпускников.",
                "Реализация двухфакторной аутентификации для онлайн платформы управления проектами Wrike. Интеграция с Twilio, DuoSecurity, Google Authenticator, Jira, Zendesk",
                "Налаживание процесса разработки и непрерывной интеграции ERP системы River BPM. Интеграция с 1С, Bonita BPM, CMIS, LDAP. Разработка приложения управления окружением на стеке: Scala/Play/Anorm/JQuery. Разработка SSO аутентификации и авторизации различных ERP модулей, интеграция CIFS/SMB java сервера.",
                "Реализация c нуля Rich Internet Application приложения на стеке технологий JPA, Spring, Spring-MVC, GWT, ExtGWT (GXT), Commet, HTML5, Highstock для алгоритмического трейдинга.",
                "Создание JavaEE фреймворка для отказоустойчивого взаимодействия слабо-связанных сервисов (SOA-base архитектура, JAX-WS, JMS, AS Glassfish). Сбор статистики сервисов и информации о состоянии через систему мониторинга Nagios. Реализация онлайн клиента для администрирования и мониторинга системы по JMX (Jython/ Django).",
                "Реализация протоколов по приему платежей всех основных платежных системы России (Cyberplat, Eport, Chronopay, Сбербанк), Белоруcсии(Erip, Osmp) и Никарагуа."
        ));

        resume.setSection(SectionType.QUALIFICATIONS, new ListSection(
                "JEE AS: GlassFish (v2.1, v3), OC4J, JBoss, Tomcat, Jetty, WebLogic, WSO2",
                "Version control: Subversion, Git, Mercury, ClearCase, Perforce",
                "DB: PostgreSQL(наследование, pgplsql, PL/Python), Redis (Jedis), H2, Oracle, MySQL, SQLite, MS SQL, HSQLDB",
                "Languages: Java, Scala, Python/Jython/PL-Python, JavaScript, Groovy",
                "XML/XSD/XSLT, SQL, C/C++, Unix shell scripts",
                "Java Frameworks: Java 8 (Time API, Streams), Guava, Java Executor, MyBatis, Spring (MVC, Security, Data, Clouds, Boot), JPA (Hibernate, EclipseLink), Guice, GWT(SmartGWT, ExtGWT/GXT), Vaadin, Jasperreports, Apache Commons, Eclipse SWT, JUnit, Selenium (htmlelements).",
                "Python: Django.",
                "JavaScript: jQuery, ExtJS, Bootstrap.js, underscore.js",
                "Scala: SBT, Play2, Specs2, Anorm, Spray, Akka",
                "Технологии: Servlet, JSP/JSTL, JAX-WS, REST, EJB, RMI, JMS, JavaMail, JAXB, StAX, SAX, DOM, XSLT, MDB, JMX, JDBC, JPA, JNDI, JAAS, SOAP, AJAX, Commet, HTML5, ESB, CMIS, BPMN2, LDAP, OAuth1, OAuth2, JWT.",
                "Инструменты: Maven + plugin development, Gradle, настройка Ngnix",
                "администрирование Hudson/Jenkins, Ant + custom task, SoapUI, JPublisher, Flyway, Nagios, iReport, OpenCmis, Bonita, pgBouncer",
                "Отличное знание и опыт применения концепций ООП, SOA, шаблонов проектрирования, архитектурных шаблонов, UML, функционального программирования",
                "Родной русский, английский 'upper intermediate'"
        ));



        resume.setSection(SectionType.EXPERIENCE, new CompanySection(
                Arrays.asList(
                        new Company("Java Online Projects", "javaops.ru", Arrays.asList(
                                new Period(10, 2013, 0, 0,
                                        "Автор проекта.", "Создание, организация и проведение Java онлайн проектов и стажировок."
                                ))),

                        new Company("Wrike", "-", Arrays.asList(
                                new Period(10, 2014, 1, 2016,
                                        "Старший разработчик (backend)",
                                        "Проектирование и разработка онлайн платформы управления проектами Wrike (Java 8 API, Maven, Spring, MyBatis, Guava, Vaadin, PostgreSQL, Redis). Двухфакторная аутентификация, авторизация по OAuth1, OAuth2, JWT SSO."
                                ))),

                        new Company("RIT Center", "-", Arrays.asList(
                                new Period(4,2012, 10, 2014,
                                        "Java архитектор",
                                        "Организация процесса разработки системы ERP для разных окружений: релизная политика, версионирование, ведение CI (Jenkins), миграция базы (кастомизация Flyway), конфигурирование системы (pgBoucer, Nginx), AAA via SSO. Архитектура БД и серверной части системы. Разработка интергационных сервисов: CMIS, BPMN2, 1C (WebServices), сервисов общего назначения (почта, экспорт в pdf, doc, html). Интеграция Alfresco JLAN для online редактирование из браузера документов MS Office. Maven + plugin development, Ant, Apache Commons, Spring security, Spring MVC, Tomcat,WSO2, xcmis, OpenCmis, Bonita, Python scripting, Unix shell remote scripting via ssh tunnels, PL/Python"
                                ))),

                        new Company("Luxoft (Deutsche Bank)", "-", Arrays.asList(
                                new Period(12, 2010, 4, 2012,
                                        "Ведущий программист",
                                        "Участие в проекте Deutsche Bank CRM (WebLogic, Hibernate, Spring, Spring MVC, SmartGWT, GWT, Jasper, Oracle). Реализация клиентской и серверной части CRM. Реализация RIA-приложения для администрирования, мониторинга и анализа результатов в области алгоритмического трейдинга. JPA, Spring, Spring-MVC, GWT, ExtGWT (GXT), Highstock, Commet, HTML5."
                                ))),

                        new Company("Yota", "-", Arrays.asList(
                                new Period(6, 2008, 12, 2010,
                                        "Ведущий специалист",
                                        "Дизайн и имплементация Java EE фреймворка для отдела \"Платежные Системы\" (GlassFish v2.1, v3, OC4J, EJB3, JAX-WS RI 2.1, Servlet 2.4, JSP, JMX, JMS, Maven2). Реализация администрирования, статистики и мониторинга фреймворка. Разработка online JMX клиента (Python/ Jython, Django, ExtJS)"
                                ))),

                        new Company("Enkata", "-", Arrays.asList(
                                new Period(3, 2007, 6, 2008,
                                        "Разработчик ПО",
                                        "Реализация клиентской (Eclipse RCP) и серверной (JBoss 4.2, Hibernate 3.0, Tomcat, JMS) частей кластерного J2EE приложения (OLAP, Data mining)."
                                ))),

                        new Company("Siemens AG", "-", Arrays.asList(
                                new Period(1, 2005, 7, 2007,
                                        "Разработчик ПО",
                                        "Разработка информационной модели, проектирование интерфейсов, реализация и отладка ПО на мобильной IN платформе Siemens @vantage (Java, Unix)."
                                ))),

                        new Company("Alcatel", "-", Arrays.asList(
                                new Period(9, 1997, 1, 2005,
                                        "Инженер по аппаратному и программному тестированию",
                                        "Тестирование, отладка, внедрение ПО цифровой телефонной станции Alcatel 1000 S12 (CHILL, ASM)."
                                )))
                )));

        resume.setSection(SectionType.EDUCATION, new CompanySection(
                Arrays.asList(
                        new Company("Coursera", "-", Arrays.asList(
                                new Period(3, 2013, 5, 2013,
                                        "'Functional Programming Principles in Scala' by Martin Odersky",
                                        "-")
                        )),

                        new Company("Luxoft", "-", Arrays.asList(
                                new Period(3, 2011, 4, 2011,
                                        "Курс 'Объектно-ориентированный анализ ИС. Концептуальное моделирование на UML.'",
                                        "-")
                        )),

                        new Company("Siemens AG", "-", Arrays.asList(
                                new Period(1, 2005, 4, 2005,
                                        "3 месяца обучения мобильным IN сетям (Берлин)",
                                        "-")
                        )),

                        new Company("Alcatel", "-", Arrays.asList(
                                new Period(9, 1997, 3, 1998,
                                        "6 месяцев обучения цифровым телефонным сетям (Москва)",
                                        "-")
                        )),

                        new Company("Санкт-Петербургский национальный исследовательский университет информационных технологий, механики и оптики", "-", Arrays.asList(
                                new Period(9, 1993, 7, 1996,
                                        "Аспирантура (программист С, С++)",
                                        "-"),
                                new Period(9, 1987, 7, 1994,
                                        "Инженер (программист Fortran, C)",
                                        "-")
                        )),

                        new Company("Заочная физико-техническая школа при МФТИ", "-", Arrays.asList(
                                new Period(9, 1984, 6, 1987,
                                        "Закончил с отличием",
                                        "-")
                        )))));


        return resume;
    }
}
