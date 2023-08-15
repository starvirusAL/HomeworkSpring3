package app.custom;

import java.util.List;

public class RandomNumber {
    public static String randomDiceNumber(){
        int[] arr = new int[4];
        for (int i = 0; i < 4; i++) {
            arr[i] = (int) (1000+Math.random()*8999);
        }
        return String.format("%s %s %s %s ", arr[0],arr[1],arr[2],arr[3]);
    }
    private List<Integer> randomListId ;
    public static int RandomId (){
        int id =(int) (1 + Math.random() * 100);
        // this.randomListId.add(id);
        return id;
    }
}
