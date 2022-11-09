
import java.io.BufferedReader;
import java.io.FileReader;

class Automat{
        private String st_init;
        private String st_finale[];
        private ListaTranzitii lt = new ListaTranzitii();
        Automat(String nume_fis) throws Exception{
            BufferedReader buf = new BufferedReader(new FileReader(nume_fis));
            this.st_init = buf.readLine();
            String st_finale_str = buf.readLine();
            this.st_finale = st_finale_str.split(" ");
            while(true){
                String linie = buf.readLine();
                if(linie == null)
                    break;
                else {
                    String tbl[] = linie.split(" ");
                    Tranzitie tr = new Tranzitie(tbl[0],tbl[1].charAt(0),tbl[2]);
                    this.lt.adaugaTranzitie(tr);
                }
            }
        }
  
        boolean analizaCuvant(String cuvant)
        {
        String stare=st_init;
        for(int i=0;i<cuvant.length();i++)
        {
            if(lt.gasesteTranzitie(stare,cuvant.charAt(i))==null)
            {
                System.out.print("Cuvantul este acceptat de automat: ");
                return false;
            }
            stare=lt.gasesteTranzitie(stare,cuvant.charAt(i)).spuneStSfarsit();
        }
        for(int i=0;i<st_finale.length;i++)
        {
            if(stare.equals(st_finale[i]))
            {
                System.out.print("Cuvantul este acceptat de automat: ");
                return true;
            }
        }
        return false;
        }
        
        public void afiseazaAlfabetul(){
            HashSet<Character> litere = new HashSet<>();
            for(Tranzitie tranzitie:lt.lista){
                    litere.add(tranzitie.spuneSimbol());
            }
            for(char lit:litere){
                System.out.println(lit);
            }
        }
        
        public void afiseazaAutomat()
        {
            System.out.println("Starea initiala: " + st_init);
            System.out.print("Stari finale: ");
            for(int i=0;i<st_finale.length;i++)
            {
                System.out.print(st_finale[i] + " ");
            }
            System.out.println();
            for(Tranzitie tranzitie:lt.lista)
            {
                System.out.println(tranzitie.spuneStInceput()+" -> "+tranzitie.spuneSimbol()+" -> "+tranzitie.spuneStSfarsit());
            }
        }
}

