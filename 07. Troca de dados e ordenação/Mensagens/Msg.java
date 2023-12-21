package Mensagens;

public class Msg {
    private String sender;
    private String text;
    private boolean read;
    
    public Msg(String sender, String text){
        this.sender = sender;
        this.text = text;
        this.read = false;
    }
    
    public void markRead() {
    	this.read = true;
    }
    
    public boolean isRead() {
    	return this.read;
    }
    
    public String toString(){
        return sender + ":" + text;
    }
}