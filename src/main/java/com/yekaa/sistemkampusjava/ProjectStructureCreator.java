package com.yekaa.sistemkampusjava;

import java.io.File;
import java.util.Scanner;

public class ProjectStructureCreator {

    public static void createModuleStructure(String moduleName) {
        File moduleDir = new File("modules", moduleName);
        moduleDir.mkdirs();

        String[] subdirectories = {
                "model",
                "controller",
                "repository",
                "dto",
                "service"
        };

        for (String subdirectory : subdirectories) {
            File subDir = new File(moduleDir, subdirectory);
            subDir.mkdirs();
        }
    }

    public static void createCommonStructure() {
        File commonDir = new File("common");
        commonDir.mkdirs();

        String[] commonSubdirectories = {
                "config",
                "utils",
                "exception",
                "logging",
                "security",
                "caching",
                "validation",
                "i18n"
        };

        for (String subdirectory : commonSubdirectories) {
            File subDir = new File(commonDir, subdirectory);
            subDir.mkdirs();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Select option (1: Common + Module, 2: Common only, 3: Module only): ");
        int option = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        if (option == 1 || option == 2) {
            createCommonStructure();
            System.out.println("Common structure created successfully!");
        }
        if (option == 1 || option == 3) {
            System.out.print("Enter the module name: ");
            String moduleName = scanner.nextLine();
            createModuleStructure(moduleName);
            System.out.println("Module '" + moduleName + "' structure created successfully!");
        }

        scanner.close();
    }
}
