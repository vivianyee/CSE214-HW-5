/**
 * 
 * The <code>FullDirectoryException</code> class 
 * 
 * @author Vivian Yee
 * 		e-mail: vivian.yee@stonybrook.edu
 * 		Stonybrook ID: 112145534
 */
public class FullDirectoryException extends Exception {
	public FullDirectoryException()
    {  //Default message
        super("Invalid element used as method parameter.");
    }

    public FullDirectoryException(String message)
    {   //Passed message
        super(message);
    }	
}