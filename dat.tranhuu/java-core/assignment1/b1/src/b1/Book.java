package b1;

public class Book {
    private String name;
    private long number;
    private String authorName;
    private String publisher;

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getNumber() {
        return this.number;
    }

    public void setNumber(long number) {
        this.number = number;
    }

    public String getAuthorName() {
        return this.authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getPublisher() {
        return this.publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }


    public Book(String name, long number, String authorName, String publisher) {
        this.name = name;
        this.number = number;
        this.authorName = authorName;
        this.publisher = publisher;
    }

    public Book() {
    }

    public String getBookInfor(){
        
    	return "name: " +this.name+", number: "+ this.number+", author: "+this.authorName+", publisher: "+this.publisher+"\n";
        
 
    }
}
