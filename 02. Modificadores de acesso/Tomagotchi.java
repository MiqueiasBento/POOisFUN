import java.util.*;

class Pet {
    // private boolean alive;
    private int clean;
    private int cleanMax;
    private int energy;
    private int energyMax;
    private int hungry;
    private int hungryMax;
    private int age;
    private int diamonds;

    public Pet(int energyMax, int hungryMax, int cleanMax) {
        this.energyMax = energyMax;
        this.hungryMax = hungryMax;
        this.cleanMax = cleanMax;
        // Os demais iniciam com valores maximo
        this.energy = this.energyMax;
        this.hungry = this.hungryMax;
        this.clean = this.cleanMax;
        this.age = 0;
        this.diamonds = 0;
        // this.alive = true;
    }

    // Getters e Setters
    public int getClean() {
        return clean;
    }

    public void setClean(int clean) {
        this.clean = clean;
    }

    public int getCleanMax() {
        return cleanMax;
    }

    public int getEnergy() {
        return energy;
    }

    public void setEnergy(int energy) {
        this.energy = energy;
    }

    public int getEnergyMax() {
        return energyMax;
    }

    public int getHungry() {
        return hungry;
    }

    public void setHungry(int hungry) {
        this.hungry = hungry;
    }

    public int getHungryMax() {
        return hungryMax;
    }

    public void setDiamonds(int diamonds) {
        this.diamonds = diamonds;
    }

    public int getDiamonds() {
        return diamonds;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    // Metodos
    private boolean testAlive() {
        if (this.clean > 0 && this.energy > 0 && this.hungry > 0) {
            return true;
        } else {
            if (this.clean < 0) {
                setClean(0);
            } else if (this.energy < 0) {
                setEnergy(0);
            } else if (this.hungry < 0) {
                setHungry(0);
            }
            return false;
        }
    }

    // Causa da morte
    private void death() {
        if (this.clean == 0) {
            Tomagotchi.write("fail: pet morreu de sujeira");
        } else if (this.energy == 0) {
            Tomagotchi.write("fail: pet morreu de fraqueza");
        } else if (this.hungry == 0) {
            Tomagotchi.write("fail: pet morreu de fome");
        }
    }

    // Comer
    public void eat() {
        if (testAlive()) {
            // -1 a energia, +4 a saciedade, -2 a limpeza, +0 diamantes, +1 a idade
            setEnergy(getEnergy() - 1);
            setHungry(getHungry() + 4);
            setClean(getClean() - 2);
            setDiamonds(getDiamonds() + 0);
            setAge(getAge() + 1);

            if (this.hungry > this.hungryMax) {
                setHungry(getHungryMax());
            }

            if (!testAlive()) {
                death();
            }
        } else {
            Tomagotchi.write("fail: pet esta morto");
        }
    }

    // Brincar
    public void play() {
        if (testAlive()) {
            setEnergy(getEnergy() - 2);
            setHungry(getHungry() - 1);
            setClean(getClean() - 3);
            setDiamonds(getDiamonds() + 1);
            setAge(getAge() + 1);

            if (!testAlive()) {
                death();
            }
        } else {
            Tomagotchi.write("fail: pet esta morto");
        }
    }

    // Banhar
    public void shower() {
        if (testAlive()) {
            setEnergy(getEnergy() - 3);
            setHungry(getHungry() - 1);
            setClean(getCleanMax());
            setAge(getAge() + 2);

            if (!testAlive()) {
                death();
            }
        } else {
            Tomagotchi.write("fail: pet esta morto");
        }
    }

    // Dormir
    public void sleep() {
        if (testAlive()) {
            if ((this.energyMax - this.energy) >= 5) {
                setAge(getAge() + (getEnergyMax() - getEnergy()));
                setEnergy(getEnergyMax());
                setHungry(getHungry() - 1);

                if (!testAlive()) {
                    death();
                }
            } else {
                Tomagotchi.write("fail: nao esta com sono");
            }
        } else {
            Tomagotchi.write("fail: pet esta morto");
        }
    }

    // toString
    public String toString() {
        return "E:" + this.energy + "/" + this.energyMax
                + ", S:" + this.hungry + "/" + this.hungryMax
                + ", L:" + this.clean + "/" + this.cleanMax
                + ", D:" + this.diamonds
                + ", I:" + this.age;
    }

}

public class Tomagotchi {
    public static void main(String[] args) {
        Pet pet = new Pet(0, 0, 0);

        while (true) {
            var line = input();
            write("$" + line);
            var argsL = line.split(" ");

            if (argsL[0].equals("end")) {
                break;
            } else if (argsL[0].equals("show")) {
                write(pet.toString());
            } else if (argsL[0].equals("init")) {
                pet = new Pet((int) number(argsL[1]), (int) number(argsL[2]), (int) number(argsL[3]));
            } else if (argsL[0].equals("play")) {
                pet.play();
            } else if (argsL[0].equals("eat")) {
                pet.eat();
            } else if (argsL[0].equals("sleep")) {
                pet.sleep();
            } else if (argsL[0].equals("shower")) {
                pet.shower();
            } else {
                write("fail: comando invalido");
            }
        }
    }

    private static Scanner scanner = new Scanner(System.in);

    public static String input() {
        return scanner.nextLine();
    }

    public static double number(String value) {
        return Double.parseDouble(value);
    }

    public static void write(String value) {
        System.out.println(value);
    }
}