//START OF QUEUE CLASS
public class Queue {
//initialize the attributes of the class
private Node front;
private Node rear;
	
//return back the song name of type STRING
public String getsongName() {
	return front.getSongName();
	
}
//checks if the queue is empty
public boolean isEmpty() {
	return(front == null);
}
//sets back the front and rear to null making the queue empty again
public void initializeQueue() {
	front = null;
	rear = null;
}
//returns back the filepath at the beginning of the queue of type STRING
public String getFront() {
	assert(front != null);
	return front.getFilePath(); 
}
//returns back the filepath at the end of the queue of type STRING
public String getRear() {
	assert(rear != null);
	return rear.getFilePath(); 
}

public void addSong(String filepath, String songName) {
	Node a = new Node(filepath , songName); //Create a new node containing both song name and filepath
	if(isEmpty()) //empty playlist
		front = rear = a;
	else {
		//set the song from the back of the playlist
		rear.setLink(a);
		rear = rear.getLink();
	}
}
//it's not actually deleting the song but rather taking the same node from the front and inserting
//it back again to the queue from the back
public void deleteSong() {
	if(isEmpty())
		System.out.println("Queue is empty!");
	else {
	addSong(getFront() ,getsongName()); // adds the front node to the back of the queue
		front = front.getLink();
		
	}
}
//shows all the nodes (song names) found in the queue
public void viewPlayList() {
	if(!isEmpty()) {
		Node c = new Node();
		c = front;
		while(c != null) {
			System.out.println(c.getSongName());
			c=c.getLink();
		}
	}
}
}
