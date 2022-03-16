package mypackage;

public class Portfoy
{
    public String id;
    public String sembol;
    public String maliyet;
    public String adet;

    public Portfoy(String id, String sembol, String maliyet, String adet)
    {
        this.id = id;
        this.sembol = sembol;
        this.maliyet = maliyet;
        this.adet = adet;
    }

    @Override
    public String toString()
    {
        return "Portfoy ( " +
                " Id = '" + id + '\'' +
                " Sembol = '" + sembol + '\'' +
                " Maliyet = '" + maliyet + '\'' +
                " Adet = '" + adet + '\'' +
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
    public String getMaliyet()
    {
        return this.maliyet;
    }
    public String getAdet()
    {
        return this.adet;
    }

    public void setId(String id)
    {
        this.id = id;
    }
    public void setSembol(String sembol)
    {
        this.sembol = sembol;
    }
    public void setAd(String maliyet)
    {
        this.maliyet = maliyet;
    }
    public void setAdet(String adet)
    {
        this.adet = adet;
    }
}
