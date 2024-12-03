import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/*
    Bu class ı dosya ile yapıcak olduğum işlemlerin kolaylığı için yazdım
    Bu class ı yazarken elimizde hocamızın atmış olduğu hazır dosyalar daha elimde olmadığı için dosyaya hocamızın
belirlediği formatta veri ekliyebilmek için write methodunuda yazdım
*/

public class FileManager <T extends Comparable>{
    private File file;

    public FileManager(String path) throws IOException {
        try {
            file = new File(path);
            if (file.createNewFile()) {
                System.out.println("Dosya oluşturuldu: " + file.getName());
            }
        } catch (IOException e) {
            throw new IOException("Bir hata meydana geldi.\nDosya Oluşturulamadı");
        }
    }

    public void write(T val) throws Exception {
        if(!(file.exists())){
            throw new IOException("Dosya yok");
        } else if (!(file.canWrite())) {
            throw new IOException("Dosya yazılabilir bir dosya değil");
        }else{
            try {
                FileWriter writer = new FileWriter(file,true);
                if(isEmpty()) {
                    writer.write(val.toString());
                }else{
                    writer.write(","+val.toString());
                }
                writer.close();
            }catch (Exception e){
                throw new Exception("Bir hata meydana geldi.");
            }
        }
    }

    public boolean isEmpty()throws Exception {
        if(!(file.exists())){
            throw new IOException("Dosya yok");
        }else{
            return (file.length()==0);
        }
    }

    public void read() throws Exception {
        if(!(file.exists())){
            throw new IOException("Dosya yok");
        } else if (!(file.canRead())) {
            throw new IOException("Dosya okunabilir bir dosya değil");
        }else{
            try{
                Scanner reader = new Scanner(file);
                while (reader.hasNextLine()) {
                    String data = reader.nextLine();
                    System.out.println(data);
                }
                reader.close();
            }catch (Exception e){
                throw new Exception("Bir hata meydana geldi.");
            }
        }
    }

    public LinkedList<Integer> returnIntegerLinkedList() throws Exception {
        if(!(file.exists())){
            throw new IOException("Dosya yok");
        } else if (!(file.canRead())) {
            throw new IOException("Dosya okunabilir bir dosya değil");
        }else{
            LinkedList<Integer> fileinf = new LinkedList<>();
            Scanner reader = new Scanner(file);
            try {
                String data ="";
                while (reader.hasNextLine()) {
                    data =  reader.nextLine();
                }
                reader.close();
                String[] list = data.split(",");
                for (int i = 0; i < list.length; i++) {
                    fileinf.addIfNotInTheList(Integer.parseInt(list[i]));
                }
                return fileinf;
            }catch (Exception e){
                throw new Exception("Bir hata meydana geldi.");
            }
        }
    }

    public int[] returnIntegerArray() throws Exception {
        if(!(file.exists())){
            throw new IOException("Dosya yok");
        } else if (!(file.canRead())) {
            throw new IOException("Dosya okunabilir bir dosya değil");
        }else {
            String[] splitedarray;

            Scanner reader = new Scanner(file);
            try {
                String data = "";
                while (reader.hasNextLine()) {
                    data = reader.nextLine();
                }
                reader.close();
                splitedarray = data.split(",");
                int[] intsofsplitedarray = new int[splitedarray.length];
                for (int i = 0; i < splitedarray.length; i++) {
                    intsofsplitedarray[i] = Integer.parseInt(splitedarray[i]);
                }
                return intsofsplitedarray;
            }catch (Exception e){
                throw new Exception("Bir hata meydana geldi.");
            }
        }
    }
}