## Erstellung der Repository-Schicht
- Um Datenbanktabellen für eine Klasse wie `Product` zu erstellen, die die Variablen der Klasse als Spalten und Daten als Zeilen enthält, sind Codeänderungen erforderlich.
- Die **Repository-Schicht** ist für die Arbeit mit Daten verantwortlich, nicht die Service-Schicht.
- Eine neue `repository`-Paket wird erstellt, um alle Repository-Klassen und -Interfaces zu enthalten.
- Für das Repository wird ein **Interface** (z.B. `ProductRepo`) anstelle einer Klasse erstellt, da Spring Data JPA die Implementierung der Methoden übernimmt.
- Das Interface wird mit `@Repository` annotiert, um zusätzliche Funktionen zu erhalten.

## Nutzung von JpaRepository
- Um Spring Data JPA die volle Kontrolle zu überlassen, muss das Repository-Interface `JpaRepository` erweitern.
- Beim Erweitern von `JpaRepository` müssen zwei Typen angegeben werden: der **Klassenname** (z.B. `Product`) und der **Primärschlüsseltyp** (z.B. `Integer`).
- `JpaRepository` stellt automatisch eine Vielzahl von Methoden für Datenbankoperationen bereit, ohne dass diese manuell im Interface deklariert werden müssen.

Hier ist eine Mindmap zur Hierarchie von JpaRepository:



## Integration in die Service-Schicht
- Im Service wird eine Referenzvariable des Repository-Interfaces (z.B. `ProductRepo`) erstellt und mit `@Autowired` annotiert, damit Spring das Objekt instanziiert.
- Spring Data JPA ist dafür verantwortlich, eine Klasse für das Interface zu erstellen und deren Objekte zu verwalten.
- Standard-CRUD-Operationen können direkt über die Repository-Referenz aufgerufen werden:
    - Produkte abrufen: `repo.findAll()` gibt eine Liste von Produkten zurück.
    - Produkt nach ID finden: `repo.findById(ID).orElse(new Product())` gibt ein optionales Objekt zurück.
    - Produkt hinzufügen/speichern: `repo.save(product)` wird sowohl zum Hinzufügen neuer Produkte als auch zum Aktualisieren bestehender Produkte verwendet.
    - Produkt löschen: `repo.deleteById(ID)` löscht ein Produkt anhand seiner ID.

Hier ist eine Tabelle, die die CRUD-Operationen zusammenfasst:
| Operation | JpaRepository Methode | Beschreibung |
|:-------- |:-------------------- |:----------- |
| **Abrufen (Alle)** | `findAll()` | Ruft alle Entitäten ab.    |
| **Abrufen (Einzeln)** | `findById()` | Ruft eine Entität anhand ihrer ID ab.    |
| **Hinzufügen/Aktualisieren** | `save()` | Speichert eine Entität; aktualisiert, wenn sie existiert, erstellt neu, wenn nicht.    |
| **Löschen** | `deleteById()` | Löscht eine Entität anhand ihrer ID.    |


## Wichtige Annotationen für Entitäten
- Eine Klasse, für die eine Datenbanktabelle erstellt werden soll, muss mit `@Entity` annotiert werden.
- Jede Entitätstabelle benötigt einen Primärschlüssel, der in der Klasse mit `@Id` annotiert werden muss (z.B. für `prodId`).

## Datenbankinteraktion und Fehlerbehebung
- Nach dem Hinzufügen von `@Entity` und `@Id` wird beim Neustart der Anwendung die entsprechende Produkttabelle in der H2-Konsole erstellt.
- Daten können über Postman hinzugefügt und abgerufen werden, und die Änderungen werden in der H2-Datenbank persistiert.
- Spring Data JPA generiert die SQL-Abfragen (z.B. `SELECT`, `INSERT`) automatisch im Hintergrund, ohne dass manueller Code geschrieben werden muss.

Hier ist ein Flussdiagramm für den Datenbankinteraktionsprozess:



## Konfiguration und Überwachung
- Um die von Spring Data JPA generierten SQL-Abfragen in der Konsole anzuzeigen, kann die Eigenschaft `spring.jpa.show-sql=true` in der `application.properties` Datei hinzugefügt werden.
- Die Standard-Anmeldeinformationen für die H2-Konsole können in der `application.properties` geändert werden, indem `spring.datasource.username` und `spring.datasource.password` festgelegt werden.
  > **💡 Hinweis:** Jedes Mal, wenn die Anwendung neu gestartet wird, gehen die Daten in einer In-Memory-Datenbank wie H2 verloren, es sei denn, sie ist persistent konfiguriert.