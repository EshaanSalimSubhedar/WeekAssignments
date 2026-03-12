import java.util.*;

public class PlagiarismDetector {

    private HashMap<String, Set<String>> ngramIndex = new HashMap<>();

    public void indexDocument(String docId, String text) {

        String[] words = text.split(" ");

        for (int i = 0; i < words.length - 2; i++) {

            String ngram = words[i] + " " + words[i+1] + " " + words[i+2];

            ngramIndex.putIfAbsent(ngram, new HashSet<>());
            ngramIndex.get(ngram).add(docId);
        }
    }

    public int checkSimilarity(String text) {

        String[] words = text.split(" ");
        int matches = 0;

        for (int i = 0; i < words.length - 2; i++) {

            String ngram = words[i] + " " + words[i+1] + " " + words[i+2];

            if (ngramIndex.containsKey(ngram)) {
                matches++;
            }
        }

        return matches;
    }

    public static void main(String[] args) {

        PlagiarismDetector detector = new PlagiarismDetector();

        detector.indexDocument("doc1", "this is a sample essay for testing plagiarism detection");

        int matches = detector.checkSimilarity("this is a sample essay written by student");

        System.out.println("Matching ngrams: " + matches);
    }
}