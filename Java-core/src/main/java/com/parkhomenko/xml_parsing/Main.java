package com.parkhomenko.xml_parsing;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.*;
import java.io.*;

/**
 * Created by dmytro on 12/29/16.
 */
public class Main {

    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {

        InputStream stream = Main.class.getResourceAsStream("/input.xml");


        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();


        Document doc = builder.parse(stream);
        doc.getDocumentElement().normalize();

        System.out.println("Root element :" + doc.getDocumentElement().getNodeName());

        NodeList nList = doc.getElementsByTagName("Token");


        System.out.println("----------------------------");

        for (int temp = 0; temp < nList.getLength(); temp++) {

            Node nNode = nList.item(temp);

            System.out.println("\nCurrent Element :" + nNode.getNodeName());

            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement = (Element) nNode;

                System.out.println("serial : "
                        + eElement.getAttribute("serial"));

                System.out.println("CaseModel : "
                        + eElement
                        .getElementsByTagName("CaseModel")
                        .item(0)
                        .getTextContent());

                System.out.println("Model : "
                        + eElement
                        .getElementsByTagName("Model")
                        .item(0)
                        .getTextContent());
                System.out.println("ProductionDate : "
                        + eElement
                        .getElementsByTagName("ProductionDate")
                        .item(0)
                        .getTextContent());
                System.out.println("ProductName : "
                        + eElement
                        .getElementsByTagName("ProductName")
                        .item(0)
                        .getTextContent());

                //TODO


                NodeList application = eElement.getElementsByTagName("Application");

                for (int j = 0; j < application.getLength(); j++) {
                    Node item = application.item(j);

                    System.out.println("\nCurrent Element :" + item.getNodeName());

                    Element eElement1 = (Element) item;

                    String attribute = eElement1.getAttribute("ConnectorID");

                    System.out.println("ConnectorID : "
                            + attribute);

                    System.out.println("Seed : "
                            + eElement1
                            .getElementsByTagName("Seed")
                            .item(0)
                            .getTextContent());

                    System.out.println("MovingFactor : "
                            + eElement1
                            .getElementsByTagName("MovingFactor")
                            .item(0)
                            .getTextContent());
                }
            }

        }



    }
}
