package laura.gotarra.tabmyscores;

class Chord {
    private String name;
    private int frase;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getFrase() {
        return frase;
    }

    public void setFrase(int frase) {
        this.frase = frase;
    }

    public Chord(String name, int frase) {
        this.name = name;
        this.frase = frase;
    }
}
