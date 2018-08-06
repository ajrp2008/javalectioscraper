/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplicationhtmlunit.htmlUnitUtils;

import com.gargoylesoftware.htmlunit.ElementNotFoundException;
import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.SilentCssErrorHandler;
import com.gargoylesoftware.htmlunit.html.HtmlElement;
import com.gargoylesoftware.htmlunit.html.HtmlForm;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.gargoylesoftware.htmlunit.html.HtmlTable;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javaapplicationhtmlunit.data.ElevData;

/**
 *
 * @author andersjuulr.petersen
 */
public class ElevListerHtmlUnit {

    public ArrayList<ElevData> elevArrayListe = new ArrayList<ElevData>();

    public void getElevDataList() throws NumberFormatException, ElementNotFoundException, SecurityException, ParseException {
        try {
            java.util.logging.Logger.getLogger("com.gargoylesoftware.htmlunit").setLevel(Level.OFF);
            java.util.logging.Logger.getLogger("org.apache.commons.httpclient").setLevel(Level.OFF);

            WebClient webClient = new WebClient();
            //CSSErrorHandler e = webClient.getCssErrorHandler();

            webClient.getOptions().setRedirectEnabled(true);
            webClient.getCookieManager().setCookiesEnabled(true);
            webClient.getOptions().setJavaScriptEnabled(true);
            webClient.getOptions().setJavaScriptEnabled(true);
            webClient.getOptions().setUseInsecureSSL(true);
            webClient.getOptions().setThrowExceptionOnScriptError(false);
            webClient.getOptions().setPrintContentOnFailingStatusCode(false);
            webClient.setCssErrorHandler(new SilentCssErrorHandler());

            HtmlPage page = webClient.getPage("https://www.lectio.dk/lectio/681/subnav/fravaergroup.aspx?klasseid=15789905483");
            //https://www.lectio.dk/lectio/681/login.aspx
            //https://www.lectio.dk/lectio/681/login.aspx?prevurl=subnav%2ffravaergroup.aspx%3fklasseid%3d15789905483
            int i = 0;

            for (HtmlForm f : page.getForms()) {
                System.out.println("DETTE ER FORM NR.: " + i++);
                if (i > 1) {
                    f.getInputByName("m$Content$username2").setValueAttribute("ajrp");
                    f.getInputByName("m$Content$password2").setValueAttribute("Isak010212");
                }
            }

            HtmlElement htmlAnchor = page.getHtmlElementById("m_Content_submitbtn2");//  .getAnchorByHref("/romarin/detail.do?ID=0");
            System.out.println("CLICKING THE BUT");
            page = htmlAnchor.click();

            HtmlElement input =  page.getHtmlElementById("s_m_Content_Content_PeriodChooserCtrl_end__date_tb");
            
           // System.out.println("DATO ?????? " + input.asText());
            
            DateFormat format = new SimpleDateFormat("dd/MM-yyyy", Locale.getDefault());
            Date tid = format.parse(input.asText());
            System.out.println(tid);
            
            HtmlTable table = page.getHtmlElementById("s_m_Content_Content_fravaertbl");
            int antalElever = table.getRowCount() - 4;

            // Object[][] listElever = new Object[antalElever][3];
            this.elevArrayListe.clear();

            for (int e = 0; e < antalElever; e++) {
                String navn = table.getCellAt(e + 3, 1).asText();
                String almFT = table.getCellAt(e + 3, 2).asText();
                String skrFT = table.getCellAt(e + 3, 8).asText();
                double almF = almFT.length() > 0 ? Double.parseDouble(skrFT.replace(",", ".").replace("%", "")): 0;
                double skrF = skrFT.length() > 0 ? Double.parseDouble(skrFT.replace(",", ".").replace("%", "")) : 0;
                // listElever[e][0] = navn;
                // listElever[e][1] = almF;
                // listElever[e][2] = skrF;
                elevArrayListe.add(new ElevData(navn, almF, skrF, 0, 0,tid));
            }

        } catch (IOException | FailingHttpStatusCodeException ex) {
            Logger.getLogger(ElevListerHtmlUnit.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ElevData getElevFromName(String navn) {
        ElevData elev = null;

        for (ElevData e : elevArrayListe) {
            if (e.navn.compareTo((String) navn) == 0) {
                elev = e;
            }
        }

        return elev;
    }

}
