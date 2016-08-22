package com.milleniuminfinity.app.milleniuminfinity.domain.internet;

import java.io.Serializable;

/**
 * Write a description of class Fibre here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Fibre implements Serializable, Internet
{
    /*@Override
    public String handleRequest(int request)
    {
        if(request == 2)
        {
            return "Fibre";
        }
        else
        {
            if(nextConnectionType != null)
            {
                return nextConnectionType.handleRequest(request);
            }
            
            return "Invalid option";
        }
    }*/

    private String ipAddress, ISP, planName;
    String price, dataAllowance;
    private Internet nextInternetType;

    private Fibre()
    {}

    private Fibre(Builder builder)
    {
        this.ipAddress = builder.ipAddress;
        this.ISP = builder.ISP;
        this.planName = builder.planName;
        this.price = builder.price;
        this.dataAllowance = builder.dataAllowance;
    }

    @Override
    public String getIPAddress()
    {
        return ipAddress;
    }

    @Override
    public String getISP()
    {
        return ISP;
    }

    @Override
    public String getPlanName()
    {
        return planName;
    }

    @Override
    public String getPrice()
    {
        return price;
    }

    @Override
    public String getDataAllowance()
    {
        return dataAllowance;
    }

    @Override
    public void setNextInternetType(Internet nextInternetType)
    {
        this.nextInternetType = nextInternetType;
    }

    public static class Builder
    {
        private String ipAddress, ISP, planName;
        String price, dataAllowance;

        public Builder ipAddress(String value)
        {
            this.ipAddress = value;
            return this;
        }

        public Builder ISP(String value)
        {
            this.ISP = value;
            return this;
        }

        public Builder planName(String value)
        {
            this.planName = value;
            return this;
        }

        public Builder price(String value)
        {
            this.price = value;
            return this;
        }

        public Builder dataAllowance(String value)
        {
            this.dataAllowance = value;
            return this;
        }

        public Builder copy(Fibre value)
        {
            this.ipAddress = value.ipAddress;
            this.ISP = value.ISP;
            this.planName = value.planName;
            this.price = value.price;
            this.dataAllowance = value.dataAllowance;

            return this;
        }

        public Fibre build()
        {
            return new Fibre(this);
        }
    }

    @Override
    public boolean equals(Object o)
    {
        if(this == o) return true;

        if(o == null || getClass() != o.getClass()) return false;

        Fibre fibre = (Fibre) o;

        return ipAddress != null ? ipAddress.equals(fibre.ipAddress) : fibre.ipAddress == null;
    }

    @Override
    public int hashCode()
    {
        return ipAddress != null ? ipAddress.hashCode() : 0;
    }
}
