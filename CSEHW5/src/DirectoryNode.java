/**
 * 
 * The <code>DirectoryNode</code> class 
 * 
 * @author Vivian Yee
 * 		e-mail: vivian.yee@stonybrook.edu
 * 		Stonybrook ID: 112145534
 */	
public class DirectoryNode {
	private DirectoryNode left = null; //left child
	private DirectoryNode middle = null; //middle child
	private DirectoryNode right = null; //right child
	private String name; //name of the node
	boolean isFile; //if the node is a file or not
	
	/**
	 * Constructor for DirectoryNode class
	 * @param name
	 * 		name of the node
	 * @param isFile
	 * 		if the node is a file or not
	 */
	public DirectoryNode(String name, boolean isFile) {
		this.name = name;
		this.isFile = isFile;
	}
	
	/**
	 * adds a child to this node
	 * @param newChild
	 * 		the child that is being added to the node
	 * @throws FullDirectoryException
	 * 		throws exception if the node already has 3 children
	 * @throws NotADirectoryException
	 * 		throws exception if the node is a file
	 */
	public static void addChild(DirectoryNode newChild) throws FullDirectoryException, NotADirectoryException{
		if(DirectoryTree.cursor.isFile) {
			throw new NotADirectoryException("ERROR: Current node is a file");
		}
		if(DirectoryTree.cursor.getLeft()==null) {
			DirectoryTree.cursor.left=newChild;
		}else if(DirectoryTree.cursor.getMiddle()==null) {
			DirectoryTree.cursor.middle=newChild;
		}else if(DirectoryTree.cursor.getRight()==null) {
			DirectoryTree.cursor.right=newChild;
		}else {
			throw new FullDirectoryException("ERROR: Present directory is full.");
		}
	}
	
	/**
	 * getter for name
	 * @return
	 * 		name
	 */
	public String getName() {
		return name;
	}
	/**
	 * setter for name
	 * @param name
	 * 		name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * getter for left child
	 * @return
	 * 		left
	 */
	public DirectoryNode getLeft() {
		return left;
	}
	
	/**
	 * getter for middle child
	 * @return
	 * 		middle
	 */
	public DirectoryNode getMiddle() {
		return middle;
	}

	/**
	 * getter for right child
	 * @return
	 * 		right
	 */
	public DirectoryNode getRight() {
		return right;
	}
}
