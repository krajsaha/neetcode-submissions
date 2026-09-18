class Node{
    char c;
    Node[] children;
    boolean isWord;
    Node(char c){
        this.c=c;
        this.children=new Node[26];
    }
}
class PrefixTree {
    Node root;
    public PrefixTree() {
         this.root =new Node('*');
    }

    public void insert(String word) {
        Node curr=this.root;

        for(char c : word.toCharArray()){
            if(curr.children[c-'a']==null){
               curr.children[c-'a']=new Node(c); 
            }
            curr=curr.children[c-'a'];
        }
        curr.isWord=true;
    }

    public boolean search(String word) {
        Node curr=this.root;

        for(char c : word.toCharArray()){
            if(curr.children[c-'a']==null){
               return false; 
            }
            curr=curr.children[c-'a'];
        }
       return curr.isWord;
    }

    public boolean startsWith(String prefix) {
        Node curr=this.root;

        for(char c : prefix.toCharArray()){
            if(curr.children[c-'a']==null){
               return false; 
            }
            curr=curr.children[c-'a'];
        }
       return true;
    }
}
