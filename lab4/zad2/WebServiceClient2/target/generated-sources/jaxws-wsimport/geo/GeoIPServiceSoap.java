
package geo;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.8
 * Generated source version: 2.2
 * 
 */
@WebService(name = "GeoIPServiceSoap", targetNamespace = "http://lavasoft.com/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface GeoIPServiceSoap {


    /**
     * <br/>Get Country and State XML String for a given ip address in x.x.x.x format<br/><br/>Parameter:GetIpAddress address &nbsp;&nbsp;&nbsp;&nbsp;<b>Type:String</b><br/><br/>Return:format in XML < GeoIP >< Country >US< /Country >< State >PA< /State >< /GeoIP > &nbsp;&nbsp;&nbsp;&nbsp;<b>Type:String</b>
     * 
     * @param sIp
     * @return
     *     returns java.lang.String
     */
    @WebMethod(operationName = "GetIpLocation", action = "http://lavasoft.com/GetIpLocation")
    @WebResult(name = "GetIpLocationResult", targetNamespace = "http://lavasoft.com/")
    @RequestWrapper(localName = "GetIpLocation", targetNamespace = "http://lavasoft.com/", className = "geo.GetIpLocation")
    @ResponseWrapper(localName = "GetIpLocationResponse", targetNamespace = "http://lavasoft.com/", className = "geo.GetIpLocationResponse")
    public String getIpLocation(
        @WebParam(name = "sIp", targetNamespace = "http://lavasoft.com/")
        String sIp);

    /**
     * <br/>Get Country and State XML String for a given ip address in x.x.x.x format<br/><br/>Parameter:GetIpAddress address &nbsp;&nbsp;&nbsp;&nbsp;<b>Type:String</b><br/><br/>Return:format in XML < GeoIP >< Country >US< /Country >< State >PA< /State >< /GeoIP > &nbsp;&nbsp;&nbsp;&nbsp;<b>Type:String</b> or <b>string empty</b> 
     * 
     * @param sIp
     * @return
     *     returns java.lang.String
     */
    @WebMethod(operationName = "GetIpLocation_2_0", action = "http://lavasoft.com/GetIpLocation_2_0")
    @WebResult(name = "GetIpLocation_2_0Result", targetNamespace = "http://lavasoft.com/")
    @RequestWrapper(localName = "GetIpLocation_2_0", targetNamespace = "http://lavasoft.com/", className = "geo.GetIpLocation20")
    @ResponseWrapper(localName = "GetIpLocation_2_0Response", targetNamespace = "http://lavasoft.com/", className = "geo.GetIpLocation20Response")
    public String getIpLocation20(
        @WebParam(name = "sIp", targetNamespace = "http://lavasoft.com/")
        String sIp);

    /**
     * <br/>Get Country and State XML String for a given ip address in x.x.x.x format<br/><br/>Parameter:GetIpAddress address &nbsp;&nbsp;&nbsp;&nbsp;<b>Type:String</b><br/><br/>Return:format in XML < GeoIP >< Country >US< /Country >< State >PA< /State >< /GeoIP > &nbsp;&nbsp;&nbsp;&nbsp;<b>Type:String</b>
     * 
     * @return
     *     returns java.lang.String
     */
    @WebMethod(operationName = "GetLocation", action = "http://lavasoft.com/GetLocation")
    @WebResult(name = "GetLocationResult", targetNamespace = "http://lavasoft.com/")
    @RequestWrapper(localName = "GetLocation", targetNamespace = "http://lavasoft.com/", className = "geo.GetLocation")
    @ResponseWrapper(localName = "GetLocationResponse", targetNamespace = "http://lavasoft.com/", className = "geo.GetLocationResponse")
    public String getLocation();

    /**
     * <br/>Get Country ISO2 code by Country Name<br/>Paramater:Country Name &nbsp;&nbsp;<b>Type:String<b/>
     * 
     * @param countryName
     * @return
     *     returns java.lang.String
     */
    @WebMethod(operationName = "GetCountryISO2ByName", action = "http://lavasoft.com/GetCountryISO2ByName")
    @WebResult(name = "GetCountryISO2ByNameResult", targetNamespace = "http://lavasoft.com/")
    @RequestWrapper(localName = "GetCountryISO2ByName", targetNamespace = "http://lavasoft.com/", className = "geo.GetCountryISO2ByName")
    @ResponseWrapper(localName = "GetCountryISO2ByNameResponse", targetNamespace = "http://lavasoft.com/", className = "geo.GetCountryISO2ByNameResponse")
    public String getCountryISO2ByName(
        @WebParam(name = "countryName", targetNamespace = "http://lavasoft.com/")
        String countryName);

    /**
     * <br/>Get Country Name by Country ISO2 code<br/>Paramater:Country Code &nbsp;&nbsp;<b>Type:String<b/><br/>Country code  format is ALPHA-2 (CA - for Canada)
     * 
     * @param iso2Code
     * @return
     *     returns java.lang.String
     */
    @WebMethod(operationName = "GetCountryNameByISO2", action = "http://lavasoft.com/GetCountryNameByISO2")
    @WebResult(name = "GetCountryNameByISO2Result", targetNamespace = "http://lavasoft.com/")
    @RequestWrapper(localName = "GetCountryNameByISO2", targetNamespace = "http://lavasoft.com/", className = "geo.GetCountryNameByISO2")
    @ResponseWrapper(localName = "GetCountryNameByISO2Response", targetNamespace = "http://lavasoft.com/", className = "geo.GetCountryNameByISO2Response")
    public String getCountryNameByISO2(
        @WebParam(name = "iso2Code", targetNamespace = "http://lavasoft.com/")
        String iso2Code);

}
