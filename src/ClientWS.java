import ws.BanqueService;
import ws.BanqueWS;
import ws.Compte;

import java.util.List;

public class ClientWS {
    public static void main(String[] args) {
        BanqueService stubWS = new BanqueWS().getBanqueServicePort();
        System.out.println("Convertion de Euro vers DH :");
        System.out.println(stubWS.conversionEuroToDH(800));
        System.out.println();

        Compte cp= stubWS.getCompte(2L);
        System.out.println("Information de Compte numero 2 :");
        System.out.println(cp.getCode());
        System.out.println(cp.getSolde());
        System.out.println();

        List<Compte> cptes=stubWS.listComptes();
        System.out.println("List des comptes :");
        cptes.forEach(c->{
            System.out.println("---------------");
            System.out.println(c.getCode());
            System.out.println(c.getSolde());
        });
    }
}
