/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myModel;

import com.mybean.Packages;
import com.mybean.SetupBox;
import com.mysessionbean.PackagesFacadeLocal;
import com.mysessionbean.SetupBoxFacadeLocal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import myConnect.DTHConnection;

/**
 *
 * @author r0cklee147
 */
public class PackageModel {

    SetupBoxFacadeLocal setupBoxFacade = lookupSetupBoxFacadeLocal();
    PackagesFacadeLocal packagesFacade = lookupPackagesFacadeLocal();

    private double totalprice;

    public double getTotalprice() {
        return totalprice;
    }

    public void setTotalprice(double totalprice) {
        this.totalprice = totalprice;
    }

    public String getPackageList() {
        String str = "";
        List<Packages> list = packagesFacade.findAll();
        for (int i = 0; i < list.size(); i++) {
            Packages pack = list.get(i);
            str += "<form action=\"packageservlet?id=" + pack.getPackageID() + "\" method=\"post\">"
                    + "<div class=\"plan\">\n"
                    + "                <h3>" + pack.getPackageName() + "<span>$" + pack.getPricePerMonth() + "</span></h3>\n"
                    + "                <button type=\"submit\" class=\"signup\" >Select</button>		\n"
                    + "                <ul>\n"
                    + "                    <li><b>" + pack.getNumberofChannels() + "</b> Channels</li>\n"
                    + "                    <li><b>Discount Price : </b>$" + (pack.getPricePerMonth() - (pack.getPricePerMonth() * pack.getDiscount() / 100)) + "</li>\n"
                    + "                    <li><b>Discount : </b>" + pack.getDiscount() + " %</li>\n"
                    + "                    <li><input type=\"radio\" id=\"1month\" value=\"1\" name=\"month\"/><label for=\"1month\" class=\"light\">1 Months</label><br/>"
                    + "                        <input type=\"radio\" id=\"3month\" value=\"3\" name=\"month\"/><label for=\"3month\" class=\"light\">3 Months</label><br/>"
                    + "                        <input type=\"radio\" id=\"6month\" value=\"6\" name=\"month\"/><label for=\"6month\" class=\"light\">6 Months</label></li>			\n"
                    + "                </ul>\n"
                    + "            </div>"
                    + "</form> ";
        }
        return str;
    }

    public String getPackageDetail(String pack_id, int month) {
        String str = "";

        List<Packages> list = packagesFacade.findByPackageID(pack_id);

        for (int i = 0; i < list.size(); i++) {
            Packages pack = list.get(i);
            SetupBox setup = setupBoxFacade.find(pack.getSetID());

            double packagediscountprice = pack.getPricePerMonth() - (pack.getPricePerMonth() * pack.getDiscount() / 100);
            double setupboxdiscountprice = setup.getPrice() - (setup.getPrice() * setup.getDiscount() / 100);
            setTotalprice(packagediscountprice * month + setupboxdiscountprice);
            str += "<form action=\"orderPackage?pack_id=" + pack.getPackageID() + "&total=" + getTotalprice() + "&month=" + month + "\" method=\"post\">"
                    + "<div id=\"content\">\n"
                    + "            <h2> " + pack.getPackageName() + "</h2>\n"
                    + "            <h4>Package Detail</h4>\n"
                    + "            <hr/>\n"
                    + "            <p>Discount : " + pack.getDiscount() + "% </p>\n"
                    + "            <p>Package Discount Price : $" + packagediscountprice + " per month</p>\n"
                    + "            <p></p>\n"
                    + "            <p>" + pack.getDescription() + "</p>\n"
                    + "            <h5><b>" + pack.getNumberofChannels() + " </b> Channels</h5>\n"
                    + "            <div class=\"cleaner h30\"></div>\n"
                    + "            <div class=\"about_box\">\n"
                    + "                <h4>Setup Box</h4>\n"
                    + "                <hr/>\n"
                    + "                <img src=\"resources/images/upload/setupbox/" + setup.getImgs() + "\" alt=\"User 02\" />\n"
                    + "                <p>Discount : " + setup.getDiscount() + "%</p>\n"
                    + "                <p>Setupbox Discount Price : $" + setupboxdiscountprice + "</p>\n"
                    + "                <div class=\"cleaner\"></div>\n"
                    + "            </div>\n"
                    + "\n"
                    + "        </div>\n"
                    + "        <div id=\"sidebar\">\n"
                    + "            <h2>Result</h2>\n"
                    + "            <div class=\"testimonial\">\n"
                    + "                <p>TOtal Price</p>\n"
                    + "                <cite> $" + getTotalprice() + " </cite>\n"
                    + "            </div>\n"
                    + "            \n"
                    + "            <button type=\"submit\" class=\"signup\">Subscribe</button>\n"
                    + "            \n"
                    + "            \n"
                    + "        </div> \n"
                    + "\n"
                    + "        <div class=\"cleaner\"></div>"
                    + "</form>";

        }
        return str;

    }

    public boolean checkExist(String pack_id) {

        List<Packages> listPackage = packagesFacade.findByPackageID(pack_id);
        if (listPackage.size() > 0) {
            return true;
        }
        return false;
    }

    public void add(String pack_id, String pack_name, int set_id, double price, String description, double discount) {
        Packages pack = new Packages();
        pack.setPackageID(pack_id);
        pack.setPackageName(pack_name);
        pack.setSetID(set_id);
        pack.setPricePerMonth(price);
        pack.setDescription(description);
        pack.setDiscount(discount);
        packagesFacade.create(pack);
    }

    public boolean update(String pack_id, String pack_name, int set_id, String description, double price, double discount) {
        Packages pack = new Packages(pack_id);
        pack.setPackageName(pack_name);
        pack.setSetID(set_id);
        pack.setPricePerMonth(price);
        pack.setDescription(description);
        pack.setDiscount(discount);
        packagesFacade.edit(pack);
        return true;
    }

    Connection conn;
    DTHConnection connect = new DTHConnection();

    public boolean delete(String pack_id) throws SQLException {
//        Packages pack = new Packages(pack_id);
//        packagesFacade.remove(pack);
//        return true;
        try {
            conn = connect.getDTHConnect();
            PreparedStatement comm = conn.prepareStatement("delete Packages where Package_ID=?");
            comm.setString(1, pack_id);
            int count = comm.executeUpdate();
            if (count > 0) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conn.close();
        }
        return false;
    }

    public String list() {
        String str = "";
        List<Packages> list = packagesFacade.findAll();
        for (int i = 0; i < list.size(); i++) {
            Packages pack = list.get(i);
            SetupBox set = setupBoxFacade.find(pack.getSetID());
            str += "<tr>"
                    + "<td>" + pack.getPackageID() + "</td>"
                    + "<td>" + pack.getPackageName() + "</td>"
                    + "<td>" + set.getSetName() + "</td>"
                    + "<td>" + pack.getDescription() + "</td>"
                    + "<td>" + pack.getPricePerMonth() + "</td>"
                    + "<td>" + pack.getDiscount() + "</td>"
                    + "<td><a href=Package_Update.jsp?packID=" + pack.getPackageID() + "><img src=\"../resources/images/edit.png\" width=\"32\" height=\"32\"/></a></td>"
                    + "<td><a href=../deletePackage?packID=" + pack.getPackageID() + "><img src=\"../resources/images/del.png\" width=\"32\" height=\"32\"/></a></td>"
                    + "</tr>";
        }
        return str;
    }

    public String createInvoice(String pack_id, double totalprice, double wallet, String cus_name, String currentdate, int month) {
        String str = "";
        List<Packages> list = packagesFacade.findByPackageID(pack_id);
        for (int i = 0; i < list.size(); i++) {
            Packages pack = list.get(i);
            double balance = wallet - totalprice;
            str += "<div id=\"container\">\n"
                    + "        <form>\n"
                    + "            <p>\n"
                    + "                <label>Customer Name</label>\n"
                    + "                <input type=\"text\" placeholder=\"" + cus_name + "\" readonly=\"true\"/>\n"
                    + "            </p>\n"
                    + "            <p>\n"
                    + "                <label>Customer Money</label>\n"
                    + "                <input type=\"text\" placeholder=\"" + wallet + "\" readonly=\"true\"/>\n"
                    + "            </p>\n"
                    + "            <p>\n"
                    + "                <label>Package Code</label>\n"
                    + "                <input type=\"text\" placeholder=\"" + pack_id + "\" readonly=\"true\"/>\n"
                    + "            </p>\n"
                    + "            <p>\n"
                    + "                <label>Package Name</label>\n"
                    + "                <input type=\"text\" placeholder=\"" + pack.getPackageName() + "\" readonly=\"true\"/>\n"
                    + "            </p>\n"
                    + "            <p>\n"
                    + "                <label>Month</label>\n"
                    + "                <input type=\"text\" placeholder=\"" + month + "\" readonly=\"true\"/>\n"
                    + "            </p>\n"
                    + "            <p>\n"
                    + "                <label>Package Price</label>\n"
                    + "                <input type=\"text\" placeholder=\"" + totalprice + "\" readonly=\"true\"/>\n"
                    + "            </p>\n"
                    + "            <p>\n"
                    + "                <label>Customer Balance</label>\n"
                    + "                <input type=\"text\" placeholder=\"" + balance + "\" readonly=\"true\"/>\n"
                    + "            </p>\n"
                    + "            <p>\n"
                    + "             <p>\n"
                    + "                <label>Create Date</label>\n"
                    + "                <input type=\"text\" placeholder=\"" + currentdate + "\" readonly=\"true\"/>\n"
                    + "            </p>"
                    + "                <label>Status</label>\n"
                    + "                <input type=\"text\" placeholder=\"Paid\" readonly=\"true\"/>\n"
                    + "            </p>\n"
                    + "            <p>\n"
                    + "                <label>Install Status</label>\n"
                    + "                <input type=\"text\" placeholder=\"Not installed\" readonly=\"true\"/>\n"
                    + "            </p>\n"
                    + "            <input type=\"submit\" value=\"Submit Payment\"/>\n"
                    + "        </form>\n"
                    + "    </div>";
        }

        return str;
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

    private SetupBoxFacadeLocal lookupSetupBoxFacadeLocal() {
        try {
            Context c = new InitialContext();
            return (SetupBoxFacadeLocal) c.lookup("java:global/DTH_Project/DTH_Project-ejb/SetupBoxFacade!com.mysessionbean.SetupBoxFacadeLocal");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

}
