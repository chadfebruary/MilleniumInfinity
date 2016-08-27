package com.milleniuminfinity.app.milleniuminfinity.domain.internet;
/* Write a description of class Internet here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.io.Serializable;

public interface Internet
{
    String getIPAddress();
    String getISP();
    String getPlanName();
    String getPrice();
    String getDataAllowance();
    String getType();
}
