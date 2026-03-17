package site.meowcat.generator;

import site.meowcat.parser.MarkdownParser;
import site.meowcat.project.DocsProject;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Files;

public class SiteGenerator {

    private final MarkdownParser parser = new MarkdownParser();

    public void build(DocsProject project) throws IOException {

        Path output = project.root.resolve("build");
        Files.createDirectories(output);

        for (Path md : project.markdownFiles) {

            String markdown = Files.readString(md);
            String html = parser.toHtml(markdown);

            Path outFile = output.resolve(
                    md.getFileName().toString().replace(".md", ".html")
            );

            Files.writeString(outFile, html);
        }
    }
}