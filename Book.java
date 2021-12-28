package library;

public class Book extends Readable {

    public Book(String t, String fn, String ln, int pages) {

        title=t;
        authorFN=fn;
        autherLN=ln;
        numOfPages=pages;
    }

    @Override
    boolean isOverPeriod() {
        if (getPeriod()>20)
            return true;
        else
            return false;
    }
}
