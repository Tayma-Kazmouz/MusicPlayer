//START OF BINARY SEARCH TREE CLASS
public class BinarySearchTree {
//initialize the attributes
	private TreeNode root;
	private int size; //to know the total number of nodes in the tree
	
	//DEFAULT CONSTRUCTOR 
	public BinarySearchTree()
	{
	root = null;
	size = 0;
	}
	//A method to create a new node in the tree which contain both a song and filepath as data
	private TreeNode createNewNode(String songname ,String filepath) {
		return new TreeNode(songname,filepath);
		}
	
		//Gets the number of nodes in the tree
	public int getSize() {
		return size;
		}
		
		//Returns the root of the Tree
	public TreeNode getRoot() {
		return root;
		}
	
	//METHOD INSERT
	//It inserts new node containing a songname and its filepath
	public boolean insert(String songname,String filepath) {
		if(root == null)//if the tree is empty
			root= createNewNode(songname,filepath); //Create a new node and assign it as a root
		else {
			//Locate the parent node
			TreeNode parent = null;
			TreeNode current = root;
		while(current != null) {
			//if the songname given as a parameter has an alphabet smaller than the current element(song)
			if(songname.compareTo(current.getElement()) < 0) {
				parent = current;
				//traverse to the left subtree
				current = current.getLeft();
			}
			//if the songname given as a parameter has an alphabet larger than the current element(song)
			else if(songname.compareTo(current.getElement()) > 0) {
				parent = current;
				//traverse to he right subtree
				current = current.getRight();
			}
			else
				return false; //Duplicate node not inserted(The same song can't be inserted twice)
		}//end of while
		
	//Create the new node and set it to the parent node.
		if(songname.compareTo(parent.getElement()) < 0)
			parent.setLeft(createNewNode(songname,filepath));
		else
			parent.setRight(createNewNode(songname,filepath));
		    size++; //increase the number of nodes
		}
	return true;
	}//end of method
	
	//METHOD SEARCHFORSONG
	public String searchforSong(String e) {
		TreeNode current = root; //Start from the root
		//keeps searching in the tree until it reaches a leaf node
		while(current != null) {
			//"e" which is the songname given as a parameter from the user has
			// an alphabet smaller than the current song element
			if(e.compareTo(current.getElement()) < 0)
				//search in the left subtree
				current = current.getLeft();
			//"e" which is the songname given as a parameter from the user has
			// an alphabet larger than the current song element
			else if(e.compareTo(current.getElement()) > 0)
				//search in the right subtree
				current = current.getRight();
			else
				return "..Song is found..";
		}//end of while
		return "..Song is not found..";
	}//end of method
	//METHOD SEARCH FOR FILE PATH
	public String searchForFilePath(String e) {
		TreeNode current = root; //Start from the root
		while(current != null) {
			if(e.compareTo(current.getElement()) < 0)
				current = current.getLeft();
			else if(e.compareTo(current.getElement()) > 0)
				current = current.getRight();
			else
				return current.getFilepath();
		}
		return "...FilePath is not found...";
	}//end of method
	

}//end of class
