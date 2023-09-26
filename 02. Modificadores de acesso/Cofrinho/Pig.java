package Cofrinho;

import java.util.ArrayList;

public class Pig {
	private boolean broken;
	private ArrayList<Coin> coins;
	private ArrayList<Item> itens;
	private int volumeMax;

	public Pig() {
	}

	public Pig(int volumeMax) {
		this.volumeMax = volumeMax;
		this.coins = new ArrayList<>();
		this.itens = new ArrayList<>();
		this.broken = false;
	}

	public boolean addCoin(Coin coin) {
		if (broken || (getVolume() + coin.getVolume()) >= volumeMax) {
			if(getVolume() + coin.getVolume() >= volumeMax) Porquinho.write("fail: the pig is full");
			else Porquinho.write("fail: the pig is broken");
			
			return false;
		} else {
			coins.add(coin);
			return true;
		}
	}

	public boolean addItem(Item item) {
		if (broken || (getVolume() + item.getVolume()) >= volumeMax) {
			if(getVolume() + item.getVolume() >= volumeMax) Porquinho.write("fail: the pig is full");
			else Porquinho.write("fail: the pig is broken");
			
			return false;
		} else {
			itens.add(item);
			return true;
		}
	}

	public boolean breakPig() {
		if (!broken) {
			broken = true;
			return true;
		} else {
			return false;
		}
	}

	public void extractCoins() {
		if (broken) {
			//	[0.10:1, 0.50:3]
			//	[]
			Porquinho.write(coins.toString());
			coins = new ArrayList<>();
		} else {
			Porquinho.write("fail: you must break the pig first");
			Porquinho.write("[]");
		}
	}

	public void extractItens() {
		if (broken) {
			//	[ouro:2, pirulito:3]
			//	[]
			Porquinho.write(itens.toString());
			itens = new ArrayList<>();
		} else {
			Porquinho.write("fail: you must break the pig first");
			Porquinho.write("[]");
		}
	}

	public int getVolume() {
		int volume = 0;
		for (Coin coin : coins) {
			volume += coin.getVolume();
		}

		for (Item item : itens) {
			volume += item.getVolume();
		}

		return volume;
	}
	
	public float getValue() {
		float value = 0;
		for(Coin coin : coins) {
			value += coin.getValue();
		}
		
		return value;
	}
	
	public int getVolumeMax() {
		return volumeMax;
	}

	@Override
	public String toString() {
		//	state=intact : coins=[0.10:1, 0.50:3] : items=[] : value=0.60 : volume=4/20
		String ss;
		if (!broken) {
			ss = "state=intact : " + "coins=" + coins.toString() + " : " + "items=" + itens.toString() + " : " + "value=" + String.format("%.2f", getValue()) + " : " + "volume=" + getVolume() + "/" + getVolumeMax();
		} else {
			ss = "state=broken : " + "coins=" + coins.toString() + " : " + "items=" + itens.toString() + " : " + "value=" + String.format("%.2f", getValue()) + " : " + "volume=" + 0 + "/" + getVolumeMax();
		}
		
		return ss;
	}
}