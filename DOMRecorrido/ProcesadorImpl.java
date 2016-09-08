import org.w3c.dom.Node;


public class ProcesadorImpl implements Procesador {

	public void procesar (Node nodo) {
    	if (nodo.getNodeType()==Node.TEXT_NODE)
    		System.out.println("Texto: "+nodo.getNodeName());
    	else if (nodo.getNodeType()==Node.COMMENT_NODE)
    		System.out.println("Comment: "+nodo.getNodeName());
    	else if (nodo.getNodeType()==Node.ATTRIBUTE_NODE)
    		System.out.println("Attribute: "+nodo.getNodeName());
    	else
    		System.out.println("Nodo: "+nodo.getNodeName());
	}
}
