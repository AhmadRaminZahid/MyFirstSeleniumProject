package com.myfirstproject;

import Utilities.TestBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Day10_fileExist extends TestBase {
    @Test
    public void fileExistsTest(){
     String path=    System.getProperty("home.user")+"/Downloads/flower.jpeg";
        System.out.println("path = " + path);
        Assertions.assertTrue(Files.exists(Paths.get(path)));
    }

}
