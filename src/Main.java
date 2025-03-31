import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        String fisierPersoane = "src/persoane.txt";
        List<Persoane> lista = citesteDinFisier(fisierPersoane);
        lista.sort(Comparator.comparing((Persoane p) -> p.getPrenume().charAt(0)).thenComparing(p -> -p.getVarsta()));
        afisare(lista);
    }

    public static List<Persoane> citesteDinFisier(String fisier) {
        List<Persoane> listaPersoane = new ArrayList<>();
        try {
            File file = new File(fisier);
            Scanner sc = new Scanner(file);
            while (sc.hasNextLine()) {
                String line = sc.nextLine().trim();
                if (!line.isEmpty()) {
                    String[] parts = line.split(" ");
                    if (parts.length == 3) {
                        String prenume = parts[0];
                        String nume = parts[1];
                        int varsta = Integer.parseInt(parts[2]);
                        listaPersoane.add(new Persoane(prenume, nume, varsta));
                    }
                }
            }
            sc.close();
        } catch (FileNotFoundException e) {
            System.out.println("Eroare");
        }
        return listaPersoane;
    }

    public static void afisare(List<Persoane> listaPersoane) {
        for (Persoane p : listaPersoane) {
            System.out.println(p);
        }
    }
}
