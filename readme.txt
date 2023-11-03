Proje 2 bölümden oluşuyor;

Main altındaki dataGenerator kısmında, random verileri üretmeye yardımcı olan sınıflar ve main sınıfı var. Main sınıfı sadece console print yapmaya yarıyor.

Rastgele veri üretme işlevselliğini sunan bir Java Spring Boot uygulaması gibi çslışıyor. Projenin iki farklı veri üretme hizmeti sunan iki HTTP API endpoint'i bulunuyor: /generateData ve /generateDataEng. Kullanıcıların isteğe bağlı olarak çeşitli veri türlerini (örneğin, ad, soyad, şehir, e-posta hesabı, vb.) rastgele üretebilecekleri bu iki hizmeti kullanarak rastgele veri oluşturabilirler.

Örnek bir HTTP isteği ve yanıt aşağıdaki gibidir:
Eğer;
GET /generateDataEng?includeAd=true&includeSoyAd=true&includeAdVeSoyAd=true&includeGmailAccount=true&includeWalletNumber=true&repeat=5

[
    {
        "ad": "John",
        "soyAd": "Doe",
        "adVeSoyAd": "John Doe",
        "gmailAccount": "johndoe@gmail.com",
        "walletNumber": "1234-5678-9012-3456",
        // Diğer alanlar...
    },
    {
        "ad": "Alice",
        "soyAd": "Smith",
        "adVeSoyAd": "Alice Smith",
        "gmailAccount": "alicesmith@gmail.com",
        "walletNumber": "9876-5432-1098-7654",
        // Diğer alanlar...
    },
    // Diğer veriler...
]
IntelliJ IDEA kullanarak bir JAR dosyası olarak nasıl alabiliriz?:

-IntelliJ IDEA'yı açın.
-Projenizi açın veya bu projeyi yeni bir IntelliJ projesi olarak içe aktarın.
-"Maven" veya "Gradle" gibi bir projeyi yönetmek için bir proje yapılandırması kullandığınızdan emin olun.
-IntelliJ'de sol üst köşedeki "File" menüsünden "Project Structure" seçeneğine gidin.
-Açılan pencerede, "Artifacts" sekmesine gidin.
-"+" simgesine tıklayarak yeni bir JAR veya WAR oluşturun, ardından "From modules with dependencies" seçeneğini belirleyin.
-Oluşturmak istediğiniz modülü ve ana sınıfınızı seçin. Bu projede muhtemelen DataController sınıfı birincil uygulama sınıfınızdır.
-Gerekli yapılandırmaları yapın ve "OK" düğmesine tıklayın.
-Proje penceresinde, oluşturulan JAR dosyasını seçin ve sağ tıklayarak "Build" seçeneğini seçin. Bu, JAR dosyanızı derler ve oluşturur.
-Derleme işlemi tamamlandığında, oluşturulan JAR dosyasını projenizin kök dizininde veya istediğiniz bir konumda bulabilirsiniz.
