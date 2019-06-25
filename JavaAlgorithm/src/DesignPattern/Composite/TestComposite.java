package DesignPattern.Composite;

public class TestComposite {
    public static void main(String[] args) {
        HtmlTag parentTag = new HtmlParentElement("<html>");
        parentTag.setStartTag("<html>");
        parentTag.setEndTag("</html>");

        HtmlTag p1 = new HtmlParentElement("<body>");
        p1.setStartTag("<body>");
        p1.setEndTag("</body>");

        parentTag.addChildTag(p1);

        HtmlTag child1 = new HtmlElement("<p>");
        child1.setStartTag("<p>");
        child1.setEndTag("</p>");
        child1.setTagBody("Testing html tag library");
        p1.addChildTag(child1);

        HtmlTag child2 = new HtmlElement("<p>");
        child2.setStartTag("<p>");
        child2.setEndTag("</p>");
        child2.setTagBody("Paragraph 2");
        p1.addChildTag(child2);

        parentTag.generateHtml();

    }
}
