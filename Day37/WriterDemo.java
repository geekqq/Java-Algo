package Day37;

public class WriterDemo {
    public static void main(String[] args) {
        Book book = new Book();
        book.setName("Web全栈开发进阶之路");
        book.setPrice(79);

        Writer writer = new Writer("Stone", 38, book);
        System.out.println("定价为：" + book.getPrice());
        writer.getBook().setPrice(59);
        System.out.println("促销价为：" + book.getPrice());
        System.out.println(writer.getBook());
    }
}
