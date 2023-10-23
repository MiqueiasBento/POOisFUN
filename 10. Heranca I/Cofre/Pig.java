package Cofre;

import java.util.*;

public class Pig {
    private boolean broken;
    private List<Coin> coins;
    private List<Item> itens;
    private int volumeMax;

    public Pig(int volumeMax) {
        this.broken = false;
        this.coins = new ArrayList<Coin>();
        this.itens = new ArrayList<Item>();
        this.volumeMax = volumeMax;
    }

    public Coin createCoin(String valor) {
        switch (valor) {
            case "10":
                return Coin.C10;
            case "25":
                return Coin.C25;
            case "50":
                return Coin.C50;
            case "100":
                return Coin.C100;
            default:
                return null;
        }
    }

    public boolean addCoin(Coin coin) throws Exception {
        if(broken) {
        	throw new Exception("fail: the pig is broken");
        }
        if(this.getVolume() + coin.getVolume() > this.getVolumeMax()) {
        	throw new Exception("fail: the pig is full");
        }

        this.coins.add( coin );
        return true;
    }

    public boolean addItem(Item item) throws Exception {
        if(isBroken()) {
        	throw new Exception("fail: the pig is broken");
        }
        if(this.getVolume() + item.getVolume() > this.getVolumeMax()) {
        	throw new Exception("fail: the pig is full");
        }

        this.itens.add( item );
        return true;
    }

    public boolean breakPig() throws Exception {
        if(isBroken()) {
        	throw new Exception("fail: the pig is broken");
        }
        
        this.broken = true;
        return true;
    }

    public ArrayList<String> extractCoins() throws Exception {
    	if(!isBroken()) {
        	throw new Exception("fail: you must break the pig first");
        }
    	
    	ArrayList<String> labels = new ArrayList<String>();
        for(Coin c : this.coins) {
            labels.add(c.toString());
        }
        
        this.coins.clear();
        return labels;
    }

    public ArrayList<String> extractItems() throws Exception {
        if(!isBroken()) {
        	throw new Exception("fail: you must break the pig first");
        }
        
        ArrayList<String> labels = new ArrayList<String>();
        for(Item i : itens) {
        	labels.add(i.toString());
        }
        
        this.itens.clear();
        return labels;
    }

    public int getVolume() {
        if(this.isBroken()) {
            return 0;
        }
        
        int volume = 0;
        for(Coin c : this.coins) {
            volume += c.getVolume();
        }
        for(Item i : this.itens) {
            volume += i.getVolume();
        }
        return volume;
    }

    public double getValue() {
        double value = 0;
        for(Coin c : this.coins) {
            value += c.getValue();
        }
        for(Item i : this.itens) {
        	value += i.getValue();
        }
        return value;
    }

    public int getVolumeMax() {
        return this.volumeMax;
    }

    public int getVolumeRestante() {
        return this.getVolumeMax() - this.getVolume();
    }

    public boolean isBroken() {
        return this.broken;
    }
    
    public String getItens() {
    	String out = "[";
    	for(Coin c : coins) {
    		out += c.toString() + ", ";
    	}
    	for(Item i : itens) {
    		out += i.toString() + ", ";
    	}
    	
    	return (out.substring(0, out.length() - 2) + "]");
    }
    
    @Override
    public String toString() {
        // [M10:0.10:1, M50:0.50:3, ouro:50.00:3, passaporte:0.00:2] : 50.60$ : 9/20 : intact
        String out = "";
        
        if(this.coins.isEmpty() && this.itens.isEmpty()) {
        	out += "[]";
        } else {
        	out += getItens();
        }
        
        out +=  " : " + String.format("%.2f", this.getValue()) + "$ : " + getVolume() + "/" + getVolumeMax() + " : ";
        
        if(!isBroken()) out += "intact";
        else out += "broken";
        
        return out;
    }
}