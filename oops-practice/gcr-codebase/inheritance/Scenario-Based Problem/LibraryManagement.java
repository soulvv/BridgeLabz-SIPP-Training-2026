class Book {
    private String title;
    private int publicationYear;

    public Book(String title, int publicationYear) {
        this.title = title;
        this.publicationYear = publicationYear;
    }

    public String getTitle() { return title; }
    public int getPublicationYear() { return publicationYear; }

    public void displayInfo() {
        System.out.println("Book Title: " + title);
        System.out.println("Publication Year: " + publicationYear);
    }
}

class Author extends Book {
    private String name;
    private String bio;

    public Author(String title, int publicationYear, String name, String bio) {
        super(title, publicationYear);
        this.name = name;
        this.bio = bio;
    }

    public String getName() { return name; }
    public String getBio() { return bio; }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Author Name: " + name);
        System.out.println("Author Bio: " + bio);
    }
}

public class LibraryManagement {
    public static void main(String[] args) {
        // As per the requirement: "Model a Book system where Book is the superclass, and Author is a subclass."
        // (Note: In standard object-oriented design, an Author "has a" Book or Book "has an" Author, 
        // rather than Author "is a" Book. This implementation strictly follows the provided prompt instructions).
        
        Author author = new Author("The Great Gatsby", 1925, "F. Scott Fitzgerald", "American novelist and essayist");
        System.out.println("--- Library Info ---");
        author.displayInfo();
    }
}
