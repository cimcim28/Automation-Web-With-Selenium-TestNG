# Selenium TestNG Automation for Sauce Demo

## Deskripsi
Proyek ini berisi skrip otomatisasi pengujian menggunakan Selenium WebDriver dengan TestNG untuk aplikasi demo belanja online [Sauce Demo](https://www.saucedemo.com).

Fitur utama yang diuji:
- Login valid dan invalid
- Menambahkan produk ke keranjang
- Menghapus produk dari keranjang
- Proses checkout dengan data valid dan invalid

---

## Struktur Proyek

- `TestBase.java` — Kelas dasar yang mengatur setup dan teardown WebDriver.
- `LoginTest.java` — Tes untuk validasi login.
- `ProductsTest.java` — Tes untuk penambahan dan penghapusan produk pada keranjang.
- `CheckoutTest.java` — Tes proses checkout.
- `Pages/` — Paket berisi Page Object Model (POM) seperti `LoginPage`, `ProductsPage`, `CartPage`, `CheckoutPage`.

---

## Cara Menjalankan Tes

1. Pastikan Java dan Maven sudah terinstall.
2. Clone repositori ini:
   ```bash
   git clone https://github.com/username/repo-sauce-demo.git
   cd repo-sauce-demo

3. Jalankan tes dengan Maven:
mvn clean test

## Konfigurasi Browser

Browser yang digunakan adalah Chrome dengan beberapa opsi ChromeDriver seperti:

1. Nonaktifkan ekstensi
2. Nonaktifkan autofill dan password manager
3. Mengaktifkan mode automation

Pengaturan opsi ini ada di kelas Hooks.java