package ra.business;

import java.util.Arrays;
import java.util.Scanner;

public class BookManagement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BookManagement bookManagement = new BookManagement();
        System.out.println("Welcome to Book Management System.");


        while (true) {
            System.out.println("Please choose the function you want to perform:");
            System.out.println("1. Add books.");
            System.out.println("2. Display all books.");
            System.out.println("3. Sort by interest.");
            System.out.println("4. Delete by bookId");
            System.out.println("5. Find by keyword");
            System.out.println("6. Update by bookId");
            System.out.println("7. Exit.");
            byte choice = Byte.parseByte(scanner.nextLine());
            switch (choice) {
                case 1:
                    bookManagement.addBooks(scanner);
                    break;
                case 2:
                    bookManagement.displayAllBooks();
                    break;
                case 3:
                    bookManagement.sortByInterest();
                    bookManagement.displayAllBooks();
                    break;
                case 4:
                    bookManagement.deleteByBookId(scanner);
                    break;
                case 5:
                    bookManagement.searchByKeyword(scanner);
                    break;
                case 6:
                    bookManagement.updateByBookId(scanner);
                    break;
                case 7:
                    System.out.println("Thank you for using the system.");
                    return;
                default:
                    System.out.println("Invalid choice. Please enter again.");
            }
        }
    }
    Book[] books = new Book[100];

    public void addBooks(Scanner scanner) {
        System.out.println("Enter number of books: ");
        byte counts;
        while (true) {
            counts = Byte.parseByte(scanner.nextLine());
            if (counts > 0) {
                break;
            } else {
                System.out.println("Invalid number of books. Please enter again: ");
            }
        }

        while (counts-- > 0) {
            System.out.println("Enter book information: ");
            for (int i = 0; i < books.length; i++) {
                if (books[i] == null) {
                    Book book = new Book();
                    book.setBookId(i + 1);
                    book.inputData(scanner);
                    books[i] = book;
                    break;
                } else if (i == books.length - 1) {
                    System.out.println("Book list is full.");
                }
            }
        }
    }

    public void displayAllBooks() {
        System.out.println("Book list:");
        for (Book book : books) {
            if (book != null) {
                book.displayData();
            }
        }
        System.out.println("End of book list.");
    }

    public void sortByInterest() {
        Arrays.sort(books, (book1, book2) -> {
            if (book1 == null && book2 == null) {
                return 0;
            }
            if (book1 == null) {
                return -1;
            }
            if (book2 == null) {
                return 1;
            }
            return (int) (book1.getInterest() - book2.getInterest());
        });
    }

    public void deleteByBookId(Scanner scanner) {
        int bookId;
        System.out.println("Enter book id to delete: ");
        while (true) {
            bookId = Integer.parseInt(scanner.nextLine());
            if (bookId > 0) {
                break;
            } else {
                System.out.println("Invalid book id. Please enter again: ");
            }
        }
        for (int i = 0; i < books.length; i++) {
            if (books[i] != null && books[i].getBookId() == bookId) {
                books[i] = null;
                break;
            }
        }
    }

    public void searchByKeyword(Scanner scanner) {
        String keyword;
        System.out.println("Enter keyword to search: ");
        keyword = scanner.nextLine();
        System.out.println("Search result:");
        for (Book book : books) {
            if (book != null &&
                    (book.getBookName().contains(keyword) ||
                            book.getDescriptions().contains(keyword))) {
                book.displayData();
            }
        }
        System.out.println("End of search result.");
    }

    public void updateByBookId(Scanner scanner) {
        System.out.println("Enter book id to update: ");
        int bookId;
        while (true) {
            bookId = Integer.parseInt(scanner.nextLine());
            if (bookId > 0) {
                break;
            } else {
                System.out.println("Invalid book id. Please enter again: ");
            }
        }

        for (Book book : books) {
            if (book != null && book.getBookId() == bookId) {
                book.inputData(scanner);
                break;
            }
        }
    }
}
