# Hazir-Veri-Tabani-Ekleme
DatabaseCopyHelper ile hazır oluşturulmuş veri tabanını projeye dahil etmek.
Dışarıdan oluşturduğumuz veri tabanımızı databaseCopyHelper.java sınıfı ile projeye dahil ediyoruz.
bu sınıftan private static String DB_NAME = "filmler.sqlite"; burada sadece veri tabanımızın adını güncelliyoruz ve en üstte paketimizi güncelliyoruz.
Dosyalardan app 'e sağ tıklayıp new deyip Folder 'in altında Assets Folder oluşturuyoruz. Bu assets dosyamıza oluşturduğumuz 
veri tabanımızı kopyalıyoruz. Ardıdndan MainActivityde kopyala() fonksiyonu oluşturup veri tabanımızı alıyoruz.

Dikkat etmemiz gereken noktalardan biri tablolarımızı oluştururken IF NOT EXISTS şeklinde ekleme yapmamız gerekli!!!

Örneğin:

sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS yonetmenler  (\n" +
                "yonetmen_id INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
                "yonetmen_ad TEXT\n" +
                ");");
