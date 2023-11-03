Proje 2 bölümden oluşuyor;

Main altındaki dataGenerator kısmında, random verileri üretmeye yardımcı olan sınıflar ve main sınıfı var. Main sınıfı sadece console print yapmaya yarıyor.

Api dosyasında ise oluşturulan random verilerin web akide printlenme işlemi gerçekleştiriliyor.

Eğer;

http://localhost:8080/generateData yazarsanız web tarafında bu size sürekli olarak random veri üreten bir web page açar.

http://localhost:8080/readDataFromFile bu url ise generate data dan sonra herhangi bir refresh yapılmadan açılır ve ilk datayı sabit olarak korur. Kapandığında ise o veriyi txt dosyasından siler.

http://localhost:8080/allData bu url ise programı çalıştırdığınız andan itibaren oluşturulan bütün verileri, program kapanıncaya kadar saklar.