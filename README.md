<div align="center">
  <h1>📒 Rubrica Digitale (Java)</h1>
  <p>
    Un'applicazione Java efficiente per la gestione e l'organizzazione dei contatti personali.
    <br />
    <br />
    <img src="https://img.shields.io/badge/Java-21-orange?style=for-the-badge&logo=openjdk" alt="Java Version">
    <img src="https://img.shields.io/badge/IDE-Eclipse-blue?style=for-the-badge&logo=eclipseide" alt="Eclipse">
    <img src="https://img.shields.io/badge/Test-JUnit_5-25A162?style=for-the-badge&logo=junit5" alt="JUnit">
  </p>
</div>

---

## 🧐 Di cosa si tratta?

Questo progetto implementa una **Rubrica** contatti con dimensione personalizzabile. È progettata per gestire l'archiviazione in memoria di contatti (in formato stringa, es. "Nome = Numero") con controlli sui duplicati e limiti di capienza.

Le funzionalità principali includono:
* **Gestione Duplicati:** Impedisce l'inserimento di contatti già presenti.
* **Ricerca per Prefisso:** Trova rapidamente i contatti che iniziano con una specifica stringa.
* **Pulizia Avanzata:** Permette di eliminare gruppi di contatti tramite ricerca o svuotare l'intera rubrica.

---

## 🛠️ Funzionalità del Codice

Il core del progetto è la classe `Rubrica` (package `rubrica`). Ecco i metodi principali disponibili:

- `aggiungi(String contatto)`: Inserisce un nuovo contatto. Restituisce `1` se aggiunto, `0` se duplicato, `-1` se la rubrica è piena.
- `ricerca(String prefisso)`: Restituisce un `ArrayList` con tutti i contatti che iniziano con il prefisso indicato.
- `elimina(String prefisso)`: Rimuove tutti i contatti che corrispondono al criterio di ricerca. Restituisce `true` se ha eliminato qualcosa.
- `svuota()`: Rimuove istantaneamente tutti i contatti dalla rubrica.
- `numEl()`: Restituisce il numero attuale di contatti presenti.

---

## 🚀 Esempio di Utilizzo

Ecco come utilizzare la classe nel tuo codice:

```java
import rubrica.Rubrica;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // 1. Crea una rubrica chiamata "Amici" con max 10 posti
        Rubrica r = new Rubrica("Amici", 10);

        // 2. Aggiungi contatti
        r.aggiungi("Mario Rossi = 3331234567");
        r.aggiungi("Marco Bianchi = 3339876543");

        // 3. Cerca tutti i contatti che iniziano per "Ma"
        ArrayList<String> risultati = r.ricerca("Ma");
        for(String s : risultati) {
            System.out.println(s); 
        }
        // Output previsto: Mario Rossi..., Marco Bianchi...

        // 4. Elimina tutti i contatti che iniziano per "Marco"
        boolean eliminato = r.elimina("Marco");
        
        // 5. Svuota tutto
        r.svuota();
    }
}
```

---

## 🧪 Testing

Il progetto include una suite di test unitari completa realizzata con **JUnit 5** per garantire l'affidabilità del codice.
Il file `RubricaTest.java` copre i seguenti scenari:

* ✅ Costruttore e inizializzazione corretta.
* ✅ Aggiunta corretta e gestione del limite (`MAX_DIM`).
* ✅ Tentativo di aggiunta di duplicati (non permessi).
* ✅ Ricerca (su rubrica vuota, parziale o piena).
* ✅ Cancellazione (singola, multipla, primo/ultimo elemento).

Per avviare i test, esegui la classe `RubricaTest` come **JUnit Test** dal tuo IDE.

---

## ⚙️ Installazione e Setup

Poiché il progetto è configurato come progetto **Eclipse** (include `.project` e `.classpath`):

1.  Clona questa repository sul tuo computer:
    ```bash
    git clone https://github.com/angie-albi/Rubrica.git   
    ```
2.  Apri **Eclipse**.
3.  Vai su `File` > `Open Projects from File System...`.
4.  Clicca su `Directory` e seleziona la cartella scaricata.
5.  Clicca su `Finish`.

---

### 👤 Autore

Sviluppato da **Angie Albitres**