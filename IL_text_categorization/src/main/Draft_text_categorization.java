package main;
/**
 * 
 */


import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author DIEGO
 *
 */
public class Draft_text_categorization {

	/**
	 * 
	 */
	public Draft_text_categorization() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 * http://stackoverflow.com/questions/3622112/vector-space-model-algorithm-in-java-to-get-the-similarity-score-between-two-peo
	 * 
	 * @param v1
	 * @param v2
	 * @return
	 */
	static double cosine_similarity(Map<String, Double> v1, Map<String, Double> v2) {
		@SuppressWarnings("unchecked")
		Set<String> both = new HashSet(v1.keySet());
		both.removeAll(v2.keySet());

		double sclar = 0, norm1 = 0, norm2 = 0;

		/*
		 * We need to perform cosine similarity only on words that exist in both
		 * lists
		 */
		for (String k : both) {
			sclar += v1.get(k) * v2.get(k);
			norm1 += v1.get(k) * v1.get(k);
			norm2 += v2.get(k) * v2.get(k);
		}
		return sclar / Math.sqrt(norm1 * norm2);
	}
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		/**
		 *	1) se obtiene el listado de documentos de un path
		 *
		 *	2) for(Documento : listaDocumentos){
		 *		2.1) eliminar las stop_words del documento
		 *		
		 *		2.2) asignar peso a cada término (# apariciones)
		 *
		 *		2.3) se categoriza el Documento
		 *			2.3.1) se calcula la similaridad numérica entre cada “documento query (Q)” (vector/set) y cada vector 
		 *					documento en la colección (Di):
			
							Sim(Q; Di) = SUM(qj*dij) para los términos comunes tj
			
						donde:
						tj → término presente en Q y Di
						qj → peso del término tj en Q
						dij → peso del término tj en Di
						
						for(glosario : lista_glosarios){
							double similaridad = cosine_similarity(Map v1, Map v2);
							syso(similaridad);
						}
						
		 *	   }
		 *
		 *
		 */

	}

}
