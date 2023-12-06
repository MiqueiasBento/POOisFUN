package Twitter;

import java.util.TreeMap;
import java.util.List;

public class Inbox {
	private TreeMap<Integer, Tweet> timeline;
	private TreeMap<Integer, Tweet> myTweets;
	
	public Inbox() {
	}
	
	// adiciona um tweet na timeline
    public void storeInTimeline(Tweet tweet) {
    	
    }
    
    // retornam todos os tweets da timeline que não estiverem deletados
    // os tweets mais recentes devem ficar primeiro na lista
    public List<Tweet> getTimeline(){
    	
    }
    
    // retorna a timeline do usuario
    @ Override
    public String toString() {
    	String out = "";
    	
    	
    	
    	return out;
    }
    
    // obtem e retorna o tweet com o id passado da timeline
    // ou dispara uma exceção se ele não existir
    public Tweet getTweet(int id) {
    	
    }
    
    // remove todos os tweets emitidos por esse usuario da sua timeline
    // quando alguem deixa de seguir um usario, apaga todos os tweets 
    // dele na sua timeline
    public void rmMsgsFrom(String username) {
    	
    }
    
    // adiciona um tweet no myTweets do usuario
    public void storeInMyTweets(Tweet tweet) {
    	
    }
    
    // retorna todos os tweets emitidos pelo usuario
    public List<Tweet> getMyTweets(){
    	
    }
}
