package Twitter;

import java.util.TreeMap;

public class User {
	private String username;
	private Inbox inbox;
	private TreeMap<String, User> followers;
	private TreeMap<String, User> following;
	
	public User(String username) {
		this.username = username;
		this.inbox = null;
		this.followers = new TreeMap<>();
		this.following = new TreeMap<>();
	}
	
	@ Override
	public String toString() {
		String out = "";
		
		out += "seguidos: [";
		for(User u : this.followers.values()) {
			out += u.getUsername() + ", ";
		}
		out = out.substring(0, out.length() - 2) + "]";
		
		out += "\nseguidos: [";
		for(User u : this.following.values()) {
			out += u.getUsername() + ", ";
		}
		out = out.substring(0, out.length() - 2) + "]";
		
		return out;
	}
	
	// voce não pode seguir a voce mesmo
	// se ainda nao estiver seguindo o usuario other
    // adiciona other na lista de seguidos
	// adiciona voce na lista de seguidores de other
	public void follow(User other) {
		
	}
	
	public Inbox getInbox() {
		return this.inbox;
	}
	
	// coloca o tw no myTweets do usuario
    // coloca o tw na timeline do usuario
    // coloca o tw na timeline de todos os seguidores do usuario
    public void sendTweet(Tweet tw) {
    	
    }
	
    // se estiver seguindo esse username
    // obtenha o objeto User correspondente na sua lista de seguidos
    // remova ele da sua lista de seguidos
    // remova todas as mensagens dele da sua timeline utilizando o metodo inbox.rmMsgsFrom(username)
    // se remova da lista de seguidores dele
    public void unfollow(String other) {
    	
    }
	
    // recupera o tweet com esse id da timeline do usuario
    // invoca o método like do tweet
    public void like(int idTw){
    	
    }

    // remove todos os seus seguidos
    // se removendo também da lista de seguidores deles
    public void unfollowAll() {
    	
    }
    
    // remove todos os seus seguidores
    // se removendo também da lista de seguidos deles
    public void rejectAll() {
    	
    }
    
	public String getUsername() {
		return this.username;
	}
}
