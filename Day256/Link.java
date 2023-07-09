package Day256;

public class Link {

    public String bookName;
    public int millionSold;

    public Link next;

    public Link(String bookName, int millionSold) {
        this.bookName = bookName;
        this.millionSold = millionSold;
    }

    public void display() {
        System.out.println(bookName + ": " + millionSold + ",000,000 sold");
    }

    public String ToString() {
        return bookName;
    }


}

class LinkList {
    public Link firstLink;
    LinkList() {
        firstLink = null;
    }

    public boolean isEmpty() {
        return firstLink == null;
    }

    public void insertFirstLink(String bookName, int millionSold) {
        Link newLink = new Link(bookName, millionSold);
        newLink.next = firstLink;
        firstLink = newLink;
    }

    public Link removeFirst() {
        Link linkReference = firstLink;
        if (!isEmpty()) {
            firstLink = firstLink.next;
        } else {
            System.out.println("empty LinkedList");
        }
        return linkReference;
    }

    public void display() {
        Link theLink = firstLink;
        while (theLink != null) {
            theLink.display();
            System.out.println("Next Link: " + theLink.next);
            theLink = theLink.next;
            System.out.println();
        }
    }

    public Link find(String bookName) {
        Link theLink = firstLink;
        if (!isEmpty()) {
            while (theLink.bookName != bookName) {
                if (theLink.next == null) {
                    return null;
                } else {
                    theLink = theLink.next;
                }
            }
        } else {
            System.out.println("Empty LinkedList");
        }
        return theLink;
    }

    public Link removeLink(String bookName) {
        Link currentLink = firstLink;
        Link previousLink = firstLink;

        while (currentLink.bookName != bookName) {
            if (currentLink.next == null) {
                return null;
            } else {
                previousLink = currentLink;
                currentLink = currentLink.next;
            }
        }
        if (currentLink == firstLink) {
            firstLink = firstLink.next;
        } else {
            previousLink.next = currentLink.next;
        }
        return currentLink;
    }

    public static void main(String[] args) {
        LinkList list = new LinkList();
        list.insertFirstLink("Don Quixote", 500);
        list.insertFirstLink("A tale of Two Cities", 200);
        list.insertFirstLink("The lord of the Rings", 150);
        list.insertFirstLink("Harry Porter", 108);
        list.display();
    }
}
