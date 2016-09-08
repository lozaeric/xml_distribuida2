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
        recorrer (root);

    }
    
    public static void recorrer (Node nodo) {
    	if (nodo.getNodeType()==Node.TEXT_NODE)
    		System.out.println("Texto: "+nodo.getNodeName());
    	else if (nodo.getNodeType()==Node.COMMENT_NODE)
    		System.out.println("Comment: "+nodo.getNodeName());
    	else if (nodo.getNodeType()==Node.ATTRIBUTE_NODE)
    		System.out.println("Attribute: "+nodo.getNodeName());
    	else
    		System.out.println("Nodo: "+nodo.getNodeName());
    	
    	NodeList hijos = nodo.getChildNodes();
    	for(int i=0;i<hijos.getLength();i++){
            Node node = hijos.item(i);
            recorrer(node);
        }
    }

    public static void recorrer2 (Node root) {
    	ArrayDeque<Node> recorrido = new ArrayDeque<Node> ();
    	Node actual;
    	
    	recorrido.add(root);
    	while (!recorrido.isEmpty()) {
    		actual = recorrido.remove();
    		NodeList hijos = actual.getChildNodes();
    		if (hijos.getLength()==0)
    			continue;
        	for(int i=0;i<hijos.getLength();i++){
                Node node = hijos.item(i);
                if (node.getNodeType()==Node.TEXT_NODE)
            		System.out.println("Texto: "+node.getNodeName());
            	if (node.getNodeType()==Node.COMMENT_NODE)
            		System.out.println("Comment: "+node.getNodeName());
            	if (node.getNodeType()==Node.ATTRIBUTE_NODE)
            		System.out.println("Attribute: "+node.getNodeName());
            	else
            		System.out.println("Nodo: "+node.getNodeName());
                recorrido.addLast(node);
            }
    	}
    }    
    
}
