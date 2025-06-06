
package geoipclient;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="GetCountryNameByISO2Result" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "getCountryNameByISO2Result"
})
@XmlRootElement(name = "GetCountryNameByISO2Response")
public class GetCountryNameByISO2Response {

    @XmlElement(name = "GetCountryNameByISO2Result")
    protected String getCountryNameByISO2Result;

    /**
     * Gets the value of the getCountryNameByISO2Result property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGetCountryNameByISO2Result() {
        return getCountryNameByISO2Result;
    }

    /**
     * Sets the value of the getCountryNameByISO2Result property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGetCountryNameByISO2Result(String value) {
        this.getCountryNameByISO2Result = value;
    }

}
