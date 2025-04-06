
package geo;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.8
 * Generated source version: 2.2
 * 
 */
@WebService(name = "GeoIPServiceHttpGet", targetNamespace = "http://lavasoft.com/")
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
@XmlSeeAlso({
    ObjectFactory.class
})
public interface GeoIPServiceHttpGet {


    /**
     * <br/>Get Country and State XML String for a given ip address in x.x.x.x format<br/><br/>Parameter:GetIpAddress address &nbsp;&nbsp;&nbsp;&nbsp;<b>Type:String</b><br/><br/>Return:format in XML < GeoIP >< Country >US< /Country >< State >PA< /State >< /GeoIP > &nbsp;&nbsp;&nbsp;&nbsp;<b>Type:String</b>
     * 
     * @param sIp
     * @return
     *     returns java.lang.String
     */
    @WebMethod(operationName = "GetIpLocation")
    @WebResult(name = "string", targetNamespace = "http://lavasoft.com/", partName = "Body")
    public String getIpLocation(
        @WebParam(name = "string", targetNamespace = "http://www.w3.org/2001/XMLSchema", partName = "sIp")
        String sIp);

    /**
     * <br/>Get Country and State XML String for a given ip address in x.x.x.x format<br/><br/>Parameter:GetIpAddress address &nbsp;&nbsp;&nbsp;&nbsp;<b>Type:String</b><br/><br/>Return:format in XML < GeoIP >< Country >US< /Country >< State >PA< /State >< /GeoIP > &nbsp;&nbsp;&nbsp;&nbsp;<b>Type:String</b> or <b>string empty</b> 
     * 
     * @param sIp
     * @return
     *     returns java.lang.String
     */
    @WebMethod(operationName = "GetIpLocation_2_0")
    @WebResult(name = "string", targetNamespace = "http://lavasoft.com/", partName = "Body")
    public String getIpLocation20(
        @WebParam(name = "string", targetNamespace = "http://www.w3.org/2001/XMLSchema", partName = "sIp")
        String sIp);

    /**
     * <br/>Get Country and State XML String for a given ip address in x.x.x.x format<br/><br/>Parameter:GetIpAddress address &nbsp;&nbsp;&nbsp;&nbsp;<b>Type:String</b><br/><br/>Return:format in XML < GeoIP >< Country >US< /Country >< State >PA< /State >< /GeoIP > &nbsp;&nbsp;&nbsp;&nbsp;<b>Type:String</b>
     * 
     * @return
     *     returns java.lang.String
     */
    @WebMethod(operationName = "GetLocation")
    @WebResult(name = "string", targetNamespace = "http://lavasoft.com/", partName = "Body")
    public String getLocation();

    /**
     * <br/>Get Country ISO2 code by Country Name<br/>Paramater:Country Name &nbsp;&nbsp;<b>Type:String<b/>
     * 
     * @param countryName
     * @return
     *     returns java.lang.String
     */
    @WebMethod(operationName = "GetCountryISO2ByName")
    @WebResult(name = "string", targetNamespace = "http://lavasoft.com/", partName = "Body")
    public String getCountryISO2ByName(
        @WebParam(name = "string", targetNamespace = "http://www.w3.org/2001/XMLSchema", partName = "countryName")
        String countryName);

    /**
     * <br/>Get Country Name by Country ISO2 code<br/>Paramater:Country Code &nbsp;&nbsp;<b>Type:String<b/><br/>Country code  format is ALPHA-2 (CA - for Canada)
     * 
     * @param iso2Code
     * @return
     *     returns java.lang.String
     */
    @WebMethod(operationName = "GetCountryNameByISO2")
    @WebResult(name = "string", targetNamespace = "http://lavasoft.com/", partName = "Body")
    public String getCountryNameByISO2(
        @WebParam(name = "string", targetNamespace = "http://www.w3.org/2001/XMLSchema", partName = "iso2Code")
        String iso2Code);

}
