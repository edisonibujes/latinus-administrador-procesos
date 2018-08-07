package net.latinus.admin.process.comun.persistencia.jpa.test;

import java.io.File;
import java.io.FileWriter;
import java.util.List;
import javax.xml.bind.DatatypeConverter;
import net.latinus.admin.process.comun.persistencia.jpa.dao.GadDAO;
import net.latinus.admin.process.comun.persistencia.jpa.entidades.Gad;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Latinus on 26/7/16.
 */
public class GadDAOImplTest {

    private static final Logger LOG = LoggerFactory.getLogger(GadDAOImplTest.class);
    private static final String APP_CONTEXT_DEV[] = {"context-arcom-persistencia-test.xml"};
    private ApplicationContext appContext;
    private GadDAO gadDAO;

    @Before
    public void setUp() {
        appContext = (ApplicationContext) new ClassPathXmlApplicationContext(APP_CONTEXT_DEV);
        gadDAO = (GadDAO) appContext.getBean(GadDAO.BEAN_NAME);
    }

    @Test
    @Ignore
    public void update() {
        Gad adj = gadDAO.read(2);
        adj.setNombre("Actualizacion gadtestest TEST");
        gadDAO.update(adj);
    }

    @Test
    @Ignore
    public void getAccesosById() {
        System.out.println("---> " + gadDAO.read(1).getNombre());
    }

    @Test
    @Ignore
    public void getAllGads() {
        List<Gad> gads = gadDAO.obtenerAllGads();
        for (Gad g : gads) {
            System.out.println("Gad : " + g.getNombre());
        }
    }

    @Test
    @Ignore
    public void getrolGads() {
        //String resultado = "";
        String rol = "Responsable GAD";
        List<Gad> gads = gadDAO.obtenerAllGads();
        for (Gad g : gads) {
            //resultado = resultado + g.getSiglas() + "\\" + rol + ",";
            System.out.println("" + g.getSiglas() + "\\" + rol + ",");
        }

        System.out.println("\n==================");
        System.out.println("Realms");
        System.out.println("==================\n");
        String realm;
        int numRealm = 11;
        for (Gad g : gads) {
            realm = "security.ldap.realm.#1=#2:dc=#2,dc=Gads,c=ec";
            realm = realm.replace("#1", "" + numRealm).replace("#2", g.getSiglas());
            System.out.println(realm);
            numRealm++;
        }
    }

    @Test
    @Ignore
    public void crearLdif() {
        List<Gad> gads = gadDAO.obtenerAllGads();
        String resultadodo = "";

        int v = 1;
        String head = "version: 1\n"
                + "dn: dc=Gads,c=ec\n"
                + "objectClass: domain\n"
                + "objectClass: extensibleObject\n"
                + "objectClass: top\n"
                + "dc: Gads\n";
        for (Gad g : gads) {

            String ldifTemplate = "\ndn: dc=#1,dc=Gads,c=ec\n"
                    + "objectClass: domain\n"
                    + "objectClass: extensibleObject\n"
                    + "objectClass: top\n"
                    + "dc: #1\n"
                    + "description: #2\n"
                    + "l: #1\n"
                    + "\n"
                    + "dn: ou=roles,dc=#1,dc=Gads,c=ec\n"
                    + "objectClass: organizationalUnit\n"
                    + "objectClass: top\n"
                    + "ou: roles\n"
                    + "\n"
                    + "dn: cn=Responsable GAD,ou=roles,dc=#1,dc=Gads,c=ec\n"
                    + "objectClass: groupOfUniqueNames\n"
                    + "objectClass: top\n"
                    + "cn: Responsable GAD\n"
                    + "description: Responsable GAD\n"
                    + "ou: roles\n"
                    + "uniqueMember: cn=null,ou=usuarios,dc=#1,dc=Gads,c=ec\n"
                    + "\n"
                    + "dn: cn=Recepcionista GAD,ou=roles,dc=#1,dc=Gads,c=ec\n"
                    + "objectClass: groupOfUniqueNames\n"
                    + "objectClass: top\n"
                    + "cn: Recepcionista GAD\n"
                    + "description: Recepcionista GAD\n"
                    + "ou: roles\n"
                    + "uniqueMember: cn=null,ou=usuarios,dc=#1,dc=Gads,c=ec\n"
                    + "\n"
                    + "dn: ou=usuarios,dc=#1,dc=Gads,c=ec\n"
                    + "objectClass: organizationalUnit\n"
                    + "objectClass: top\n"
                    + "ou: usuarios\n"
                    + "\n"
                    + "dn: ou=usuariosAdministradores,dc=#1,dc=Gads,c=ec\n"
                    + "objectClass: organizationalUnit\n"
                    + "objectClass: top\n"
                    + "ou: usuariosAdministradores\n";

            ldifTemplate = ldifTemplate.replace("#1", g.getSiglas());
            ldifTemplate = ldifTemplate.replace("#2", g.getNombre());

            resultadodo = resultadodo + ldifTemplate;
            v++;
        }

        System.out.println("Resultad : \n" + head + resultadodo);

        String str = head + resultadodo;
        File newTextFile = new File("/Users/alejomantillasam/Desktop/gads-22112916.ldif");

        try {
            FileWriter fw = new FileWriter(newTextFile);
            fw.write(str);
            fw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Test
    @Ignore
    public void obtenerGadPorCodigoLocalidad() {
        System.out.println("Gad: " + gadDAO.obtenerGadPorCodigoLocalidad(922L).getNombre());
    }

}
