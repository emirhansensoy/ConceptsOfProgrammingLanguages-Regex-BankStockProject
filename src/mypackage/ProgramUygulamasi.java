package mypackage;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;



public class ProgramUygulamasi
{
    public void hisseOku(ArrayList<Hisse> hisseler)
    {
        String text = "";

        File f = new File("./doc/hisseler.json");
        Scanner reader = null;
        try
        {
            reader = new Scanner(f);
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }

        while (reader.hasNextLine())
        {
            String data = reader.nextLine();
            text += data + "\n";
        }
        reader.close();

        Pattern pattern = Pattern.compile("\"[a-zA-Z0-9ÖÇŞİĞÜ_)('^\"+&.\\-\\s]+\"\\s*:\\s*\"*[a-zA-Z0-9ÖÇŞİĞÜ_)('^\"+&.\\-\\s]+\"*");
        Matcher matcher = pattern.matcher(text);

        String arr1[] = new String[2];
        String arr2[] = new String[4];

        int sayac = 0;

        while (matcher.find())
        {
            arr1 = matcher.group().split("\s*:\s*");

            for(int i = 0; i < 2; i++)
            {
                arr1[i] = arr1[i].replaceAll("\"","");
            }

            arr2[sayac] = arr1[1];

            if(sayac == 3)
            {
                hisseler.add(new Hisse(arr2[0],arr2[1],arr2[2],arr2[3]));
                sayac = 0;
            }
            else
            {
                sayac++;
            }

        }

    }

    public void hisseGoster(ArrayList<Hisse> hisseler)
    {
        for(Hisse s : hisseler)
        {
            System.out.println(s);
        }
    }

    public int hisseBul(String sembol, ArrayList<Hisse> hisseler)
    {
        for(int i = 0; i < hisseler.size(); i++)
        {
            if(hisseler.get(i).getSembol().matches(sembol))
            {
                return i;
            }
        }
        return -1;
    }

    public void portfoyOku(ArrayList<Portfoy> portfoyler)
    {
        String text = "";

        File f = new File("./doc/portfoy.json");
        Scanner reader = null;
        try
        {
            reader = new Scanner(f);
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }

        while (reader.hasNextLine())
        {
            String data = reader.nextLine();
            text += data + "\n";
        }
        reader.close();

        Pattern pattern = Pattern.compile("\"[a-zA-Z0-9ÖÇŞİĞÜ_)('^\"+&.\\-\\s]+\"\\s*:\\s*\"*[a-zA-Z0-9ÖÇŞİĞÜ_)('^\"+&.\\-\\s]+\"*");
        Matcher matcher = pattern.matcher(text);

        String arr1[] = new String[2];
        String arr2[] = new String[4];

        int sayac = 0;

        while (matcher.find())
        {
            arr1 = matcher.group().split("\s*:\s*");

            for(int i = 0; i < 2; i++)
            {
                arr1[i] = arr1[i].replaceAll("\"","");
            }

            arr2[sayac] = arr1[1];

            if(sayac == 3)
            {
                portfoyler.add(new Portfoy(arr2[0],arr2[1],arr2[2],arr2[3]));
                sayac = 0;
            }
            else
            {
                sayac++;
            }

        }

    }

    public void portfoyGoster(ArrayList<Portfoy> portfoyler)
    {
        for(Portfoy s : portfoyler)
        {
            System.out.println(s);
        }
    }

    public int portfoyBul(String sembol, ArrayList<Portfoy> portfoyler)
    {
        for(int i = 0; i < portfoyler.size(); i++)
        {
            if(portfoyler.get(i).getSembol().matches(sembol))
            {
                return i;
            }
        }
        return -1;
    }

    public void emirOku(ArrayList<Emir> emirler)
    {
        String text = "";

        File f = new File("./doc/emirler.json");
        Scanner reader = null;
        try
        {
            reader = new Scanner(f);
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }

        while (reader.hasNextLine())
        {
            String data = reader.nextLine();
            text += data + "\n";
        }
        reader.close();

        Pattern pattern = Pattern.compile("\"[a-zA-Z0-9ÖÇŞİĞÜ_)('^\"+&.\\-\\s]+\"\\s*:\\s*\"*[a-zA-Z0-9ÖÇŞİĞÜ_)('^\"+&.\\-\\s]+\"*");
        Matcher matcher = pattern.matcher(text);

        String arr1[] = new String[2];
        String arr2[] = new String[4];

        int sayac = 0;

        while (matcher.find())
        {
            arr1 = matcher.group().split("\s*:\s*");

            for(int i = 0; i < 2; i++)
            {
                arr1[i] = arr1[i].replaceAll("\"","");
            }

            arr2[sayac] = arr1[1];

            if(sayac == 3)
            {
                emirler.add(new Emir(arr2[0],arr2[1],arr2[2],arr2[3]));
                sayac = 0;
            }
            else
            {
                sayac++;
            }

        }

    }

    public void emirGoster(ArrayList<Emir> emirler)
    {
        for(Emir s : emirler)
        {
            System.out.println(s);
        }
    }

    public int emirBul(String sembol, ArrayList<Emir> emirler)
    {
        for(int i = 0; i < emirler.size(); i++)
        {
            if(emirler.get(i).getSembol().matches(sembol))
            {
                return i;
            }
        }
        return -1;
    }

    public void alimSatimIslemiYap(ArrayList<Hisse> hisseler, ArrayList<Portfoy> portfoyler, ArrayList<Emir> emirler)
    {
        DecimalFormat df = new DecimalFormat("###.##");

        for(int i = 0; i < emirler.size(); i++)
        {
            if(emirler.get(i).getIslem().matches(".*SATIS.*"))
            {
                System.out.println(
                        emirler.get(i).getSembol() + " hissesi icin satis:\n"
                        + "Guncel Fiyat: " + hisseler.get(hisseBul(emirler.get(i).getSembol(), hisseler)).getFiyat() + " "
                        + emirler.get(i).getAdet() + "x" + hisseler.get(hisseBul(emirler.get(i).getSembol(), hisseler)).getFiyat()
                        + " = " + df.format(Double.parseDouble(emirler.get(i).getAdet())*Double.parseDouble(hisseler.get(hisseBul(emirler.get(i).getSembol(), hisseler)).getFiyat()))
                        + " TL\n"
                        + "Maliyet: " + portfoyler.get(portfoyBul(emirler.get(i).getSembol(), portfoyler)).getMaliyet() + " "
                        + emirler.get(i).getAdet() + "x" + portfoyler.get(portfoyBul(emirler.get(i).getSembol(), portfoyler)).getMaliyet()
                        + " = " + df.format(Double.parseDouble(emirler.get(i).getAdet())*Double.parseDouble(portfoyler.get(portfoyBul(emirler.get(i).getSembol(), portfoyler)).getMaliyet()))
                        + " TL\n"
                );
            }
        }

        for(int i = 0; i < emirler.size(); i++)
        {
            if(emirler.get(i).getIslem().matches(".*ALIS.*"))
            {
                System.out.println(
                        emirler.get(i).getSembol() + " hissesi icin alis:\n"
                        + "Guncel Fiyat: " + hisseler.get(hisseBul(emirler.get(i).getSembol(), hisseler)).getFiyat() + " "
                        + emirler.get(i).getAdet() + "x" + hisseler.get(hisseBul(emirler.get(i).getSembol(), hisseler)).getFiyat()
                        + " = " + df.format(Double.parseDouble(emirler.get(i).getAdet())*Double.parseDouble(hisseler.get(hisseBul(emirler.get(i).getSembol(), hisseler)).getFiyat()))
                        + " TL\n"
                        + "Maliyet Hesabi: Onceden " + portfoyler.get(portfoyBul(emirler.get(i).getSembol(), portfoyler)).getAdet()
                        + " adet ve maliyeti " + portfoyler.get(portfoyBul(emirler.get(i).getSembol(), portfoyler)).getMaliyet() + " TL idi.\n"
                        + "Yeni maliyet " + portfoyler.get(portfoyBul(emirler.get(i).getSembol(), portfoyler)).getAdet() + "x" + portfoyler.get(portfoyBul(emirler.get(i).getSembol(), portfoyler)).getMaliyet()
                        + " + " + emirler.get(i).getAdet() + "x" + hisseler.get(hisseBul(emirler.get(i).getSembol(), hisseler)).getFiyat() + " = "
                        + df.format(
                                Double.parseDouble(portfoyler.get(portfoyBul(emirler.get(i).getSembol(), portfoyler)).getAdet()) * Double.parseDouble(portfoyler.get(portfoyBul(emirler.get(i).getSembol(), portfoyler)).getMaliyet())
                                + Double.parseDouble(emirler.get(i).getAdet()) * Double.parseDouble(hisseler.get(hisseBul(emirler.get(i).getSembol(), hisseler)).getFiyat())
                        )
                        + " => " + df.format(
                                Double.parseDouble(portfoyler.get(portfoyBul(emirler.get(i).getSembol(), portfoyler)).getAdet()) * Double.parseDouble(portfoyler.get(portfoyBul(emirler.get(i).getSembol(), portfoyler)).getMaliyet())
                                + Double.parseDouble(emirler.get(i).getAdet()) * Double.parseDouble(hisseler.get(hisseBul(emirler.get(i).getSembol(), hisseler)).getFiyat())
                        )
                        + "/" + (Double.parseDouble(portfoyler.get(portfoyBul(emirler.get(i).getSembol(), portfoyler)).getAdet())+Double.parseDouble(emirler.get(i).getAdet())) + " = "
                        + df.format(
                                (Double.parseDouble(portfoyler.get(portfoyBul(emirler.get(i).getSembol(), portfoyler)).getAdet()) * Double.parseDouble(portfoyler.get(portfoyBul(emirler.get(i).getSembol(), portfoyler)).getMaliyet())
                                + Double.parseDouble(emirler.get(i).getAdet()) * Double.parseDouble(hisseler.get(hisseBul(emirler.get(i).getSembol(), hisseler)).getFiyat())) /
                                (Double.parseDouble(portfoyler.get(portfoyBul(emirler.get(i).getSembol(), portfoyler)).getAdet())+Double.parseDouble(emirler.get(i).getAdet()))
                        )
                        + " TL olacaktir\n"
                );
            }
        }
    }

    public void karZararYazdir(ArrayList<Hisse> hisseler, ArrayList<Portfoy> portfoyler, ArrayList<Emir> emirler)
    {
        DecimalFormat df = new DecimalFormat("###.##");
        System.out.println("Satislar Kar/Zarar:");

        double guncelFiyat;
        double maliyet;
        double karZarar;
        double toplamKarZarar = 0;

        for(int i = 0; i < emirler.size(); i++)
        {
            if(emirler.get(i).getIslem().matches(".*SATIS.*"))
            {
                if(hisseBul(emirler.get(i).getSembol(),hisseler) != -1 && portfoyBul(emirler.get(i).getSembol(),portfoyler) != -1)
                {
                    if(Double.parseDouble(emirler.get(i).getAdet()) <= Double.parseDouble(portfoyler.get(portfoyBul(emirler.get(i).getSembol(),portfoyler)).getAdet()))
                    {
                        guncelFiyat = Double.parseDouble(emirler.get(i).getAdet())*Double.parseDouble(hisseler.get(hisseBul(emirler.get(i).getSembol(), hisseler)).getFiyat());
                        maliyet = Double.parseDouble(emirler.get(i).getAdet())*Double.parseDouble(portfoyler.get(portfoyBul(emirler.get(i).getSembol(), portfoyler)).getMaliyet());

                    }
                    else
                    {
                        guncelFiyat = Double.parseDouble(portfoyler.get(portfoyBul(emirler.get(i).getSembol(),portfoyler)).getAdet())*Double.parseDouble(hisseler.get(hisseBul(emirler.get(i).getSembol(), hisseler)).getFiyat());
                        maliyet = Double.parseDouble(portfoyler.get(portfoyBul(emirler.get(i).getSembol(),portfoyler)).getAdet())*Double.parseDouble(portfoyler.get(portfoyBul(emirler.get(i).getSembol(), portfoyler)).getMaliyet());

                    }
                    karZarar = guncelFiyat - maliyet;
                    if(karZarar > 0)
                    {
                        System.out.println(emirler.get(i).getSembol() + ": " + df.format(karZarar) + " TL Kar");
                    }
                    else if(karZarar < 0)
                    {
                        System.out.println(emirler.get(i).getSembol() + ": " + df.format(karZarar*(-1)) + " TL Zarar");
                    }
                    else
                    {
                        System.out.println(emirler.get(i).getSembol() + ": " + df.format(karZarar) + " TL");
                    }
                    toplamKarZarar += karZarar;

                }
            }
        }
        if(toplamKarZarar > 0)
        {
            System.out.println("Toplam Kar/Zarar: +" + df.format(toplamKarZarar) + " TL");
        }
        else
        {
            System.out.println("Toplam Kar/Zarar: " + df.format(toplamKarZarar) + " TL");
        }
        System.out.println();
    }

    public void guncelPortfoyYazdir(ArrayList<Hisse> hisseler, ArrayList<Portfoy> portfoyler, ArrayList<Emir> emirler)
    {
        DecimalFormat df = new DecimalFormat("###.##");
        System.out.println("Guncel Portfoy:");

        double guncelFiyat;
        double eskiFiyat;
        double yeniFiyat;
        double yeniMaliyet;
        double yeniAdet;

        int sayac = 0;

        for(int i = 0; i < emirler.size(); i++)
        {
            if(emirler.get(i).getIslem().matches(".*ALIS.*"))
            {
                if(hisseBul(emirler.get(i).getSembol(),hisseler) != -1)
                {
                    if(portfoyBul(emirler.get(i).getSembol(), portfoyler) != -1)
                    {
                        guncelFiyat = Double.parseDouble(emirler.get(i).getAdet()) * Double.parseDouble(hisseler.get(hisseBul(emirler.get(i).getSembol(), hisseler)).getFiyat());
                        eskiFiyat = Double.parseDouble(portfoyler.get(portfoyBul(emirler.get(i).getSembol(), portfoyler)).getAdet()) * Double.parseDouble(portfoyler.get(portfoyBul(emirler.get(i).getSembol(), portfoyler)).getMaliyet());
                        yeniFiyat = eskiFiyat + guncelFiyat;
                        yeniAdet = Double.parseDouble(emirler.get(i).getAdet()) + Double.parseDouble(portfoyler.get(portfoyBul(emirler.get(i).getSembol(), portfoyler)).getAdet());
                    }
                    else
                    {
                        yeniFiyat = Double.parseDouble(emirler.get(i).getAdet()) * Double.parseDouble(hisseler.get(hisseBul(emirler.get(i).getSembol(), hisseler)).getFiyat());
                        yeniAdet = Double.parseDouble(emirler.get(i).getAdet());
                    }

                    yeniMaliyet = yeniFiyat / yeniAdet;

                    if(sayac > 0)
                    {
                        System.out.println("--------------------------");
                    }
                    System.out.println(
                            "Hisse: " + emirler.get(i).getSembol() + "\n"
                                    + "Adet: " + df.format(yeniAdet) + "\n"
                                    + "Maliyet: " + df.format(yeniMaliyet)
                    );
                    sayac = 1;
                }
            }
        }
        for(int i = 0; i < portfoyler.size(); i++)
        {
            if(emirBul(portfoyler.get(i).getSembol(),emirler) == -1)
            {
                if(sayac > 0)
                {
                    System.out.println("--------------------------");
                }
                System.out.println(
                        "Hisse: " + portfoyler.get(i).getSembol() + "\n"
                                + "Adet: " + portfoyler.get(i).getAdet() + "\n"
                                + "Maliyet: " + portfoyler.get(i).getMaliyet()
                );
                sayac = 1;
            }
        }
        System.out.println();


    }

    public static void main(String[] args)
    {
        ProgramUygulamasi program = new ProgramUygulamasi();
        ArrayList<Hisse> hisseler = new ArrayList<>();
        ArrayList<Portfoy> portfoyler = new ArrayList<>();
        ArrayList<Emir> emirler = new ArrayList<>();

        program.hisseOku(hisseler);
        program.portfoyOku(portfoyler);
        program.emirOku(emirler);

        program.karZararYazdir(hisseler,portfoyler,emirler);
        program.guncelPortfoyYazdir(hisseler,portfoyler,emirler);
    }
}
