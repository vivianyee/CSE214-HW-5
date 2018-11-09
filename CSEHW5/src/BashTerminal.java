import java.util.Scanner;
/**
 * 
 * The <code>BashTerminal</code> class 
 * 
 * @author Vivian Yee
 * 		e-mail: vivian.yee@stonybrook.edu
 * 		Stonybrook ID: 112145534
 */
public class BashTerminal {
	static DirectoryTree tree = new DirectoryTree(new DirectoryNode("root",false)); //initializes Directory tree
	
	/**
	 * Main method of BashTerminal
	 * 
	 * @param args
	 * @throws NotADirectoryException
	 * @throws IllegalArgumentException
	 * @throws FullDirectoryException
	 */
	public static void main(String[] args) throws NotADirectoryException, IllegalArgumentException, FullDirectoryException {
		System.out.println("Starting bash terminal");
		Scanner scan = new Scanner(System.in);
		while(true) {
			System.out.println("[112145534@dude]: $ ");
			String x = scan.nextLine();
			if(x.equals("pwd")) {
				System.out.println(tree.presentWorkingDirectory());
			}else if(x.equals("ls")) {
				System.out.println(tree.listDirectory());
			}else if(x.equals("ls -R")) {
				tree.printDirectoryTree();
			}else if(x.equals("cd /")) {
				tree.resetCursor();
			}else if(x.startsWith("cd")) {
				x = x.replaceFirst("cd ", "");
				try {
					tree.changeDirectory(x);
				}catch(NotADirectoryException e) {
					System.out.println(e);
				}
			}else if(x.startsWith("mkdir")) {
				x = x.replaceFirst("mkdir ", "");
				try {
					tree.makeDirectory(x);
				}catch(NotADirectoryException e) {
					System.out.println(e);
				}
			}else if(x.startsWith("touch")) {
				x = x.replaceFirst("touch ", "");
				try {
					tree.makeFile(x);
				}catch(NotADirectoryException e) {
					System.out.println(e);
				}
			}else if(x.equals("exit")) {
				System.out.println("Program terminating normally...");
				System.exit(0);
			}else if(x.startsWith("find")) {
				x = x.replaceFirst("touch", "");
				System.out.println(tree.find(x));
			}
		}
	}
}
