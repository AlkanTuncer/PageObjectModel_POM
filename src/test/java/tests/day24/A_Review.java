package tests.day24;

public class A_Review {

    /*
                    POM - Page Object Model

          - Herkes tarafından kabul görmüş bir framework design pattern'dir.

          - Temel amaç ;
                - sürdürülebilir / maintainable
                - yeniden kullanılabilir / reusable
                - daha hızlı / faster
                - anlaşılabilir / understandable
                - tekrar eden kodlardan kurtulduk.
                - test datalarını tek bir merkezden kontrol ediyoruz. (configuration.properties)
                - sonradan projeye katılanlar framework'u rahatlıkla anlayabilir.

           * Oluşturdugumuz temel classlarımız var.Bunlar;
                   1. Locate ve Reusable Metotları koydugumuz 'pages' altındaki classlarımız.
                   2. Driver'ı cagırdıgımız 'driver' class. Static metotlarla olusturdugumuz browserlar var.(Bagımlı olmaktan kurtardık bunları.)
                   3. Driver.getDriver() ve closeDriver(), singleton pattern'e uygun olarak düzenliyoruz.
                     * 'Singleton desgin pattern' çalışma zamanında yalnızca 1 object yaratılmasını garanti eden tasarım desenidir.
                   4. configuration.properties : test datalarını tuttugumuz yer. 'key-value' şeklinde olusturulur.
                     * Kesinlike ve mutlak suretle key'ler unique olmalıdır.
                   5. ConfigurationReader class'da .properties uzantılı file çalıştırır. Yazdıgımız key-value ilişkisindeki .properties dosyasını yönetir.


     */

}
