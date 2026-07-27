class Node {
    char c;
    boolean isWord;
    Node[] children;

    Node(char c) {
        this.c=c;
        this.children = new Node[26];
    }
}
class WordDictionary {
 Node root;
    

    public WordDictionary() {
         this.root = new Node('*');
    }

    public void addWord(String word) {
         Node current = root;
        for(char c : word.toCharArray()) {
            if(current.children[c-'a']==null){
                current.children[c-'a'] = new Node(c);
            }
            current = current.children[c-'a'];
        }
        current.isWord = true;
    }

    boolean idxSerach(Node node ,int idx,String word){

        if(node==null){
            return false;
        }

        

        if(idx==word.length()){
            return node.isWord;
        }

        boolean flag=false;

        char c = word.charAt(idx);

        if(c=='.'){
            idx+=1;
            for(Node n : node.children){
                
                    flag = flag || idxSerach(n,idx,word);
                
            }

        }else{
            flag = flag || idxSerach(node.children[c-'a'],idx+1,word);
        }

        return flag;
    }

    public boolean search(String word) {
       return idxSerach(root,0,word);
    }
}
