package enric;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Crear {
    private static final short GOL1= -1;
    private static final short GOL2 = -1;
//    private static final String ARB = "                              ";
//    private static final String ARB = "维维维维维维维维维维维维维维维维维维维维维维维维维维维维维维";
    private static final String ARB = "한국어한국어한국어한국어한국어한국어한국어한국어한국어한국어";

    private static final int FECHA = 10000101;
//    private static final String FECHA = "10000101";
//    private static final String FRMT = "uuuuMMdd" ;
//    private static final DateTimeFormatter DTF = DateTimeFormatter.ofPattern(FRMT); //DateFormatter¿
//    private static final LocalDate DATE = LocalDate.parse(FECHA,DTF);

    private final static File PATH = new File("data/data.bin");


    public Crear(int teams) throws IOException {
        System.out.println(PATH.delete()); //new league, new file, pa guardar, contador static y nombredearchivo +ese contador

        String mkdir = PATH.getParent();
        System.out.println(new File(mkdir).mkdir());

        System.out.println(PATH.createNewFile());
        try(RandomAccessFile raf = new RandomAccessFile(PATH,"rw")) {


//            int totalMatches = (teams * teams); //sin la diagonal - teams
//            System.out.println("total matches: " + totalMatches);

            //escribir un partido
            for (int i = 0; i < 1; i++) {
                raf.writeShort(GOL1);
                raf.writeShort(GOL2);
                raf.writeUTF(ARB);
                raf.writeInt(FECHA);
            }
            System.out.println("mida partit -> " + PATH.length());
            System.out.println("length String: "+ARB.length());

        }


    }
}
