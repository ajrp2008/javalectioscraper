/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplicationhtmlunit;

import com.gargoylesoftware.htmlunit.ElementNotFoundException;
import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.SilentCssErrorHandler;
import com.gargoylesoftware.htmlunit.html.HtmlElement;
import com.gargoylesoftware.htmlunit.html.HtmlForm;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.gargoylesoftware.htmlunit.html.HtmlTable;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author andersjuulr.petersen
 */
public class JavaApplicationHTMLUnit {


    public Object[][] getElevDataList() throws NumberFormatException, ElementNotFoundException, SecurityException {
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

            HtmlPage page = webClient.getPage("https://www.lectio.dk/lectio/681/login.aspx?prevurl=subnav%2ffravaergroup.aspx%3fklasseid%3d15789905483");
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

            HtmlTable table = page.getHtmlElementById("s_m_Content_Content_fravaertbl");
            int antalElever = table.getRowCount() - 4;

            Object[][] listElever = new Object[antalElever][3];

            for (int e = 0; e < antalElever; e++) {
                listElever[e][0] = table.getCellAt(e + 3, 1).asText();
                listElever[e][1] = Double.parseDouble(table.getCellAt(e + 3, 2).asText().replace(",", ".").replace("%", ""));
                listElever[e][2] = Double.parseDouble(table.getCellAt(e + 3, 8).asText().replace(",", ".").replace("%", ""));

            }

            return listElever;

        } catch (IOException | FailingHttpStatusCodeException ex) {
            Logger.getLogger(JavaApplicationHTMLUnit.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
