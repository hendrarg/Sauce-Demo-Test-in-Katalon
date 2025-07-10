# 🧪 SauceDemo Automation with Katalon Studio (Gherkin BDD)

Automated test project for (https://www.saucedemo.com) built using **Katalon Studio** with **Gherkin BDD** syntax.  
This project covers key user flows including login, product listing, cart interaction, and item verification.

---

## ✅ Test Scenarios

### 1. 🔐 Login with Conditional Retry

- Attempt login using **locked_out_user**
- If error message appears, verify and log it
- Else, retry login using **standard_user**

### 2. 🛍️ Product Count Verification

- Ensure there are exactly **6 products** displayed on the main menu page

### 3. ➕ Add Products to Cart by Title

- Add specific products to the cart by their **product title**

### 4. ➖ Remove Product from Cart

- After adding, verify the **Remove** button appears to confirm successful addition

### 5. 💵 Cart Label and Price Verification

- Go to **Your Cart**
- Verify:
  - Product titles
  - Prices are displayed correctly and match the selection

---

## 🔧 Tools & Technologies

- **Katalon Studio**
- **Gherkin (Cucumber) BDD**
- **Groovy (Custom Keywords & Logic)**
- **Web Automation with Selenium Engine**

---

## 📁 Project Structure

