/**
 * 
 * The <code>DirectoryTree</code> class 
 * 
 * @author Vivian Yee
 * 		e-mail: vivian.yee@stonybrook.edu
 * 		Stonybrook ID: 112145534
 */
public class DirectoryTree {
	DirectoryNode root; //root of the tree
	static DirectoryNode cursor; //cursor that points to the node in the tree
	String pwd = "root"; //pwd helper variable
	
	/**
	 * Constructor for the DirectoryTree class
	 * 
	 * @param root
	 * 		root of the tree
	 */
	public DirectoryTree(DirectoryNode root) {
		this.root = root;
		cursor = root;
	}
	
	public String find(String y) {
		DirectoryNode x = root;
		return findhelp(y,"",x, false);
	}
	public String findhelp(String name,String find,DirectoryNode curs,boolean ree) {
		if(!ree) {
			if(curs.getLeft()!=null) {
				find = find + curs.getName() + "/";
				findhelp(name,find,curs.getLeft(),ree);
			}
			if(curs.getMiddle()!=null) {
				find = find + curs.getName() + "/";
				findhelp(name,find,curs.getMiddle(),ree);
			}
			if(curs.getRight()!=null) {
				find = find + curs.getName() + "/";
				findhelp(name,find,curs.getRight(),ree);
			}
			if(!ree) {
				if(curs.getName().equals(name)) {
					ree = true;
					return find;
				}else {
					find = "";
					return find;
				}
			}
		}else {
			return find;
		}
		return find;
	}
	
	/**
	 * Resets the cursor to the root of the tree
	 */
	public void resetCursor() { //cd /
		cursor = root;
		pwd = "root";
	}
	
	/**
	 * Changes the directory to one of the children
	 * 
	 * @param name
	 * 		name of the child to change to
	 * @throws NotADirectoryException
	 * 		if the child is a file it will throw an exception
	 * 		if the name does not exist within the three children
	 */
	public void changeDirectory(String name) throws NotADirectoryException{ // cd
		DirectoryNode x = cursor;
		boolean y = false;
		if(x.getLeft()!=null) {
			if(name.equals(x.getLeft().getName())) {
				if(x.getLeft().isFile) {
					throw new NotADirectoryException("ERROR: Cannot change directory into a file.");
				}
				pwd=pwd+"/"+x.getLeft().getName();
				cursor = x.getLeft();
				y = true;
			}
		}
		if(x.getMiddle()!=null) {
			if(name.equals(x.getMiddle().getName())) {
				if(x.getMiddle().isFile) {
					throw new NotADirectoryException("ERROR: Cannot change directory into a file.");
				}
				pwd=pwd+"/"+x.getMiddle().getName();
				cursor = x.getMiddle();
				y = true;
			}
		}
		if(x.getRight()!=null) {
			if(name.equals(x.getRight().getName())) {
				if(x.getRight().isFile) {
					throw new NotADirectoryException("ERROR: Cannot change directory into a file.");
				}
				pwd=pwd+"/"+x.getRight().getName();
				cursor = x.getRight();
				y = true;
			}
		}
		if(!y){
			throw new NotADirectoryException("ERROR: No such directory named "+name+".");
		}
	}
	
	/**
	 * prints the present working directory
	 * 
	 * @return
	 * 		returns a string of the present working directory
	 */
	public String presentWorkingDirectory() { //pwd
		return pwd;
	}
	
	/**
	 * lists the cursor and the children
	 * 
	 * @return
	 * 		returns a string of the cursor and the children of that cursor
	 */
	public String listDirectory() { //ls good????
		String list = "";
		DirectoryNode x = cursor;
		if(x.getLeft()!=null) {
			list = list +" "+ x.getLeft().getName();
		}
		if(x.getMiddle()!=null) {
			list = list +" "+ x.getMiddle().getName();
		}
		if(x.getRight()!=null) {
			list = list +" "+ x.getRight().getName();
		}
		return list;
	}
	
	/**
	 * prints the Directory Tree starting from the cursor
	 */
	public void printDirectoryTree() { //ls -R 
		DirectoryNode x = cursor;
		printTree(x,0);
		System.out.println("");
	}
	/**
	 * helper method for the printDirectoryTree method
	 * 
	 * @param x
	 * 		where the directory tree's supposed to start at
	 * @param space
	 * 		the spaces before the node when printed
	 */
	public void printTree(DirectoryNode x,int space) {
		String spaces = "";
		for(int i=0;i <space;i++) {
			spaces += "  ";
		}
		System.out.print(spaces);

		if(x.isFile) {
			System.out.println(spaces+"-"+x.getName());
		}else {
			System.out.println(spaces+"|-"+x.getName());
		}
		space = space + 1;
		if(x.getLeft()!=null) {
			printTree(x.getLeft(),space);
		}
		if(x.getMiddle()!=null) {
			printTree(x.getMiddle(),space);
		}
		if(x.getRight()!=null) {
			printTree(x.getRight(),space);
		}
		return;
	}
	
	/**
	 * makes a directory
	 * 
	 * @param name
	 * 		name of the directory
	 * @throws IllegalArgumentException
	 * @throws FullDirectoryException
	 * 		throws an exception if the parent already contains 3 children
	 * @throws NotADirectoryException
	 * 		throws an exception if the name is empty
	 */
	public void makeDirectory(String name) throws IllegalArgumentException, FullDirectoryException, NotADirectoryException{
		if(name.equals("")) {
			throw new NotADirectoryException("ERROR: Name incompatible");
		}
		DirectoryNode yeo = new DirectoryNode(name, false);
		try {
			DirectoryNode.addChild(yeo);
		}catch(FullDirectoryException e) {
			System.out.println(e);
		}
	}
	
	/**
	 * makes a file
	 * 
	 * @param name
	 * 		name of the file
	 * @throws IllegalArgumentException
	 * @throws FullDirectoryException
	 * 		throws an exception if the parent already contains 3 children
	 * @throws NotADirectoryException
	 * 		throws an exception if the name is empty
	 */
	public void makeFile(String name) throws IllegalArgumentException, FullDirectoryException, NotADirectoryException{
		if(name.equals("")) {
			throw new NotADirectoryException("ERROR: Name incompatible");
		}
		DirectoryNode yeo = new DirectoryNode(name, true);
		try {
			DirectoryNode.addChild(yeo);
		}catch(FullDirectoryException e) {
			System.out.println(e);
		}
	}
}
