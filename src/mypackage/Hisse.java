package mypackage;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Hisse
{
    private String id;
    private String sembol;
    private String ad;
    private String fiyat;

    public Hisse(String id, String sembol, String ad, String fiyat)
    {
        this.id = id;
        this.sembol = sembol;
        this.ad = ad;
        this.fiyat = fiyat;
    }

    @Override
    public String toString()
    {
        return "Hisse ( " +
                " Id = '" + id + '\'' +
                " Sembol = '" + sembol + '\'' +
                " Ad = '" + ad + '\'' +
                " Fiyat = '" + fiyat + '\'' +
                " )";
    }

    public String getId()
    {
        return this.id;
    }
    public String getSembol()
    {
        return this.sembol;
    }
    public String getAd()
    {
        return this.ad;
    }
    public String getFiyat()
    {
        return this.fiyat;
    }

    public void setId(String id)
    {
        this.id = id;
    }
    public void setSembol(String sembol)
    {
        this.sembol = sembol;
    }
    public void setAd(String ad)
    {
        this.ad = ad;
    }
    public void setFiyat(String fiyat)
    {
        this.fiyat = fiyat;
    }

}
