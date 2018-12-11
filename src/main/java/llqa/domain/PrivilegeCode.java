package llqa.domain;

/*
   This enum correlates with the table privileges. This means any changes in table privileges
   has to be applied to this enum.
 */
public enum PrivilegeCode {
   CHGCOD, // Darf den Codewert beim Aendern verschiedener Objekte editieren (erweiterndes Privileg)
   CRTALL, // Darf neue Objekte jeden Typs erstellen (Privilegiensammlung)
   CRTMOD, // Darf neue Modelle erstellen
   CRTPSM, // Darf neue Prozeduren erstellen
   CRTTOL, // Darf neue Werkzeuge unter existierenden Werkzeugtypen eintragen
   CRTTTY, // Darf neue Werkzeugtypen erstellen
   CRTUNT, // Darf neue Einheiten erstellen
   DELALL, // Darf Objekte aller Typen löschen oder deaktivieren (Privilegiensammlung)
   DELCHK, // Darf Prüfungen loeschen
   DELMOD, // Darf Modelle löschen oder deaktivieren
   DELPRC, // Dark Prozeduren löschen oder deaktivieren
   DELTOL, // Darf Werkzeuge löschen oder deaktivieren
   DELTTY, // Darf Werkzeugtypen löschen oder deaktivieren
   DELUNT, // Darf Einheiten löschen oder deaktivieren
   EDTALL, // Darf alle existierenden Objekte editieren (Privilegiensammlung)
   EDTMOD, // Darf existierende Modelle editieren
   EDTPSM, // Darf existierende Prozeduren, einschliesslich deren Schritte und Messungen editieren (Schritte und Messungen dürfen auch gelöscht werden)
   EDTTTY, // Darf existierende Werkzeugtypen editieren
   EDTUNT, // Darf existierende Einheiten editieren
   FINALZ, // Darf die aktuellen Versionen der Objekte finalisieren (nur verfügbar, wenn auch das Editierrecht für das Objekt besessen ist; erweiterndes Privileg)
   FINALL, //
   GLSRCH, // Der Benutzer darf die globale Suche verwenden.
   GRPCRT, // Darf Gruppen erstellen und editieren
   GRTPRA, // Darf alle verfügbaren Privilegien an andere Benutzer vergeben
   GRTPRO, // Darf selbst besessene Privilegien an andere Benutzer vergeben
   GRTTOG, // Darf Privilegien auch an Gruppen vergeben (erweiterndes Privileg)
   MNGALL, // Darf alle Bearbeitungsansichten aufrufen (Privilegiensammlung)
   MNGCFE, // Der Benutzer darf Konfigurationen auf Prüfungen vornehmen
   MNGCFG, // Der Benutzer darf Konfigurationstabellen einsehen und bearbeiten
   MNGMUC, // Darf die Bearbeitungsansicht für Modelle, Einheiten und Prüfungen aufrufen
   MNGNTC, // Der Benutzer darf Fehlerberichte einsehen und bearbeiten
   MNGPAR, // Darf die Bearbeitungsansicht für Parameter, Gerätetypen und Prüfungsarten aufrufen, sowie die optionalen Einstellungen bearbeiten
   MNGPSM, // Darf die Bearbeitungsansicht für Prozeduren, sowie Schritte und Messungen aufrufen
   MNGTOL, // Darf die Bearbeitungsansicht für Werkzeugtypen aufrufen
   MNGUSR, // Darf die Benutzermanagementansicht aufrufen
   MODVRS, // Darf eine finalisierte Version eines Objektes verändern (nur Rechtschreibfehler)
   TKOVER, // Der Benutzer kann bei Eignung Aufgaben übernehmen, für die sich andere Benutzer bereits registriert haben
   TRUSER, // Der Benutzer ist in dem System erfahren und darf zusätzlich einige beschleunigende Funktionen verwenden
   USRMGA, // Darf alle Benutzer bearbeiten (hinzufügen, ändern, deaktivieren)
   USRMGO, // Darf Benutzer niedrigerer Stufen bearbeiten (hinzufügen, ändern, deaktivieren)
   WFLMNG, // Darf Prüfungen und Prüfungsabläufe verwalten, Prüfungen kommentieren und erweiterte Informationen einsehen
   WFLREG, // Darf sich an verfügbare und passende Arbeitsabläufe anmelden, bzw. von selbst-registrierten Arbeitsabläufen abmelden
   WFLALL,
   CRTCHK  // Darf neue Prüfungen einrichten oder Prüfungen löschen, die noch nicht gestartet sind
}