import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Definim calea fisierului cu persoane
        String fisierPersoane = "src/persoane.txt";

        // Citim persoanele din fisier si le stocam intr-o lista
        List<Persoane> lista = citesteDinFisier(fisierPersoane);

        // Sortam lista persoanelor dupa prenume (prima litera) si apoi dupa varsta (descrescator)
        lista.sort(Comparator.comparing((Persoane p) -> p.getPrenume().charAt(0)) // Comparam dupa prima litera a prenumelui
                .thenComparing(p -> -p.getVarsta())); // Daca sunt la fel, comparam descrescator dupa varsta

        // Afisam persoanele din lista sortata
        afisare(lista);
    }

    // Metoda pentru citirea persoanelor din fisier
    public static List<Persoane> citesteDinFisier(String fisier) {
        List<Persoane> listaPersoane = new ArrayList<>(); // Cream o lista pentru stocarea persoanelor
        try {
            // Cream un obiect File pentru fisierul de persoane
            File file = new File(fisier);
            Scanner sc = new Scanner(file); // Folosim Scanner pentru a citi fisierul linie cu linie

            // Citim fiecare linie din fisier
            while (sc.hasNextLine()) {
                String line = sc.nextLine().trim(); // Citim linia si eliminam spatiile de la inceput si sfarsit
                if (!line.isEmpty()) { // Daca linia nu este goala
                    String[] parts = line.split(" "); // Impartim linia in parti (prenume, nume, varsta)

                    if (parts.length == 3) { // Verificam daca linia are exact 3 parti
                        String prenume = parts[0];
                        String nume = parts[1];
                        int varsta = Integer.parseInt(parts[2]); // Convertim varsta la integer

                        // Adaugam persoana in lista
                        listaPersoane.add(new Persoane(prenume, nume, varsta));
                    }
                }
            }
            sc.close(); // Inchidem scannerul dupa ce am citit toate liniile
        } catch (FileNotFoundException e) { // Gestionam cazul in care fisierul nu exista
            System.out.println("Eroare");
        }
        return listaPersoane; // Returnam lista cu persoanele citite
    }

    // Metoda pentru a afisa persoanele din lista
    public static void afisare(List<Persoane> listaPersoane) {
        for (Persoane p : listaPersoane) { // Parcurgem lista de persoane
            System.out.println(p); // Afisam fiecare persoana
        }
    }
}