/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myModel;

import com.mybean.Admin;
import com.mybean.Customer;
import com.mybean.Dealer;
import com.mysessionbean.AdminFacadeLocal;
import com.mysessionbean.CustomerFacadeLocal;
import com.mysessionbean.DealerFacadeLocal;
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
public class LoginModel {
    AdminFacadeLocal adminFacade = lookupAdminFacadeLocal();
    DealerFacadeLocal dealerFacade = lookupDealerFacadeLocal();
    CustomerFacadeLocal customerFacade = lookupCustomerFacadeLocal();


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    private String username;
    private String password;

    public String loginAdmin(String username, String password) {
        
        List<Admin> listAdm = adminFacade.findByAdminID(username);
        for (int i = 0; i < listAdm.size(); i++) {
            Admin user = listAdm.get(i);
            if (username.equals(user.getAdminID()) && password.equals(user.getPassword())) {
                return "success";
            }
        }
        return "false";
    }
    
    public String loginCustomer(String username, String password) {
        
        List<Customer> listCus = customerFacade.findByCusID(username);
        for (int i = 0; i < listCus.size(); i++) {
            Customer cus = listCus.get(i);
            if (username.equals(cus.getCusID()) && password.equals(cus.getPassword())) {
                return "success";
            }
        }
        return "false";
    }
    
    public String loginDealer(String username, String password) {
        
        List<Dealer> listDea = dealerFacade.findByDeaID(username);
        for (int i = 0; i < listDea.size(); i++) {
            Dealer dea = listDea.get(i);
            if (username.equals(dea.getDeaID()) && password.equals(dea.getPassword())) {
                return "success";
            }
        }
        return "false";
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

    private DealerFacadeLocal lookupDealerFacadeLocal() {
        try {
            Context c = new InitialContext();
            return (DealerFacadeLocal) c.lookup("java:global/DTH_Project/DTH_Project-ejb/DealerFacade!com.mysessionbean.DealerFacadeLocal");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

    private AdminFacadeLocal lookupAdminFacadeLocal() {
        try {
            Context c = new InitialContext();
            return (AdminFacadeLocal) c.lookup("java:global/DTH_Project/DTH_Project-ejb/AdminFacade!com.mysessionbean.AdminFacadeLocal");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
    
    
    
    
    

    
    
    

}
