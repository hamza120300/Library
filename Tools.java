package library;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Tools {

    public static void MyMain() throws FileNotFoundException {
        try {
            Scanner input = new Scanner(System.in);
            Operation.list = new ArrayList<Readable>();
            Operation p = new Operation();
            Operation.readFile("D:\\book.txt");
            int ans;
            String serveBook;

            do {
                System.out.println("To student menue press 1 \n" + "To admin menue Press 2");
                ans = input.nextInt();
                if (ans ==2) {
                    System.out.println("Enter the password");
                    serveBook = input.next();
                    if(serveBook.equals("khaled") ) {
                        Operation.menue();
                        ans = input.nextInt();
                        switch (ans) {
                            case 1:
                                Operation.menue2();
                                ans = input.nextInt();
                                switch (ans) {
                                    case 1:
                                        System.out.println("Enter type name");
                                        serveBook = input.next();
                                        if (serveBook.equalsIgnoreCase("book") || serveBook.equalsIgnoreCase("booklet") || serveBook.equalsIgnoreCase("magazine")) {
                                            String type = serveBook;
                                            System.out.println("Enter Author First name");
                                            String fn = input.next();
                                            System.out.println("Enter Author Last name");
                                            String ln = input.next();
                                            System.out.println("Enter title");
                                            String title = input.next();
                                            System.out.println("Enter num of pages");
                                            int pa = input.nextInt();
                                            p.add(type, fn, ln, title, pa);
                                            serveBook = "D:\\book.txt";
                                            p.writeFile(serveBook);
                                        }
                                        else break;
                                        break;
                                    case 2:
                                        System.out.println("Enter old publication title");
                                        String key = input.next();
                                        System.out.println("Enter new title");
                                        String t = input.next();
                                        System.out.println("Enter new author first name");
                                        String fn = input.next();
                                        System.out.println("Enter new author last name");
                                        String ln = input.next();
                                        System.out.println("Enter number of pages");
                                        int pa =input.nextInt();
                                        p.Modify(key , t , fn , ln , pa );
                                        serveBook = "D:\\book.txt";
                                        p.writeFile("D:\\book.txt");
                                        break;
                                    case 3:
                                        System.out.println("Enter book title");
                                        serveBook = input.next();
                                        p.delete(serveBook);
                                        serveBook = "D:\\book.txt";
                                        p.writeFile(serveBook);
                                        break;
                                    default:
                                        System.out.println("enter correct number");
                                        break;
                                }
                                break;
                            case 2:
                                System.out.println("Enter title of publication");
                                serveBook = input.next();
                                p.search(serveBook);
                                break;
                            case 3:
                                p.displayAvailable();
                                break;
                            case 4:
                                System.out.println("Enter the book title .");
                                serveBook = input.next();
                                input.nextLine();
                                p.Borrow(serveBook);
                                break;
                            case 5:
                                p.displayBorrowed();
                                break;
                            case 6:
                                System.out.println("Enter the book title .");
                                serveBook = input.next();
                                p.Return(serveBook);
                                break;
                            case 7:
                               p.overPeriod();
                               break;
                            case 00:
                                break;
                            default:
                                System.out.println("Enter correct number");
                                break;
                        }
                    }
                    else
                        {
                            System.out.println("Enter correct password");
                        break;
                        }
                }

                else if (ans ==1)
                {
                    Operation.studentMenue();
                    ans = input.nextInt();
                    switch (ans)
                    {
                        case 1:
                            System.out.println("Enter title of publication");
                            serveBook = input.next();
                            p.search(serveBook);
                            break;
                        case 2:
                            p.displayAvailable();
                            break;
                        case 3:
                            System.out.println("Enter the book title .");
                            serveBook = input.next();
                            input.nextLine();
                            p.Borrow(serveBook);
                            break;
                        case 4:
                            p.displayBorrowed();
                            break;
                        case 00:
                            break;
                        default:
                            System.out.println("Enter correct number");
                            break;
                    }
                }
            } while (ans != 00 );
        } catch (Exception x) {
            System.out.println("Enter as shown");
        }
    }
}
