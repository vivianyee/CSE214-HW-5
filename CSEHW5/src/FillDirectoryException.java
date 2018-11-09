/**
 * 
 * The <code>FillDirectoryException</code> class 
 * 
 * @author Vivian Yee
 * 		e-mail: vivian.yee@stonybrook.edu
 * 		Stonybrook ID: 112145534
 */
public class FillDirectoryException extends Exception {
	public FillDirectoryException()
    {  //Default message
        super("Invalid element used as method parameter.");
    }

    public FillDirectoryException(String message)
    {   //Passed message
        super(message);
    }	
}