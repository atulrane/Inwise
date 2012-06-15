package com.inwise.action;

import com.inwise.pojo.Customer;
import com.inwise.pojo.Address;
import com.inwise.dao.implementation.CustomerDaoImpl;
import com.google.inject.Inject;
import net.sourceforge.stripes.action.Resolution;
import net.sourceforge.stripes.action.ForwardResolution;
import net.sourceforge.stripes.action.DefaultHandler;
import net.sourceforge.stripes.action.RedirectResolution;

import java.util.List;


/**
 * Created by IntelliJ IDEA.
 * User: Atul
 * Date: May 11, 2012
 * Time: 11:38:26 AM
 * To change this template use File | Settings | File Templates.
 */
public class CustomerActionBean extends BaseActionBean
{
    @Inject CustomerDaoImpl customerDao;

    private Customer customer;
    private List<Customer> customerlst;
    private List<Address> addresslst;


    public List<Address> getAddresslst() {
        return addresslst;
    }

    public void setAddresslst(List<Address> addresslst) {
        this.addresslst = addresslst;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<Customer> getCustomerlst() {
        return customerlst;
    }

    public void setCustomerlst(List<Customer> customerlst) {
        this.customerlst = customerlst;
    }

    public Resolution pageDirect()
    {
        System.out.println("in paeg direct");
     return new ForwardResolution("jsp/addCustomer.jsp");
    }

    public Resolution addCustomer()
    {
          System.out.println("in addd custmer");
        System.out.println(getCustomer());
        System.out.println(customer);
            customer.setAddresslst(addresslst);
        customerDao.save(customer);
        System.out.println(customerDao.listAll().iterator().next());
        return new ForwardResolution("jsp/main_page.jsp");
    }

     @DefaultHandler
     public Resolution deleteLink()
     {   customerlst=customerDao.listAll();
         System.out.println("in delete link getting lists");
         return new ForwardResolution("jsp/deleteCustomer.jsp");
     }
    public Resolution delete()
    {
        customerDao.remove(getId());
        customerlst=customerDao.listAll();
        return new ForwardResolution("jsp/deleteCustomer.jsp");
    }
    public Resolution updateCustomerLink()
    {
        customerlst=customerDao.listAll();
        System.out.println("in update link");
         return new ForwardResolution("jsp/updateCustomer.jsp");
    }
    public Resolution updateCustomer()
    {

        System.out.println(getId());
        customer = customerDao.find(id);
        customerlst=customerDao.listAll();
         return new ForwardResolution("jsp/updateCustomer.jsp");
    }
    public Resolution update()
    {
        System.out.println("in update resolution");
        System.out.println(customer);
              customerDao.save(customer);
         customerlst=customerDao.listAll();

        return new ForwardResolution("jsp/deleteCustomer.jsp");
    }
}
