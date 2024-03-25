package ra.business;

import java.util.Scanner;

public class Book {
    private int bookId;
    private String bookName;
    private String author;
    private String descriptions;
    private double importPrice;
    private double exportPrice;
    private float interest;
    private boolean bookStatus;

    public Book() {
    }

    public Book(int bookId, String bookName, String author, String descriptions, double importPrice, boolean bookStatus) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.author = author;
        this.descriptions = descriptions;
        this.importPrice = importPrice;
        this.bookStatus = bookStatus;
        this.exportPrice = importPrice * 1.2;
        this.interest = (float) (exportPrice - importPrice);
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    public double getImportPrice() {
        return importPrice;
    }

    public void setImportPrice(double importPrice) {
        this.importPrice = importPrice;
    }

    public double getExportPrice() {
        return exportPrice;
    }

    public void setExportPrice(double exportPrice) {
        this.exportPrice = exportPrice;
    }

    public float getInterest() {
        return interest;
    }

    public void setInterest(float interest) {
        this.interest = interest;
    }

    public boolean isBookStatus() {
        return bookStatus;
    }

    public void setBookStatus(boolean bookStatus) {
        this.bookStatus = bookStatus;
    }

    public void inputData(Scanner scanner) {

        do {
            System.out.println("Enter book name: ");
            this.bookName = scanner.nextLine();
        } while (this.bookName.isEmpty());

        do {
            System.out.println("Enter author: ");
            this.author = scanner.nextLine();
        } while (this.author.isEmpty());

        do {
            System.out.println("Enter descriptions: ");
            this.descriptions = scanner.nextLine();
        } while (this.descriptions.isEmpty());

        System.out.println("Enter import price: ");
        double importPrice;
        while (true) {
            importPrice = Double.parseDouble(scanner.nextLine());
            if (importPrice > 0) {
                break;
            }
            System.out.println("Invalid value. Please enter again:");
        }
        this.importPrice = importPrice;
        this.exportPrice = importPrice * 1.2;
        this.interest = (float) (exportPrice - importPrice);
        System.out.println("Enter book status: ");
        Boolean status;
        while (true) {
            String statusText = scanner.nextLine();
            if (statusText.matches("true|false")) {
                this.bookStatus = Boolean.parseBoolean(statusText);
                break;
            } else {
                System.out.println("Invalid status. Please enter again: ");
            }
        }
    }

    public void displayData() {
        System.out.println("-".repeat(50));
        System.out.println("Book ID: " + bookId);
        System.out.println("Book name: " + bookName);
        System.out.println("Author: " + author);
        System.out.println("Descriptions: " + descriptions);
        System.out.println("Import price: " + importPrice);
        System.out.println("Export price: " + exportPrice);
        System.out.println("Interest: " + interest);
        System.out.println("Book status: " + bookStatus);
        System.out.println("-".repeat(50));
    }
}
