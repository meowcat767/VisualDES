package site.meowcat.project;

import java.io.IOException;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;


public class DocsProject {
    public Path root;
    public List<Path> markdownFiles = new ArrayList<>();

    public static DocsProject load(Path root) throws IOException {
        DocsProject project = new DocsProject();
        project.root = root;

        Files.walk(root).filter(p -> p.toString().endsWith(".md")).forEach(project.markdownFiles::add);
        return project;
    }
}
