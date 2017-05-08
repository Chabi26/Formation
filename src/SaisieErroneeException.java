/**
 * Created by manu on 08/05/2017.
 */
public class SaisieErroneeException extends Exception {

    public SaisieErroneeException() {
        super();
    }

    public SaisieErroneeException(String s) {
        super(s);
    }

    public SaisieErroneeException(String s, Throwable e) {
        super(s, e);
    }
}
