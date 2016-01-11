package main;
/**
 * 
 */


import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
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
	
	public static Map<String, Integer> wordCounterMethod(InputStream in) {
        BufferedReader br = null;
        String words[] = null;
        String line;
        Map<String, Integer> wordCount = new HashMap<String, Integer>();     //Creates an Hash Map for storing the words and its count
        try {
        	br = new BufferedReader(new InputStreamReader(in));      //creates an Buffered Reader to read the contents of the file
            
        	while ((line = br.readLine()) != null) {
                words = line.toLowerCase().split("\\s+");                      //Splits the words with "space" as an delimeter 
            }
            br.close();
            
            for (String read : words) {
                Integer freq = wordCount.get(read);
                wordCount.put(read, (freq == null) ? 1 : freq + 1); //For Each word the count will be incremented in the Hashmap
            }
        } catch (NullPointerException | IOException e) {
            System.out.println("I could'nt read your files:" + e);
        }
            
        System.out.println(wordCount.size() + " distinct words:");     //Prints the Number of Distinct words found in the files read
        System.out.println(wordCount);                                 //Prints the Word and its occurrence
        
        return wordCount;
	}
	
	/**
	 * Devuelve un Set<String> compuesto por los términos 
	 * que aparecen en el archivo txt pasado como parámetro
	 * 
	 * @param file
	 * @return
	 */
	public Set<String> fileToSet(Scanner file){
		Set<String> doc = new HashSet<>();
		while (file.hasNext()) {
		    doc.add(file.next().trim().toLowerCase());
		}
		
		return doc;
	}
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(StopWords.class.getResourceAsStream("/clippings/test.txt"));
		InputStream fileIs = StopWords.class.getResourceAsStream("/clippings/test.txt");
				
		Map<String, Integer> wordCount = wordCounterMethod(fileIs);
		
//		while (scan.hasNext()) {
//		    System.out.println(scan.next().trim().toLowerCase());
//		}
		
		String[] stop_words_vector = StopWords.stop_words;
		
		Set<String> stop_words_set = new HashSet<>();
		for(String stop_word:stop_words_vector){
			stop_words_set.add(stop_word.toLowerCase());
		}
		
		// Set que contiene todos los términos de un documento
		Set<String> document = new HashSet<>(); //TODO
		// Eliminamos las stop_words del documento
		document.removeAll(stop_words_set);
		
		
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
