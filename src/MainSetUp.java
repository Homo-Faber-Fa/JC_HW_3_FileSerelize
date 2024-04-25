import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainSetUp {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        //HW JC №3 Задача 1: Установка поправил 25.04.2024

        createDirectory(sb, "Games\\src\\main"); // C:\Java\Java Core\HW 3 File\
        createDirectory(sb, "Games\\src\\test");
        createDirectory(sb, "Games\\temp");
        createDirectory(sb, "Games\\savegames");
        createDirectory(sb, "Games\\res\\vectors");
        createDirectory(sb, "Games\\res\\icons");
        createFile(sb, "Games\\src\\main\\Main.java");
        createFile(sb, "Games\\src\\main\\Utils.java");
        createFile(sb, "Games\\temp\\temp.txt");

        sendLod("Games\\temp\\temp.txt", sb);// C:\Java\Java Core\HW 3 File\

        System.out.println(sb.toString());


    }
    public static void createFile(StringBuilder sb, String loger) {
        File myFile0 = new File(loger);
        try {
            if (myFile0.createNewFile());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        sb.append("Создан файл ").append(loger).append("\n");
    }
    public static void createDirectory(StringBuilder sb, String loger) {
        System.out.println(loger);
        File dir = new File(loger);
        if (dir.mkdirs()) ;
        sb.append("Создан каталог ").append(loger).append("\n");
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
