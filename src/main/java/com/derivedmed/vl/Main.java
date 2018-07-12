package com.derivedmed.vl;

import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) throws IOException {
        List<String> collect = Files.lines(Paths.get("src/main/resources/test.txt"))
                .filter(l -> l.contains("<a"))
                .flatMap(l -> Stream.of(StringUtils.substringsBetween(l.replaceAll("\\s+",""), "href=\"", "\"")))
                .collect(Collectors.toList());
        collect.forEach(System.out::println);

        new Thread(()-> System.out.println("hello")).start();

    }
}

class MyThread implements Runnable{

    @Override
    public void run() {
        System.out.println("Run");
    }
}
