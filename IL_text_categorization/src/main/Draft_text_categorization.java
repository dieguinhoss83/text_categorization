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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.Vector;

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
	static double cosine_similarity(Map<String, Integer> v1, Map<String, Integer> v2) {
		Set<String> both = new HashSet(v1.keySet());
        both.retainAll(v2.keySet());
        double sclar = 0, norm1 = 0, norm2 = 0;
        
        for (String k : both) 
        	sclar += v1.get(k) * v2.get(k);
        for (String k : v1.keySet()) 
        	norm1 += v1.get(k) * v1.get(k);
        for (String k : v2.keySet()) 
        	norm2 += v2.get(k) * v2.get(k);
        return sclar / Math.sqrt(norm1 * norm2);
	}
	
	/**
	 * 
	 * 
	 * @param in
	 * @return
	 */
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
            
        //System.out.println(wordCount.size() + " distinct words:");     //Prints the Number of Distinct words found in the files read
        //System.out.println(wordCount);                                 //Prints the Word and its occurrence
        
        return wordCount;
	}
	
	/**
	 * 
	 * @param vector
	 * @return
	 */
	public static Map<String, Integer> wordCounterForVector(Vector<String> vector) {
        ArrayList<String> words = new ArrayList<String>();
        Map<String, Integer> wordCount = new HashMap<String, Integer>();     //Creates an Hash Map for storing the words and its count
        try {
        	
            for(String vectorElement:vector){
            	words.add(vectorElement.toLowerCase());                      //Splits the words with "space" as an delimeter
            }
            
            for (String read : words) {
                Integer freq = wordCount.get(read);
                wordCount.put(read, (freq == null) ? 1 : freq + 1); //For Each word the count will be incremented in the Hashmap
            }
        } catch (NullPointerException e) {
            System.out.println("I could'nt read your files:" + e);
        }
            
//        System.out.println(wordCount.size() + " distinct words:");     //Prints the Number of Distinct words found in the files read
//        System.out.println(wordCount);                                 //Prints the Word and its occurrence
        
        return wordCount;
	}
	
	/**
	 * Devuelve un Set<String> compuesto por los términos 
	 * que aparecen en el archivo txt pasado como parámetro
	 * 
	 * @param file
	 * @return
	 */
	public static Set<String> fileToSet(Scanner file){
		Set<String> doc = new HashSet<>();
		while (file.hasNext()) {
		    doc.add(file.next().trim().toLowerCase());
		}
		
		return doc;
	}
	
	/**
	 * 
	 * @param file
	 * @return
	 */
	public static Vector<String> fileToVector(Scanner file){
		Vector<String> doc = new Vector<>();
		while (file.hasNext()) {
		    doc.add(file.next().trim().toLowerCase());
		}
		
		return doc;
	}
	
	public static Map<String, Integer> docAsVectorToMap(String path)
	{
		Scanner scan = new Scanner(StopWords.class.getResourceAsStream(path));
		//InputStream fileIs = StopWords.class.getResourceAsStream("/clippings/test.txt");
		
		String[] stop_words_vector = StopWords.stop_words;
		
		Set<String> stop_words_set = new HashSet<>();
		for(String stop_word:stop_words_vector){
			stop_words_set.add(stop_word.toLowerCase());
		}
		
		// Vector que contiene todos los términos de un documento
		Vector<String> docToCategorize = fileToVector(scan);
		// Eliminamos las stop_words del documento
		docToCategorize.removeAll(stop_words_set);
		
		// 2.2) asignar peso a cada término (# apariciones)
		// Calculamos los pesos de cada palabra de la noticia
		Map<String, Integer> docWithWeights = wordCounterForVector(docToCategorize);
		
		return docWithWeights;
	}
	
	public static void news_categorization(String package_path){
		
		Map<String, Integer> glossWithWeights = new HashMap<String,Integer>();
		double similaridad = 0.0;
		String tipoGlosario = "";
		
		for(int counter = 1; counter<=15;counter++){
			//2.1) eliminar las stop_words del documento
			//Obtenemos el documento que queremos categorizar
			Map<String, Integer> docWithWeights = docAsVectorToMap(package_path+counter+".txt");
			
			for(int i=1; i<4; i++){
				glossWithWeights = docAsVectorToMap("/clippings/glosario_"+i+".txt");
				similaridad = cosine_similarity(docWithWeights, glossWithWeights);
				switch(i){
					case 1: 
						tipoGlosario="DEPORTES";
						break;
					case 2:
						tipoGlosario="ECONOMÍA";
						break;
					case 3: 
						tipoGlosario="POLÍTICA";
						break;
					
				}
				System.out.println("Similaridad de noticia "+package_path+counter+".txt con glosario de "+tipoGlosario+" = "+String.format("%.2f",similaridad*100)+" %");
			}
			System.out.println("\n");
			
			System.out.println("\n");
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		/**
		 *	1) se obtiene el listado de documentos de un path
		 *
		 *  2) for(Documento : listaDocumentos){
		 *		2.1) eliminar las stop_words del documento
		 *		
		 *		2.2) asignar peso a cada término (# apariciones)
		 *
		 *      2.3) se categoriza el Documento
			 *			2.3.1) se calcula la similaridad numérica entre cada “documento query (Q)” (vector/set) y cada vector 
			 *					documento en la colección (Di):
				
								Sim(Q; Di) = SUM(qj*dij) para los términos comunes tj
				
							donde:
							tj → término presente en Q y Di
							qj → peso del término tj en Q
							dij → peso del término tj en Di
			*/
		//Categorizamos noticias de deportes
		news_categorization("/news_sports/news_sports_");
		
		//Categorizamos noticias de economía
		news_categorization("/news_economics/news_economics_");
		
		//Categorizamos noticias de política
		news_categorization("/news_politics/news_politics_");

	}

}
