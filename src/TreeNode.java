
public class TreeNode {

	private String element;
	private String filepath;
	private TreeNode left;
	private TreeNode right;
	
	public TreeNode(String newElement,String filepath)
	{
	this.filepath = filepath;
	element = newElement;
	left = null;
	right = null;
	}

	public String getElement() {
		return element;
	}

	public void setElement(String element) {
		this.element = element;
	}

	public TreeNode getLeft() {
		return left;
	}

	public void setLeft(TreeNode left) {
		this.left = left;
	}

	public TreeNode getRight() {
		return right;
	}

	public void setRight(TreeNode right) {
		this.right = right;
	}

	public String getFilepath() {
		return filepath;
	}

	public void setFilepath(String filepath) {
		this.filepath = filepath;
	}
	
	
	
	
	
}
