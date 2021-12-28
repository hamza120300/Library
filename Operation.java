package library;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Operation {
    public static ArrayList<Readable> list = new ArrayList<>();

    public static void readFile(String fileName) throws FileNotFoundException {
        File f = new File(fileName);
        Scanner sc = new Scanner(f);
        list.clear();
        while (sc.hasNext()) {
            String type = sc.next();
            int numOf_pages = sc.nextInt();
            String fn = sc.next();
            String ln = sc.next();
            String title = sc.nextLine();

            if (type.equalsIgnoreCase("book")) {
                list.add(new Book(title, fn, ln, numOf_pages));
            } else if (type.equalsIgnoreCase("magazine")) {
                list.add(new Magazine(title, fn, ln, numOf_pages));
            } else if (type.equalsIgnoreCase("booklet")) {
                list.add(new Booklet(title, fn, ln, numOf_pages));
            }
        }
        sc.close();
    }

    public void add(String type, String fn, String ln, String title, int p) {
        if (type.equals("book")) {
            list.add(new Book(title, fn, ln, p));
        } else if (type.equalsIgnoreCase("magazine")) {
            list.add(new Magazine(title, fn, ln, p));
            System.out.println("successfuly added");
        } else if (type.equalsIgnoreCase("booklet")) {
            list.add(new Booklet(title, fn, ln, p));
            System.out.println("successfuly added");
        }
        else {
            System.out.println("Enter correct type");
        }
    }

    public void writeFile(String fileName) {
        File F = new File(fileName);
        try {
            PrintWriter pw = new PrintWriter(F);
            for (int i = 0; i < list.size(); i++) {
                Readable r = list.get(i);
                if (r instanceof Book) {
                    pw.print("book ");
                    pw.println(r.getNumOfPages() + " " + r.getAuthorFN() + " " + r.getAutherLN() + " " + r.getTitle());
                } else if (r instanceof Magazine) {
                    pw.print("magazine ");
                    pw.println(r.getNumOfPages() + " " + r.getAuthorFN() + " " + r.getAutherLN() + " " + r.getTitle());
                } else if (r instanceof Booklet) {
                    pw.print("booklet ");
                    pw.println(r.getNumOfPages() + " " + r.getAuthorFN() + " " + r.getAutherLN() + " " + r.getTitle());
                }
            }

            pw.close();
        } catch (FileNotFoundException e) {
          System.out.println("Wrong *********");
        }
    }

    public void delete(String title) {
        for (int i = 0; i < list.size(); i++) {
            Readable r = list.get(i);
            if (r.getTitle().equalsIgnoreCase(title)) {
                list.remove(i);
                System.out.println(title+"   is removed");
                break;
            }
            else System.out.println(title+"   is uncorrect title ");
            break;
        }
    }


    public void search(String k) {
        for (int i = 0; i < list.size(); i++) {
            Readable r = list.get(i);
            if (r.getTitle().contains(k)) {
                System.out.println(r);
            }
        }
    }

    public void Modify(String k, String t , String fn , String ln , int p) {
        for (int i = 0; i < list.size(); i++) {
            Readable r = list.get(i);
            if (r.getTitle().contains(k)) {
                r.setTitle(t);
                r.setAuthorFN(fn);
                r.setAutherLN(ln);
                r.setNumOfPages(p);
                break;
            }
        }
    }

public void Borrow(String title) {
        for (int i = 0; i < list.size(); i++) {
            Readable r = list.get(i);
            if (r.getTitle().trim().equals(title)&&r.borrowed==false) {
                Scanner sc = new Scanner(System.in);
                System.out.println("time");
                System.out.println("enter year");
                int d1=sc.nextInt();
                System.out.println("enter month");
                int m1=sc.nextInt();
                System.out.println("enter the day");
                int y1=sc.nextInt();
                System.out.println("enter your id");
                int id=sc.nextInt();
                r.setId(id);
                System.out.println("enter your name");
                sc.nextLine();
                String name=sc.nextLine();
                r.setName(name);
                Date x=new Date(d1,m1,y1);
                r.issueDate=x;
                r.borrowed=true;
                System.out.println("Borrowed successfully");
            }
        }
    }
    public void Return(String title) {
        for (int i = 0; i < list.size(); i++) {
            Readable r = list.get(i);
            if (r.getTitle().trim().equals(title)) {

                Scanner sc = new Scanner(System.in);
                System.out.println("time");
                System.out.println("enter year");
                int d2 = sc.nextInt();
                System.out.println("enter month");
                int m2 = sc.nextInt();
                System.out.println("enter the day");
                int y2 = sc.nextInt();
                Date y = new Date(d2, m2, y2);
                r.returnDate=y;
                r.borrowed=false;
                System.out.println("Returned successfully");
            }

        }
    }
    
   public void overPeriod() {
        for (int i = 0; i < list.size(); i++) {
            Readable r = list.get(i);
            if (r.isOverPeriod()) {
                System.out.println(r.getPeriod());
                System.out.println("  you have a fine 20$");

            }
        }
    }
   
    public void displayBorrowed() {
        for (int i = 0; i < list.size(); i++) {
            Readable r = list.get(i);
            if (r.isBorrowed()) {
                System.out.println(r);
            }
        }
    }

    int Pares() {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            if (sc.hasNextInt()) {
                return sc.nextInt();
            } else {
                sc.next();
            }
        }

        return 0;
    }

    public void displayAvailable() {
        for (int i = 0; i < list.size(); i++) {
            Readable r = list.get(i);
            if (!r.isBorrowed()) {
                System.out.println(r);
            }
        }
    }


    public static void menue() {
        System.out.println("Press 1 to Add, modify and delete publication details.");
        System.out.println("Press 2 to Search feature for finding book availability in library stock");
        System.out.println("Press 3 to Display list of available publications");
        System.out.println("Press 4 to Borrow a publication to a student");
        System.out.println("press 5 to display list of borrowed publications");
        System.out.println("press 6 to Return");
        System.out.println("press 7 to display list of  over-period borrowed publications");
        System.out.println("press 00 to Exit");
    }

    public static void menue2() {
        System.out.println("Press 1 to Add publication details.");
        System.out.println("Press 2 modify publication details.");
        System.out.println("Press 3 to delete publication details.");
    }

    
    public static void studentMenue()
    {
        System.out.println("Press 1 to Search feature for finding book availability in library stock");
        System.out.println("Press 2 to Display list of available publications");
        System.out.println("Press 3 to to Borrow a publication to a student");
        System.out.println("Press 4 to display list of borrowed publications");
        System.out.println("press 00 to Exit");

    }
}
