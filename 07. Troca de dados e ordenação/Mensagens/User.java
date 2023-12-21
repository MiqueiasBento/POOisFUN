package Mensagens;

import java.util.ArrayList;

public class User {
    private String username;
    private ArrayList<Msg> inbox;
    private int unreadCount;
    
    public User(String username){
        this.username = username;
        this.inbox = new ArrayList<>();
        this.unreadCount = 0;
    }
    
    public void sendMsg(User dest, String text){
        Msg msg = new Msg(dest.getUsername(), text);
        receiveMsg(msg);
        addUnreadCount();
    }
    
    public void receiveMsg(Msg msg){
        inbox.add(msg);
        addUnreadCount();
    }
    
    public void addUnreadCount(){
        this.unreadCount++;
    }
    
    public void markReads() {
    	for(Msg msg : inbox) {
    		msg.markRead();
    	}
    	this.unreadCount = 0;
    }
    
    public void setUnreadCount(int unreadCount) {
        this.unreadCount = unreadCount;
    }
    
    public String getAllMsg(){
        if(this.unreadCount == 0){
            return "- empty -";
        }
        
        if(this.inbox.size() == 0) {
        	return "- vazio -";
        }
        
        String out = "";
        for(Msg msg : inbox) {
        	if(!msg.isRead()) {
        		out += msg + "\n";
        	}
        }
        
        return out.substring(0, out.length() - 1);
    }
    
    public String getUsername(){
        return this.username;
    }
    
    public String toString(){
        return "";
    }
}