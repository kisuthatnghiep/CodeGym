package IOBinaryFile;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.Scanner;

public class Main {
    private static void copyFileUsingJava7Files(File source, File des) throws IOException{
        Files.copy(source.toPath(), des.toPath(), StandardCopyOption.REPLACE_EXISTING);
    }

    private static void copyFilesUsingStream(File source, File des) throws IOException{
        try (InputStream is = Files.newInputStream(source.toPath()); OutputStream os = Files.newOutputStream(des.toPath())) {
            int length;
            byte[] buffer = new byte[1024];
            while ((length = is.read(buffer)) > 0) {
                os.write(buffer, 0, length);
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter source path:");
        String sourcePath = scanner.nextLine();
        System.out.println("Enter destination path:");
        String desPath = scanner.nextLine();
        File sourceFile = new File(sourcePath);
        File desFile = new File(desPath);
        try {
            copyFileUsingJava7Files(sourceFile, desFile);
//            copyFilesUsingStream(sourceFile, desFile);
            System.out.println("copy completed");
        }catch (IOException e){
            System.out.println("Can't copy that file");
            System.out.println(e.getMessage());
        }
    }
}
