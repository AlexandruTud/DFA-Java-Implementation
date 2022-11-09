class Test{
    public static void main(String[] args) throws Exception {
        Automat M = new Automat("C:\\Users\\Alexandru\\Desktop\\Info II\\Limbaje formale si compilatoare\\automat.txt");
        System.out.println(M.analizaCuvant("abbbbbbbba"));
        M.afiseazaAutomat();
        M.afiseazaAlfabetul();
    }
}
