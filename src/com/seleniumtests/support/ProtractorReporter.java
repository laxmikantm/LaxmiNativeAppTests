package com.seleniumtests.support;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import java.io.FileOutputStream;

/**
 * Created by Laxmi Somni on 26/08/2016.
 */
public class ProtractorReporter {
    public static void main(String[] args) {
        try {

            TransformerFactory tFactory = TransformerFactory.newInstance();

            Transformer transformer =
                    tFactory.newTransformer
                            (new javax.xml.transform.stream.StreamSource
                                    ("Result.xsl"));

            transformer.transform
                    (new javax.xml.transform.stream.StreamSource
                                    ("C:\\Users\\Eval9\\Desktop\\Tractor\\lib\\junitresults.xml"),
                            new javax.xml.transform.stream.StreamResult
                                    ( new FileOutputStream("Result.html")));
        }
        catch (Exception e) {
            e.printStackTrace( );
        }
    }
}
