# Çok İş Parçacıklı Depo Yönetim Sistemi (Multi-Threaded Warehouse Management System)

Bu proje, Java kullanılarak geliştirilmiş, **Thread-Safe (İş Parçacığı Güvenli)** bir depo ve envanter yönetim simülasyonudur. Uygulamanın temel amacı, paylaşılan bir kaynağa (depo) birden fazla iş parçacığının (thread) aynı anda erişmesi durumunda `synchronized` anahtar kelimesi ile veri tutarlılığının nasıl sağlandığını göstermektir.

## Proje Hakkında

Bu laboratuvar çalışması (Lab4) kapsamında;
- Çoklu iş parçacığı (Multi-threading) yönetimi,
- Eşzamanlılık (Concurrency) problemleri,
- Dosya işlemleri (I/O) ve loglama mekanizmaları uygulanmıştır.

## Sınıf Yapısı (Class Structure) 

Proje 4 ana sınıftan oluşmaktadır:

1.  **Product (Ürün):** Depodaki ürünleri (id, isim, stok) temsil eder.
2.  **Warehouse (Depo):** Ürünlerin saklandığı ana sınıftır.
    - `inventory`: Ürünleri tutan Map yapısı.
    - `updateAndLog()`: **Synchronized** olarak çalışan, stok güncelleyen ve log tutan kritik metot.
3.  **FileHelper:** Dosya okuma/yazma işlemlerini yönetir. İşlemleri loglar ve envanterin son halini kaydeder.
4.  **TransactionWorker (İşçi):** `Runnable` arayüzünü uygular. Paralel olarak çalışarak depoya ürün ekleme/çıkarma isteklerini simüle eder.


*Bu proje 07.01.2026 tarihinde Lab4 çalışması kapsamında geliştirilmiştir.*
