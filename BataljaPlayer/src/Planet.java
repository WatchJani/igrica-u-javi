public class Planet {
    public int ime;
    public int x;
    public int y;
    public float velikost;
    public int stladij;
    public String color;

    public Planet(String[] t){
        this.ime = Integer.parseInt(t[1]);
        this.x = Integer.parseInt(t[2]);
        this.y = Integer.parseInt(t[3]);
        this.velikost = Float.parseFloat(t[4]);
        this.stladij = Integer.parseInt(t[5]);
        this.color = t[6];

    }

    public String getColor(){
        return this.color;
    }

    public int getIme(){
        return this.ime;
    }

    public String napadiPlanet(Planet b){
        String poteza = "A" + " ";
        poteza += this.ime + " ";
        poteza += b.getIme() + "\n";
        return poteza;
    }
}
