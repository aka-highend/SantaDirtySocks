/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daa_tubes;

/**
 *
 * @author MohamadFachrur
 */
public class BruteForce {
    public Item checkBox(Item[] box){
        int average=0;
        int i=0;
        Item outBox=new Item();
        while(box[i].weight<=average){
            System.out.println("Checking Box number "+box[i].number+", no Dirty Socks Found");
            i++;
        }
        if(box[i].weight>average){
            System.out.println("(BF) The Dirty Socks has been found !!, inside box number "+box[i].number);
            outBox=box[i];
        }
        return outBox;
        
    }
}
