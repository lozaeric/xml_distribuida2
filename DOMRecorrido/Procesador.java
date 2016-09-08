import org.w3c.dom.Node;
import org.w3c.dom.NodeList;


public abstract class Procesador {
	public abstract void procesar (Node nodo);
	
	public void recorrer (Node root) {
		procesar(root);
    	NodeList hijos = root.getChildNodes();
    	Node node;
    	for(int i=0;i<hijos.getLength();i++){
            node = hijos.item(i);
            recorrer(node);
        }
	}
}
