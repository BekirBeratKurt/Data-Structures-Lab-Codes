import java.util.Scanner;

/*
    Bu kod Pamukkale Üniversitesi Veri Yapıları dersi #1 kodlu ödev kapsamında yazılmıştır. Kodun
main fonksiyonunda kullanıcıdan bir postfix ifade girilmesi istenmiştir ve ödev için verilen kural
kapsamında ifadelerinin arasına '_' yazılması istenmiştir kullanıcıdan Scanner nesnesi ile alınan değer
aşağıda yazdığımız calculatePostFix komutu ile try-catch yapısı içinde hesaplanıp kullanıcıya gösterilir
    Eğer verilen postfix ifadede bir hata var ise hatanın nedeniyle birlikte bu hata belirtilir ve hata
mesajı kullanıcıya gösterilir
 */

public class Main {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.println("Bir Postfix ifade giriniz " +
                "postfix ifade girerken ifadeler arasına '_' işareti koyunuz");
        String postfix_expression = scn.nextLine();
        try {
            System.out.println("Sonuç = " + calculatePostFix(postfix_expression));
        } catch (Exception e) {
            System.out.println("BİR HATA OLDU\nHata Mesajı:\n*****************\n");
            System.out.println(e.getMessage());
            System.out.println("\n*****************");
        }
    }
/*
***********************************************************************************************************
    calculatePostFix fonksiyonu String tipinde girilen bir postfix işlemi metnini hesaplar bunuda :

1-) String tipinde seperated_expressions isimli bir dizi oluşturup bu dizinin elemanlarını girilen String
ifadenin hocamızın koyduğu kurala göre '_' ifadesini içeren yerlerinden ayırarak oluşturup ve Numbers
adında Float tipinde değerler tutan genericStack nesnesini oluşturarak yapılacak diğer işlemler için bir
başlangıç yapar

2-) Sonra for döngüsü içerisinde dizinin elemanları kontrol edilir eğer eleman sayı ise Numbers isimli
GenericStack nesnesine eklenir eğer değil ise elemanın bir işlem olacağı farz edilir ve stack e eklenmiş
iki tane float değer stackten alınıp değişkenlere atanır (bu işlem pop komutu ile çıkarılan değerlerin
sıralarının düzenlenmesi içindir) eğer stackte eleman yoksa ifadede bir hata olduğu varsayılır ve
GenericStack Class ı içerisinde yazılan hata mesajı verilir

3-) Daha sonra push komutu içerisinde calculateParts fonksiyonu çalıştırılır eğer işlem olarak düşünülen
değer işlem değil ise calculateParts fonksiyonundan bir RunTimeException ile hata mesajı gönderilir eğer
işlemse fonksiyonun sonucu stack e eklenir

    for döngüsü bittiğinde ise stackte kalan son eleman işlemin sonucu olduğu için bu eleman fonksiyon
sonunda return edilir
*/
    public static Float calculatePostFix(String postfix_expression) throws Exception {
        float a,b;
        //1-)
        GenericStack<Float> Numbers = new GenericStack<>(Float.class, postfix_expression.length());
        String[] seperated_expressions = postfix_expression.split("_");
        for (int i = 0; i < seperated_expressions.length; i++) {
            //2-)
            if(isNumber(seperated_expressions[i]) == true){
                Numbers.push(Float.parseFloat(seperated_expressions[i]));
            }else {
                a = Numbers.pop();
                b = Numbers.pop();
                //3-)
                Numbers.push(calculateParts(b,a,seperated_expressions[i]));
            }
        }
        return Numbers.pop();
    }
/*
**********************************************************************************************************
calculateParts fonksiyonunda girilen String bir işlem ifade ediyorsa ondan önce girilen iki sayı ile o
işlem yapılıyor eğer işlem ifadesi yoksa run time exepcion gönderiyor.
 */
    public static float calculateParts(float x, float y, String operator) {
        return switch (operator) {
            case "+" -> x + y;
            case "-" -> x - y;
            case "*" -> x * y;
            case "/" -> x / y;
            default -> throw new RuntimeException("Böyle bir işlem yok \n" +
                    "Kullanılabilen işlemler sadece '+, -, *, /' dır \n" +
                    "Siz ise '" + operator + "' yazdınız");
        };
    }
/*
*********************************************************************************************************
Buradaki is Number fonksiyonunu içine girilen String ifadenin bir sayı olup olmadığını anlamak için koydum.
Eğer Girilen String ifadede parse float fonksiyonu başarılı bir şekilde çalışıyorsa fonksiyon true
döndürecek çalışmıyorsa false döndürecek. Bu sayede String ifadenin kimliği(Sayı mı değilmi) belirlenebilecek
 */
    public static boolean isNumber(String expression){
        try{
            Float.parseFloat(expression);
            return true;
        }catch (Exception e){
            return false;
        }
    }
}