public class Tranzitie{
    private final String st_inceput;
    private final char simbol;
    private final String st_sfarsit;

    Tranzitie( String st_inceput,char simbol,String st_sfarsit)
    {   
    this.st_inceput=st_inceput;
    this.simbol=simbol;
    this.st_sfarsit=st_sfarsit;
    }

    String spuneStInceput(){
        return this.st_inceput;
    }

    char spuneSimbol(){
        return this.simbol;
    }

    String spuneStSfarsit()
    {
        return this.st_sfarsit;
    }

    
}
    



