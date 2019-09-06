package problems.practice;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

class WordLadder {
    
    class Pair{
        String key;
        int value;
        
        Pair(String key,int value){
            this.key=key;
            this.value=value;
        }
    }
    
    
    public static void main(String[] args) {
		
    	List<String> woList =new ArrayList<>();
    	woList.add("hot");
    	woList.add("dot");
    	woList.add("dog");
    	woList.add("lot");
    	woList.add("log");
    	woList.add("cog");
    	
    	WordLadder solution=new WordLadder();
    	
    	System.out.println(solution.ladderLength("hit","cog",woList));
	}
    
    public  int ladderLength(String beginWord, String endWord, List<String> wordList) {
        
      int L = beginWord.length();
      Map<String,List<String>> allCombMap = new HashMap<>();
        
      wordList.forEach(word -> {
          for(int i=0; i<L ; i++){
              String newWord = word.substring(0,i)+"*"+word.substring(i+1,L);
              List<String> trans = allCombMap.getOrDefault(newWord,new ArrayList<String>());
              trans.add(word);
              allCombMap.put(newWord,trans);
          }
      });  
        
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(beginWord,1));
        Map<String,Boolean> visited = new HashMap<>();
        visited.put(beginWord,true);
        
        while(!queue.isEmpty()){
            Pair node = queue.remove();
            String word = node.key;
            int level = node.value;
            for(int i=0; i<L ; i++){
                 String newWord = word.substring(0,i)+"*"+word.substring(i+1,L);
                for(String adjWord : allCombMap.getOrDefault(newWord, new ArrayList<String>())){
                    if(adjWord.equals(endWord)){
                        return level+1;
                    }
                    
                    if(!visited.containsKey(adjWord)){
                        visited.put(adjWord,true);
                        queue.add(new Pair(adjWord,level+1));
                    }
                    
                    }
                }
            }
         return 0;
        
        }
        
    }
