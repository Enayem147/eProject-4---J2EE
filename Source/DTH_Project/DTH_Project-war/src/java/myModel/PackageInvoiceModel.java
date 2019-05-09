/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myModel;

import com.mybean.PackageSubscribeDetail;
import com.mybean.Packages;
import com.mysessionbean.CustomerFacadeLocal;
import com.mysessionbean.PackageSubscribeDetailFacadeLocal;
import com.mysessionbean.PackagesFacadeLocal;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author r0cklee147
 */
public class PackageInvoiceModel {
    CustomerFacadeLocal customerFacade = lookupCustomerFacadeLocal();
    PackagesFacadeLocal packagesFacade = lookupPackagesFacadeLocal();
    PackageSubscribeDetailFacadeLocal packageSubscribeDetailFacade = lookupPackageSubscribeDetailFacadeLocal();

    Date date = new Date();
    
    public boolean addPackageSubscribeDetail (String pack_id, String cus_id, String currentdate, int month){
         String str = "";
        List<Packages> list = packagesFacade.findByPackageID(pack_id);
        double price = 0;
        for (int i = 0; i < list.size(); i++) {
            Packages pack = list.get(i);
            price = pack.getPricePerMonth()- (pack.getPricePerMonth()*month/100);
        }
        
        PackageSubscribeDetail psd = new PackageSubscribeDetail();
        psd.setPSDetailID(month);
        psd.setCusID(cus_id);
        psd.setPackageID(pack_id);
        psd.setPackageSubscribeDate(new Timestamp(date.getTime()));
        psd.setMonth(month);
        psd.setPrice(price);
        psd.setExpired(false);
        psd.setInstalltionStatus(false);
        
        packageSubscribeDetailFacade.create(psd);
        return true;
    }
    
    
    private PackageSubscribeDetailFacadeLocal lookupPackageSubscribeDetailFacadeLocal() {
        try {
            Context c = new InitialContext();
            return (PackageSubscribeDetailFacadeLocal) c.lookup("java:global/DTH_Project/DTH_Project-ejb/PackageSubscribeDetailFacade!com.mysessionbean.PackageSubscribeDetailFacadeLocal");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

    private PackagesFacadeLocal lookupPackagesFacadeLocal() {
        try {
            Context c = new InitialContext();
            return (PackagesFacadeLocal) c.lookup("java:global/DTH_Project/DTH_Project-ejb/PackagesFacade!com.mysessionbean.PackagesFacadeLocal");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

    private CustomerFacadeLocal lookupCustomerFacadeLocal() {
        try {
            Context c = new InitialContext();
            return (CustomerFacadeLocal) c.lookup("java:global/DTH_Project/DTH_Project-ejb/CustomerFacade!com.mysessionbean.CustomerFacadeLocal");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
    
}
