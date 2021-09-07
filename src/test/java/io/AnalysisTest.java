package io;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;
import question.Analize;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class AnalysisTest {
    @Rule
    public TemporaryFolder folder = new TemporaryFolder();

    @Test
    public void unavailable() throws IOException {
        File source = folder.newFile("source.txt");
        File target = folder.newFile("target.txt");
        try (PrintWriter out = new PrintWriter(source)) {
            out.println("200 10:56:01");
            out.println("500 10:57:01");
            out.println("400 10:58:01");
            out.println("200 10:59:01");
            out.println("500 11:01:02");
            out.println("200 11:02:02");
        }
        Analysis analysis = new Analysis();
        analysis.unavailable(source.getAbsolutePath(), target.getAbsolutePath());
        ArrayList<String> rsl = new ArrayList();
        try (BufferedReader in = new BufferedReader(new FileReader(target))) {
            in.lines().forEach(x -> rsl.add(x));
        }
        assertThat(rsl.get(0), is("10:57:01;10:59:01"));
        assertThat(rsl.get(1), is("11:01:02;11:02:02"));
    }
}