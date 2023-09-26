package Pula_Pula;

import java.util.LinkedList;

public class Trampoline {
	private LinkedList<Kid> playing;
	private LinkedList<Kid> waiting;
	
	public Trampoline() {
		super();
		this.playing = new LinkedList<>();
		this.waiting = new LinkedList<>();
	}
	
//	private Kid removeKid(String name, LinkedList<Kid> list) {
//		return null;
//	}
	
	public void arrive(Kid kid) {
		waiting.addFirst(kid);
	}
	
	public void enter() {
		if(!waiting.isEmpty()) {
			playing.addFirst(waiting.getLast());
			waiting.removeLast();
		} else {
			System.out.println("fail: sem pessoas na fila");
		}
	}
	
	public void leave() {
		if(!playing.isEmpty()) {
			waiting.addFirst(playing.getLast());
			playing.removeLast();
		} else {
			System.out.println("fail: sem criancas brincando");
		}
	}
	
	public void remove(String name) {
		int i = 0;
		for(Kid kid : waiting) {
			if(kid.getName().equals(name)) {
				waiting.remove(i);
			}
			i++;
		}
		i = 0;
		
		for(Kid kid : playing) {
			if(kid.getName().equals(name)) {
				playing.remove(i);
			}
			i++;
		}
	}
	
	public String toString() {
		String ss = "";
		
		ss += "[";
		if(waiting.isEmpty()) {
			ss += "] => [";
		} else {
			for(Kid kid : waiting) {
				ss += kid + ", ";
			}
			ss = ss.substring(0, ss.length() - 2);
			ss += "] => [";
		}
		
		if(playing.isEmpty()) {
			ss += "]";
		} else {
			for(Kid kid : playing) {
				ss += kid + ", ";
			}
			ss = ss.substring(0, ss.length() - 2);
			ss += "]";
		}
		
		return ss;
	}
}
