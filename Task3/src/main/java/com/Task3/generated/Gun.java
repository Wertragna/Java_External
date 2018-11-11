//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2018.11.10 at 11:58:33 PM EET 
//


package com.Task3.generated;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


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
 *         &lt;element name="weapon" maxOccurs="unbounded">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="model" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="handly" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="origin" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="material" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="ttc">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="range">
 *                               &lt;simpleType>
 *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                                   &lt;enumeration value="close"/>
 *                                   &lt;enumeration value="average "/>
 *                                   &lt;enumeration value="long "/>
 *                                 &lt;/restriction>
 *                               &lt;/simpleType>
 *                             &lt;/element>
 *                             &lt;element name="sighting_range" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *                             &lt;element name="yoke" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *                             &lt;element name="optics" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *                 &lt;attribute name="id" use="required" type="{http://www.w3.org/2001/XMLSchema}ID" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
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
    "weapon"
})
@XmlRootElement(name = "gun")
public class Gun {

    @XmlElement(required = true)
    protected List<Gun.Weapon> weapon;

    /**
     * Gets the value of the weapon property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the weapon property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getWeapon().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Gun.Weapon }
     * 
     * 
     */
    public List<Gun.Weapon> getWeapon() {
        if (weapon == null) {
            weapon = new ArrayList<Gun.Weapon>();
        }
        return this.weapon;
    }


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
     *         &lt;element name="model" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="handly" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="origin" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="material" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="ttc">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="range">
     *                     &lt;simpleType>
     *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *                         &lt;enumeration value="close"/>
     *                         &lt;enumeration value="average "/>
     *                         &lt;enumeration value="long "/>
     *                       &lt;/restriction>
     *                     &lt;/simpleType>
     *                   &lt;/element>
     *                   &lt;element name="sighting_range" type="{http://www.w3.org/2001/XMLSchema}int"/>
     *                   &lt;element name="yoke" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
     *                   &lt;element name="optics" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *       &lt;/sequence>
     *       &lt;attribute name="id" use="required" type="{http://www.w3.org/2001/XMLSchema}ID" />
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "model",
        "handly",
        "origin",
        "material",
        "ttc"
    })
    public static class Weapon {
        @Override
        public String toString() {
            return "Weapon{" +
                    "model='" + model + '\'' +
                    ", handly='" + handly + '\'' +
                    ", origin='" + origin + '\'' +
                    ", material='" + material + '\'' +
                    ", ttc=" + ttc +
                    ", id='" + id + '\'' +
                    '}';
        }

        @XmlElement(required = true)
        protected String model;
        @XmlElement(required = true)
        protected String handly;
        @XmlElement(required = true)
        protected String origin;
        @XmlElement(required = true)
        protected String material;
        @XmlElement(required = true)
        protected Gun.Weapon.Ttc ttc;
        @XmlAttribute(name = "id", required = true)
        @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
        @XmlID
        @XmlSchemaType(name = "ID")
        protected String id;

        /**
         * Gets the value of the model property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getModel() {
            return model;
        }

        /**
         * Sets the value of the model property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setModel(String value) {
            this.model = value;
        }

        /**
         * Gets the value of the handly property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getHandly() {
            return handly;
        }

        /**
         * Sets the value of the handly property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setHandly(String value) {
            this.handly = value;
        }

        /**
         * Gets the value of the origin property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getOrigin() {
            return origin;
        }

        /**
         * Sets the value of the origin property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setOrigin(String value) {
            this.origin = value;
        }

        /**
         * Gets the value of the material property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getMaterial() {
            return material;
        }

        /**
         * Sets the value of the material property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setMaterial(String value) {
            this.material = value;
        }

        /**
         * Gets the value of the ttc property.
         * 
         * @return
         *     possible object is
         *     {@link Gun.Weapon.Ttc }
         *     
         */
        public Gun.Weapon.Ttc getTtc() {
            return ttc;
        }

        /**
         * Sets the value of the ttc property.
         * 
         * @param value
         *     allowed object is
         *     {@link Gun.Weapon.Ttc }
         *     
         */
        public void setTtc(Gun.Weapon.Ttc value) {
            this.ttc = value;
        }

        /**
         * Gets the value of the id property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getId() {
            return id;
        }

        /**
         * Sets the value of the id property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setId(String value) {
            this.id = value;
        }


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
         *         &lt;element name="range">
         *           &lt;simpleType>
         *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
         *               &lt;enumeration value="close"/>
         *               &lt;enumeration value="average "/>
         *               &lt;enumeration value="long "/>
         *             &lt;/restriction>
         *           &lt;/simpleType>
         *         &lt;/element>
         *         &lt;element name="sighting_range" type="{http://www.w3.org/2001/XMLSchema}int"/>
         *         &lt;element name="yoke" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
         *         &lt;element name="optics" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
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
            "range",
            "sightingRange",
            "yoke",
            "optics"
        })
        public static class Ttc {
            @Override
            public String toString() {
                return "Ttc{" +
                        "range='" + range + '\'' +
                        ", sightingRange=" + sightingRange +
                        ", yoke=" + yoke +
                        ", optics=" + optics +
                        '}';
            }

            @XmlElement(required = true)
            protected String range;
            @XmlElement(name = "sighting_range")
            protected int sightingRange;
            protected boolean yoke;
            protected boolean optics;

            /**
             * Gets the value of the range property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getRange() {
                return range;
            }

            /**
             * Sets the value of the range property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setRange(String value) {
                this.range = value;
            }

            /**
             * Gets the value of the sightingRange property.
             * 
             */
            public int getSightingRange() {
                return sightingRange;
            }

            /**
             * Sets the value of the sightingRange property.
             * 
             */
            public void setSightingRange(int value) {
                this.sightingRange = value;
            }

            /**
             * Gets the value of the yoke property.
             * 
             */
            public boolean isYoke() {
                return yoke;
            }

            /**
             * Sets the value of the yoke property.
             * 
             */
            public void setYoke(boolean value) {
                this.yoke = value;
            }

            /**
             * Gets the value of the optics property.
             * 
             */
            public boolean isOptics() {
                return optics;
            }

            /**
             * Sets the value of the optics property.
             * 
             */
            public void setOptics(boolean value) {
                this.optics = value;
            }

        }

    }

}
