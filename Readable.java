package library;

import java.util.Date;

public abstract class Readable {
    String title;
    String authorFN;
    String autherLN;
    int numOfPages;
    boolean borrowed;
    Date issueDate=new Date();
    Date returnDate=new Date();
    int id;
    String name;


    int getPeriod()
    {
        long d1=issueDate.getTime();
        long d2=returnDate.getTime();
        long diff=d2-d1;
        return (int) (diff/(24*60*60*1000));
    }
    abstract boolean isOverPeriod();

    void Borrow(Date d1,Date d2)
    {
        issueDate=d1;
        returnDate=d2;
        borrowed=true;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthorFN(String authorFN) {
        this.authorFN = authorFN;
    }

    public void setAutherLN(String autherLN) {
        this.autherLN = autherLN;
    }

    public void setNumOfPages(int numOfPages) {
        this.numOfPages = numOfPages;
    }

    public void setBorrowed(boolean borrowed) {
        this.borrowed = borrowed;
    }

    public void setIssueDate(Date issueDate) {
        this.issueDate = issueDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Readable{" +
                "title='" + title + '\'' +
                ", authorFN='" + authorFN + '\'' +
                ", autherLN='" + autherLN + '\'' +
                ", numOfPages=" + numOfPages +
                ", isBorrowed=" + borrowed +
                '}';
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthorFN() {
        return authorFN;
    }

    public String getAutherLN() {
        return autherLN;
    }

    public int getNumOfPages() {
        return numOfPages;
    }

    public boolean isBorrowed() {
        return borrowed;
    }

    public Date getIssueDate() {
        return issueDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }
}
