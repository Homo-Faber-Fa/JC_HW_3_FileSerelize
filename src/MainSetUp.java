import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainSetUp {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();

        //HW JC №3 Задача 1: Установка поправил 20.04.2024
        addDirectoryFiles(sb);
        
        sendLod("C:\\Java\\Java Core\\HW 3 File\\Games\\temp\\temp.txt", sb);
        System.out.println(sb);

    }
        public static void addDirectoryFiles(StringBuilder sb) {
            sb.append(" Games ");

            String loger;

            loger = "Games\\src\\main";
            File dir = new File(loger);
            if (dir.mkdirs()) ;
            sb.append("Создан каталог ").append(loger).append("\n");


            loger = "Games\\src\\main\\Main.java";
            File myFile0 = new File(loger);
            try {
                if (myFile0.createNewFile());
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
            sb.append("Создан файл ").append(loger).append("\n");


            loger = "Games\\src\\main\\Utils.java";
            File myFile1 = new File(loger);
            try {
                if (myFile1.createNewFile());
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
            sb.append("Создан файл ").append(loger).append("\n");

            loger = "Games\\src\\test";
            File dir1 = new File(loger);
            if (dir1.mkdirs()) ;
            sb.append("Создан каталог ").append(loger).append("\n");

            loger = "Games\\temp";
            File dir2 = new File(loger);
            if (dir2.mkdirs()) ;
            sb.append("Создан каталог ").append(loger).append("\n");

            loger = "Games\\temp\\temp.txt";
            File myFile2 = new File(loger);
            try {
                if (myFile2.createNewFile())
                    ;
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
            sb.append("Создан файл ").append(loger).append("\n");

            loger = "Games\\savegames";
            File dir3 = new File(loger);
            if (dir3.mkdirs()) ;
            sb.append("Создан каталог ").append(loger).append("\n");



            loger = "Games\\res\\drawables";
            File dir4 = new File(loger);
            if (dir4.mkdirs()) ;
            sb.append("Создан каталог ").append(loger).append("\n");

            loger = "Каталог создан Games\\res\\vectors";
            File dir5 = new File(loger);
            if (dir5.mkdirs()) ;
            sb.append("Создан каталог ").append(loger).append("\n");

            loger = "Каталог создан Games\\res\\icons";
            File dir6 = new File(loger);
            if (dir6.mkdirs()) ;
            sb.append("Создан каталог ").append(loger).append("\n");



            System.out.println(sb.toString());
    }




    public static void sendLod(String path, StringBuilder sb) {
        try (FileOutputStream fos = new FileOutputStream(path)) {
            byte[] bytes = sb.toString().getBytes();
            fos.write(bytes, 0, bytes.length);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
