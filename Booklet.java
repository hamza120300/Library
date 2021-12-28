package library;

public class Booklet extends Readable {
    public Booklet(String t, String fn, String ln, int pages) {

        title=t;
        authorFN=fn;
        autherLN=ln;
        numOfPages=pages;
    }

    @Override
    boolean isOverPeriod() {
           if (getPeriod()>12)
            return true;
        else
            return false;
    }
}
