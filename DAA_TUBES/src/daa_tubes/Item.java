/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daa_tubes;
import java.util.Random;

/**
 *
 * @author MohamadFachrur
 */
public class Item {
    public int weight;
    public int number;
    public Item() {
    }
    public int randomWeight(Item[] box, int num){
        Random rand = new Random();
        int randomNum = rand.nextInt((num - 0) + 1) + 0;
        System.out.println(randomNum);
        this.setWeight(box,randomNum);
        return randomNum;
    }
    public void setWeight(Item[] box, int randomNum){
        int boxTotal=box.length;
        for(int i=0; i<boxTotal; i++){
            box[i]=new Item();
            box[i].weight=0;
            box[i].number=i+1;
        }
        box[randomNum].weight=1;
        
    }    
}
