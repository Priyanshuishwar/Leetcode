public class pair{
    String first;
    int second;
    pair(String f,int s){
        this.first = f;
        this.second = s;
    }
}
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>();
        Queue<pair> q = new LinkedList<>();
        q.add(new pair(beginWord,1));
        for(int i = 0; i < wordList.size();i++){
            set.add(wordList.get(i));
        }
        set.remove(beginWord);
        while(!q.isEmpty()){
            String word = q.peek().first;
            int steps = q.peek().second;
            if(word.equals(endWord) == true){
                return steps;
            }
            q.remove();
            for(int i = 0; i < word.length();i++){
                for(char j = 'a'; j <= 'z';j++){
                    char replacedChar[] = word.toCharArray();
                    replacedChar[i] = j;
                    String replaceWord = new String(replacedChar);
                    if(set.contains(replaceWord) == true){
                        set.remove(replaceWord);
                        q.add(new pair(replaceWord,steps + 1));
                    }
                }
            }
        }
        return 0;
    }
}