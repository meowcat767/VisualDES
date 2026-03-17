package site.meowcat.parser;

import org.commonmark.parser.Parser;
import org.commonmark.renderer.html.HtmlRenderer;

public class MarkdownParser {
    private final Parser parser;
    private final HtmlRenderer renderer;

    public MarkdownParser() {
        this.parser = Parser.builder().build();
        this.renderer = HtmlRenderer.builder().build();
    }

    public String toHtml(String markdown) {
        return renderer.render(parser.parse(markdown));
    }
}
