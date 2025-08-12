# 🍔 JavaFX Food Ordering System

An interactive food ordering simulation built with Java and JavaFX. Select items, build combos, and manage past orders through a sleek multi-tabbed GUI.

---

## 📌 Overview

This project presents a menu-based ordering system with combo logic, cart tracking, and post-order archive capabilities.

- Choose from burgers, sandwiches, beverages, and sides
- Automatically apply combo pricing for eligible items
- View current selections in a live cart
- Track and manage placed orders (keep, delete, export)
- Built with JavaFX, supporting GUI design via FXML and Scene Builder

---

## 🧾 Features

### 🧪 Menu

Users are greeted with a simple main screen that offers:
- 🍔 **Burger**
- 🥪 **Sandwich**
- 🥤 **Beverage**
- 🍟 **Side**

### 🧃 Combo Deals

- When selecting a **burger or sandwich**, users can opt for a **combo**
- Combos automatically include:
  - One beverage
  - One side
- ✅ Combos are offered at a discounted price compared to separate items

---

### 🛒 Cart Functionality

- A **Cart button** in the top right opens the **Current Order** tab
- Add items to the cart by clicking through menu selections
- Cart dynamically updates to reflect total order and combo logic

---

### ✅ Orders Management

After clicking **Order**:
- Items are transferred to the **Orders Placed** tab
- Users can:
  - 🧾 View previous orders
  - 🗑️ Delete past orders
  - 📤 Export orders (implementation recommended via CSV, JSON, or PDF)


---

## 🛠️ How to Run

Built and tested using **IntelliJ IDEA**, **Java 17**, and **JavaFX 17.x**

### Setup Steps

1. **Install Java 17 and JavaFX SDK 17.x**
2. Open project in IntelliJ
3. Configure:
   - Project SDK: Java 17
   - Library: Point to `javafx-sdk-17.x/lib`
   - VM Options (Run > Edit Configurations):
     ```
     --module-path "path/to/javafx-sdk/lib" --add-modules javafx.controls,javafx.fxml
     ```
4. Run `Main.java`:

com.example.model.Main
---

### ✨ Scene Builder Integration

- Install Gluon Scene Builder
- Link it under:
- IntelliJ → Preferences → Languages & Frameworks → JavaFX → Scene Builder path
- Open `.fxml` files for drag‑and‑drop UI edits

---

## 📚 Documentation

- Javadoc available at:  
`Javadoc/index.html`

To generate manually:
```bash
javadoc -d Javadoc -sourcepath src/main/java -subpackages com.example.foodorder
```

---

## 🛎️ Tips
If setup doesn’t work:

- Confirm matching JavaFX versions across SDK, Scene Builder, and runtime

- Verify `--module-path` and `--add-modules` in run configs

- Check working directory for file exports

- Print debug output:

```bash
System.out.println(new File(".").getAbsolutePath());
```

🚀 Launch Instructions
Once configured:

- 🖱️ Run Main.java

- 🍽️ Select menu items

- 📦 Track via Cart tab

- ✅ Finalize in Orders Placed tab

- 📤 Export if needed

Happy ordering! 🍟🥤🥪

---

## Contributing
Yining Chen, GitHub: wekantakabotdis
Professor Lily Chang, Rutgers University Computer Science Department

---

## License
GNU GENERAL PUBLIC LICENSE
Version 3, 29 June 2007

---

## Contact
vishalsaran2021@gmail.com

