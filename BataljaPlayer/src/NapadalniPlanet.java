import java.util.ArrayList;
import java.util.Random;

public class NapadalniPlanet {

    public int x;
    public int y;
    public String color;

    ArrayList<Planet> mojiPlaneti;
    ArrayList<Planet> nevtralni;
    ArrayList<Planet> nasprotnik;


    public NapadalniPlanet(int x, int y, String color){
        this.x = x;
        this.y = y;
        this.color = color;
        mojiPlaneti = new ArrayList<>();
        nasprotnik = new ArrayList<>();
        nevtralni = new ArrayList<>();
    }

    public String napad(){
        if(!(mojiPlaneti.isEmpty() || nasprotnik.isEmpty())){
            if(!nevtralni.isEmpty()){
                return nakljucniNapad(nevtralni);
            }else{
                return nakljucniNapad(nasprotnik);
            }
        }
        return "";
    }

    public String nakljucniNapad(ArrayList<Planet> planeti){
        String napad ="";
        for (int i = 0; i< mojiPlaneti.size(); i++){
            if(mojiPlaneti.get(i).stladij > 40){
                Planet a = mojiPlaneti.get(i);
                Planet b = nakljucni(planeti);
                napad+= a.napadiPlanet(b);
            }
        }
        return napad;
    }

    public  Planet nakljucni(ArrayList<Planet> planeti){
        Random rand = new Random();
        int i = rand.nextInt(planeti.size());
        Planet p = planeti.get(i);
        return p;
    }



    public void dodajPlanet(String[] t){
        Planet p = new Planet(t);

        if(p.getColor().equals(this.color)){
            mojiPlaneti.add(p);
        }else if(p.getColor().equals("null")){
            nevtralni.add(p);
        }else{
            nasprotnik.add(p);
        }

    }
}
