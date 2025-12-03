<div align="center">
  <h1>📒 Gestore Rubriche Digitali</h1>
  <p>
    Un'applicazione Java completa con interfaccia grafica (GUI) per la gestione organizzata di rubriche e contatti multipli.
    <br />
    <br />
    <img src="https://img.shields.io/badge/Java-21-orange?style=for-the-badge&logo=openjdk" alt="Java Version">
    <img src="https://img.shields.io/badge/GUI-Swing-red?style=for-the-badge&logo=java" alt="Swing">
    <img src="https://img.shields.io/badge/Architecture-MVC-blueviolet?style=for-the-badge" alt="MVC Pattern">
    <img src="https://img.shields.io/badge/Test-JUnit_5-25A162?style=for-the-badge&logo=junit5" alt="JUnit">
  </p>
</div>

---

## 🧐 Di cosa si tratta?

Questo progetto è un'evoluzione della classica rubrica telefonica. Non si limita a salvare contatti, ma permette di gestire **intere collezioni di rubriche** (es. "Lavoro", "Amici", "Famiglia") tramite un'interfaccia grafica intuitiva basata su **Java Swing**.

Il software è progettato seguendo il pattern architetturale **MVC (Model-View-Controller)**, garantendo una netta separazione tra la logica dei dati, la visualizzazione e la gestione degli eventi.

---

## ✨ Funzionalità Principali

### 📂 Gestione Rubriche (Manager)
* **Multi-Rubrica:** Crea, rinomina ed elimina intere rubriche.
* **Capienza Personalizzata:** Definisci un limite massimo di contatti per ogni rubrica alla creazione.
* **Persistenza in Memoria:** I dati vengono gestiti dinamicamente durante l'esecuzione.

### 👤 Gestione Contatti
* **CRUD Completo:**
    * **C**reate: Aggiungi nuovi contatti (Nome e Numero).
    * **R**ead: Visualizza la lista e cerca contatti per nome.
    * **U**pdate: Modifica nome e numero di contatti esistenti.
    * **D**elete: Rimuovi contatti specifici.
* **Integrità dei Dati:** Controllo automatico dei duplicati e validazione degli input.

---

## 🏗️ Architettura del Progetto (MVC)

Il codice è organizzato in tre package principali per favorire la manutenibilità:

1.  **`modello`**: Contiene la logica di business.
    * `Contatto`: Oggetto che rappresenta il singolo dato (Nome, Numero).
    * `Rubrica`: Gestisce una lista di contatti e i limiti di capienza.
    * `GestoreRubriche`: Il punto di ingresso principale che amministra la collezione di rubriche.
2.  **`GUI.vista`**: Gestisce l'interfaccia utente.
    * Pannelli modulari (`ContentPanel`, `OpsPanel`, `ListaRubrichePanel`) per costruire la finestra.
    * Finestre di dialogo (`DialogoContatto`) per l'input utente.
3.  **`GUI.controllo`**: Gestisce l'interazione tra utente e sistema.
    * Ascolta i click sui bottoni e invoca i metodi del Modello, aggiornando di conseguenza la Vista.

---

## 🚀 Esempio di Utilizzo

L'applicazione si avvia tramite la classe `Main`, che inizializza il gestore e lancia l'interfaccia grafica.

```java
import GUI.GestoreGUI;
import modello.GestoreRubriche;

public class Main {
    public static void main(String[] args) {
        // 1. Inizializzazione del gestore (Backend)
        GestoreRubriche gestore = new GestoreRubriche();

        // 2. Creazione dati di esempio
        gestore.createRubrica("Amici", 10);
        gestore.createRubrica("Lavoro", 50);

        // 3. Avvio dell'Interfaccia Grafica (Frontend)
        // È buona norma avviare Swing nell'Event Dispatch Thread
        javax.swing.SwingUtilities.invokeLater(() -> 
            new GestoreGUI(gestore)
        );
    }
}
```

---

## 🧪 Testing e Qualità

La stabilità del progetto è garantita da una suite di test unitari sviluppata con **JUnit 5**.
I test coprono:

* ✅ **Logica Rubrica:** Aggiunta, limiti di dimensione (`MAX_DIM`), gestione duplicati.
* ✅ **Ricerca e Cancellazione:** Test su casi limite (rubrica vuota, piena, eliminazione parziale).
* ✅ **Integrità Dati:** Verifica della corretta modifica dei contatti.
* ✅ **Gestore:** Test sulla creazione e rinomina delle rubriche.

Per eseguire i test: Tasto destro sulla cartella `src/modello/test` > `Run As` > `JUnit Test`.

---

## ⚙️ Installazione e Setup

Il progetto è configurato per **Eclipse**, ma è compatibile con qualsiasi IDE Java.

1.  **Clona la repository:**
    ```bash
    git clone [https://github.com/angie-albi/Rubrica.git](https://github.com/angie-albi/Rubrica.git)
    ```
2.  **Importa in Eclipse:**
    * `File` > `Open Projects from File System...`
    * Seleziona la cartella scaricata.
    * Clicca su `Finish`.
3.  **Esegui:**
    * Apri `src/Main.java`.
    * Premi `Run`.

---

### 👤 Autore

Sviluppato da **Angie Albitres**
