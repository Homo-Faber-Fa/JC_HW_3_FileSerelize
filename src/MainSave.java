import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class MainSave {
    //HW JC №3 Задача 2: Сохранение поправлено 25.04.2024
    public static void main(String[] args) {
        List<GameProgress> listGameProgress = new ArrayList<>(); // сформирован объект массива содержащий переменные типа GameProgress
        Collections.addAll(listGameProgress,                     // добавление объектов массива
                new GameProgress(11, 12, 13, 1.4),
                new GameProgress(21, 22, 23, 2.4),
                new GameProgress(31, 32, 33, 3.4));
        // сформированы три объекта типа GameProgress

        List<String> fileNameAPathFiles = saveGames("Games/savegames/", listGameProgress); // запуск saveGame  Запуск передает в метод путь папки и Массив GameProgress


        zipFiles("", fileNameAPathFiles);           // запуск zipFiles   Запуск передает в метод путь папки и Имена файлов

        deleteFiles(fileNameAPathFiles);
    }

    public static List<String> saveGames(String path, List<GameProgress> list) {

        List<String> pathToZip = new ArrayList<>();  // сформирован объект массива содержащий переменные типа String

        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < list.size(); i++) {
            GameProgress gameProgress = list.get(i);
            stringBuilder.append(path).append("/save").append(i + 1).append(".dat"); // Цикл формирования имени файла включая путь и расширение (отдельный оборот для каждого файла)

            try (FileOutputStream fos = new FileOutputStream(String.valueOf(stringBuilder));
                 ObjectOutputStream oos = new ObjectOutputStream(fos)) {
                oos.writeObject(gameProgress);
            } catch (IOException e) {
                e.getMessage();
            }

            pathToZip.add(String.valueOf(stringBuilder));

            stringBuilder.setLength(0);
        }
        return pathToZip;
    }

    public static void zipFiles(String pathToDirectory, List<String> pathToFiles) {

        StringBuilder sb = new StringBuilder().append(pathToDirectory).append("savegames.zip");
        try (ZipOutputStream arhops = new ZipOutputStream(new FileOutputStream(String.valueOf(sb)))) {
            pathToFiles.stream().forEach(x -> {
                try {
                    FileInputStream fips = new FileInputStream(x);
                    sb.setLength(0);
                    sb.append(x).replace(0, 19, "zip_");
                    ZipEntry entry = new ZipEntry(String.valueOf(sb));
                    arhops.putNextEntry(entry);
                    byte[] buffer = new byte[fips.available()];
                    fips.read(buffer);
                    arhops.write(buffer);
                    arhops.closeEntry();
                    fips.close();
                } catch (IOException e) {
                    e.getMessage();
                }
            });
        } catch (IOException e) {
            e.getMessage();
        }

    }

    private static void deleteFiles(List<String> path) {
        int count = 0;
        for (int i = 0; i < path.size(); i++) {
            File file = new File(path.get(i));
            if (file.delete()) {
                count = count + 1;
            }
        }
        if (count == 3) {
            System.out.println("файлы удалены");
        }
    }
}
