import java.io.IOException;

/*
Bu kod, Pamukkale Üniversitesi Bilgisayar Mühendisliği Bölümü kapsamında Veri Yapıları isimli derste verilen
2.ödevini içermektedir.

	Bu ödevin amacı, iki farklı arama yönteminin etkinliğini karşılaştırmak için verilen source.txt dosyasındaki
veriler üzerinde belirli aramaları gerçekleştirmektir. source.txt dosyasında yer alan kaynaklar ile search.txt
dosyasında bulunan arama değerleri arasında yapılan karşılaştırmalar, belirtilen iki yöntem kullanılarak yapılacaktır.

    Ödevin bir diğer önemli hedefi, bu arama işlemlerinin çalışma süreleri ve bellek erişim miktarları açısından
nasıl performans farkları yarattığının incelenmesidir.

    Arama işlemlerinde kullanacağımız temel veri yapısı, derste öğrendiğimiz LinkedList sınıfı olacaktır. Ancak,
bu sınıfın şu ana kadar yazmış olduğumuz versiyonunda bellek erişimi miktarının izlenmesi için gerekli eklemeler
bulunmamaktadır. Dolayısıyla, ödevde LinkedList sınıfına yeni metodlar ve alanlar ekleyerek bellek erişimi
bilgilerini takip etmemiz gerekecektir. Bu adım, hem arama yöntemlerinin verimliliğini daha doğru bir şekilde
değerlendirmemize olanak tanıyacak hem de veri yapısının işlevselliğini genişletecektir.

    Sonuç olarak, bu ödevde amacımız, veri yapılarının performansını analiz etmek ve farklı arama yöntemlerinin
etkilerini daha iyi anlayabilmektir. Bu bağlamda, LinkedList sınıfının geliştirilmesi ve uygun metriklerin toplanması,
ödevin temel unsurlarından biri olarak öne çıkmaktadır
 */

public class Main {
    public static void main(String[] args){
        try {
            FileManager<Integer> myfile = new FileManager<>("source.txt");
            FileManager<Integer> mysearcher = new FileManager<>("search.txt");
            //Bu kısım hocamızın atmış olduğu dosya daha elimde yokken yazdım böylece eğer dosya yeni oluşmuş bir dosya
            //ise dosya yazmış olduğum fileLoader methodu sayesinde 10000 tane istenilen formattaki veri ile dolar
            //Buradaki fileLoader methodunun bundan başka bir işlevi yoktur
            //*********************************************************************
            if (myfile.isEmpty()){
                fileLoader(myfile);
            }
            if(mysearcher.isEmpty()){
                fileLoader(mysearcher);
            }
            //******************************************************
            LinkedList<Integer> sourceList = myfile.returnIntegerLinkedList();
            int[] searcharray = mysearcher.returnIntegerArray();
            System.out.println("Normal arama methodu ile :");
            searcher(sourceList, searcharray);
            System.out.println("\nÖzel arama methodu ile :");
            specialSearcher(sourceList, searcharray);

        }catch (Exception e){
            e.getMessage();
        }
    }

    public static void fileLoader(FileManager<Integer> file)throws Exception{
        int value;
        for(int i = 0 ; i < 10000 ; i++){
            value = (int) ((Math.random()*10000)+1);
            file.write(value);
        }
    }

    public static void searcher(LinkedList<Integer> filelist,int[] searcherarray)throws Exception{
        int foundcounter = 0,memoryaccesscounter = 0;
        float time;
        long startTime = 0,endTime = 0;
        startTime = System.currentTimeMillis();
        for(int i = 0 ; i < searcherarray.length ; i++){
            if(filelist.searchWithCounter(searcherarray[i])){
                foundcounter++;
            }
        }
        endTime = System.currentTimeMillis();
        time = (float) ((endTime - startTime));
        memoryaccesscounter = filelist.getMemoryAccessCounter();
        System.out.println("->"+foundcounter + " tane değerin karşılığı dosyada bulundu\n->"+ memoryaccesscounter+" kez belleğe " +
                "erişildi\n->Ortalama bellek erişim sayısı " + (memoryaccesscounter/searcherarray.length) + "\'dir" +
                "\n->"+ time +" milisaniyede arama işlemleri tamamlandı");
    }

    public static void specialSearcher(LinkedList<Integer> filelist,int[] searcherarray)throws Exception{
        int foundcounter = 0,memoryaccesscounter = 0;
        float time;
        long startTime = 0,endTime = 0;
        startTime = System.currentTimeMillis();
        for(int i = 0 ; i < searcherarray.length ; i++){
            if(filelist.specialSearchWCounter(searcherarray[i])){
                foundcounter++;
            }
        }
        endTime = System.currentTimeMillis();
        time = (float) ((endTime - startTime));
        memoryaccesscounter = filelist.getMemoryAccessCounter();
        System.out.println("->"+foundcounter + " tane değerin karşılığı dosyada bulundu\n->"+ memoryaccesscounter +" kez belleğe " +
                "erişildi\n->Ortalama bellek erişim sayısı " + (memoryaccesscounter/searcherarray.length) + "\'dir" +
                "\n->"+ time +" milisaniyede arama işlemleri tamamlandı");
    }
}