package com.milleniuminfinity.app.milleniuminfinity.repository.internet;
 /* Write a description of class TestInternet here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import android.test.AndroidTestCase;

import com.milleniuminfinity.app.milleniuminfinity.domain.internet.ADSL;
import com.milleniuminfinity.app.milleniuminfinity.domain.internet.Internet;
import com.milleniuminfinity.app.milleniuminfinity.repository.internet.Impl.InternetRepositoryImpl;

import junit.framework.Assert;

import java.util.Set;


public class InternetRepositoryTest extends AndroidTestCase
{
    private static final String TAG = "INTERNET TEST";
    
    public void createReadUpdateDeleteTest() throws Exception
    {
        InternetRepository repository = new InternetRepositoryImpl(this.getContext());
        String ipAddress;
        
        //Create
        Internet createdInternet = new ADSL.Builder()
                                            .ipAddress("10.1.1.1")
                                            .ISP("Telkom")
                                            .planName("Capped ADSL")
                                            .price("R399")
                                            .dataAllowance("100GB")
                                            .type("ADSL")
                                            .build();
                                            
        Internet insertedInternet = repository.save(createdInternet);
        ipAddress = insertedInternet.getIPAddress();
        Assert.assertNotNull(TAG + " CREATE", insertedInternet);
        
        //Read all
        Set<Internet> internetServices = repository.findAll();
        Assert.assertTrue(TAG + " READ ALL", internetServices.size() > 0);
        
        //Read entity
        Internet internet = repository.findById(createdInternet.getIPAddress(), createdInternet.getType());
        Assert.assertNotNull(TAG + " READ INTERNET", internet);
        
        //Update internet
        Internet updateInternet = new ADSL.Builder()
                                            .copy((ADSL)internet)
                                            .ipAddress("NewIP")
                                            .build();
        repository.update(updateInternet);
        Internet newInternet = repository.findById(updateInternet.getIPAddress(), updateInternet.getType());
        Assert.assertEquals(TAG + " UPDATE INTERNET", "NewIP", newInternet.getIPAddress());
        
        //Delete employee
        repository.delete(updateInternet);
        Internet deletedInternet = repository.findById(updateInternet.getIPAddress(), updateInternet.getType());
        Assert.assertNull(TAG + " DELETE", deletedInternet);
    }
}
