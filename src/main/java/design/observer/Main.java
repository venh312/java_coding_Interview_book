package design.observer;

public class Main {
    public static void main(String[] args) {
        Feed feed = new Feed();
        feed.registerObserver(new NYTimes());
        feed.registerObserver(new Guardian());
        feed.notifyObserver("show me the money!");
        //feed.notifyObserver("queen is back!");
    }
}
