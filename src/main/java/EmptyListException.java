public class EmptyListException extends Throwable {
    public EmptyListException() {
        super("Can not remove first element since the list is empty");
    }
}
