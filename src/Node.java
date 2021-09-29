
public class Node {
private String songFilePath;
private Node link;
private String songName;

public String getSongName() {
	return songName;
}

public void setSongName(String songName) {
	this.songName = songName;
}

public Node() {
	songFilePath = null;
	link = null;
}

public Node(String filepath , String songName) {
	this.songFilePath = filepath;
	this.songName = songName;
	link = null;
}

public Node(String filepath, String songName,Node link) {
	this.songFilePath = filepath;
	this.songName = songName;
	this.link = link;
}

public String getFilePath() {
	return songFilePath;
}

public void setFilePath(String filepath) {
	this.songFilePath = filepath;
}

public Node getLink() {
	return link;
}

public void setLink(Node link) {
	this.link = link;
}


}