package mypackage;

public class Emir
{
    public String id;
    public String sembol;
    public String islem;
    public String adet;

    public Emir(String id, String sembol, String islem, String adet)
    {
        this.id = id;
        this.sembol = sembol;
        this.islem = islem;
        this.adet = adet;
    }

    @Override
    public String toString()
    {
        return "Emir ( " +
                " Id = '" + id + '\'' +
                " Sembol = '" + sembol + '\'' +
                " Islem = '" + islem + '\'' +
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
    public String getIslem()
    {
        return this.islem;
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
    public void setIslem(String islem)
    {
        this.islem = islem;
    }
    public void setAdet(String adet)
    {
        this.adet = adet;
    }
}
