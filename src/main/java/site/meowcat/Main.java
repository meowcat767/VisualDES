package site.meowcat;

import site.meowcat.generator.SiteGenerator;
import site.meowcat.project.DocsProject;

import java.nio.file.Path;

public class Main {
    public static void main(String[] args) throws Exception {
        Path projectPath = Path.of("example-docs");

        DocsProject project = DocsProject.load(projectPath);

        SiteGenerator generator = new SiteGenerator();
        generator.build(project);

        System.out.println("Done!");
    }
}