package Mensagens;

import java.util.*;

public class Main{
    public static void main (String[] args) {
        ArrayList<User> users = new ArrayList<>();
        
        while(true){
            String line = input();
            write("$" + line);
            args = line.split(" ");
            
            
            switch(args[0]){
                case "end":
                    return;
                case "addUser":
                    users.add(new User(args[1]));
                    break;
                case "inbox":
                    write(users.get(getByName(args[1], users)).getAllMsg());
                    break;
                case "sendMsg":
                    User envia = users.get(getByName(args[1], users));
                    User recebe = users.get(getByName(args[2], users));
                    
                    // Junta todos as Strings da posição 3 até .size(), e passa como se fosse uma String
                    recebe.sendMsg(envia, String.join(" ", Arrays.copyOfRange(args, 3, args.length)));
                    envia.markReads();
                    break;
                default:
                    write("comando invalido");
            }
        }
    }
    public static Scanner sc = new Scanner(System.in);
    
    public static String input() {
        return sc.nextLine();
    }
    public static void write(String str) {
        System.out.println(str);
    }
    
    public static int getByName(String name, ArrayList<User> users){
        for(int i = 0; i < users.size(); i++){
            if(users.get(i).getUsername().equals(name)){
                return i;
            }
        }
        
        return -1;
    }
}