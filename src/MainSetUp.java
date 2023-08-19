import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainSetUp {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();

        //HW JC №3 Задача 1: Установка

        File dir = new File("Games");  if (dir.mkdir())  sb.append(" Games каталог создан \n");
        File dir1 = new File("Games/src");  if (dir1.mkdir()) sb.append(" Games/src каталог создан \n");
        File dir2 = new File("Games/res");  if (dir2.mkdir()) sb.append(" Games/res каталог создан \n");
        File dir3 = new File("Games/savegames");  if (dir3.mkdir()) sb.append(" Games/savegames каталог создан \n");
        File dir4 = new File("Games/temp");  if (dir4.mkdir()) sb.append(" Games/temp каталог создан \n");
        File dir5 = new File("Games/src/main");  if (dir5.mkdir()) sb.append(" Games/src/main каталог создан \n");
        File dir6 = new File("Games/src/test");  if (dir6.mkdir()) sb.append(" Games/src/test каталог создан \n");





        File myFile0 = new File("Games/src/main/Main.java");
        try { if (myFile0.createNewFile())
            sb.append(" Main.java файл был создан \n");
        } catch (IOException ex) {
            System.out.println(ex.getMessage());}

        File myFile1 = new File("Games/src/main/Utils.java");
        try { if (myFile1.createNewFile())
            sb.append(" Utils.java файл был создан \n");
        } catch (IOException ex) {
            System.out.println(ex.getMessage());}

        File myFile2 = new File("Games/temp/temp.txt");
        try { if (myFile2.createNewFile())
            sb.append(" temp.txt файл был создан \n");
        } catch (IOException ex) {
            System.out.println(ex.getMessage());}


        System.out.println(sb.toString());


        String text = sb.toString();
        byte[] buffer = text.getBytes();
// создаем выходной байтовый поток
// и передаем его в выходной буферизированный поток
        try (FileOutputStream out = new FileOutputStream("Games\\temp\\temp.txt");
             BufferedOutputStream bos = new BufferedOutputStream(out)) {
            // производим запись от 0 до последнего байта из массива
            bos.write(buffer, 0, buffer.length);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }


    }
}