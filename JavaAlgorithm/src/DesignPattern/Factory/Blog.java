package DesignPattern.Factory;

public class Blog extends Website {

    @Override
    public void createWebsite(){
        pages.add(new PostPage());
        pages.add(new About());
        pages.add(new ContactPage());
    }
}
