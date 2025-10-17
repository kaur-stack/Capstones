# 🪙 PennyPilot - Accounting Ledger

---

Welcome to PennyPilot! 

A Java command-line accounting ledger to track your finance using a CSV ledger.

---
## 📚 Table of Contents

- [💡 About the Project](#-about-the-project)
- [⚡ Features](#-features)
- [🚀 Getting Started](#-getting-started)
- [📂 Project Structure](#-project-structure)
- [🖼️ Images](#-images)
- [✍️ Author](#-author)
- [🔗 References](#-references)

--- 

## 💡 About the Project

PennyPilot helps users manage personal or small business finances by tracking:

- 💰 Deposits
- 🏦 Payments / Debits
- 📊 Ledger reports by date or vendor

All within a **console-based Java application** with a fun, intuitive interface.

---

## ⚡ Features

- 💰 **Add Deposits**
- 🏦 **Make Payments / Debits**
- 📒 **View Ledger**:
    - All transactions (newest first)
    - Deposits only
    - Payments only
- 📊 **Generate Reports**:
    - Month-to-Date
    - Previous Month
    - Year-to-Date
    - Previous Year
    - Search by Vendor

---

## 🖥️ How to Run

1. Clone the repository:
    ```bash
    git clone <https://github.com/kaur-stack/Capstones>
    ```
2. Open the project in **IntelliJ IDEA**.
3. Make sure your **transactions.csv** file exists in the root project directory.
4. Run the `PennyPilot` class:
    ```bash
    java com.pluralsight.AccountingLedgerCapstone.PennyPilot
    ```

---

## 📂 Project Structure
```
PennyPilot/
│
├── src/
│   └── main/
│       └── java/
│           └── com/
│               └── pluralsight/
│                   └── AccountingLedgerCapstone/
│                       ├── PennyPilot.java              # Main application entry point
│                       ├── LedgerScreen.java            # Ledger display logic
│                       ├── ReportScreen.java            # Report generation logic
│                       ├── Transaction.java             # Transaction model
│                       ├── TransactionFileManager.java  # CSV file operations
│                       └── AppScreens.java              # Screen navigation utilities
│
├── resources/
│   └── transactions.csv    # Transaction data storage
│
├── .gitignore
├── README.md
└── pom.xml                 # Maven configuration

---
```

## 🖼️ Images
### Welcome interface
![Screenshot 2025-10-17 at 8.39.32 AM.png](Assets/Screenshot%202025-10-17%20at%208.39.32%E2%80%AFAM.png)
### Main Menu
![Screenshot 2025-10-17 at 8.39.24 AM.png](Assets/Screenshot%202025-10-17%20at%208.39.24%E2%80%AFAM.png)

### Outcomes
💻 All Transactions Report
This screen displays all recorded transactions in the account ledger, showing deposits and payments in chronological order (newest first). 
![Screenshot 2025-10-17 at 8.37.30 AM.png](Assets/Screenshot%202025-10-17%20at%208.37.30%E2%80%AFAM.png)

💰 Deposit Menu
This screen allows the user to add a new deposit (credit) to the account ledger.
Users enter details such as the date, time, description, vendor/source, and deposit amount.
![Screenshot 2025-10-17 at 8.37.57 AM.png](Assets/Screenshot%202025-10-17%20at%208.37.57%E2%80%AFAM.png)

💳 Payments View
This screen displays the payment transactions recorded in the system, including date, time, description, vendor, and amount.
It lists all outgoing payments (debits) made by the user.
![Screenshot 2025-10-17 at 8.38.09 AM.png](Assets/Screenshot%202025-10-17%20at%208.38.09%E2%80%AFAM.png)
---

## ✍️ Author

- **Name:** Supreet Kaur
- **Email:** skaur@my.yearupunited.org
- **GitHub:** [GitHub](https://github.com/kaur-stack)
- **LinkedIn:** [Linkedin](https://www.linkedin.com/in/supreet-kaur-892953326/)

---

## 📚 References
Van Puttanesca, M. (2025, October). Java In-Class [Workshop review]. LTCA Year Up United.  

OpenAI. (2025). ChatGPT (GPT-5) [Large language model](https://chatgpt.com).