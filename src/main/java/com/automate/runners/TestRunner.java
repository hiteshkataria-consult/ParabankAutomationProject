package com.automate.runners;

import org.apache.commons.io.FileUtils;
import org.testng.TestNG;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class TestRunner {

    public static void main(String[] args) {

        String suite1 = "suite1.xml";
        String suite2 = "suite2.xml";

        runSuite(suite1, "test-output/set1");
        runSuite(suite2, "test-output/set2");
        runSuite(suite2, "test-output/set2");
    }

    private static void runSuite(String suiteFile, String outputDirectory) {
        try {
            File dir = new File(outputDirectory);
            if (dir.exists()) {
                FileUtils.cleanDirectory(dir); // Using Apache Commons IO to clean the directory
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        TestNG testNG = new TestNG();
        testNG.setTestSuites(Arrays.asList(suiteFile));
        testNG.setOutputDirectory(outputDirectory);
        testNG.run();
    }
}

