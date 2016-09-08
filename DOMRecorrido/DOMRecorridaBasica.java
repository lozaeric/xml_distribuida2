import org.apache.xerces.parsers.DOMParser;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayDeque;

/**
 * Created by Juan Lagostena on 04/09/16
 * jlagostena@bitsense.com.ar
 * .
 */
public class DOMRecorridaBasica {


    public static void main(String [] args) throws IOException, SAXException {

        // Creamos el parseador
        DOMParser parser = new DOMParser();

       ClassLoader classLoader = DOMRecorridaBasica.class.getClassLoader();
        InputStream is = null;

        try {
            is = new FileInputStream("propiedades_original.xml");
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        // Procesamos el fichero XML
        parser.parse(new InputSource(is));
        Document doc = parser.getDocument();

        Node root = doc.getDocumentElement();
        recorrer (root, new ProcesadorImpl());

    }
    
    public static void recorrer (Node nodo, Procesador p) {
    	p.procesar(nodo);
    	
    	NodeList hijos = nodo.getChildNodes();
    	Node node;
    	for(int i=0;i<hijos.getLength();i++){
            node = hijos.item(i);
            recorrer(node, p);
        }
    }
    
}
