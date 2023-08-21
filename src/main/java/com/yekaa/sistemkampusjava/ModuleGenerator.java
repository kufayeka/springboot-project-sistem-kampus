package com.yekaa.sistemkampusjava;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class ModuleGenerator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Masukkan ModuleName: ");
        String moduleName = scanner.nextLine();

        scanner.close();

        generateFolderStructure(moduleName);
    }

    public static void generateFolderStructure(String moduleName) {
        String rootPath = "modules_generated";
        String modulePath = rootPath + "/" + moduleName.toLowerCase();

        createDirectory(modulePath);

        // Create model folder
        createDirectory(modulePath + "/model");
        createFile(modulePath + "/model", moduleName + "Model.java", getModelTemplate(moduleName));

        // Create controller folder
        createDirectory(modulePath + "/controller");
        createFile(modulePath + "/controller", moduleName + "Controller.java", getControllerTemplate(moduleName));

        // Create repository folder
        createDirectory(modulePath + "/repository");
        createFile(modulePath + "/repository", moduleName + "Repository.java", getRepositoryTemplate(moduleName));
        //createFile(modulePath + "/repository", moduleName + "RepositoryImpl.java", getRepositoryImplTemplate(moduleName));


        // Create service folder
        createDirectory(modulePath + "/service");
        createFile(modulePath + "/service", moduleName + "Service.java", getServiceTemplate(moduleName));
        createFile(modulePath + "/service", moduleName + "ServiceImpl.java", getServiceImplTemplate(moduleName));


        // Create dto folder
        createDirectory(modulePath + "/dto");
        createFile(modulePath + "/dto", moduleName + "ResponseDto.java", getResponseDtoTemplate(moduleName));
        createFile(modulePath + "/dto", moduleName + "RequestDto.java", getRequestDtoTemplate(moduleName));
    }

    public static void createDirectory(String path) {
        File directory = new File(path);
        directory.mkdirs();
    }

    public static void createFile(String path, String fileName, String content) {
        try {
            File file = new File(path, fileName);
            FileWriter writer = new FileWriter(file);
            writer.write(content);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String capitalize(String str) {
        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }

    public static String getModelTemplate(String moduleName) {
        String modelName = capitalize(moduleName);
        return "@Entity\n" +
                "@Data\n" +
                "@NoArgsConstructor\n" +
                "@AllArgsConstructor\n" +
                "@Builder\n" + "public class " + modelName + "Model {}\n";
    }

    public static String getControllerTemplate(String moduleName) {
        String modelName = capitalize(moduleName);
        return "@RestController\n" +
                "public class " + modelName + "Controller {}\n";
    }

    public static String getRepositoryTemplate(String moduleName) {
        String modelName = capitalize(moduleName);
        return "public interface " + modelName + "Repository {}\n";
    }

//    public static String getRepositoryImplTemplate(String moduleName) {
//        String modelName = capitalize(moduleName);
//        return "@Repository\n" +
//                "public class " + modelName + "RepositoryImpl implements " + modelName + "Repository {}\n";
//    }

    public static String getServiceTemplate(String moduleName) {
        String modelName = capitalize(moduleName);
        return "public interface " + modelName + "Service {}\n";
    }

    public static String getServiceImplTemplate(String moduleName) {
        String modelName = capitalize(moduleName);
        return "@Service\n" +
                "public class " + modelName + "ServiceImpl implements " + modelName + "Service {}\n";
    }

    public static String getResponseDtoTemplate(String moduleName) {
        String modelName = capitalize(moduleName);
        return  "@Data\n" +
                "public class " + modelName + "ResponseDto {}\n";
    }

    public static String getRequestDtoTemplate(String moduleName) {
        String modelName = capitalize(moduleName);
        return  "@Data\n" +
                "public class " + modelName + "RequestDto {}\n";
    }
}
