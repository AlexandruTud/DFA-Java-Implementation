
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
        String stare = st_init;
        int i;
        for(i=0;i < cuvant.length();i++)
        {
            Tranzitie tr = lt.gasesteTranzitie(stare,cuvant.charAt(i));
            if(tr.spuneSimbol()==cuvant.charAt(i))
                stare = tr.spuneStSfarsit();
            else
                return false;
        }
        i=0;
        while(i < st_finale.length){
            if(stare.equals(st_finale[i]))
                return true;
            else
                i++;
        }
        return false;
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

