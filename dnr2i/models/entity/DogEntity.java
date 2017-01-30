package dnr2i.models.entity;

import java.util.ArrayList;

public class DogEntity extends TimeEntity {

    private enum DogEvent {

        COUCHE("Dog is sleeping",0),
        LEVE("Dog is standing up",1),
        ABBOIE("Dog : wouf!",2),
        MANGE("Dog is eating...",3),
        JOUE("Dog is playing with a bone",4),
        FAIT_LE_BEAU("good dog ! good dog !",5);

        private String dogActionPossible;
        private int index;

        DogEvent(String dogActionPossible, int index) {
            this.dogActionPossible = dogActionPossible;
            this.index = index;
        }

        public String getDogActionPossible() {
            return dogActionPossible;
        }

        public int getIndex() {
            return index;
        }
        
        public static String valueOf(int index) {
            String value = "";
            switch(index){
                case 0 : value = DogEvent.COUCHE.getDogActionPossible();
                break;
                case 1 : value = DogEvent.LEVE.getDogActionPossible();
                break;
                case 2 : value = DogEvent.ABBOIE.getDogActionPossible();
                break;
                case 3 : value = DogEvent.MANGE.getDogActionPossible();
                break;
                case 4 : value = DogEvent.JOUE.getDogActionPossible();
                break;
                case 5 : value = DogEvent.FAIT_LE_BEAU.getDogActionPossible();
                default:
            }
            
            return value;
        }
    }
    
    private final static int DRAW_LOT = 3;

    public DogEntity() {

        createEvent();
        

    }

    @Override
    public void createEvent() {
        DogEvent dogEvent;
        int randomEvent = 0;
        int max = DogEvent.values().length;
        String[] randomEventTable = new String[max];
        
        
        System.out.println("nombre d'event possible : "+DogEvent.values().length+"\n\r event 0 : "+
                DogEvent.valueOf(5));
        for(int i=0;i<DRAW_LOT;i++){
            
        
              randomEvent = (int) (Math.random() * max);
              System.out.println("Numéro tiré au sort : "+randomEvent);
              //checking if 
              randomEventTable[i] = DogEvent.valueOf(randomEvent);
              System.out.println("event ajouté au tableau : "+DogEvent.valueOf(randomEvent));
        }
        
    }

}
