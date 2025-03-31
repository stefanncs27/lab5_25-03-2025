public class Persoane {
    private String prenume;
    private String nume;
    private int varsta;

    public Persoane(String prenume, String nume, int varsta) {
        this.prenume = prenume;
        this.nume = nume;
        this.varsta = varsta;
    }

    public String getPrenume() {
        return prenume;
    }

    public String getNume() {
        return nume;
    }

    public int getVarsta() {
        return varsta;
    }

    @Override
    public String toString() {
        return prenume + " " + nume + ", " + varsta + " ani";
    }
}
