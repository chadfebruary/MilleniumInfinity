package com.milleniuminfinity.app.milleniuminfinity.repository.internet;
 /* Write a description of class TestInternet here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import android.test.AndroidTestCase;



public class InternetRepositoryTest extends AndroidTestCase
{
    /*private static final String TAG = "INTERNET TEST";
    
    public void createReadUpdateDeleteTest() throws Exception
    {
        InternetRepository repository = new InternetRepositoryImpl(this.getContext());
        String ipAddress;
        
        //Create
        Internet createdInternet = new Internet.Builder()
                                            .ipAddress("10.1.1.1")
                                            .ISP("Telkom")
                                            .planName("Capped ADSL")
                                            .price("R399")
                                            .dataAllowance("100GB")
                                            .build();
                                            
        Internet insertedInternet = repository.save(createdInternet);
        ipAddress = insertedInternet.getIPAddress();
        Assert.assertNotNull(TAG + " CREATE", insertedInternet);
        
        //Read all
        Set<Internet> internetServices = repository.findAll();
        Assert.assertTrue(TAG + " READ ALL", internetServices.size() > 0);
        
        //Read entity
        Internet internet = repository.findById(ipAddress);
        Assert.assertNotNull(TAG + " READ INTERNET", internet);
        
        //Update internet
        Internet updateInternet = new Internet.Builder()
                                            .copy(internet)
                                            .ipAddress("NewIP")
                                            .build();
        repository.update(updateInternet);
        Internet newInternet = repository.findById(ipAddress);
        Assert.assertEquals(TAG + " UPDATE INTERNET", "NewIP", newInternet.getIPAddress());
        
        //Delete employee
        repository.delete(updateInternet);
        Internet deletedInternet = repository.findById(ipAddress);
        Assert.assertNull(TAG + " DELETE", deletedInternet);
    }*/
}
