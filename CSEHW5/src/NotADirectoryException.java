/**
 * 
 * The <code>NotADirectoryException</code> class 
 * 
 * @author Vivian Yee
 * 		e-mail: vivian.yee@stonybrook.edu
 * 		Stonybrook ID: 112145534
 */
public class NotADirectoryException extends Exception {
	public NotADirectoryException()
    {  //Default message
        super("Invalid element used as method parameter.");
    }

    public NotADirectoryException(String message)
    {   //Passed message
        super(message);
    }	
}