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
public class DivNCon {
    public void divNSearch(Item[] box, int level){
        Item[] inBox=new Item[box.length];
        int sumWeightA,sumWeightB=0;
        inBox=box;
        if(box.length==1){
            System.out.println("(DNC) The Dirty Sock has been found !!, it's inside box number "+inBox[0].number);
        }
        else{
            if(inBox.length % 2 != 0 ){
                System.out.println("The number of Boxes is Odd, taking last 2 boxes in the group for weighing first !!, box number "+box[box.length-1].number+" and "+box[box.length-2].number+" is taken !!");
                Item[] boxO=new Item[2];
                boxO[0]=box[box.length-2];
                boxO[1]=box[box.length-1];
                if(box[box.length-2].weight>box[box.length-1].weight){
                    System.out.println("(DNC) The Dirty Sock has been found !!, it's inside box number "+box[box.length-2].number);
                }
                else if(box[box.length-2].weight<box[box.length-1].weight){
                    System.out.println("(DNC) The Dirty Sock has been found !!, it's inside box number "+box[box.length-1].number);
                }
                else{
                    System.out.println("No dirty socks found inside this 2 boxes, placing back box number "+box[box.length-2].number+" into the group");
                    Item[] outBox=new Item[box.length-1];
                    for(int i=0; i<outBox.length; i++){
                        outBox[i]=box[i];
                    } 
                    this.divNSearch(outBox, level);
                }
                
            }
            else{
                Item[] boxA=new Item[box.length/2];
                Item[] boxB=new Item[boxA.length];
                System.out.println(boxA.length+" "+boxB.length);
                for(int i=0; i<boxA.length; i++){
                    boxA[i]=inBox[i];
                }
                for(int i=boxA.length; i<box.length; i++){
                    boxB[i-boxA.length]=inBox[i];
                }
                sumWeightA=this.countWeight(boxA);
                sumWeightB=this.countWeight(boxB);
                int nBoxStartA=boxA[0].number;
                int nBoxEndA=boxA[boxA.length-1].number;
                int nBoxStartB=boxB[0].number;
                int nBoxEndB=boxB[boxB.length-1].number;
                if(sumWeightA>sumWeightB){
                    if(boxA.length==1){
                        System.out.println("Group "+level+"A (Box number "+nBoxStartA+") is heavier than Group B (Box number "+nBoxStartB+")");                
                    }
                    else{
                        System.out.println("Group "+level+"A (Box number "+nBoxStartA+" until "+nBoxEndA+") is heavier than Group "+level+"B (Box number "+nBoxStartB+" until "+nBoxEndB+"), now divide Group "+level+"A into Group "+(level+1)+"A and "+(level+1)+"B");
                    }
                    this.divNSearch(boxA, level+1);
                     
                }
                else if(sumWeightA<sumWeightB){
                    if(boxA.length==1){
                        System.out.println("Group "+level+"B (Box number "+nBoxStartA+") is heavier than Group "+level+"A (Box number "+nBoxStartB+")");                
                    }
                    else{
                        System.out.println("Group "+level+"B (Box number "+nBoxStartB+" until "+nBoxEndB+") is heavier than Group "+level+"A (Box number "+nBoxStartA+" until "+nBoxEndA+"), now divide Group "+level+"B into Group "+(level+1)+"A and "+(level+1)+"B");
                    }
                    this.divNSearch(boxB, level+1);
                
                }
                else{
                    System.out.println("No Dirty Socks Found !!!!");;
                }

            }
            
        }
    }
    public int countWeight(Item[] box){
        int sumWeight=0;
        for(int i=0; i<box.length; i++){
            sumWeight=sumWeight+box[i].weight;
        }
        return sumWeight;
        
    }
}
