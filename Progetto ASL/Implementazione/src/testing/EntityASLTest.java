package testing;

 

import static org.junit.Assert.*;

 

import java.sql.Date;

 

import org.junit.After;

import org.junit.Before;

import org.junit.Test;

 

import entity.EntityASL;

public class EntityASLTest {

 

    @Before

    public void setUp() throws Exception {

    }

 

    @After

    public void tearDown() throws Exception {

    }

 

    @Test

    public void testEffettuaRegistrazione_InputValidi() {

        int expected = 1;

        EntityASL singleton = EntityASL.getInstance();

        Date date = Date.valueOf("2015-06-31");

       

        int ret = singleton.effettuaRegistrazione("Giuseppe","Esposito","SPSGPP80A01F839B",date,"Napoli","Napoli","3488397653","Giusy.espo@hotmail.com","Giuseppe80","fLkxa7w&");

        assertEquals(expected,ret);

    }

   

    @Test

    public void testEffettuaRegistrazione_CittadinogiaRegistrato() {

      int expected = -2;

       EntityASL singleton = EntityASL.getInstance();

       Date date = Date.valueOf("2015-06-31");

       

       int ret = singleton.effettuaRegistrazione("Giuseppe","Esposito","SPSGPP80A01F839B",date,"Napoli","Napoli","3488397653","Giusy.espo@hotmail.com","Giuseppe80","fLkxa7w&");

       assertEquals(expected,ret);

    }

   

   

    @Test

    public void testEffettuaRegistrazione_NomeNonValidoLunghezza() {

        EntityASL singleton = EntityASL.getInstance();

        int expected = -3;

        Date date = Date.valueOf("2015-06-31");

        int ret = singleton.effettuaRegistrazione("Giuseppeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee","Esposito","SPSGPP80A01F839B",date,"Napoli","Napoli","3488397653","Giusy.espo@hotmail.com","Giuseppe80","fLkxa7w&");

        assertEquals(expected,ret);

    }

 

    @Test

    public void testEffettuaRegistrazione_NomeNonValidoSimboli() {

        EntityASL singleton = EntityASL.getInstance();

        int expected = -4;

        Date date = Date.valueOf("2015-06-31");

        int ret=singleton.effettuaRegistrazione("Giuseppe%","Esposito","SPSGPP80A01F839B",date,"Napoli","Napoli","3488397653","Giusy.espo@hotmail.com","Giuseppe80","fLkxa7w&");

        assertEquals(expected,ret);

    }

 

 

    @Test

    public void testEffettuaRegistrazione_CognomeNonValidoLunghezza() {

        EntityASL singleton = EntityASL.getInstance();

        int expected = -5;

        Date date = Date.valueOf("2015-06-31");

        int ret=singleton.effettuaRegistrazione("Giuseppe","Espositoooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo","SPSGPP80A01F839B",date,"Napoli","Napoli","3488397653","Giusy.espo@hotmail.com","Giuseppe80","fLkxa7w&");

        assertEquals(expected,ret);

    }

 

    @Test

    public void testEffettuaRegistrazione_CognomeNonValidoSimboli() {

        EntityASL singleton = EntityASL.getInstance();

        int expected = -6;

        Date date = Date.valueOf("2015-06-31");

        int ret=singleton.effettuaRegistrazione("Giuseppe","Esposito%","SPSGPP80A01F839B",date,"Napoli","Napoli","3488397653","Giusy.espo@hotmail.com","Giuseppe80","fLkxa7w&");

        assertEquals(expected,ret);

    }

 

    @Test

    public void testEffettuaRegistrazione_CfNonValidoLunghezza() {

        EntityASL singleton = EntityASL.getInstance();

        int expected = -7;

        Date date = Date.valueOf("2015-06-31");

        int ret=singleton.effettuaRegistrazione("Giuseppe","Esposito","SPSGPP80A01F839BIKSGOHOIJCDSSXDSX",date,"Napoli","Napoli","3488397653","Giusy.espo@hotmail.com","Giuseppe80","fLkxa7w&");

        assertEquals(expected,ret);

    }

 

    @Test

    public void testEffettuaRegistrazione_CfNonValidoSimboli() {

        EntityASL singleton = EntityASL.getInstance();

        int expected = -8;

        Date date = Date.valueOf("2015-06-31");

        int ret=singleton.effettuaRegistrazione("Giuseppe","Esposito","SPSGPP80A01F839%",date,"Napoli","Napoli","3488397653","Giusy.espo@hotmail.com","Giuseppe80","fLkxa7w&");

        assertEquals(expected,ret);

    }

 

    @Test

    public void testEffettuaRegistrazione_TelefonoNonValidoLunghezza() {

        EntityASL singleton = EntityASL.getInstance();

        int expected = -9;

        Date date = Date.valueOf("2015-06-31");

        int ret = singleton.effettuaRegistrazione("Giuseppe","Esposito","SPSGPP80A01F839B",date,"Napoli","Napoli","348839765354","Giusy.espo@hotmail.com","Giuseppe80","fLkxa7w&");

        assertEquals(expected,ret);

    }

 

   

 

    @Test

    public void testEffettuaRegistrazione_TelefonoNonValidoSimboli() {

        EntityASL singleton = EntityASL.getInstance();

        int expected = -10;

        Date date = Date.valueOf("2015-06-31");

        int ret=singleton.effettuaRegistrazione("Giuseppe","Esposito","SPSGPP80A01F839B",date,"Napoli","Napoli","348839765%","Giusy.espo@hotmail.com","Giuseppe80","fLkxa7w&");

        assertEquals(expected,ret);

    }

 

    @Test

    public void testEffettuaRegistrazione_EmailNonValida() {

        EntityASL singleton = EntityASL.getInstance();

        int expected = -11;

        Date date = Date.valueOf("2015-06-31");

        int ret=singleton.effettuaRegistrazione("Giuseppee","Esposito","SPSGPP80A01F839B",date,"Napoli","Napoli","3488397653","Giusy.espohotmail.com","Giuseppe80","fLkxa7w&");

        assertEquals(expected,ret);

    }

 

    @Test

    public void testEffettuaRegistrazione_PasswordNonValidaLunghezza() {

        EntityASL singleton = EntityASL.getInstance();

        int expected = -12;

        Date date = Date.valueOf("2015-06-31");

        int ret=singleton.effettuaRegistrazione("Giuseppe","Esposito","SPSGPP80A01F839B",date,"Napoli","Napoli","3488397653","Giusy.espo@hotmail.com","Giuseppe80","fLkxa7w&aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");

        assertEquals(expected,ret);

    }

 

    @Test

    public void testEffettuaRegistrazione_PasswordNonValidaSimboloMancante() {

        EntityASL singleton = EntityASL.getInstance();

        int expected = -13;

        Date date = Date.valueOf("2015-06-31");

        int ret=singleton.effettuaRegistrazione("Giuseppe","Esposito","SPSGPP80A01F839B",date,"Napoli","Napoli","3488397653","Giusy.espo@hotmail.com","Giuseppe80","fLkxa7ww");

        assertEquals(expected,ret);

    }

 

    @Test

    public void testEffettuaRegistrazione_PasswordNonValidaMaiuscolaMancante() {

        EntityASL singleton = EntityASL.getInstance();

        int expected = -14;

        Date date = Date.valueOf("2015-06-31");

        int ret=singleton.effettuaRegistrazione("Giuseppe","Esposito","SPSGPP80A01F839B",date,"Napoli","Napoli","3488397653","Giusy.espo@hotmail.com","Giuseppe80","flkxa7w&");

        assertEquals(expected,ret);

    }

 

    @Test

    public void testEffettuaRegistrazione_LuogoResidenzaNonValidoLunghezza() {

        EntityASL singleton = EntityASL.getInstance();

        int expected = -15;

        Date date = Date.valueOf("2015-06-31");

        int ret=singleton.effettuaRegistrazione("Giuseppe","Esposito","SPSGPP80A01F839B",date,"Napoli","Napoliiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiii","3488397653","Giusy.espo@hotmail.com","Giuseppe80","fLkxa7w&");

        assertEquals(expected,ret);

    }

 

    @Test

    public void testEffettuaRegistrazione_LuogoResidenzaNonValidoSimboli() {

        EntityASL singleton = EntityASL.getInstance();

        int expected = -16;

        Date date = Date.valueOf("2015-06-31");

        int ret=singleton.effettuaRegistrazione("Giuseppe","Esposito","SPSGPP80A01F839B",date,"Napoli","Napoli£$","3488397653","Giusy.espo@hotmail.com","Giuseppe80","fLkxa7w&");

        assertEquals(expected,ret);

    }

 

    @Test

    public void testEffettuaRegistrazione_LuogoNascitaNonValidoLunghezza() {

        EntityASL singleton = EntityASL.getInstance();

        int expected = -17;

        Date date = Date.valueOf("2015-06-31");

        int ret=singleton.effettuaRegistrazione("Giuseppe","Esposito","SPSGPP80A01F839B",date,"Napoliiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiii","Napoli","3488397653","Giusy.espo@hotmail.com","Giuseppe80","fLkxa7w&");

        assertEquals(expected,ret);

    }

 

    @Test

    public void testEffettuaRegistrazione_LuogoNascitaNonValidoSimboli() {

        EntityASL singleton = EntityASL.getInstance();

        int expected = -18;

        Date date = Date.valueOf("2015-06-31");

        int ret=singleton.effettuaRegistrazione("Giuseppe","Esposito","SPSGPP80A01F839B",date,"Napoli£$","Napoli","3488397653","Giusy.espo@hotmail.com","Giuseppe80","fLkxa7w&");

        assertEquals(expected,ret);

    }

 

    @Test

    public void testEffettuaRegistrazione_UsernameNonValidoLunghezza() {

        EntityASL singleton = EntityASL.getInstance();

        int expected = -19;

        Date date = Date.valueOf("2015-06-31");

        int ret=singleton.effettuaRegistrazione("Giuseppe","Esposito","SPSGPP80A01F839B",date,"Napoli","Napoli","3488397653","Giusy.espo@hotmail.com","Giuseppe80000000000000000000000000","fLkxa7w&");

        assertEquals(expected,ret);

    }

 

   

    @Test

    public void testInserisciDatiMedici_InputValidi() {

 

        EntityASL singleton = EntityASL.getInstance();

        boolean expected = true;

        int ret = singleton.inserisciDatiMedici("Mario","Tortora","Gastroenterologia","giusy.espo@asl.com","fLkxa7w&");

        assertEquals(expected,(ret>=1));

       

     }

   

    @Test

    public void testInserisciDatiMedici_MedicoGiaPresente() {

 

        EntityASL singleton = EntityASL.getInstance();

        boolean expected = true;

        int ret = singleton.inserisciDatiMedici("Mario","Tortora","Gastroenterologia","giusy.espo@asl.com","fLkxa7w&");

        assertEquals(expected,(ret==0));

       

     }

   

   

   

    @Test

    public void testInserisciDatiMedici_NomeNonValidoLunghezza() {

        EntityASL singleton = EntityASL.getInstance();

        int expected=-2;

        int ret = singleton.inserisciDatiMedici("Pinooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo","Giappone","Neurologia","giusy.espo@asl.com","fLkxa7w&");

        assertEquals(expected,ret);

    }

 

    @Test

    public void testInserisciDatiMedici_NomeNonValidoSimboli() {

        EntityASL singleton = EntityASL.getInstance();

        int expected=-3;

        int ret = singleton.inserisciDatiMedici("Domenico%","Giappone","Neurologia","giusy.espo@asl.com","fLkxa7w&");

        assertEquals(expected,ret);

    }

 

    @Test

    public void testInserisciDatiMedici_CognomeNonValidoLunghezza() {

        EntityASL singleton = EntityASL.getInstance();

        int expected=-4;

        int ret = singleton.inserisciDatiMedici("Domenico","Giapponeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee","Neurologia","giusy.espo@asl.com","fLkxa7w&");

        assertEquals(expected,ret);

    }

 

    @Test

    public void testInserisciDatiMedici_CognomeNonValidoSimboli() {

        EntityASL singleton = EntityASL.getInstance();

        int expected=-5;

        int ret = singleton.inserisciDatiMedici("Domenico","Giappone%","Neurologia","giusy.espo@asl.com","fLkxa7w&");

        assertEquals(expected,ret);

    }

 

    @Test

    public void testInserisciDatiMedici_EmailNonValida() {

        EntityASL singleton = EntityASL.getInstance();

        int expected=-6;

        int ret = singleton.inserisciDatiMedici("Domenico","Giappone","Neurologia","giusy.espoasl.com","fLkxa7w&");

        assertEquals(expected,ret);

    }

 

    @Test

    public void testInserisciDatiMedici_PassNonValida() {

        EntityASL singleton = EntityASL.getInstance();

        int expected=-7;

        int ret = singleton.inserisciDatiMedici("Domenico","Giappone","Neurologia","giusy.espo@asl.com","fLkxa7w&ddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddd");

        assertEquals(expected,ret);

    }

 

    @Test

    public void testInserisciDatiMedici_PassNonValida2() { // manca maiuscola 

        EntityASL singleton = EntityASL.getInstance();

        int expected=-9;

        int ret = singleton.inserisciDatiMedici("Domenico","Giappone","Neurologia","giusy.espo@asl.com","flkxa7w&");

        assertEquals(expected,ret);

    }

 

    @Test

    public void testInserisciDatiMedici_PassNonValida1() { // manca carattere speciale

        EntityASL singleton = EntityASL.getInstance();

        int expected=-8;

        int ret = singleton.inserisciDatiMedici("Domenico","Giappone","Neurologia","giusy.espo@asl.com","fLkxa7ww");

        assertEquals(expected,ret);

    }
    
}