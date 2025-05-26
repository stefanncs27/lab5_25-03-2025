public class Persoane {
    private String prenume;
    private String nume;
    private int varsta;

    // Constructor pentru initializarea obiectului Persoane
    public Persoane(String prenume, String nume, int varsta) {
        this.prenume = prenume;
        this.nume = nume;
        this.varsta = varsta;
    }

    // Gettere pentru a obtine valorile atributelor
    public String getPrenume() {
        return prenume;
    }

    public String getNume() {
        return nume;
    }

    public int getVarsta() {
        return varsta;
    }

    // Suprascrierea metodei toString pentru a formata afisarea persoanei
    @Override
    public String toString() {
        return prenume + " " + nume + ", " + varsta + " ani";
    }
}