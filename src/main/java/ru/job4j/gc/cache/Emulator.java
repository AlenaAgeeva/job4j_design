package ru.job4j.gc.cache;

import java.util.Scanner;

public class Emulator {
    private static DirFileCache cache;

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                System.out.println("1. Specify caching directory");
                System.out.println("2. Load file into cache");
                System.out.println("3. Get file from cache");
                System.out.println("4. Exit");
                System.out.print("Select an option: ");

                int option = scanner.nextInt();
                scanner.nextLine();

                switch (option) {
                    case 1:
                        System.out.print("Enter the caching directory: ");
                        String cachingDir = scanner.nextLine();
                        cache = new DirFileCache(cachingDir);
                        break;
                    case 2:
                        if (cache == null) {
                            System.out.println("Specify caching directory first");
                            break;
                        }
                        System.out.print("Enter the file name: ");
                        String fileName = scanner.nextLine();
                        String fileContent = cache.get(fileName);
                        if (fileContent == null) {
                            System.out.println("File not found");
                        } else {
                            System.out.println("File content:\n" + fileContent);
                        }
                        break;
                    case 3:
                        if (cache == null) {
                            System.out.println("Specify caching directory first");
                            break;
                        }
                        System.out.print("Enter the file name: ");
                        fileName = scanner.nextLine();
                        fileContent = cache.get(fileName);
                        System.out.println(fileContent);
                        if (fileContent == null) {
                            System.out.println("File not found in cache");
                        } else {
                            System.out.println("File content in cache:\n" + fileContent);
                        }
                        break;
                    case 4:
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Invalid option");
                        break;
                }
            }
        }

    }
}

