package Minitest.minitest2.Book;

import java.util.Scanner;

public class Book {
    private int bookCode;
    private String name;
    private int price;
    private String author;

    public int getBookCode() {
        return bookCode;
    }

    public void setBookCode(int bookCode) {
        this.bookCode = bookCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Book() {
    }

    public Book(int bookCode, String name, int price, String author) {
        this.bookCode = bookCode;
        this.name = name;
        this.price = price;
        this.author = author;
    }

}

class ProgrammingBook extends Book{
    private String language;
    private String framework;

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getFramework() {
        return framework;
    }

    public void setFramework(String framework) {
        this.framework = framework;
    }

    public ProgrammingBook() {
    }

    public ProgrammingBook(String language, String framework) {
        this.language = language;
        this.framework = framework;
    }

    public ProgrammingBook(int bookCode, String name, int price, String author, String language, String framework) {
        super(bookCode, name, price, author);
        this.language = language;
        this.framework = framework;
    }
}

class FictionBook extends Book{
    private String category;

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public FictionBook() {
    }

    public FictionBook(int bookCode, String name, int price, String author, String category) {
        super(bookCode, name, price, author);
        this.category = category;
    }
}

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BookManager bookManager = new BookManager();
        int choice = -1;
        while (choice != 0) {
            System.out.println("Menu");
            System.out.println("1. Display");
            System.out.println("2. Sum price books");
            System.out.println("3. Filter language");
            System.out.println("4. Filter category");
            System.out.println("5. Filter price");
            System.out.println("0. Exit");
            System.out.println("Enter your choice: ");
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    bookManager.display();
                    break;
                case 2:
                    bookManager.sumPriceBook();
                    break;
                case 3:
                    bookManager.filterLanguage(scanner);
                    break;
                case 4:
                    bookManager.filterCategory(scanner);
                    break;
                case 5:
                    bookManager.filterPrice(scanner);
                    break;
            }
        }
    }
}

class BookManager{
    Book programmingBook1 = new ProgrammingBook(1, "Java Book",
            100, "Thanh", "Java", "Spring");
    Book programmingBook2 = new ProgrammingBook(2, "C Book",
            10, "Thanh", "C", "Spring");
    Book programmingBook3 = new ProgrammingBook(3, "Python Book",
            300, "Thanh", "Python", "Spring");
    Book programmingBook4 = new ProgrammingBook(4, "JS Book",
            20, "Thanh", "JavaScript", "Spring");
    Book programmingBook5 = new ProgrammingBook(5, "PHP Book",
            19, "Thanh", "PHP", "Spring");

    Book fictionBook1 = new FictionBook(6, "Spider Man", 30,
            "Thanh", "superhero");
    Book fictionBook2 = new FictionBook(7, "Bat Man", 40,
            "Thanh", "superhero");
    Book fictionBook3 = new FictionBook(8, "Super Man", 50,
            "Thanh", "Viễn tưởng 1");
    Book fictionBook4 = new FictionBook(9, "Super Girl", 340,
            "Thanh", "Viễn tưởng 1");
    Book fictionBook5 = new FictionBook(10, "Iron Man", 60,
            "Thanh", "superhero");
    Book[] books = {programmingBook1, programmingBook2, programmingBook3, programmingBook4, programmingBook5,
            fictionBook1, fictionBook2, fictionBook3, fictionBook4, fictionBook5};

    public void display() {
        System.out.printf("%-20s%-20s%-20s%-20s%-20s%-20s%-20s%s%n", "Book No", "BookCode", "Name", "Price", "Author",
                "language", "framework", "category");
        for (int i = 0; i < books.length; i++) {

            if (books[i] instanceof ProgrammingBook) {
                System.out.printf("%-20d%-20d%-20s%-20d%-20s%-20s%-20s%s%n", i + 1, books[i].getBookCode(),
                        books[i].getName(), books[i].getPrice(), books[i].getAuthor(),
                        ((ProgrammingBook) books[i]).getLanguage(), ((ProgrammingBook) books[i]).getFramework(), "");
            }
            if (books[i] instanceof FictionBook) {
                System.out.printf("%-20d%-20d%-20s%-20d%-20s%-20s%-20s%s%n", i + 1, books[i].getBookCode(),
                        books[i].getName(), books[i].getPrice(), books[i].getAuthor(), "", ""
                        , ((FictionBook) books[i]).getCategory());
            }
        }
    }

    public void sumPriceBook() {
        int sumPriceBook = 0;

        for (Book book : books) {
            sumPriceBook += book.getPrice();
        }
        System.out.println("Sum of price book: "+sumPriceBook);
    }

    public void filterLanguage(Scanner scanner){
        int count = 0;
        System.out.println("Enter a language: ");
        String language = scanner.nextLine();
        for (Book book : books) {
            if (book instanceof ProgrammingBook) {
                if (((ProgrammingBook) book).getLanguage().equals(language)) {
                    count++;
                }
            }
        }
        System.out.println("There are "+count+" books with "+language+" language");
    }

    public void filterCategory(Scanner scanner){
        int count = 0;
        System.out.println("Enter a category: ");
        String category = scanner.nextLine();
        for (Book book : books) {
            if (book instanceof FictionBook) {
                if (((FictionBook) book).getCategory().equals(category)) {
                    count++;
                }
            }
        }
        System.out.println("There are "+count+" books with "+category+" category");
    }

    public void filterPrice(Scanner scanner){
        int count = 0;
        System.out.println("Enter price you need to filler: ");
        int price = Integer.parseInt(scanner.nextLine());
        for (Book book : books) {
            if (book.getPrice() < price) {
                count++;
            }
        }
        System.out.println("There are "+count+" books with price less than "+price);
    }
}